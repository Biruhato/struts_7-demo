package org.my.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.my.dao.mybatis.mapper.FooTableMapper;
import org.my.dao.mybatis.pool.Pool_MyBatis;
import org.my.mybatis.service.dao.mybatis.mapper.IdeaMapper;
import org.my.mybatis.service.dao.mybatis.model.Idea;

public class FooTableService extends Pool_MyBatis {

	/**
	 * 
	 * @return
	 */
	public List<Map<String, Object>> query() {
		SqlSession sqlSession = this.createSqlSessionFactory().openSession();
		List<Map<String, Object>> resList = null;

		try {
			FooTableMapper fooTableMapper = sqlSession.getMapper(FooTableMapper.class);
			resList = fooTableMapper.queryFooTableAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return resList;
	}

	/**
	 * @return
	 * 
	 */
	public List<Idea> query2IdeaOfCpDb() {
		SqlSession sqlSession = this.createSqlSessionFactory().openSession();
		List<Idea> resList = null;

		try {
			IdeaMapper fooTableMapper = sqlSession.getMapper(IdeaMapper.class);
			resList = fooTableMapper.selectByExample(null);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return resList;
	}

}
