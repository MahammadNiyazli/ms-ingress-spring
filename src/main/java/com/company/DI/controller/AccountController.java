package com.company.DI.controller;

import com.company.DI.dto.AccountFilterRequest;
import com.company.DI.dto.AccountSaveRequest;
import com.company.DI.dto.AccountUpdateRequest;
import com.company.DI.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAccount(@RequestBody AccountSaveRequest request){
        accountService.saveAccount(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateAccount(@PathVariable Long id,@RequestBody AccountUpdateRequest request){
        accountService.updateAccount(request,id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String getAccounts(AccountFilterRequest request){
        return accountService.getAccounts(request); //imagine, there is a response class ;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getAccountById(@PathVariable Long id){
        return accountService.getAccountById(id); //imagine, there is a response class ;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccountById(@PathVariable Long id){
         accountService.deleteAccountById(id);
    }

}
