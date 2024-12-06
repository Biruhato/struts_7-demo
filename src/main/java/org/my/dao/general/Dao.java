package org.my.dao.general;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.my.dao.general.pool.Pool;

public class Dao extends Pool {
	/**
	 * 建構時需要從pool寫死連線的資料(或者直接讀外部資料,如:xml)
	 */
	public Dao() {

	}

	/**
	 * 建構時須從前端傳送連線所需要的資料
	 * 
	 * @param dbTypeNmNum
	 * @param ip
	 * @param port
	 * @param schemata
	 * @param username
	 * @param passwd
	 */
	public Dao(int dbTypeNmNum, String ip, String port, String schemata, String username, String passwd) {
		this.setDbType(dbTypeNmNum);
		this.setIp(ip);
		this.setSchemata(schemata);
		this.setPort(port);
		this.setUsername(username);
		this.setPasswd(passwd);
	}

	// =============Dao通用項目=============

	/**
	 * 查詢
	 * 
	 * @param columnNmList 查詢欄位的欄位名稱
	 * @param condition    查詢條件,null為全查詢。如需模糊查詢,請將Key的字串加上"@like",例:條件ID,值Leo,的模糊查詢
	 *                     : map.put("ID@like","leo")
	 * @param schemata
	 * @param table
	 * 
	 */
	public ArrayList<Map<String, Object>> exeQuery(List<String> columnNmList, Map<String, String> condition,
			List<String> orerByList, String ascOrDesc, String schemata_table) {
		ArrayList<Map<String, Object>> res = null;

		if (connect(getDbType())) {
			String syntax = querySyntax_canFuzzy(columnNmList, condition, orerByList, ascOrDesc, schemata_table);

			System.out.println(syntax);

			res = resultSet2ListMap(exeQueryLow(syntax));
			close();
		}

		return res;
	}

	/**
	 * 新增
	 * 
	 * @param insertDataPack 新增資料包
	 * @param schemata
	 * @param table
	 * 
	 */
	public int exeInsert(Map<String, String> insertDataPack, String schemata_table) {
		int res = 0;

		if (connect(getDbType())) {
			String syntax = insertSyntax(insertDataPack, schemata_table);

			System.out.println(syntax);

			res = exeInsertLow(syntax);
			close();
		}

		return res;
	}

	/**
	 * 刪除
	 * 
	 * @param m        刪除資料包,僅能放一組資料(通常此資料為key)
	 * @param schemata
	 * @param table
	 */
	public int exeDel(Map<String, String> m, String schemata_table) {
		int res = 0;

		if (connect(getDbType())) {
			String syntax = delSyntax(m, schemata_table);

			System.out.println(syntax);

			res = exeDelLow(syntax);
			close();
		}

		return res;
	}

	/**
	 * 修改
	 * 
	 * @param updateDataPack      修改的資料包
	 * @param updateConditionPack 條件包(通常此資料為key,但可加入其他條件)
	 * @param schemata
	 * @param table
	 */
	public int exeUpdate(Map<String, String> updateDataPack, Map<String, String> conditionPack, String schemata_table) {
		int res = 0;

		if (connect(getDbType())) {
			String syntax = updateSyntax(conditionPack, updateDataPack, schemata_table);

			System.out.println(syntax);

			res = exeUpdateLow(syntax);
			close();
		}

		return res;
	}

	// =============Dao通用項目(低階)=============

