package org.my.dao.mybatis.pool;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Pool_MyBatis {

	/**
	 * 
	 * @return
	 */
	protected SqlSessionFactory createSqlSessionFactory() {
		SqlSessionFactory sqlSessionFactory = null;

		try {
			String resource = "net/cp/dao/mybatis/pool/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}

		return sqlSessionFactory;
	}
}
