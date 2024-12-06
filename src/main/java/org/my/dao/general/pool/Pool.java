package org.my.dao.general.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Pool {
	/**
	 * 注意connect()中,目前CpIdea沒有Oracle的Jar,有時間再測試
	 * 
	 * 注意stmt.setPoolable(true)此行,此為pool開關
	 */

	// 選擇dbType
	public int dbType_MySQL = 0;
	public int dbType_SQLServer = 1;
	public int dbType_MariaDB = 2;

	public Statement stmt = null;
	public Connection con = null;
	private String url4DriverManager;
	private String ip;
	private String schemata;
	private String port;
	private String username;
	private String passwd;
	private int dbType;

	public Pool() {
		// 如需要從pool寫死連線的資料(或者直接讀外部資料,如:xml),在這邊加
	}

	/**
	 * DB連結
	 * 
	 * @param dbType 0:MySql,1:SQL Server,2:MariaDB,3:OracleXE11
	 */
	protected boolean connect(int dbType) {
		boolean r = false;

		switch (dbType) {
		case 0:
			connect4MySql();
			break;
		case 1:
			connect4SqlServer();
			break;
		case 2:
			connect4MariaDB();
			break;
		case 3:
			connect4OracleXE11();
			break;
		}

		try {
			if (con != null && !con.isClosed()) {
				r = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (con == null) {
			System.out.println("錯誤 ! con == null");
		}

		return r;
	}

	/**
	 * 關閉連線
	 */
	protected void close() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 建立連線(MySql)
	 */
	private void connect4MySql() {
		String class4Name = "com.mysql.jdbc.Driver";
		String url4DriverManager = "jdbc:mysql://" + getIp() + ":" + getPort() + "/" + getSchemata()
				+ "?autoReconnect=true&amp;maxReconnects=36000&amp;initialTimeout=3&amp;characterEncoding=UTF-8";
		connectLow(class4Name, url4DriverManager, getUsername(), getPasswd());
	}

	/**
	 * 建立連線(MariaDB)
	 */
	private void connect4MariaDB() {
		String class4Name = "org.mariadb.jdbc.Driver";
		String url4DriverManager = "jdbc:mariadb://" + getIp() + ":" + getPort() + "/" + getSchemata()
				+ "?autoReconnect=true&amp;maxReconnects=36000&amp;initialTimeout=3&amp;characterEncoding=UTF-8";
		connectLow(class4Name, url4DriverManager, getUsername(), getPasswd());
	}

	/**
	 * 建立連線(Sql Server)
	 */
	private void connect4SqlServer() {
		String class4Name = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url4DriverManager = "jdbc:sqlserver://" + getIp() + ":" + getPort() + ";databaseName=" + getSchemata()
				+ ";";
		connectLow(class4Name, url4DriverManager, getUsername(), getPasswd());
	}

	/**
	 * 建立連線(Sql Server)
	 */
	private void connect4OracleXE11() {
		String class4Name = "oracle.jdbc.driver.OracleDriver";
		String url4DriverManager = "jdbc:oracle:thin:@//" + getIp() + ":" + getPort() + "/XE";
		connectLow(class4Name, url4DriverManager, getUsername(), getPasswd());
	}

	/**
	 * 建立連線的共用方法
	 */
	private void connectLow(String class4Name, String url4DriverManager, String username, String passwd) {
		try {
			Class.forName(class4Name).newInstance();
			setUrl4DriverManager(url4DriverManager);
			con = DriverManager.getConnection(url4DriverManager, username, passwd);
			stmt = con.createStatement();
			stmt.setPoolable(true);// pool開關
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ====================get set========================
	public int getDbType() {
		return dbType;
	}

	public void setDbType(int dbType) {
		this.dbType = dbType;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getSchemata() {
		return schemata;
	}

	public void setSchemata(String schemata) {
		this.schemata = schemata;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getUrl4DriverManager() {
		return url4DriverManager;
	}

	public void setUrl4DriverManager(String url4DriverManager) {
		this.url4DriverManager = url4DriverManager;
	}

}
