package com.miles.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miles.springboot.mapper.StudentMapper;

@RestController
@RequestMapping("/student")
@EnableAutoConfiguration
public class StudentController {

	@Resource
	private StudentMapper studentMapper;
	
	@RequestMapping("/list/{limt}")
	Map<String, Object> list(@PathVariable(required = false) Double limt) {
		System.out.println(limt);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", studentMapper.findAllStuent(limt));
		map.put("code", "10000");
		map.put("msg", "操作成功");
		return map;
	}

}