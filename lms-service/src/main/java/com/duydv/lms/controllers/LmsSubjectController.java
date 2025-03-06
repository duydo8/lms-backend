package com.duydv.lms.controllers;

import com.duydv.lms.constant.MessageConstant;
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
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/subject")
public class LmsSubjectController {

  private final LmsSubjectService lmsSubjectService;

  @GetMapping("/findAll")
  public ResponseEntity<BaseResponse> findAll() {
    return ResponseEntity.ok(
        new BaseResponse(lmsSubjectService.findAll(), 200, MessageConstant.MESSAGE_FOUND));
  }

  @PostMapping("/save")
  public ResponseEntity<BaseResponse> save(@RequestBody @Valid LmsSubject lmsSubject) {
    LmsSubject currentSubject = lmsSubjectService.findByName(lmsSubject.getName());
    if (currentSubject != null || lmsSubject.getName().isEmpty()) {
      return ResponseEntity.ok()
          .body(new BaseResponse(400, MessageConstant.MESSAGE_ALREADY_EXISTS_ERROR));
    }

    return ResponseEntity.ok(new BaseResponse(
        lmsSubjectService.save(lmsSubject), 200, MessageConstant.MESSAGE_SAVE_SUCCESS)
    );
  }

  @PutMapping("/update")
  public ResponseEntity<BaseResponse> update(@RequestBody LmsSubject lmsSubject) {
    LmsSubject subject = lmsSubjectService.findById(lmsSubject.getId());
    if (subject == null) {
      ResponseEntity.ok().body(new BaseResponse(400, MessageConstant.MESSAGE_NOT_FOUND));
    }

    LmsSubject currentSubject = lmsSubjectService.findByName(lmsSubject.getName());
    if (currentSubject != null) {
      return ResponseEntity.ok()
          .body(new BaseResponse(400, MessageConstant.MESSAGE_ALREADY_EXISTS_ERROR));
    }

    lmsSubject = lmsSubjectService.update(lmsSubject);
    return ResponseEntity.ok(
        new BaseResponse(lmsSubject, 200, MessageConstant.MESSAGE_SAVE_SUCCESS));
  }

  @GetMapping("/findById")
  public ResponseEntity<BaseResponse> findById(@RequestParam Integer id) {
    LmsSubject subject = lmsSubjectService.findById(id);
    if (subject != null) {
      return ResponseEntity.ok(new BaseResponse(subject, 200, MessageConstant.MESSAGE_FOUND));
    }

    return ResponseEntity.ok(new BaseResponse(404, MessageConstant.MESSAGE_NOT_FOUND));
  }

  @GetMapping("/findByName")
  public ResponseEntity<BaseResponse> findById(@RequestParam String name) {
    List<LmsSubject> subject = lmsSubjectService.findLikeName(name);
    if (subject != null) {
      return ResponseEntity.ok(new BaseResponse(subject, 200, MessageConstant.MESSAGE_FOUND));
    }

    return ResponseEntity.ok(new BaseResponse(404, MessageConstant.MESSAGE_NOT_FOUND));
  }

  @DeleteMapping("/deleteById")
  public ResponseEntity<BaseResponse> delete(@RequestParam Integer id) {
    LmsSubject subject = lmsSubjectService.findById(id);
    if (subject != null) {
      lmsSubjectService.deleteById(id);
      return ResponseEntity.ok(
          new BaseResponse(subject.getId(), 200, MessageConstant.MESSAGE_DELETE_SUCCESS));
    }

    return ResponseEntity.ok(new BaseResponse(404, MessageConstant.MESSAGE_NOT_FOUND));
  }
}
