package com.saggy.HMS.controllers;

import com.saggy.HMS.models.Bill;
import com.saggy.HMS.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bills")
public class BillControllers {

    @Autowired
    private BillService billService;
    // Dependency injection of BillService using @Autowired
    // Spring provides the instance automatically using component scanning and auto-configuration

    @GetMapping
    public List<Bill> getAllBills() {
        System.out.println("Fetching the bills");
        return billService.getAllBills();
    }

    @PostMapping
    public Bill createBill(@RequestBody Bill bill) {
        System.out.println("Creating Bill");
        return billService.createBill(bill);
    }

    @GetMapping("/{id}")
    public Bill getBillById(@PathVariable Long id) {
        System.out.println("Fetching bill by id");
        return billService.getBillById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBill(@PathVariable Long id) {
        System.out.println("Deleting bill by id");
        billService.deleteBill(id);
    }

    @PutMapping("/{id}")
    public void updateBill(@PathVariable Long id, @RequestBody Bill bill) {
        System.out.println("Updating bill by id");
        billService.updateBill(id, bill);
    }
}
