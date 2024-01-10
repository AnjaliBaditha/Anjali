package com.example.task.cont;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class Service2 {
	@Autowired
	JdbcTemplate j;
	 public List select(Setgetpojo ss) {
		    String ph=ss.getPhno();
		    String uname=ss.getUsername();
		    String mail= ss.getEmail();
		    String st="";
		   
		    if(ph==null && uname==null && mail==null)
		    {
		    	st="select * from t1";
		    }
		    else if(ph!=null && uname!=null)
		    {
		    	st="select * from t1 where phno like '"+ph+"%' and username like '"+uname+"%' ";
		    	//System.out.println(st);
				 
		//	System.out.println(table);
		    
		    }
		    else if((ph!=null && mail!=null))
		    {
		    	st="select * from t1 where phno like '"+ph+"%' and email like '"+mail+"%' ";
		    }
		    else if((mail!=null && uname!=null))
		    {
		    	st="select * from t1 where email like '"+mail+"%' and username like '"+uname+"%' ";
		    }
		    else
		    {
		    	st="select * from t1 where phno like '"+ph+"%' or username like '"+uname+"%' or email like '"+mail+"%'";
		    }
		    List i=new ArrayList<>();
			List<Map<String ,Object>> t=new ArrayList<Map<String,Object>>();
		    t=j.queryForList(st);
			 return t;
			
	  }
}


