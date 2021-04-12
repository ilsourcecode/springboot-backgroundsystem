package com.lyw.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyw.entity.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper extends BaseMapper<Student> {

//  @Select("select id, name, email, age from student order by id asc")
  List<Student> findStudents();
}
