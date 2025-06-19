package com.martin.userman.service.impl;

import com.martin.userman.handler.exception.ResourceNotFound;
import com.martin.userman.model.Account;
import com.martin.userman.model.Transaction;
import com.martin.userman.model.constant.PaymentType;
import com.martin.userman.model.request.TransactionRequest;
import com.martin.userman.model.response.TransactionReportResponse;
import com.martin.userman.model.response.TransactionResponse;
import com.martin.userman.repository.AccountRepository;
import com.martin.userman.repository.TransactionRepository;
import com.martin.userman.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired private TransactionRepository transactionRepository;

	@Autowired private AccountRepository accountRepository;

	@Override
	public Transaction addTransaction(TransactionRequest transactionRequest) throws Exception {

		try {
			Account account = getAccountByAccountId(transactionRequest);

			validateAmount(transactionRequest, account);

			Transaction transaction = new Transaction();
			transaction.setAccount(account);
			transaction.setType(transactionRequest.getPaymentType());
			transaction.setBalance(transactionRequest.getAmount());

			this.transactionRepository.save(transaction);
			account.setBalance(account.getBalance() - transactionRequest.getAmount());
			this.accountRepository.save(account);

			return transaction;

		} catch (Exception e) {
			e.printStackTrace();
			throw  new ResourceNotFound(e.getMessage());
		}

	}

	private static void validateAmount(TransactionRequest transactionRequest, Account account)
			throws Exception {
		if (PaymentType.DEBIT.equals(transactionRequest.getPaymentType())) {
			if (account.getBalance() < transactionRequest.getAmount()) {
				throw new ResourceNotFound("Not enough balance");
			}
		}
	}

	private Account getAccountByAccountId(TransactionRequest transactionRequest) throws Exception {
		Account account =
				accountRepository.findById(UUID.fromString(transactionRequest.getAccountId())).orElse(null);
		if (account == null) {
			throw new Exception("Account not found");
		}
		return account;
	}

	@Override
	public Page<TransactionResponse> getTransactionHistory(String accountId, int page, int size) {
		Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
		return transactionRepository.findByAccountId(UUID.fromString(accountId), pageable).map(
				transaction -> new TransactionResponse(transaction.getId().toString(),
						transaction.getAccount().getId().toString(), transaction.getType().toString(),
						transaction.getBalance(), transaction.getCreatedAt()));
	}

	@Override
	public TransactionReportResponse getTransactionReport(PaymentType type, LocalDateTime start,
			LocalDateTime end) {
		return transactionRepository.getTransactionReport(type, start, end);
	}
}
