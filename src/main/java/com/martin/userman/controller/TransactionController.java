package com.martin.userman.controller;

import com.martin.userman.model.Transaction;
import com.martin.userman.model.constant.PaymentType;
import com.martin.userman.model.request.TransactionRequest;
import com.martin.userman.model.response.TransactionReportResponse;
import com.martin.userman.model.response.TransactionResponse;
import com.martin.userman.model.response.wrapper.BaseResponse;
import com.martin.userman.service.ConverterService;
import com.martin.userman.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired private TransactionService transactionService;

	@Autowired private ConverterService converterService;

	@PostMapping("/add-transaction")
	public TransactionResponse addTransaction(@RequestBody TransactionRequest transactionRequest)
			throws Exception {
		Transaction transaction = this.transactionService.addTransaction(transactionRequest);
		return this.converterService.convertToTransactionResponse(transaction);
	}

	@GetMapping("/account/{accountId}/history")
	public Page<TransactionResponse> getTransaction(@PathVariable String accountId,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		return this.transactionService.getTransactionHistory(accountId, page, size);
	}

	@GetMapping("/reporting")
	public TransactionReportResponse getTransactionReporting(
			@RequestParam(required = false) PaymentType type,
			@RequestParam("start_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
			LocalDateTime startDate,
			@RequestParam("end_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
			LocalDateTime endDate) {
		return this.transactionService.getTransactionReport(type, startDate, endDate);
	}
}
