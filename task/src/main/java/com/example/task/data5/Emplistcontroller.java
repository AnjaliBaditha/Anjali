package com.example.task.data5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.task.data2.Addpojo;
import com.example.task.data2.Addservice;
import com.example.task.data3.Copypojo;
import com.example.task.data3.Copyservice;

@RestController
public class Emplistcontroller {
	@Autowired
	Emplistservice skk;
	@Autowired
	Stausservice skkk;
		@PostMapping("detail")
		public String spp(@RequestBody Emplistpojo p)
		{
			return skk.emp(p);
			 
		}

@PostMapping("det")
			public String st(@RequestBody Emplistpojo p1)
			{
				return skkk.status(p1);
				 

	}
}


