package com.miles.lottery.mapper;

import com.miles.lottery.bean.StudentDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

	List<StudentDto> findAllStuent(@Param("limt") Double limt);

}
