package com.martin.userman.service.impl;

import com.martin.userman.handler.exception.ResourceNotFound;
import com.martin.userman.model.Account;
import com.martin.userman.model.User;
import com.martin.userman.model.request.AccountRequest;
import com.martin.userman.repository.AccountRepository;
import com.martin.userman.repository.UserRepository;
import com.martin.userman.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public Account createAccount(AccountRequest accountRequest) throws ResourceNotFound {
		try {
			User user = userRepository.findById(UUID.fromString(accountRequest.getUserId())).orElse(null);

			if (Objects.isNull(user)) {
				throw new ResourceNotFound("User not found");
			}

			Account account = new Account();
			account.setUser(user);
			account.setBalance(accountRequest.getBalance());

			accountRepository.save(account);

			return account;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResourceNotFound("Error");
		}
	}

	@Override
	public List<Account> getAccounts(String userId) {
		List<Account> accounts = this.accountRepository.findAccountsByUserId(UUID.fromString(userId));
		return accounts;
	}
}
