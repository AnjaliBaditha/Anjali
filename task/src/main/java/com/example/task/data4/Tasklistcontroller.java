package com.example.task.data4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.task.data2.Addpojo;
import com.example.task.data2.Addservice;
@RestController
public class Tasklistcontroller {
	@Autowired
	Tasklistservice sk;
		@PostMapping("data")
		public String sp(@RequestBody Tasklistpojo p)
		{

			int re=sk.sell(p);
			if(re!=0) {
				return "inserted";
			}
			else {
				return "not inserted";
			}
		}
		
		
		
		@Autowired
		Tasklistservice skk;
			@PostMapping("data12")
			public String spp(@RequestBody Tasklistpojo p1)
			{

				int re=skk.selup(p1);
				if(re!=0) {
					return "inserted";
				}
				else {
					return "not inserted";
				}
			}
		
			@Autowired
			Tasklistservice skkk;
				@PostMapping("dataa")
				public String sppp(@RequestBody Tasklistpojo p2)
				{

					int re=skk.selin(p2);
					if(re!=0) {
						return "inserted";
					}
					else {
						return "not inserted";
					}
				}
			
}


