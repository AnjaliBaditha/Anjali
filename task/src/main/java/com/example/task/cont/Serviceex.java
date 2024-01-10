package com.example.task.cont;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class Serviceex {
	@Autowired
	JdbcTemplate c;
	public int insert(Employee c1)
	{
		int id=c1.getId();
		String name=c1.getName();
	    String role =c1.getRole()	;
	    String s="insert into imp values(?,?,?)";
	    return c.update(s,id,name,role);
	}
}
