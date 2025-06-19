package com.martin.userman.repository;

import com.martin.userman.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
	@Query("SELECT a FROM account a WHERE a.user.id = :userId")
	List<Account> findAccountsByUserId(@Param("userId") UUID userId);
}
