package com.example.task.data1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Detailscontroller {
	@Autowired
	Detailsservice ss;
	
	@PostMapping("data1")
	public String specific(@RequestBody Detailspojo p)
	{

		int re=ss.inse(p);
		if(re!=0) {
			return "inserted";
		}
		else {
			return "not inserted";
		}
	}

}
