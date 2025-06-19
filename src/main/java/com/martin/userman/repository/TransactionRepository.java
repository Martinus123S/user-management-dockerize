package com.martin.userman.repository;

import com.martin.userman.model.Transaction;
import com.martin.userman.model.constant.PaymentType;
import com.martin.userman.model.response.TransactionReportResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

	Page<Transaction> findByAccountId(UUID accountId, Pageable pageable);

	@Query("""
				SELECT new com.martin.userman.model.response.TransactionReportResponse(
					t.type, COUNT(t), SUM(t.balance)
				)
				FROM transaction t
				WHERE t.createdAt BETWEEN :start AND :end
				AND (:type IS NULL OR t.type = :type)
				group by t.type
			""")
	TransactionReportResponse getTransactionReport(@Param("type") PaymentType type,
			@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

}
