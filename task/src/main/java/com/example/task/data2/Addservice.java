package com.example.task.data2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
@Service
public class Addservice {
	@Autowired
	JdbcTemplate j;
	public int sel(Addpojo p)
	{

	
	
		int a=0;
		String pmuser=p.getPmuser();
		String pmpwd=p.getPmpwd();
		String pmquery="select role from details where uname='"+pmuser+"' and pwd='"+pmpwd+"'";
      	List getdata=new ArrayList();
		List <Map<String,Object>>tabledata =new ArrayList<Map<String,Object>>();
		tabledata=j.queryForList(pmquery);
		
		if(tabledata.isEmpty()==false)
		{
			System.out.println("hii");
			String loginrole="";
			for(Map fetchdata:tabledata)
			{
				System.out.println("hello anju");
				loginrole=loginrole+(String)fetchdata.get("role");
			
			}
			System.out.println(loginrole);
			if(loginrole.equals("pm"))
			{
				System.out.println("some");
				DateTimeFormatter t=DateTimeFormatter.ofPattern("dd//mm//yyyy");
				LocalDateTime t1=LocalDateTime.now();
				String ti=t.format(t1);
				
				
		//String projectassigndate=p.getProjectassigndate();
		String phno=p.getPhno();		
		String pid=p.getProjectid();
		String query="select projectname,assignedby from projecttable where projectid='"+pid+"' ";
		System.out.println("ygy");
		//List getdata=new ArrayList();
		List <Map<String,Object>>tabledata2 =new ArrayList<Map<String,Object>>();
		tabledata2=j.queryForList(query);
		String projectname="";
		String assignedby="";
		System.out.println("djhih");
		for(Map fetchdata2:tabledata2)	
		{
			System.out.println("gsyg");
			
			projectname=(String)fetchdata2.get("projectname");
			assignedby=(String)fetchdata2.get("assignedby");
		}
		System.out.println(projectname);
		//System.out.println(assignedby);
		
		String pw=p.getPwd();
		String sta="b";
		String query2="select email,joindate from details where pwd='"+pw+"' and status='"+sta+"'";
		List <Map<String,Object>>tabledata3 =new ArrayList<Map<String,Object>>();
		tabledata3=j.queryForList(query2);
		String email="";
		String jod="";
	
		for(Map fetchdata3:tabledata3)
		{System.out.print("Hello");
			email=(String)fetchdata3.get("email");
			jod=(String)fetchdata3.get("joindate");
		}
		String s1="insert into projectconcatdetails(projectid,projectname,email,pho,projectassigndate,joiningdate,assignedby) values(?,?,?,?,?,?,?)";
		a=j.update(s1,pid,projectname,email,phno,ti,jod,assignedby);
		if(a>0) {
			String star="A";
			String upq="update details set status='"+star+"' where  pwd='"+pw+"'";
			j.update(upq);
		}

			}

		}
		return a;
	}
}



