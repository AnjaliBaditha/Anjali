package com.example.task.data2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class Addcontoller {
	@Autowired
	Addservice sk;
		@PostMapping("data2")
		public String sp(@RequestBody Addpojo p)
		{

			int re=sk.sel(p);
			if(re!=0) {
				return "inserted";
			}
			else {
				return "not inserted";
			}
		}

}
