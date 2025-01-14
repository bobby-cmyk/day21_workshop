package vttp.paf.day21_workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp.paf.day21_workshop.models.Customer;
import vttp.paf.day21_workshop.repositories.CustomerRepository;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepo;
    
    public List<Customer> getCustomers(int limit, int offset) {
        return customerRepo.getCustomers(limit, offset);
    }

    public Optional<Customer> getCustomerById(int id) {
        return customerRepo.getCustomerById(id);
    }
}
