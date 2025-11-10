package com.sdia.inventoryservice.Repository;


import com.sdia.inventoryservice.entities.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductRepository  extends JpaRepository<product,String> {

}