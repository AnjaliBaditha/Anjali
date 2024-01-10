package com.example.task.cont2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
@Service
public class Serviceinsert {

	@Autowired
	JdbcTemplate j;
	public int insert2(Pojoinsert p)
	{
		int a=0;
		String s="";
		String username=p.getLoginuser_name();
		String pwd=p.getLoginuser_pass();
		String ss="select * from details where uname='"+username+"' and pwd='"+pwd+"'";
      	List getdata=new ArrayList();
		List <Map<String,Object>>tabledata =new ArrayList<Map<String,Object>>();
		tabledata=j.queryForList(ss);
		System.out.println("anjali");
		Map mapdata;
		for(Map fetchdata:tabledata)
		{
			if(fetchdata.get("role").equals("a")||fetchdata.get("role").equals("h"))
				System.out.println("bye");
					{
				String fn=p.getFname();
				String ln=p.getLname();
				String d=p.getDob();
				String rl=p.getRole();
				String uname=" "+fn.charAt(0)+fn.charAt(1);
				String gm=" "+ln+d.charAt(0)+d.charAt(1)+"@gmail.com";
				String pd="@123";
				String sal=p.getSalary();
				String s2="select * from rolestable";
				List <Map<String,Object>>obj=new ArrayList<Map<String,Object>>();
				obj=j.queryForList(s2);
				for(Map f1:obj)
				{
					if(f1.get("role").equals(rl))
					{
						System.out.println("shabana");
						String user_role_id=(String)f1.get("roleid");
								//s=s+(String)f1.get(fn);
								String s1="insert into details values(?,?,?,?,?,?,?,?)";
								a=j.update(s1,fn,ln,d,user_role_id,uname,gm,pd,sal);
					
						
					}
				}
					}
		}
		return a;
			
	}}