	/**
	 * 
	 * */
	private ResultSet exeQueryLow(String syntax) {
		try {
			return stmt.executeQuery(syntax);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * */
	private int exeInsertLow(String syntax) {
		return exeUpdateLow(syntax);
	}

	/**
	 * 
	 * */
	private int exeDelLow(String syntax) {
		return exeUpdateLow(syntax);
	}

	/**
	 * 
	 * */
	private int exeUpdateLow(String syntax) {
		try {
			return stmt.executeUpdate(syntax);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * ResultSet轉List<Map>
	 */
	private ArrayList<Map<String, Object>> resultSet2ListMap(ResultSet resultSet) {
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		try {
			while (resultSet.next()) {
				Map<String, Object> m = new HashMap<String, Object>();

				for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
					m.put(resultSet.getMetaData().getColumnName(i),
							resultSet.getString(resultSet.getMetaData().getColumnName(i)));
				}

				list.add(m);
			}

			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * del語法產生(where條件僅能放一組)
	 */
	private String delSyntax(Map<String, String> m, String schemata_table) {
		ArrayList<String[]> l = takeApartMap(m);

		StringBuffer b = new StringBuffer();
		StringBuffer t4Where = new StringBuffer();

		for (String[] s : l) {
			t4Where.append(s[0] + "=" + "'" + s[1] + "'");
		}

		b.append("delete from");
		b.append(" ");
		b.append(schemata_table);
		b.append(" ");
		b.append("where");
		b.append(" ");
		b.append(t4Where.toString());
		b.append(";");

		// System.out.println(b.toString());

		return b.toString();
	}

	/**
	 * query語法產生(可以模糊查詢)(尚無針對時間查詢)
	 * 
	 * @param columnNmList   欲抓取資料庫中欄位的欄位名稱,不可為null,最少要有一筆"*"資料("*"為將所有欄位抓取資料)
	 *                       ,如需模糊字串查詢
	 * @param condition      查詢條件(null為不對sql設條件。如需模糊查詢,請將Key的字串加上"@like",例:條件ID,值Leo,的模糊查詢
	 *                       : map.put("ID@like","leo"))
	 * @param schemata_table 欲查詢的table名稱
	 */
	private String querySyntax_canFuzzy(List<String> columnNmList, Map<String, String> condition,
			List<String> orderByList, String ascOrDesc, String schemata_table) {
		StringBuffer b = new StringBuffer();
		StringBuffer t4Select = new StringBuffer();
		String where = null;
		String likeStr = "@like";
		StringBuffer t4OrderBy = new StringBuffer();
		String orderBy = null;

		// select
		if (columnNmList.size() == 1 & "*".equals(columnNmList.get(0))) {
			t4Select.append("*" + ",");
		} else {
			for (String columnNm : columnNmList) {
				t4Select.append(columnNm + ",");
			}
		}

		String select = delLastSymbol(t4Select.toString(), ",");

		// where
		where = this.querySyntax_genWhere(condition, likeStr);
		// order by
		if (orderByList != null && orderByList.size() != 0) {
			for (String s : orderByList) {
				t4OrderBy.append(s + ",");
			}

			orderBy = delLastSymbol(t4OrderBy.toString(), ",");
		}

		// 產生語法
		b.append("select");
		b.append(" ");
		b.append(select);
		b.append(" ");
		b.append("from");
		b.append(" ");
		b.append(schemata_table);

		if (condition != null && condition.size() != 0 && where != null) {
			b.append(" ");
			b.append("where");
			b.append(" ");
			b.append(where);
		}
		if (orderBy != null && orderByList.size() != 0) {
			b.append(" ");
			b.append("order by");
			b.append(" ");
			b.append(orderBy);
			b.append(" ");
			b.append(ascOrDesc);
		}

		b.append(";");

		// System.out.println(b.toString());

		return b.toString();
	}

	/**
	 * 產生query需要的where字串
	 */
	private String querySyntax_genWhere(Map<String, String> condition, String likeStr) {
		StringBuffer t4Where = new StringBuffer();
		String where = null;

		// where
		if (condition != null && condition.size() != 0) {
			ArrayList<String[]> l = takeApartMap(condition);

			for (String[] s : l) {
				if (likeStr != null && s[0].contains(likeStr)) {
					t4Where.append(s[0].replace(likeStr, "") + " " + "like" + " " + "'" + "%" + s[1] + "%" + "'" + " "
							+ "AND" + " ");
				} else {
					t4Where.append(s[0] + "=" + "'" + s[1] + "'" + " " + "AND" + " ");
				}
			}

			where = delLastSymbol(t4Where.toString(), " " + "AND" + " ");
		}

		return where;
	}

	/**
	 * insert語法產生
	 */
	private String insertSyntax(Map<String, String> insertDataPack, String schemata_table) {
		StringBuffer b = new StringBuffer();
		StringBuffer t4labelNm = new StringBuffer();
		StringBuffer t4value = new StringBuffer();

		ArrayList<String[]> l = takeApartMap(insertDataPack);

		for (String[] s : l) {
			t4labelNm.append(s[0] + ",");
			t4value.append("'" + s[1] + "'" + ",");
		}

		String labelNm = delLastSymbol(t4labelNm.toString(), ",");
		String value = delLastSymbol(t4value.toString(), ",");

		b.append("insert into");
		b.append(" ");
		b.append(schemata_table);
		b.append("(" + labelNm + ")");
		b.append(" ");
		b.append("values");
		b.append("(" + value + ")");
		b.append(";");

		// System.out.println(b.toString());

		return b.toString();
	}

	/**
	 * update語法產生
	 */
	private String updateSyntax(Map<String, String> updateConditionPack, Map<String, String> updateDataPack,
			String schemata_table) {
		StringBuffer b = new StringBuffer();

		// 處理欲修改的值的字串
		ArrayList<String[]> valueList = takeApartMap(updateDataPack);
		String t4labelNm_value = null;

		for (String[] s : valueList) {
			if (t4labelNm_value == null) {
				t4labelNm_value = s[0] + "=" + "'" + s[1] + "'" + ",";
			} else {
				t4labelNm_value = t4labelNm_value + s[0] + "=" + "'" + s[1] + "'" + ",";
			}
		}

		String labelNm_value = delLastSymbol(t4labelNm_value, ",");

		// 處理欲修改的key的字串
		ArrayList<String[]> conditionList = takeApartMap(updateConditionPack);
		String t4where = null;

		for (String[] condition : conditionList) {
			if (t4where == null) {
				t4where = condition[0] + "=" + "'" + condition[1] + "'" + ",";
			} else {
				t4where = t4where + "," + condition[0] + "=" + "'" + condition[1] + "'" + ",";
			}
		}

		String where = delLastSymbol(t4where.toString(), ",");

		b.append("update");
		b.append(" ");
		b.append(schemata_table);
		b.append(" ");
		b.append("set");
		b.append(" ");
		b.append(labelNm_value);
		b.append(" ");
		b.append("where");
		b.append(" ");
		b.append(where);
		b.append(";");

		// System.out.println(b.toString());

		return b.toString();
	}

	// =============tool=============

	/**
	 * 刪除最後一個符號
	 */
	public String delLastSymbol(String s, String symbol) {
		return s.substring(0, s.lastIndexOf(symbol));
	}

	/**
	 * 
	 * */
	@SuppressWarnings("rawtypes")
	public ArrayList<String[]> takeApartMap(Map<String, String> map) {
		ArrayList<String[]> list = new ArrayList<String[]>();

		for (Iterator iter = map.entrySet().iterator(); iter.hasNext();) {
			Map.Entry entry = (Map.Entry) iter.next();
			String key = (String) entry.getKey();
			String value = (String) map.get(key);
			String[] arrayStr = { key, value };

			list.add(arrayStr);
		}

		return list;
	}

	/**
	 * 
	 * */
	public List<String> spilt2(String str, String exp) {
		List<String> result = new ArrayList<>();

		Pattern ptn = Pattern.compile("[" + exp + "]");
		String[] spilt = ptn.split(str);

		for (int i = 0; i < spilt.length; i++) {
			result.add(spilt[i]);
		}

		return result;
	}

	/**
	 * 
	 * */
	public boolean check_String_Is_Null(ArrayList<Object> l) {
		ArrayList<Boolean> bList = new ArrayList<Boolean>();

		for (Object o : l) {
			if (o == null) {
				bList.add(true);
			} else {
				bList.add(false);
			}
		}

		return check_BooleanList_Is_AllTrue(bList);
	}

	/**
	 * 
	 * */
	public boolean check_String_Is_NullorSpace(ArrayList<Object> l) {
		ArrayList<Boolean> bList = new ArrayList<Boolean>();

		for (Object o : l) {
			if (o == null | "".equals(String.valueOf(o))) {
				bList.add(true);
			} else {
				bList.add(false);
			}
		}

		return check_BooleanList_Is_AllTrue(bList);
	}

	/**
	 * 
	 * */
	public boolean check_BooleanList_Is_AllTrue(ArrayList<Boolean> bList) {
		int count = 0;

		for (Boolean b : bList) {
			if (b == true) {
				count++;
			}
		}

		if (count == bList.size()) {
			return true;
		} else {
			return false;
		}
	}
}
