package com.martin.userman.service;

import com.martin.userman.model.Transaction;
import com.martin.userman.model.constant.PaymentType;
import com.martin.userman.model.request.TransactionRequest;
import com.martin.userman.model.response.TransactionReportResponse;
import com.martin.userman.model.response.TransactionResponse;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

public interface TransactionService {
	Transaction addTransaction(TransactionRequest transactionRequest) throws Exception;

	Page<TransactionResponse> getTransactionHistory(String accountId, int page, int size);

	TransactionReportResponse getTransactionReport(PaymentType type, LocalDateTime start,
			LocalDateTime end);
}
