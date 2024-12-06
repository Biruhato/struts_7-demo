package org.my.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

public interface FooTableMapper {
	/**
	 * 
	 * @return
	 */
	List<Map<String, Object>> queryFooTableAll();

}
