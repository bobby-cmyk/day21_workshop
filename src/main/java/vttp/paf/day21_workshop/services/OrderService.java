package vttp.paf.day21_workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp.paf.day21_workshop.models.Order;
import vttp.paf.day21_workshop.repositories.OrderRepository;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepo;

    public Optional<List<Order>> getOrdersByCustomerId(int customerId) {
        return orderRepo.getOrdersByCustomerId(customerId);
    }
}
