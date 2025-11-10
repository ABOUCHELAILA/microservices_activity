package com.sdia.custumorservice.repository;

import com.sdia.custumorservice.entities.custumor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface custumorRepository extends JpaRepository<custumor,Long> {
}