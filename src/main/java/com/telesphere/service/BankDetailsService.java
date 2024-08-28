package com.telesphere.service;

import com.telesphere.model.BankDetails;
import com.telesphere.repository.BankDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankDetailsService {

    @Autowired
    private BankDetailsRepository bankDetailsRepository;

    // Create or update bank details
    public BankDetails saveBankDetails(BankDetails bankDetails) {
        return bankDetailsRepository.save(bankDetails);
    }

    // Get all bank details
    public List<BankDetails> getAllBankDetails() {
        return bankDetailsRepository.findAll();
    }

    // Get bank details by ID
    public Optional<BankDetails> getBankDetailsById(Long id) {
        return bankDetailsRepository.findById(id);
    }

    public Optional<BankDetails> getBankDetailsByCardNumber(String cardNumber) {
        return bankDetailsRepository.findByCardNumber(cardNumber);
    }

    // Update bank details by ID
    public Optional<BankDetails> updateBankDetails(Long id, BankDetails bankDetailsDetails) {
        return bankDetailsRepository.findById(id).map(bankDetails -> {
            bankDetails.setCardNumber(bankDetailsDetails.getCardNumber());
            bankDetails.setCvv(bankDetailsDetails.getCvv());
            bankDetails.setPin(bankDetailsDetails.getPin());
            bankDetails.setUser(bankDetailsDetails.getUser());
            return bankDetailsRepository.save(bankDetails);
        });
    }

    // Delete bank details by ID
    public boolean deleteBankDetails(Long id) {
        if (bankDetailsRepository.existsById(id)) {
            bankDetailsRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
