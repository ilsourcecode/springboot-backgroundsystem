package com.lyw.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyw.entity.Student;
import com.lyw.mapper.StudentMapper;
import com.lyw.service.StudentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Log4j2
@Controller
public class TablesController {

  @Autowired
  StudentService studentService;

  @GetMapping("/dynamic_table")
  public String dynamic_table(
          @RequestParam(value = "pn", defaultValue = "1") Integer pn,
          Model model
  ) {

//    List<Student> students = studentService.list();
//    model.addAttribute("students", students);
    Page<Student> studentPage = new Page<>(pn, 4);
    Page<Student> page = studentService.page(studentPage);
    model.addAttribute("page", page);

    return "tables/dynamic_table";
  }

  @GetMapping("/editable_table")
  public String editable_table() {
    return "tables/editable_table";
  }

  @GetMapping("/responsive_table")
  public String responsive_table(HttpServletRequest request) {
    List<Student> students = studentService.list();
    request.setAttribute("students", students);
    return "tables/responsive_table";
  }

  @GetMapping("/delete/{id}")
  public  String deleteStudent(
          @PathVariable("id") Long id,
          @RequestParam(value = "pn",defaultValue = "1") Integer pn,
          RedirectAttributes redirectAttributes
  ) {
    boolean b = studentService.removeById(id);
    if (!b)
      return "删除失败！";
//    return "删除成功！";

    redirectAttributes.addAttribute("pn", pn);
    return "redirect:/dynamic_table";

  }
}
