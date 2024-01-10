package com.example.task.cont3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Projectcontroller {
	
	@Autowired
	Projectservice ss;
	
	@PostMapping("anju")
	public String specific(@RequestBody Projectpojo p)
	{

		int re=ss.inse(p);
		if(re!=0) {
			return "inserted";
		}
		else {
			return "not inserted";
		}
	}
	@Autowired
	Projectservice2 sk;
		@PostMapping("anjali")
		public String sp(@RequestBody Projectpojo p)
		{

			int re=sk.sel(p);
			if(re!=0) {
				return "inserted";
			}
			else {
				return "not inserted";
			}
		}
			@Autowired
			Projectservice3 skk;
				@PostMapping("anjalidevi")
				public String spp(@RequestBody Projectpojo p)
				{

//					int re=skk.sel2(p);
//					if(re!=0) {
//						return "inserted";
//					}
//					else {
//						return "not inserted";
//					}
					return skk.sel2(p);
	}
}
