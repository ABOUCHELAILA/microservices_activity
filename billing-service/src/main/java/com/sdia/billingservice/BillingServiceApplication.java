package com.sdia.billingservice;

import com.sdia.billingservice.entities.ProductItem;
import com.sdia.billingservice.entities.bill;
import com.sdia.billingservice.feign.ProductRestClient;
import com.sdia.billingservice.feign.custumorRestClient;
import com.sdia.billingservice.model.Product;
import com.sdia.billingservice.model.custumor;
import com.sdia.billingservice.repository.BillRepository;
import com.sdia.billingservice.repository.Productrepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(BillRepository  billRepository,
                                        Productrepository productItemRepository,
                                        custumorRestClient customerRestClient,
                                        ProductRestClient productRestClient){

        return args -> {
            Collection<custumor> customers = customerRestClient.GetAllCustumors().getContent();
            Collection<Product> products = productRestClient.getAllProducts().getContent();

            customers.forEach(customer -> {
                bill Bill = bill.builder()
                        .billingDate(new Date())
                        .customerId(customer.getId())
                        .build();
                billRepository.save(Bill);
                products.forEach(product -> {
                    ProductItem productItem = ProductItem.builder()
                            .bill(Bill)
                            .productId(product.getId())
                            .quantity(1+new Random().nextInt(10))
                            .unitPrice(product.getPrice())
                            .build();
                    productItemRepository.save(productItem);
                });
            });
        };
    }


}
