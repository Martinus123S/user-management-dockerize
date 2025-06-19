package com.martin.userman.model.response;

import com.martin.userman.model.request.TransactionRequest;
import com.martin.userman.model.response.wrapper.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {

	private String id;
	private String accountId;
	private String type;
	private Long amount;
	private LocalDateTime timestamp;
}
