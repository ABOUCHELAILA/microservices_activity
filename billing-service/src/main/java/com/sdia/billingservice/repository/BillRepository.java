package com.sdia.billingservice.repository;

import com.sdia.billingservice.entities.bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository  extends JpaRepository<bill, Long>  {
}
