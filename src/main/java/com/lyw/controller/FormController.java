package com.lyw.controller;

import com.lyw.entity.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Log4j2
@Controller
public class FormController {

  /*@PostMapping("/uploadfile")
  public String upload(
          User user,
          @RequestPart("header") MultipartFile header,
          @RequestPart("photos") MultipartFile[] photos
  ) throws IOException {
    log.info("username={},passwd={},header={},photos={}",
            user.getUsername(), user.getPasswd(), header.getSize(), photos.length);
    if (header.isEmpty())
      return "上传失败！";
    header.transferTo(new File("/Users/liyawei/idea_workspace/review-springboot2-atguigu/springboot-systemos/src/main/resources/picture/header/" + header.getOriginalFilename()));
    for (MultipartFile photo : photos) {
      if (photo.isEmpty())
        return "上传失败！";
      photo.transferTo(new File("/Users/liyawei/idea_workspace/review-springboot2-atguigu/springboot-systemos/src/main/resources/picture/photos/" + photo.getOriginalFilename()));
    }

    return "redirect:/main.html";
  }*/

  @GetMapping("/form_layouts")
  public String form_layouts() {
    return "form/form_layouts";
  }

  @PostMapping("/uploadfile")
  public String upload(
          User user,
          @RequestPart("header")MultipartFile header,
          @RequestPart("photos")MultipartFile[] photos
          ) throws IOException {

    log.info("user={}", user);

    if (header.isEmpty())
      return "上传失败";
    for (MultipartFile photo : photos) {
      if (photo.isEmpty())
        return "上传失败";

      photo.transferTo(
              new File("/Users/liyawei/idea_workspace/backgroundsystem/src/main/resources/picture/photos/"
                      + photo.getOriginalFilename()));
    }
    header.transferTo(new File("/Users/liyawei/idea_workspace/backgroundsystem/src/main/resources/picture/header/"
            + header.getOriginalFilename()));

    return "redirect:/main.html";
  }

}
