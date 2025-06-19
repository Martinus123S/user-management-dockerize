package com.martin.userman.model;

import com.martin.userman.model.constant.PaymentType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "transaction")
@Data
public class Transaction {
	@Id
	@GeneratedValue
	private UUID id;

	private Long balance;

	private PaymentType type;

	@ManyToOne
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;

	private LocalDateTime createdAt;

	@PrePersist
	public void prePersist() {
		createdAt = LocalDateTime.now();
	}
}
