/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duydv.lms.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * @author pc
 */
@Entity
@Data
@Table(name = "lms_profile")
public class LmsProfile implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  private Integer id;

  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "name")
  private String name;

  @Size(max = 255)
  @Column(name = "avatar")
  private String avatar;

  @Column(name = "birthday")
  private Date birthday;

  @Column(name = "gender")
  private Integer gender;

  @NotNull
  @Column(name = "grade_id")
  private Integer gradeId;

  @NotNull
  @Column(name = "status")
  private Integer status;

  @Column(name = "created_at")
  private Date createdAt = new Date();

  @Column(name = "updated_at")
  private Date updatedAt;

  @Column(name = "account_id")
  private Integer accountId;

  @Column(name = "is_default")
  private Integer isDefault;

  @Column(name = "is_vip")
  private Integer isVip;

  @Column(name = "is_paid")
  private Integer isPaid;

  @Size(max = 255)
  @Column(name = "province_code")
  private String provinceCode;

  @Column(name = "district_id")
  private Integer districtId;

  @Column(name = "school_id")
  private Integer schoolId;

  private Integer crmChildId;

  private Integer lmsId;

  private Integer expireDate;

  private String lmsGradeCode;

  private String lmsLevelCode;

  private String crmProduct;
}
