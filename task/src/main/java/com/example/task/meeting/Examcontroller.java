package com.example.task.meeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Examcontroller {
	@Autowired
	Examservice es;
	@PostMapping("micro")
	public int spp(@RequestBody Exampojo p)
	{
		return es.ex(p);
		 
	}
	
	

}
