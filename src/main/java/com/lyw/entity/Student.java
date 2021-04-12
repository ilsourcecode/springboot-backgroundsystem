package com.lyw.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student implements Serializable {

  private static final long serialVersionUID = -6849794470124261390L;

  //这个属性在表中不存在
  @TableField(exist = false)
  private String userName;

  private Integer id;
  private String name;
  private String email;
  private Integer age;
}
