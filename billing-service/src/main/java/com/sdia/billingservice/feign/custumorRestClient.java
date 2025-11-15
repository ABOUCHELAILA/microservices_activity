package com.sdia.billingservice.feign;

import com.sdia.billingservice.model.custumor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.web.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface custumorRestClient {

    @GetMapping("/api/customers/{id}")
    custumor getCustomerById(@PathVariable Long id);

    @GetMapping("/api/customers")
    PagedModel<custumor> getAllCustomers();
}
