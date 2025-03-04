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

@Entity
@Data
@Table(name = "lms_courses")
public class LmsCourses implements Serializable, Cloneable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  private Integer id;

  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "title")
  private String title;

  @Column(name = "thumbnail")
  private String thumbnail;

  @Size(max = 1000)
  @Column(name = "description")
  private String description;

  @NotNull
  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "deleted_at")
  private Date deletedAt;

  @Column(name = "created_at")
  private Date createdAt;

  @Column(name = "updated_at")
  private Date updatedAt;

  @Column(name = "level")
  private Integer level;

  @Column(name = "grade_id")
  private Integer gradeId;

  @Column(name = "subject_id")
  private Integer subjectId;

  @Override
  public LmsCourses clone() {
    try {
      LmsCourses clone = (LmsCourses) super.clone();
      // TODO: copy mutable state here, so the clone can't change the internals of the original
      return clone;
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }
}
