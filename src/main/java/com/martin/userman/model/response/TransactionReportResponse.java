package com.martin.userman.model.response;

import com.martin.userman.model.constant.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionReportResponse {
	private PaymentType type;
	private long totalTransactions;
	private double totalAmount;
}
