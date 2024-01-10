package com.example.task.meeting;

import java.time.LocalDate;

import java.time.LocalDateTime;import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class Mettingservice {
	@Autowired
	JdbcTemplate j;
	@Autowired
	  JavaMailSender javaMailSender;
	@Transactional
	public String met(Mettingpojo m)
	
//		String a="";
//		String fm=p.getFname();
//		String pwd=p.getPwd();
//		String st=p.getStatus();
//		String proid=p.getProjectid();
//		String mena=p.getMeetingname();
//		String meid=""+mena.charAt(0)+mena.charAt(1);
//		String stime=p.getStarttime();
//		String etime=p.getEndtime();
//		String con=p.getContact();
//		String cre=p.getCreatedby();
//		String dur=p.getDuration();
//		String dat=p.getDate();
//		String role="";
//		DateTimeFormatter d= DateTimeFormatter.ofPattern("dd/MM/YYYY");
//		LocalDateTime l= LocalDateTime.now();
//		LocalDate d1=LocalDate.now();
//		String time=d.format(l);
//		String s="select * from details where fname=? and pwd=? and status='a' and (role='pm' or role='hr' or role='e')";
//		List <Map<String,Object>> data=new ArrayList<Map<String,Object>>();
//		data=j.queryForList(s,fm,pwd);
//		for(Map obj:data ) {
//			role=(String)obj.get("role");
//		}
//		if(data.isEmpty())
//		{
//			a="invalid login credintials";
//		}
//		else
//		{
//			System.out.println("dfsdf");
//
//			String pid= p.getProjectid();
//			String cod=p.getContact();
//			String [] emp=cod.split(",");
//			for(String s1:emp) {
//			String checkid="select * from project_contact_details where project_id=? and emp_id=? ";
//			String rolechecking="select role from Spring where id=?";
//			List<Map<String,Object>> checkingid= new ArrayList<Map<String,Object>>();
//			List<Map<String,Object>> checkingid1= new ArrayList<Map<String,Object>>();
//
//			checkingid=j.queryForList(checkid,pid,s1);
//			checkingid1=j.queryForList(rolechecking,s1);
//			System.out.println("role: "+checkingid);
//			for(Map maprole:checkingid1) {
//			role=(String)maprole.get("role");
//
//			}
//			if(checkingid.isEmpty()) {
//			a= s1+" employ id is  not belongs to your project";
//
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//			}else {
//			DateTimeFormatter dtf= DateTimeFormatter.ofPattern("HH:mm");
//			// Duration dt=Duration.ofMinutes(45);
//			LocalTime ld= LocalTime.now();
//			String time1=ld.format(dtf);
//			String du=p.getDuration();
//			System.out.println(time1);
//			String mname=p.getMeetingname();
//			String meeting_id= mname + time1;
//			String created_by=username;
//			String desc=p.getDescription();
//			String status="c";
//			// String date= d1;
//			String start_time=ld.format(dtf);
//			String stime=p.getStarttime();
//			if(stime==null) {
//			stime=start_time;
//			}
//			LocalTime start=LocalTime.parse(stime, dtf);
//			LocalTime endtime=start.plusMinutes(dur);
//			String end_time=endtime.format(dtf);
//			for(Map map:checking) {
//			String role1=(String)map.get("role");
//			if(!(role1.equals("e") && (role.equals("p") || role.equals("h")))) {
//			String insertquery="insert into Meeting_table values(?,?,?,?,?,?,?,?,?,?,?)";
//			int insertquerydata=j.update(insertquery,meeting_id,mname,s1,proid,stime,end_time,dur,time,created_by,status,desc);
//			if(insertquerydata>0) {
//			a="meeting sheduled";
//			}
//			}
//			else {
//
//			}
//			}
//			}	 
//			}
//			}
//			return message;
//			}
//
//
//			 return check;
//			}
//		}
//					 {
//			String s2="insert into contactdetails values(?,?,?,?,?,?,?,?,?,?)";
//			int a1=j.update(s2,meid,men,stime,etime,con,cre,dur,dat,st,proid);
//		}
//		
//		
//		
//		return a;
//	}
//
//}
		
		 {
			String message="",checkrole="";
			String username=m.getFname();
			System.out.println(username);
			String password=m.getPwd();
			System.out.println(password);
			DateTimeFormatter d= DateTimeFormatter.ofPattern("dd/MM/YYYY");
			LocalDateTime l= LocalDateTime.now();
			LocalDate d1=LocalDate.now();
			String time=d.format(l);
			String check="select * from details where fname=? and pwd=? and status='a' and (role='pm' or role='h' or role='e')";
			List<Map<String,Object>> checking = new ArrayList<Map<String,Object>>();
			checking=j.queryForList(check,username,password);
			System.out.println(checking);
			if(checking.isEmpty()) {
			System.out.println("heelo");
			return "invalid credentials";
			
			}else {
			System.out.println("dfsdf");
			String project_id= m.getProjectid();
			String meeting_contact_details=m.getContact();
			String [] emp=meeting_contact_details.split(",");
			String checkid="select * from projectconcatdetails where projectid=? and projectname=? ";
			
			for(String s1:emp) {
			String rolechecking="select role from details where lname=?";
			List<Map<String,Object>> checkingid= new ArrayList<Map<String,Object>>();
			List<Map<String,Object>> checkingid1= new ArrayList<Map<String,Object>>();
			checkingid=j.queryForList(checkid,project_id,s1);
			checkingid1=j.queryForList(rolechecking,s1);
			System.out.println("role: "+checkingid);
			for(Map maprole:checkingid1) {
			checkrole=(String)maprole.get("role");
			}
			if(checkingid.isEmpty()) {
			message= s1+" employ id is  not belongs to your project";
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			}else {
			DateTimeFormatter dtf= DateTimeFormatter.ofPattern("HH:mm");
			// Duration dt=Duration.ofMinutes(45);
			LocalTime ld= LocalTime.now();
			String time1=ld.format(dtf);
			int duration=m.getDuration();
			System.out.println(time1);
			String meeting_name=m.getMeetingname();
			String meeting_id= meeting_name + time1;
			String created_by=username;
			String description=m.getDescription();
			String status="c";
			// String date= d1;
			String start_time=ld.format(dtf);
			String starttime=m.getStarttime();
			if(starttime==null) {
			starttime=start_time;
			}
			LocalTime start=LocalTime.parse(starttime, dtf);
			LocalTime endtime=start.plusMinutes(duration);
			String end_time=endtime.format(dtf);
			for(Map map:checking) {
			String role1=(String)map.get("role");
			if(!(role1.equals("e") && (checkrole.equals("pm") || checkrole.equals("h")))) {
				System.out.println("helloo");
			String insertquery="insert into Meetingdetails values(?,?,?,?,?,?,?,?,?)";
			System.out.println("anjuuuuu");
			int insertquerydata=j.update(insertquery,meeting_id,meeting_name,project_id,starttime,end_time,duration,created_by,status,description);
             System.out.print(insertquerydata);
         	System.out.println("anjuuuuu");
             if(insertquerydata>0) {
System.out.println("hiiii");
spring();
			message="meeting sheduled";

			}

			}

			else {
				
			}

			}

			} 
			}
			
			}
			return message;

		 }

			public String spring() {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
          mailMessage.setFrom("anjalibaditha333@gmail.com");
        mailMessage.setTo("sireeshasaripilli3@gmail.com");
        mailMessage.setText("this is spring boot task.");
        mailMessage.setSubject("spring boot");

      
		// Sending the mail
        javaMailSender.send(mailMessage);
        return "Mail Sent Successfully...";
    
		 }
			
		}
	

			

