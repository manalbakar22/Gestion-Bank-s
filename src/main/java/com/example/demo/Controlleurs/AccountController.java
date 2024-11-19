package com.example.demo.Controlleurs;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AccountDto;
import com.example.demo.services.AccountService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
@Tag(name = "accounts")
public class AccountController {

  private final AccountService service;

  @PostMapping("/")
  public ResponseEntity<Integer> save(
      @RequestBody AccountDto accountDto
  ) {
    return ResponseEntity.ok(service.save(accountDto));
  }

  @GetMapping("/")
  public ResponseEntity<List<AccountDto>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/{account-id}")
  public ResponseEntity<AccountDto> findById(
      @PathVariable("account-id") Integer accountId
  ) {
    return ResponseEntity.ok(service.findById(accountId));
  }

  @DeleteMapping("/{account-id}")
  public ResponseEntity<Void> delete(
      @PathVariable("account-id") Integer accountId
  ) {
    service.delete(accountId);
    return ResponseEntity.accepted().build();
  }

}
