package com.sdia.billingservice.web;

import com.sdia.billingservice.entities.Bill;
import com.sdia.billingservice.feign.ProductRestClient;
import com.sdia.billingservice.feign.custumorRestClient;
import com.sdia.billingservice.repository.BillRepository;
import com.sdia.billingservice.repository.Productrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {


    @Autowired
    private BillRepository billRepository;
    @Autowired
    private Productrepository productItemRepository;
    @Autowired
    private custumorRestClient customerRestClient;
    @Autowired
    private ProductRestClient productRestClient;
    @GetMapping(path = "/bills/{id}")
    public Bill getBill(@PathVariable Long id){

        Bill bill = billRepository.findById(id).get();

        bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomerId()));

        bill.getProductItems().forEach(productItem -> {
            productItem.setProduct(productRestClient.getProductById(productItem.getProductId()));
        });
        return bill;
    }
}
