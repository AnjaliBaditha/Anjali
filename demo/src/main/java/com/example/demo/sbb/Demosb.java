package com.example.demo.sbb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demosb {
	@GetMapping
	public String display()
	{
		return "hi";
	}
@Autowired
demoex d;
@PostMapping("add/{a}/{b}")
public int  add(@PathVariable int a,@PathVariable int b) {
	int c=d.add(a,b);
	return c;
}
@GetMapping("sub/{x}/{y}")

	public int  sub(@PathVariable int x,@PathVariable int y)
	{
	int e=d.sub(x,y);
	return e;
	}
//@PostMapping("mul")

//public int mul(@RequestBody Getex g )
//{
//int e=d.mul(g.getX(),g.getY());
//return e;
//}
//@PostMapping("div1")
//
//public int  div2(@RequestBody Getex g )
//{
//int e1=d.div(g.getX(),g.getY());
//return e1;
//}
@PostMapping("div1")

public String  div(@RequestBody Getex g )
{
	try
	{
		return Integer.toString(g.x/g.y);
	}
	catch(ArithmeticException e)
	{
		return e.getMessage();
	}
}

}
