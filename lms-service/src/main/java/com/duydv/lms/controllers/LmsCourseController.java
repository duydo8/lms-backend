package com.duydv.lms.controllers;

import com.duydv.lms.constant.MessageConstant;
import com.duydv.lms.dtos.response.BaseResponse;
import com.duydv.lms.entities.LmsCourses;
import com.duydv.lms.services.impl.LmsCourseService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/course")
public class LmsCourseController {

  private final LmsCourseService lmsCourseService;

  @GetMapping("/findAll")
  public ResponseEntity<BaseResponse> findAll(
      @RequestParam(required = false) Integer page,
      @RequestParam(required = false) Integer size
  ) {
    if (page == null || size == null) {
      page = 0;
      size = 10;
    }

    if (page < 0 || size < 0) {
      ResponseEntity.ok()
          .body(new BaseResponse(400, MessageConstant.MESSAGE_PAGE_AND_SIZE_INVALID));
    }

    Pageable pageable = PageRequest.of(page, size);

    return ResponseEntity.ok(new BaseResponse(
        lmsCourseService.findAllPageable(pageable), 200, MessageConstant.MESSAGE_FOUND)
    );
  }

  @PostMapping("/save")
  public ResponseEntity<BaseResponse> save(@RequestBody @Valid LmsCourses lmsCourses) {
    return ResponseEntity.ok(new BaseResponse(
        lmsCourseService.save(lmsCourses), 200, MessageConstant.MESSAGE_SAVE_SUCCESS)
    );
  }

  @GetMapping("/findById")
  public ResponseEntity<BaseResponse> findById(@RequestParam Integer id) {
    LmsCourses lmsCourses = lmsCourseService.findById(id);
    if (lmsCourses != null) {
      return ResponseEntity.ok(new BaseResponse(lmsCourses, 200, MessageConstant.MESSAGE_FOUND));
    }
    return ResponseEntity.ok(new BaseResponse(400, MessageConstant.MESSAGE_NOT_FOUND));
  }

  @DeleteMapping("/deleteById")
  public ResponseEntity<BaseResponse> delete(@RequestParam Integer id) {
    LmsCourses lmsCourses = lmsCourseService.findById(id);
    if (lmsCourses != null) {
      lmsCourseService.deleteById(id);
      return ResponseEntity.ok(
          new BaseResponse(lmsCourses.getId(), 200, MessageConstant.MESSAGE_DELETE_SUCCESS));
    }
    return ResponseEntity.ok(new BaseResponse(400, MessageConstant.MESSAGE_NOT_FOUND));
  }
}
