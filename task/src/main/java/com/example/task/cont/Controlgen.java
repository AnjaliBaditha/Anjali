package com.example.task.cont;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlgen {
	@Autowired
	Servicegen sq;
//	@PostMapping("insert1")
//	public String ins(@RequestBody Setgetpojo p)
//	{
//		int i=sq.insert(p);
//		if(i>0)
//		{
//			return "done";
//			
//		}
//		else
//		{
//			return "not done";
//		}
//	}
//	@GetMapping("sele1")
//	public List fetch1() {
//		return sq.select8();
//	}
	@GetMapping("getdata")
	public List springs(@RequestBody Setgetpojo ss)
	{
		
		List re=sq.selec1(ss);
		return re;
	}
	
		
}
