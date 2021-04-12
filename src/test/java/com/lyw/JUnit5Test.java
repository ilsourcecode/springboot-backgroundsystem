package com.lyw;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Junit5注解测试类")
public class JUnit5Test {

  @DisplayName("测试DisplayName注解功能")
  @Test
  void displayNameTest() {
    System.out.println(1);
  }

  @BeforeEach
  void beforeMethodIsRun() {
    System.out.println("@BeforeEach每个测试方法执行了。。。。");
  }

  @AfterEach
  void afterMethodIsRen() {
    System.out.println("@AfterEach每个测试方法执行后执行。。。。。。。。。");
  }

  @DisplayName("简单断言测试")
  @Test
  void asssertionsTest() {
    int sum = sum(1, 3);
    //断言提示信息
    assertEquals(4, sum, "业务逻辑错误");
    Object o1 = new Object();
    Object o2 = o1;
    assertSame(o1, o2, "两个对象不相等！");
    assertArrayEquals(new int[]{1, 2}, new int[]{1, 2}, "数组不相等！");
  }

  int sum(int a, int b) {
    return a + b;
  }

  @Test
  @DisplayName("测试前置条件")
  void assumptions() {
    Assumptions.assumeTrue(false, "结果不为true");
    System.out.println(111);
  }


}
