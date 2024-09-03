package com.telesphere.controller;

import com.telesphere.model.BankDetails;
import com.telesphere.service.BankDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/bank-details")
public class BankDetailsController {

    @Autowired
    private BankDetailsService bankDetailsService;

    @GetMapping("/validate")
    public ResponseEntity<Map<String, Boolean>> validateBankDetails(
            @RequestParam String cardNumber,
            @RequestParam String cvv,
            @RequestParam String pin
    ) {
        Optional<BankDetails> bankDetails = bankDetailsService.getBankDetailsByCardNumber(cardNumber);

        if (bankDetails.isPresent()) {
            BankDetails details = bankDetails.get();
            boolean isValid = details.getCvv() == Integer.parseInt(cvv) && details.getPin() == Integer.parseInt(pin);
            Map<String, Boolean> response = new HashMap<>();
            response.put("isValid", isValid);

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create new bank details
    @PostMapping
    public ResponseEntity<BankDetails> createBankDetails(@RequestBody BankDetails bankDetails) {
        BankDetails createdBankDetails = bankDetailsService.saveBankDetails(bankDetails);
        return ResponseEntity.ok(createdBankDetails);
    }

    // Get all bank details
    @GetMapping
    public ResponseEntity<List<BankDetails>> getAllBankDetails() {
        List<BankDetails> bankDetails = bankDetailsService.getAllBankDetails();
        return ResponseEntity.ok(bankDetails);
    }

    // Get bank details by ID
    @GetMapping("/{id}")
    public ResponseEntity<BankDetails> getBankDetailsById(@PathVariable Long id) {
        Optional<BankDetails> bankDetails = bankDetailsService.getBankDetailsById(id);
        return bankDetails.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update bank details by ID
    @PutMapping("/{id}")
    public ResponseEntity<BankDetails> updateBankDetails(@PathVariable Long id, @RequestBody BankDetails bankDetailsDetails) {
        Optional<BankDetails> updatedBankDetails = bankDetailsService.updateBankDetails(id, bankDetailsDetails);
        return updatedBankDetails.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete bank details by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBankDetails(@PathVariable Long id) {
        boolean deleted = bankDetailsService.deleteBankDetails(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
