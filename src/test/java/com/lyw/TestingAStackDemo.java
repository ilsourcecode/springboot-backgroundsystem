package com.lyw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("嵌套测试")
public class TestingAStackDemo {

  Stack<Object> stack;

  @Test
  @DisplayName("创建个栈")
  void isInstantiatedWith() {
    new Stack<>();
    assertNull(stack);
  }

  @Nested
  @DisplayName("什么时候创建的")
  class WhenNew {


    @BeforeEach
    void createNewStack() {
      stack = new Stack<>();
    }

    @Test
    @DisplayName("栈是空的")
    void isEmpty() {
      assertTrue(stack.isEmpty());
    }

    @Test
    @DisplayName("当栈弹出的时候会出异常")
    void throwExceptionWhenPopped() {
      assertThrows(EmptyStackException.class, stack::pop, "栈本来就是空的，没值弹出了！");
    }

    @Test
    @DisplayName("查看栈的第一个元素会报异常")
    void throwsExceptionWhenPeeked() {
      assertThrows(EmptyStackException.class, stack::peek, "栈本来就是空的！");
    }

    @Nested
    @DisplayName("最后添加元素")
    class AfterPushing {

      String element = "an element";

      @BeforeEach
      void pushAnElement() {
        stack.push(element);
      }

      @Test
      @DisplayName("测试栈中不为空")
      void isNotEmpty() {
        assertTrue(!stack.isEmpty());
      }

      @Test
      @DisplayName("弹出一个元素后，是不是栈为空")
      void returnElementWhenPopped() {
        assertEquals(element, stack.pop());
        assertTrue(stack.isEmpty());
      }

      @Test
      @DisplayName("栈的第一个元素是否相同，栈是否为空")
      void isEmptyWhenPeekStackElement() {
        assertEquals(element, stack.peek());
        assertTrue(stack.isEmpty(), "不为空！");
      }

    }
  }
}
