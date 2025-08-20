package com.ilf.domain.customer.gateway;

import com.ilf.domain.customer.Customer;

public interface CustomerGateway {
    Customer getByById(String customerId);
}
