package com.martin.userman.controller;

import com.martin.userman.handler.exception.ResourceNotFound;
import com.martin.userman.model.Account;
import com.martin.userman.model.request.AccountRequest;
import com.martin.userman.model.response.AccountResponse;
import com.martin.userman.service.AccountService;
import com.martin.userman.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private ConverterService converterService;

	@PostMapping
	public AccountResponse createAccount(@RequestBody AccountRequest accountRequest)
			throws ResourceNotFound {
		Account account = this.accountService.createAccount(accountRequest);
		return converterService.convertToAccountResponse(account);
	}

	@GetMapping("/{id}")
	public List<AccountResponse> getAllAccount(@PathVariable String id){
		List<Account> accounts = this.accountService.getAccounts(id);
		return converterService.convertToAccountListResponse(accounts);
	}
}
