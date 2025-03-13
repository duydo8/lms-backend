package com.duydv.lms.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Data
@Table(name = "lms_account")
public class LmsAccount {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  private Integer id;

  // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
  @Size(max = 20)
  @Column(name = "phone")
  private String phone;

  @Size(max = 255)
  @Column(name = "password")
  private String password;

  @Size(max = 45)
  @Column(name = "full_name")
  private String fullName;

  @Column(name = "gender")
  private Integer gender;

  // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
  @Size(max = 45)
  @Column(name = "email")
  private String email;

  @Size(max = 255)
  @Column(name = "address")
  private String address;

  @Column(name = "birthday")
  private Date birthday;

  @NotNull
  @Column(name = "status")
  private Integer status;

  @NotNull
  @Column(name = "role_id")
  private Integer roleId;

  @Column(name = "avatar_url")
  private String avatarUrl;

  @CreatedDate
  @Column(name = "created_at")
  private Date createdAt = new Date();

  @LastModifiedDate
  @Column(name = "updated_at")
  private Date updatedAt;
}
