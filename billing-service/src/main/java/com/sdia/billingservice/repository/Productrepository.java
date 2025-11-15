package com.sdia.billingservice.repository;

import com.sdia.billingservice.entities.ProductItem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Productrepository extends JpaRepository<ProductItem,Long> {
}
