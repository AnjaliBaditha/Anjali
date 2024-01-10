package com.example.demo.sbb;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class demoex {
	
	int add(int a,int b) {
		return a+b;
	}
	
		int sub(int x,int y)
		{
		return x-y;
	}
		int mul(int x,int y)
		{
		return x*y;
	}
		int div(int x,int y)
		{
			return x/y;
		}
}
