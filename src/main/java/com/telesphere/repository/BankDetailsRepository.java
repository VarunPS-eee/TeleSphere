package com.telesphere.repository;

import com.telesphere.model.BankDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankDetailsRepository extends JpaRepository<BankDetails, Long> {
    Optional<BankDetails> findByCardNumber(String cardNumber);
}
