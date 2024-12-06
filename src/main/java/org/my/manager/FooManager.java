package org.my.manager;

import java.util.List;
import java.util.Map;

import org.my.mybatis.service.dao.mybatis.model.Idea;
import org.my.service.FooTableService;

public class FooManager {
	private FooTableService fooTableService = new FooTableService();

	/**
	 * 
	 * @return
	 */
	public List<Map<String, Object>> query() {
		return fooTableService.query();
	}

	/**
	 * 
	 * @return
	 */
	public List<Idea> query2IdeaOfCpDb() {
		return fooTableService.query2IdeaOfCpDb();
	}
}
