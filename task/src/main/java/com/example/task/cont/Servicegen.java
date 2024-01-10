package com.example.task.cont;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
@Service
public class Servicegen {
	@Autowired
	JdbcTemplate j;
	
//	public int insert(Setgetpojo s)
//	{
//		String fname=s.getFname();
//		String lname=s.getLname();
//		String dob=s.getDob();
//	    String ph=s.getPhno();
//	    String pwd=s.getPwd();
//  String uname=s.getUsername();
//    String mail=s.getEmail();
//	    
	
	   
//	    
//	   String username=" "+fname.charAt(0)+lname.charAt(1);
//	  String email=" "+dob.charAt(0)+dob.charAt(1)+"@gmail.com";
//	    String s1="insert into t1(fname,lname,dob,phno,pwd,username,email)values(?,?,?,?,?,?,?)";
	   // String s1="update t1 set fname=? where lname =?";
//	  int res=j.update(s1,fname,lname,dob,ph,pwd,username,email);
	  //  String s1="delete from t1 where phno=?"; 
   //int res=j.update(s1,fname,lname);
	    //int res=j.update(s1,phno);
//	    return res;
//	}

//	    public List select8() {
//		
//	    
//		String querry="select * from t1";
//		List l=new ArrayList<>();
//		List <Map<String ,Object>> table=new ArrayList<Map<String,Object>>();
//		table=j.queryForList(querry);
//		Map m;
//		//List getData;
//		for(Map fetchdata : table)
//		{
//			m=new HashMap<String,Object>();
//		
//			m.put("fname", fetchdata.get("fname"));
//			m.put("lname",fetchdata.get ("lname"));;
//			m.put("dob",fetchdata.get("dob"));
//			m.put("phno",fetchdata.get("phno"));
//			m.put("pwd",fetchdata.get("pwd"));
//			m.put("username",fetchdata.get("username"));
//			m.put("email", fetchdata.get("email"));
//			l.add(m);
//		}
//		 return l ;
//		    
//	
//	    }
//	    public class Service2 {
	 //   	@Autowired
//	    	JdbcTemplate j;
	    	 public List selec1(Setgetpojo ss) {
	    		    String ph=ss.getPhno();
	    		    String uname=ss.getUsername();
	    		    String mail= ss.getEmail();
	    		    String st="";
	    		   
	    		    if(ph==null && uname==null && mail==null)
	    		    {
	    		    	st="select * from t1";
	    		    }
	    		    else if((ph!=null && uname!=null))
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
//}

	
	
	
	
//<select ..............................................................................>
	 
		    
			//String querry="select * from t1 where phno like '"+ph+"%' or username like '"+uname+"%' or email like '"+mail+"%'";
//			List l=new ArrayList<>();
//			System.out.println(querry);
//			List <Map<String ,Object>> table=new ArrayList<Map<String,Object>>();
//			table=j.queryForList(querry);
//			Map m;
			//List getData;
//			for(Map fetchdata : table)
//			{
//				m=new HashMap<String,Object>();
//			
//				//m.put("fname", fetchdata.get("fname"));
//				//m.put("lname",fetchdata.get ("lname"));;
//				//m.put("dob",fetchdata.get("dob"));
//				m.put("phno",fetchdata.get("phno"));
//				//m.put("pwd",fetchdata.get("pwd"));
//				m.put("username",fetchdata.get("username"));
//				m.put("email", fetchdata.get("email"));
//				l.add(m);
//			}
//			 return l ;
			    
		
		    

			
		

