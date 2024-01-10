package com.example.task.data3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.task.cont3.Projectpojo;
@Service

public class Copyservice {
	@Autowired
	JdbcTemplate j;
	public String sel(Copypojo p)
	{
		
		int a=0;
		String adminuser=p.getAdminuser();
		String adminpwd=p.getAdminpwd();
		String ss="select role from details where uname='"+adminuser+"' and pwd='"+adminpwd+"'";
      //	List getdata=new ArrayList();
		List <Map<String,Object>>tabledata =new ArrayList<Map<String,Object>>();
		tabledata=j.queryForList(ss);
		
		if(tabledata.isEmpty()==false)
		{
			System.out.println("hii");
			String loginrole="";
			for(Map fetchdata:tabledata)
			{
				System.out.println("hello anju");
				loginrole=(String)fetchdata.get("role");
			
			}
			System.out.println(loginrole);
			if(loginrole.equals("a"))
			{
				System.out.println("abhi");
				String proname=p.getProname();
				String pid=" "+proname.charAt(3)+proname.charAt(2);
				String query="select * from projecttable where projectname=? ";
				List <Map<String,Object>>tabledata2=new ArrayList<Map<String,Object>>();
				tabledata2=j.queryForList(query,p.getProjectname());
				String pde="",nume="";
				String pm="";
				String h="";
				String aby="";
				String sd="";
				for(Map fetchdata:tabledata2)
				{
					pde=(String)fetchdata.get("projectdescription");
					 nume=(String)fetchdata.get("numemployes");
					 pm=(String)fetchdata.get("projectmanager");
					 h=(String)fetchdata.get("hr");
					 aby=(String)fetchdata.get("assignedby");
					 sd=(String)fetchdata.get("startdate");
				}
				String s1="insert into projecttable values(?,?,?,?,?,?,?,?)";
				 a=j.update(s1,proname,pid,pde,nume,pm,h,aby,sd);
				if(a>0)
				{
					String que="insert into projectconcatdetails values(?,?,?,?,?,?,?)";
					String qu="select * from projectconcatdetails where projectname=?";
					List <Map<String,Object>>tabledata4=new ArrayList<Map<String,Object>>();
					tabledata4=j.queryForList(qu,p.getProjectname());
					String pi="",pna="",em="",pno="",pass="",joi="",asby="";
					for(Map fetchdata:tabledata4)
					{
						
						em=(String)fetchdata.get("email");
						pno=(String)fetchdata.get("pho");
						pass=(String)fetchdata.get("projectassigndate");
						joi=(String)fetchdata.get("joiningdate");
						asby=(String)fetchdata.get("assignedby");
						int b=j.update(que,pid,proname,em,pno,pass,joi,asby);
						
					}
					return "insereted";
				}
				else
				{
					return "not inserted";
				}
			}
			
			}
		
		return null;

}
	
	
	}
	



