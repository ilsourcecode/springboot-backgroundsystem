package com.lyw.controller;

import com.lyw.entity.Student;
import com.lyw.entity.User;
import com.lyw.mapper.StudentMapper;
import com.lyw.service.impl.TestServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Log4j2
@Controller
public class IndexController {

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Autowired
  StudentMapper studentMapper;

  @Autowired
  StringRedisTemplate redisTemplate;

  @Autowired
  TestServiceImpl testService;

  @ResponseBody
  @GetMapping("/student")
  public String doSome() {
    /*Long aLong = jdbcTemplate.queryForObject("select count(*) from student", Long.class);
    return "along -> " + aLong;*/

    List<Student> student = studentMapper.findStudents();
    return student.toString();
  }

  @GetMapping({"/", "/login"})
  public String login() {
    return "login";
  }

  @PostMapping("/login")
  public String main(User user, HttpSession session, Model model) {
    //HttpSession  session = request.getSession();
    if (!StringUtils.isEmpty(user.getUsername()) && "123456".equals(user.getPasswd()))
    {
      session.setAttribute("user", user);
      //防止表单重复提交
      return "redirect:/main.html";
    }
    model.addAttribute("meg", "用户名账户或密码错误，请重新登录！");
    //request.setAttribute("meg", "用户名账户或密码错误，请重新登录！");
    return "/login";
  }

  @GetMapping("/main.html")
  public String index(Model model) {
    ValueOperations<String, String> operations = redisTemplate.opsForValue();
    String main = operations.get("/main.html");
    model.addAttribute("mainCount", main);
    return "main";
  }

  @GetMapping("/test")
  @ResponseBody
  public String some() {
    testService.print();
    return "123";
  }

}
