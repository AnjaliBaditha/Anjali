package com.example.task.data5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class Emplistservice {
@Autowired
JdbcTemplate j;
String projectid;
String proman;
public String emp(Emplistpojo p)
{ 
	String fnn=p.getFname();
	String pww2=p.getPwd();
	String proid=p.getProjectid();
	String std=p.getStartdate();
	String ed=p.getEnddate();
	//String pmid=p.getProjectmanager();
	String empid=p.getEmployeid();
	String m="";
	String s="select * from details where fname=? and pwd=? ";
	List <Map<String,Object>> data=new ArrayList<Map<String,Object>>();
	data=j.queryForList(s,fnn,pww2);
	if(data.isEmpty()==false)
	{
   String login="";
   for(Map fetchdata:data)
   {
	   login=(String)fetchdata.get("role");
   }
   if(login.equals ("pm"))
   {

	String tid=p.getTaskid();
    String s2="select * from tasklist where taskid=?";
		 List <Map<String,Object>> data2=new ArrayList<Map<String,Object>>();
			data2=j.queryForList(s2,tid);
			for(Map md:data2) 
				if(data2.isEmpty()) {
					m="invalid task id";
				}
				else{
			projectid=(String)md.get("projectid");
			proman=(String)md.get("createdby");
		}
		System.out.println("pm"+proman);
		System.out.print("df"+projectid);
		String s3="insert into emplist values(?,?,?,?,?,?,?)";
		int aa=j.update(s3,projectid,tid,proman,empid,std,ed,"a");
		String  s4="update tasklist set status=? where taskid=? ";
		int b=j.update(s4,"a",tid);
	
if(aa>0 && b>0)
{
	m="inserted";
}
else
{
	m="not inserted";
}
}
	
	}else 
{
	m="invalid login";
}

	return m;
	


}

}


