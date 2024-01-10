package com.example.task.data3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Copycontroller {
	@Autowired
	Copyservice skk;
		@PostMapping("data3")
		public String spp(@RequestBody Copypojo p)
		{
			return skk.sel(p);
}
}



