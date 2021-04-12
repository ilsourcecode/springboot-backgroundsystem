package com.lyw.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("users")
public class User implements Serializable {
  private static final long serialVersionUID = -6849794470754661390L;

  private Integer id;
  private String username;
  @TableField("password")
  private String passwd;
}
