package com.company.DI.service;

import com.company.DI.dto.AccountFilterRequest;
import com.company.DI.dto.AccountSaveRequest;
import com.company.DI.dto.AccountUpdateRequest;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    public void saveAccount(AccountSaveRequest request){
        System.out.println("account saved : "+request);
    }

    public void updateAccount(AccountUpdateRequest request, Long id){
        System.out.println("account updated : "+"id" + id + " " +request);
    }

    public String getAccounts(AccountFilterRequest request){
        System.out.println("get filtered accounts : "+request);
        return "accounts";
    }

    public String getAccountById(Long id){
        System.out.println("get account by id : "+id);
        return "account";
    }

    public void deleteAccountById(Long id){
        System.out.println("delete account by id : "+id);
    }
}
