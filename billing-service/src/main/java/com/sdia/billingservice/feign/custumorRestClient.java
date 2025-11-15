package com.sdia.billingservice.feign;

import com.sdia.billingservice.model.custumor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "custumor-service")
public interface custumorRestClient {

    @GetMapping("/api/custumors/{id}")
    custumor getCustomerById(@PathVariable Long id);



    @GetMapping("/api/custumors")
    PagedModel<custumor> GetAllCustumors();
}
