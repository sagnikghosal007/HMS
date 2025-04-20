package com.saggy.HMS.repo;

import com.saggy.HMS.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BillRepository extends JpaRepository<Bill,Long>{
}
