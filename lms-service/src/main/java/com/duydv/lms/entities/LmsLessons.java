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
@Table(name = "lms_lessons")
public class LmsLessons implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  private Integer id;

  @Column(name = "stage_id")
  private Integer stageId;

  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "title")
  private String title;

  @Size(max = 1000)
  @Column(name = "description")
  private String description;

  @Column(name = "thumbnail")
  private String thumbnail;

  @NotNull
  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "deleted_at")
  private Date deletedAt;

  @Column(name = "created_at")
  private Date createdAt;

  @Column(name = "updated_at")
  private Date updatedAt;
}
