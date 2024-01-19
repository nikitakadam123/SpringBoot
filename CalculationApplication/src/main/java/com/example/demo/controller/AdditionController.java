package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.*;
import com.example.demo.model.Number;
@RestController
@RequestMapping("/api")
public class AdditionController {
	@PostMapping("/add")
	public int addnumber(@RequestBody Number num)
	{
		int sum=num.getN1()+num.getN2();
		System.out.println("Sum is: "+sum);
		
		return sum;
	 
	}

}
