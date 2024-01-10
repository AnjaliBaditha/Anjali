package com.example.task.cont2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class Controllerinsert {
	@Autowired
	Serviceinsert s;
	
	@PostMapping("map")
	public String spring(@RequestBody Pojoinsert p)
	{
//		System.out.println("hii");
		int re=s.insert2(p);
//		System.out.println("hiip");
		if(re!=0) {
			return "inserted";
		}
		else {
			return "not inserted";
		}
	
	}
	
	

}
