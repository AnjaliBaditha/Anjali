package com.example.task.data5;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class Stausservice {
	@Autowired
	JdbcTemplate j;
	public String  status(Emplistpojo p)
     {
		String m="";
		String fn=p.getFname();
		String pw=p.getPwd();

//		String enda=p.getEnddate();
		String tid=p.getTaskid();
//		String pj=p.getProjectid();
		String s="select * from details where fname=? and pwd=? and role='pm'";
			
		List <Map<String,Object>> data=new ArrayList<Map<String,Object>>();
		data=j.queryForList(s,fn,pw);
		if(data.isEmpty())
		{
			m="invalid login credintials";
		}
		else
		{
			System.out.println("hoi");
//			DateTimeFormatter t=DateTimeFormatter.ofPattern("dd//mm//yyyy");
//			LocalDateTime t1=LocalDateTime.now();
//			String ti=t.format(t1);
//			String ss="update emplist set enddate=? where taskid=?";
//			int a=j.update(ss,enda,tid);
			String s3="update emplist set status='f' where taskid=?";
			int a=j.update(s3,tid);
			String s4="update tasklist set status='f' where taskid=?";
			int a1=j.update(s4,tid);
			System.out.println("anjali");
		
		if(a>0 && a1>0)
		{
			m="inserted";
			
		}
		else
		{
			m="not inserted";
		}
		}
	
		
		
		return m;
	}
	

}
