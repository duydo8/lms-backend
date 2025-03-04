package com.duydv.lms.controllers;

import com.duydv.lms.dtos.response.BaseResponse;
import com.duydv.lms.entities.LmsSubject;
import com.duydv.lms.services.impl.LmsSubjectService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subject")
@RequiredArgsConstructor
@CrossOrigin("*")
public class LmsSubjectController {

  private final LmsSubjectService lmsSubjectService;

  @GetMapping("/findAll")
  public ResponseEntity<?> findAll() {
    return ResponseEntity.ok(new BaseResponse(lmsSubjectService.findAll(),200, "find successfully"));
  }

  @PostMapping("/save")
  public ResponseEntity<?> save(@RequestBody @Valid LmsSubject lmsSubject) {
    LmsSubject currentSubject = lmsSubjectService.findByName(lmsSubject.getName());
    if (currentSubject != null || lmsSubject.getName().isEmpty()) {
      return ResponseEntity.ok().body(new BaseResponse(400, "Subject already exists"));
    }

    return ResponseEntity.ok(new BaseResponse(
        lmsSubjectService.save(lmsSubject), 200, "Subject save successfully")
    );
  }

  @PutMapping("/update")
  public ResponseEntity<?> update(@RequestBody LmsSubject lmsSubject) {
    LmsSubject subject = lmsSubjectService.findById(lmsSubject.getId());
    if (subject == null) {
      ResponseEntity.ok().body(new BaseResponse(400, "Subject not found"));
    }

    LmsSubject currentSubject = lmsSubjectService.findByName(lmsSubject.getName());
    if (currentSubject != null) {
      return ResponseEntity.ok().body(new BaseResponse(400, "Subject already exists"));
    }

    lmsSubject = lmsSubjectService.update(lmsSubject);
    return ResponseEntity.ok(new BaseResponse(lmsSubject, 200, "Subject updated"));
  }

  @GetMapping("/findById")
  public ResponseEntity<?> findById(@RequestParam Integer id) {
    LmsSubject subject = lmsSubjectService.findById(id);
    if (subject != null) {
      return ResponseEntity.ok(new BaseResponse(subject, 200, "Subject found"));
    }

    return ResponseEntity.ok(new BaseResponse(404, "Subject not found"));
  }

  @GetMapping("/findByName")
  public ResponseEntity<?> findById(@RequestParam String name) {
    List<LmsSubject> subject = lmsSubjectService.findLikeName(name);
    if (subject != null) {
      return ResponseEntity.ok(new BaseResponse(subject, 200, "Subject found"));
    }

    return ResponseEntity.ok(new BaseResponse(404, "Subject not found"));
  }

  @DeleteMapping("/deleteById")
  public ResponseEntity<?> delete(@RequestParam Integer id) {
    LmsSubject subject = lmsSubjectService.findById(id);
    if (subject != null) {
      lmsSubjectService.deleteById(id);
      return ResponseEntity.ok(new BaseResponse(subject.getId(), 200, "delete successfully"));
    }

    return ResponseEntity.ok(new BaseResponse(404, "Subject not found"));
  }
}
