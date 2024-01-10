package com.example.task.meeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class Examservice {
	@Autowired
	JdbcTemplate j;
	public int ex(Exampojo p)
	{
	String i=p.getId();
	String n=p.getName();
	String r=p.getRole();
	String s="insert into imp(id,name,role) values (?,?,?)";
int re=j.update(s,i,n,r);
return re;
	}
	
	
	

}
