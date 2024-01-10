package com.example.task.cont;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controllerex {
	@Autowired																									
	Serviceex s;
	@PostMapping("insert")
public String insert(@RequestBody Employee e)
{
		int i=s.insert(e);
		if(i>0)
		{
			return "inserted sucessfully";
		}
		else
		{
			return "can't inserted";
		}
}
}
