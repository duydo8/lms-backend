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
import jakarta.persistence.JoinColumn;
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
@Table(name = "lms_schedules")
public class LmsSchedules implements Cloneable, Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  private Integer id;

  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "title")
  private String title;

  @Column(name = "parent_id")
  private Integer parentId;

  @Size(max = 255)
  @Column(name = "description")
  private String description;

  @NotNull
  @Column(name = "is_active")
  private Boolean isActive;

  @Size(max = 255)
  @Column(name = "content")
  private String content;

  @Size(max = 255)
  @Column(name = "`values`")
  private String values;

  @Column(name = "deleted_at")
  private Date deletedAt;

  @Column(name = "created_at")
  private Date createdAt;

  @Column(name = "updated_at")
  private Date updatedAt;

  @JoinColumn(name = "course_id")
  private Integer courseId;

  @Column(name = "type")
  private Integer type;

  @Override
  public LmsSchedules clone() {
    try {
      LmsSchedules clone = (LmsSchedules) super.clone();
      // TODO: copy mutable state here, so the clone can't change the internals of the original
      return clone;
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }
}
