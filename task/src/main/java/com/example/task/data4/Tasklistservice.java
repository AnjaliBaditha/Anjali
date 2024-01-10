package com.example.task.data4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.task.data3.Copypojo;
@Service
public class Tasklistservice {
	@Autowired
	JdbcTemplate j;
	public int sell (Tasklistpojo p)
	{
		int a=0;
	String fn=p.getFname();
	String pw=p.getPwd();
	String tsn=p.getTaskname();
	   String tid=" "+tsn.charAt(0)+tsn.charAt(2);
	   String des=p.getDescription();
	   String du=p.getDuration();
	   String st=p.getStatus();
	   String proid=p.getProjectid();
	   String createdby="";
	   String projectid="";
	  
		String s="select * from details where fname=? and pwd=?";
	List <Map<String,Object>> data=new ArrayList<Map<String,Object>>();
	data=j.queryForList(s,fn,pw);

	if(data.isEmpty()==false)
			{
		   String login="";
		   for(Map fetchdata:data)
		   {
			   login=(String)fetchdata.get("role");
		   }
		   if(login.equals ("pm"))
		   {
			   String s1="select * from projecttable where projectid= '"+proid+"'";
			   List <Map<String,Object>> data1=new ArrayList<Map<String,Object>>();
				data1=j.queryForList(s1);
				System.out.println(proid);
				
				  
				  for(Map fetchdata1:data1)
				  {
					  projectid=(String)fetchdata1.get("projectid");
					  createdby=(String) fetchdata1.get("assignedby");
						System.out.println("projectname");
				  }
				  	System.out.println("project");
				  String s2="insert into tasklist values(?,?,?,?,?,?,?)";
				  a=j.update(s2,projectid,tid,tsn,des,du,st,createdby);
		   }
			}
	return a;
	}
	public int selup (Tasklistpojo p1)
	{
	int b=0;
		String f=p1.getFname();
		String ps=p1.getPwd();
		
		   System.out.println("hiii");
		String query="select * from details where fname=? and pwd=?";
		List <Map<String,Object>> getdata=new ArrayList<Map<String,Object>>();
		getdata=j.queryForList(query,f,ps);
		System.out.println("hiiiooo");
		if(getdata.isEmpty()==false)
		{
			System.out.println("hiiidddd");
	   String login="";
	   for(Map fetchdata4:getdata)
	   {
		   login=(String)fetchdata4.get("role");
	   }
	   if(login.equals ("pm"))
	   {
		   String dess=p1.getDescription();
		   String duu=p1.getDuration();
		   String sta=p1.getStatus();
		   String prid=p1.getProjectid();
		   String crby=p1.getCreatedby();
		   String sup="update tasklist set description=?,duration=?,status=? where projectid=? and createdby=?";
		  b=j.update(sup,dess,duu,sta,prid,crby);
		  
	   }
		}
		return b;
	}
	
	public int selin (Tasklistpojo p2)
	{
	int c=0;
		String ff=p2.getFname();
		String pss=p2.getPwd();
		
		   System.out.println("hiii");
		String query="select * from details where fname=? and pwd=?";
		List <Map<String,Object>> getdat=new ArrayList<Map<String,Object>>();
		getdat=j.queryForList(query,ff,pss);
		System.out.println("hiiiooo");
		if(getdat.isEmpty()==false)
		{
			System.out.println("hiiidddd");
	   String login="";
	   for(Map fetchdata5:getdat)
	   {
		   login=(String)fetchdata5.get("role");
	   }
	   if(login.equals ("pm"))
	   {
		   System.out.println("anju");
		   //String pj=p2.getProjectid();
	   String ts=p2.getTaskid();
		   String que="delete from tasklist where taskid=? ";
		c=j.update(que,ts);
	   }
	   }
		return c;
}
}

		

