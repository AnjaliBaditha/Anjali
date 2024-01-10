package com.example.task.data1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.task.cont3.Projectpojo;
@Service
public class Detailsservice {
	@Autowired
	JdbcTemplate j;
	public int inse(Detailspojo p)
	{
		int a=0;
		String adminuser=p.getAdminuser();
		String adminpwd=p.getAdminpwd();
		String ss="select role from details where uname='"+adminuser+"' and pwd='"+adminpwd+"'";
      	List getdata=new ArrayList();
		List <Map<String,Object>>tabledata =new ArrayList<Map<String,Object>>();
		tabledata=j.queryForList(ss);
		
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
			if(loginrole.equals("a"))
			{
			
				String projectname=p.getProjectname();
				String pid=" "+projectname.charAt(0)+projectname.charAt(2);
				String projectdescription=p.getProjectdescription();
				String numemployes=p.getNumemployes();
				String projectmanager=p.getProjectmanager();
				String h=p.getHr();
				String startdate=p.getStartdate();
				String  as=p.getAssignedby(); 
				System.out.println("if");
				
				String pwid=p.getPwid();
				String query="select fname from details where pwd ='"+pwid+"'";
				List <Map<String,Object>>tabledata2=new ArrayList<Map<String,Object>>();
				tabledata2=j.queryForList(query);
				String pmuser="";
				for(Map fetchdata2:tabledata2)
				{
					System.out.println("ghbj");
					pmuser=pmuser+(String)fetchdata2.get("fname");
				}
				System.out.println(pmuser);
				String hr=p.getHr();
				String hrquery="select fname from details where pwd='"+hr+"'";
				List <Map<String,Object>>tabledata3=new ArrayList<Map<String,Object>>();
				tabledata3=j.queryForList(hrquery);
				String hruser="";
				for(Map fetchdata3:tabledata3)
				{
					System.out.println("jgh");
					hruser=hruser+(String)fetchdata3.get("fname");
				}
	
				System.out.println(hruser);
				String adminquery="select fname from details where pwd='"+adminpwd+"'";
				List <Map<String,Object>>tabledata4=new ArrayList<Map<String,Object>>();
				tabledata4=j.queryForList(adminquery);
				String aduser="";
				for(Map fetchdata4:tabledata4)
				{
					aduser=aduser+(String)fetchdata4.get("fname");
				}
				
				String s1="insert into projecttable(projectname,projectid,projectdescription,numemployes,projectmanager,hr,startdate,assignedby) values(?,?,?,?,?,?,?,?)";
				a=j.update(s1,projectname,pid,projectdescription,numemployes,pmuser,hruser,startdate,aduser);
			}
			else
			{
				System.out.println("only admin can insert the data");
			}
		}
	return a;

	}
	
	
	}


