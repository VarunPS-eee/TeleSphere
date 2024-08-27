package com.telesphere.repository;

import com.telesphere.model.BankDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankDetailsRepository extends JpaRepository<BankDetails, Long> {
}
