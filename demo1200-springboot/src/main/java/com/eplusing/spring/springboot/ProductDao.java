package com.eplusing.spring.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductDao {

	/*@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addProduct(String name){
		String sql = "insert into product (pname) values('" + name + "')";
		jdbcTemplate.execute(sql);
		
	}
	
	
	public void addBatch(String ... names) throws Exception{
		addProductBatch(names);
	}
	
	
	//默认仅针对运行时异常回滚
	@Transactional(rollbackFor=NullPointerException.class)
	public void addProductBatch(String ... names) throws Exception{
		for(String name : names){
			String sql = "insert into product (pname) values('" + name + "')";
			jdbcTemplate.execute(sql);
			
			throw new NullPointerException();
			//throw new NullPointerException();
		}
	}*/
	
}
