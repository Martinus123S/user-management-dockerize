package com.martin.userman.service.impl;

import com.martin.userman.model.Account;
import com.martin.userman.model.Transaction;
import com.martin.userman.model.User;
import com.martin.userman.model.response.AccountResponse;
import com.martin.userman.model.response.TransactionResponse;
import com.martin.userman.model.response.UserResponse;
import com.martin.userman.service.ConverterService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConverterServiceImpl implements ConverterService {

	@Override
	public UserResponse convertToUserResponse(User user) {

		UserResponse userResponse = new UserResponse();
		userResponse.setId(user.getId().toString());
		userResponse.setName(user.getName());
		userResponse.setEmail(user.getEmail());
		userResponse.setCreatedAt(user.getCreatedAt());
		return userResponse;
	}

	@Override
	public AccountResponse convertToAccountResponse(Account account) {


		AccountResponse accountResponse = new AccountResponse();
		accountResponse.setAccountId(account.getId().toString());
		accountResponse.setBalance(account.getBalance());
		accountResponse.setCreatedAt(account.getCreatedAt());
		accountResponse.setUserId(account.getUser().getId().toString());
		return accountResponse;
	}

	@Override
	public List<AccountResponse> convertToAccountListResponse(List<Account> accounts) {
		List<AccountResponse> accountResponses = new ArrayList<AccountResponse>();
		for (Account account : accounts) {
			accountResponses.add(convertToAccountResponse(account));
		}
		return accountResponses;
	}

	@Override
	public TransactionResponse convertToTransactionResponse(Transaction transaction) {
		TransactionResponse transactionResponse = new TransactionResponse();
		transactionResponse.setId(transaction.getId().toString());
		transactionResponse.setAccountId(transaction.getAccount().getId().toString());
		transactionResponse.setAmount(transaction.getBalance());
		transactionResponse.setTimestamp(transaction.getCreatedAt());
		return transactionResponse;
	}
}
