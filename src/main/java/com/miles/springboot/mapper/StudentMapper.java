package com.miles.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.miles.springboot.dto.StudentDto;

public interface StudentMapper {

	public List<StudentDto> findAllStuent(@Param("limt") Double limt);  

}
