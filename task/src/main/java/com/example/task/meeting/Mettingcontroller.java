package com.example.task.meeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Mettingcontroller {
	@Autowired
	Mettingservice es;
	@PostMapping("mica")
	public String met23(@RequestBody Mettingpojo p)
	{
		return es.met(p);
		 
	}

}
