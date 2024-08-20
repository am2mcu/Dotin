package org.example;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerHandler {
    private static final CustomerHandler SINGLETON = new CustomerHandler();
    private final Map<String, Customer> customerMap = new HashMap<>();

    private CustomerHandler() {
    }

    public static CustomerHandler getSINGLETON() {
        return SINGLETON;
    }

    public Collection<Customer> getCustomers() {
        return customerMap.values();
    }

    public void addCustomer(Customer customer) {
        customerMap.put(customer.getId(), customer);
    }
}
