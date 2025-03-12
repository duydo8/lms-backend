package com.duydv.lms.controllers;

import com.duydv.lms.constant.MessageConstant;
import com.duydv.lms.dtos.request.AccountFindAllRequest;
import com.duydv.lms.dtos.response.BaseResponse;
import com.duydv.lms.entities.LmsAccount;
import com.duydv.lms.services.impl.LmsAccountService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class LmsAccountController {

  private final LmsAccountService lmsAccountService;
  private final PasswordEncoder passwordEncoder;

  @PostMapping("/findAll")
  public ResponseEntity<BaseResponse> findAll(
      @RequestBody AccountFindAllRequest accountFindAllRequest) {
    if (accountFindAllRequest.getPage() == null || accountFindAllRequest.getSize() == null) {
      accountFindAllRequest.setPage(0);
      accountFindAllRequest.setSize(10);
    }

    if (accountFindAllRequest.getPage() < 0 || accountFindAllRequest.getSize() < 0) {
      ResponseEntity.ok()
          .body(new BaseResponse(400, MessageConstant.MESSAGE_PAGE_AND_SIZE_INVALID));
    }

    return ResponseEntity.ok(new BaseResponse(
        lmsAccountService.findAllPageable(accountFindAllRequest), 200,
        MessageConstant.MESSAGE_FOUND)
    );
  }

  @PostMapping("/save")
  public ResponseEntity<BaseResponse> save(@RequestBody @Valid LmsAccount lmsAccount) {
    if (lmsAccount.getPhone() == null) {
      return ResponseEntity.ok(new BaseResponse(400, MessageConstant.MESSAGE_INVALID_PARAMS));
    }
    LmsAccount account = lmsAccountService.findByPhone(lmsAccount.getPhone());
    if (account != null) {
      return ResponseEntity.ok(new BaseResponse(400, MessageConstant.MESSAGE_ALREADY_EXISTS));
    }
    lmsAccount.setPassword(passwordEncoder.encode(lmsAccount.getPassword()));

    return ResponseEntity.ok(new BaseResponse(
        lmsAccountService.save(lmsAccount), 200, MessageConstant.MESSAGE_SAVE_SUCCESS)
    );
  }

  @GetMapping("/findById")
  public ResponseEntity<BaseResponse> findById(@RequestParam Integer id) {
    LmsAccount lmsAccount = lmsAccountService.findById(id);
    if (lmsAccount != null) {
      return ResponseEntity.ok(new BaseResponse(lmsAccount, 200, MessageConstant.MESSAGE_FOUND));
    }
    return ResponseEntity.ok(new BaseResponse(400, MessageConstant.MESSAGE_NOT_FOUND));
  }

  @DeleteMapping("/deleteById")
  public ResponseEntity<BaseResponse> delete(@RequestParam Integer id) {
    LmsAccount lmsAccount = lmsAccountService.findById(id);
    if (lmsAccount != null) {
      lmsAccountService.deleteById(id);
      return ResponseEntity.ok(
          new BaseResponse(lmsAccount.getId(), 200, MessageConstant.MESSAGE_DELETE_SUCCESS));
    }
    return ResponseEntity.ok(new BaseResponse(400, MessageConstant.MESSAGE_NOT_FOUND));
  }
}
