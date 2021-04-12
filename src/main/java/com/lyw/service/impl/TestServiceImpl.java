package com.lyw.service.impl;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl {

  Counter counter;

  public TestServiceImpl(MeterRegistry meterRegistry) {
    counter = meterRegistry.counter("TestServiceImpl.print.count");
  }

  public void print() {
    counter.increment();
    System.out.println("is run!");
  }
}
