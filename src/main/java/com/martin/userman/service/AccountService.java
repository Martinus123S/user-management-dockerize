package com.martin.userman.service;

import com.martin.userman.handler.exception.ResourceNotFound;
import com.martin.userman.model.Account;
import com.martin.userman.model.request.AccountRequest;

import java.util.List;

public interface AccountService {
	Account createAccount(AccountRequest accountRequest) throws ResourceNotFound;
	List<Account> getAccounts(String userId);
}
