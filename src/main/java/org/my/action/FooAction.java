package org.my.action;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ActionContext;
import org.apache.struts2.interceptor.parameter.StrutsParameter;
import org.my.manager.FooManager;
import org.my.mybatis.service.dao.mybatis.model.Idea;

public class FooAction {

	private Log log = LogFactory.getLog(FooAction.class);

	private String var1;

	private String var2;

	// annotation需要加在setter或getter上，此位置沒有作用
	// @StrutsParameter(depth = 10)
	private Map<String, String> map = new HashMap<>();
	private Map<String, String> tmpmap = new HashMap<>();
	private List<String> list = new ArrayList<>();
	private FileInputStream fileInputStream;
	private List<Idea> list2;

//	public String subReport() {
//		try {
////			String path = ServletActionContext.getServletContext().getRealPath("/reports");
//			JasperReport jr = JasperCompileManager.compileReport(path + "/test.jrxml");
//			JasperPrint jp = JasperFillManager.fillReport(jr, new HashMap<>(), new JREmptyDataSource(1));
//			JasperExportManager.exportReportToPdfFile(jp, path + "/EmployeeRecords" + ".pdf");
//			fileInputStream = new FileInputStream(new File(path + "/EmployeeRecords" + ".pdf"));
//		} catch (JRException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			log.debug(e.toString());
//			Arrays.asList(e.getStackTrace()).stream().forEach(sub -> log.debug(sub.toString()));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return "success";
//	}

	/**
	 * 
	 * @return
	 */
	public String report() {
		try {
//			String reportSource;
//			reportSource = ServletActionContext.getServletContext().getRealPath("/jasper/test.jrxml");
//			File parent = new File(reportSource).getParentFile();
			// Compile the .jrxml template file into a .jasper file. Of course, its file
			// name can be specified. If not specified, it is the same as the .jrxml file
			// name. The suffix is ​​different.
//			JasperCompileManager.compileReportToFile(reportSource, new File(parent, "test.jasper").getAbsolutePath());

//			String path = ServletActionContext.getServletContext().getRealPath("/reports");
//
//			Idea idea = new Idea();
//
//			this.list2 = new ArrayList<Idea>();
//			try {
//
//				JasperCompileManager.compileReportToFile(path + "/test.jrxml", path + "/test.jasper");
//			} catch (Exception e) {
//				e.printStackTrace();
//				return "error";
//			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug(e.toString());
			Arrays.asList(e.getStackTrace()).stream().forEach(sub -> log.debug(sub.toString()));
		}
		return "success";
	}

	/**
	 * 
	 * @param var1
	 * @return
	 */
	public String api1() {
		log.debug("test to parameter:" + this.getVar1());
		return "success";
	}

	/**
	 * 
	 * @return
	 */
	public String execute() {
		log.debug("!!!test");

		String test = "";
		// test.

		try {
			FooManager fooManager = new FooManager();

			if (true) {
				return "success";
			}

			List<Idea> resList = fooManager.query2IdeaOfCpDb();

			for (Idea idea : resList) {
				System.out.print(idea.getSyskey());
				System.out.print(",");
				System.out.print(idea.getIdeawho());
				System.out.println();
			}

			resList.stream().forEach(res -> map.put(res.getSyskey(), res.getIdeawho()));

//			FooManager fooManager = new FooManager();
//			List<Map<String, Object>> resList = fooManager.query();
//
//			for (Map<String, Object> map : resList) {
//				System.out.print(map.get("ID"));
//				System.out.print(",");
//				System.out.print(map.get("NM"));
//				System.out.println();
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "success";
	}

	/**
	 * 
	 * @return
	 */
	public String foo() {
		try {
			System.out.println(ActionContext.getContext().getServletRequest().getAttribute("map"));
			System.out.println(ActionContext.getContext().getServletRequest().getAttribute("var1"));

			// 各種Request參數測試
			System.out.println("map: " + this.getMap());
			System.out.println("tmp-map: " + this.getTmpmap());

			Map<String, String> mapAct = this.getMap();
			mapAct.put("foo", "bar@action");
			this.setMap(mapAct);
			System.out.println("map: " + this.getMap());

			System.out.println("var1 value:" + this.getVar1());
			System.out.println("var2 value:" + this.getVar2());

			this.setVar1(this.getVar1());
			this.setVar2("set value from action");
		} catch (Exception e) {
			Arrays.asList(e.getStackTrace()).stream().forEach(sub -> log.debug(sub.toString()));
		}

		try {
			System.out.println("Will Start Query all Data of FooTable!");
			FooManager fooManager = new FooManager();

			// 暫時不會有資料庫，故這裡錯誤先跳過
			try {
				List<Map<String, Object>> resList = fooManager.query();

				for (Map<String, Object> map : resList) {
					System.out.print(map.get("ID"));
					System.out.print(",");
					System.out.print(map.get("NM"));
					System.out.println();
				}
			} catch (Exception e) {
				Arrays.asList(e.getStackTrace()).stream().forEach(sub -> log.debug(sub.toString()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("map: " + this.getMap());
		return "success";
	}

	public String getVar1() {
		return var1;
	}

	/**
	 * struts 7開始引入安全機制，設定後才予許傳入變數，且可設定傳入的深度
	 * 
	 * @param var1
	 */
	@StrutsParameter(depth = 1)
	public void setVar1(String var1) {
		this.var1 = var1;
	}

	public String getVar2() {
		return var2;
	}

	@StrutsParameter(depth = 1)
	public void setVar2(String var2) {
		this.var2 = var2;
	}

	// struts parameter annotation因應request資料為資料結構的話，則需要放在getter上
	// XXX 此規則很詭異，未來getter setter都加上struts parameter annotation
	@StrutsParameter(depth = 10)
	public Map<String, String> getMap() {
		return map;
	}

//	@StrutsParameter(depth = 10)
	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public List<Idea> getList2() {
		return list2;
	}

	public void setList2(List<Idea> list2) {
		this.list2 = list2;
	}

	public FileInputStream getFileInputStream() {
		return fileInputStream;
	}

	public void setFileInputStream(FileInputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}

	public Map<String, String> getTmpmap() {
		return tmpmap;
	}

	@StrutsParameter(depth = 2)
	public void setTmpmap(Map<String, String> tmpmap) {
		this.tmpmap = tmpmap;
	}

}
