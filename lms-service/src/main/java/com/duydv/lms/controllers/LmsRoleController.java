package com.duydv.lms.controllers;

import com.duydv.lms.constant.MessageConstant;
import com.duydv.lms.dtos.response.BaseResponse;
import com.duydv.lms.entities.LmsRoles;
import com.duydv.lms.services.impl.LmsRoleService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/role")
public class LmsRoleController {

  private final LmsRoleService lmsRoleService;

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
        lmsRoleService.findAllPageable(pageable), 200, MessageConstant.MESSAGE_FOUND)
    );
  }

  @PostMapping("/save")
  public ResponseEntity<BaseResponse> save(@RequestBody @Valid LmsRoles lmsRoles) {
    return ResponseEntity.ok(new BaseResponse(
        lmsRoleService.save(lmsRoles), 200, MessageConstant.MESSAGE_SAVE_SUCCESS)
    );
  }

  @GetMapping("/findById")
  public ResponseEntity<BaseResponse> findById(@RequestParam Integer id) {
    LmsRoles lmsRoles = lmsRoleService.findById(id);
    if (lmsRoles != null) {
      return ResponseEntity.ok(new BaseResponse(lmsRoles, 200, MessageConstant.MESSAGE_FOUND));
    }

    return ResponseEntity.ok(new BaseResponse(400, MessageConstant.MESSAGE_NOT_FOUND));
  }

  @PutMapping("/update")
  public ResponseEntity<BaseResponse> update(@RequestBody LmsRoles lmsRoles) {
    LmsRoles roles = lmsRoleService.findById(lmsRoles.getId());
    if (roles == null) {
      return ResponseEntity.ok().body(new BaseResponse(400, MessageConstant.MESSAGE_NOT_FOUND));
    }

    roles.setName(lmsRoles.getName());
    return ResponseEntity.ok(
        new BaseResponse(lmsRoleService.save(roles), 200, MessageConstant.MESSAGE_SAVE_SUCCESS)
    );
  }

  @DeleteMapping("/deleteById")
  public ResponseEntity<BaseResponse> delete(@RequestParam Integer id) {
    LmsRoles lmsRoles = lmsRoleService.findById(id);
    if (lmsRoles != null) {
      lmsRoleService.deleteById(id);
      return ResponseEntity.ok(
          new BaseResponse(lmsRoles.getId(), 200, MessageConstant.MESSAGE_DELETE_SUCCESS));
    }

    return ResponseEntity.ok(new BaseResponse(400, MessageConstant.MESSAGE_NOT_FOUND));
  }
}
