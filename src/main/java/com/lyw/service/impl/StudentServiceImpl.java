package com.lyw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyw.entity.Student;
import com.lyw.mapper.StudentMapper;
import com.lyw.service.StudentService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

  /*Counter counter;

  public StudentServiceImpl(MeterRegistry meterRegistry) {
    counter = meterRegistry.counter("StudentServiceImpl.list.count");
  }*/
}
