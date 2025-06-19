package com.martin.userman.service;

import com.martin.userman.model.Account;
import com.martin.userman.model.Transaction;
import com.martin.userman.model.User;
import com.martin.userman.model.response.AccountResponse;
import com.martin.userman.model.response.TransactionResponse;
import com.martin.userman.model.response.UserResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ConverterService {
	UserResponse convertToUserResponse(User user);
	AccountResponse convertToAccountResponse(Account account);
	List<AccountResponse> convertToAccountListResponse(List<Account> accounts);
	TransactionResponse convertToTransactionResponse(Transaction transaction);
}
