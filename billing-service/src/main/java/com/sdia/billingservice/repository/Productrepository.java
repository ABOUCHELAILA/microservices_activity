package com.sdia.billingservice.repository;

import com.sdia.billingservice.entities.bill;
import com.sdia.billingservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Productrepository extends JpaRepository<Product,Long> {
}
