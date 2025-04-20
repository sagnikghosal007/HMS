package com.saggy.HMS.services;

import com.saggy.HMS.models.Bill;
import com.saggy.HMS.repo.BillRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    private static final Logger logger = LoggerFactory.getLogger(BillService.class);

    @Autowired
    private BillRepository billRepository;

    public List<Bill> getAllBills() {
        try {
            System.out.println("Into the bill service");
            return billRepository.findAll();
        } catch (Exception e) {
            System.out.println("Error Message: " + e.getMessage());
            logger.error("An error occurred while fetching all bills: {}", e.getMessage());
            return null;
        }
    }

    public Bill getBillById(Long id) {
        try {
            Optional<Bill> bill = billRepository.findById(id);
            return bill.orElse(null);
        } catch (Exception e) {
            System.out.println("Error Message: " + e.getMessage());
            logger.error("An error occurred while fetching bill with id {}: {}", id, e.getMessage());
            return null;
        }
    }

    public Bill createBill(Bill bill) {
        try {
            billRepository.save(bill);
            return bill;
        } catch (Exception e) {
            System.out.println("Error Message: " + e.getMessage());
            logger.error("An error occurred while creating a bill: {}", e.getMessage());
            return null;
        }
    }

    public void deleteBill(Long id) {
        try {
            logger.info("Deleting bill with id: {}", id);
            billRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error Message: " + e.getMessage());
            logger.error("An error occurred while deleting bill with id {}: {}", id, e.getMessage());
        }
    }

    public Bill updateBill(Long id, Bill updatedBill) {
        try {
            Optional<Bill> existingBill = billRepository.findById(id);
            if (existingBill.isPresent()) {
                Bill bill = existingBill.get();
                bill.setPatientId(updatedBill.getPatientId());
                bill.setAmount(updatedBill.getAmount());
                bill.setStatus(updatedBill.getStatus());
                billRepository.save(bill);
                return bill;
            } else {
                logger.error("Bill with id {} not found", id);
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error Message: " + e.getMessage());
            logger.error("An error occurred while updating bill with id {}: {}", id, e.getMessage());
            return null;
        }
    }
}
