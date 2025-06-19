package com.martin.userman.model.request;

import com.martin.userman.model.constant.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionRequest implements Serializable {
	private String accountId;
	private PaymentType paymentType;
	private Long amount;
}
