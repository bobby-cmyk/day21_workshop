package vttp.paf.day21_workshop.repositories;

import static vttp.paf.day21_workshop.repositories.Queries.SQL_GET_CUSTOMER_BY_ID;
import static vttp.paf.day21_workshop.repositories.Queries.SQL_GET_ORDERS_BY_CUSTOMER_ID;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp.paf.day21_workshop.models.Order;
import static vttp.paf.day21_workshop.models.Order.*;

@Repository
public class OrderRepository {
    
    @Autowired
    private JdbcTemplate template;

    public Optional<List<Order>> getOrdersByCustomerId(int customerId){
        // Check if customer exists
        SqlRowSet rsCustomer = template.queryForRowSet(SQL_GET_CUSTOMER_BY_ID, customerId);

        if (!rsCustomer.next()) {
            // Return empty if customer does not exist
            return Optional.empty();
        }

        List<Order> orders = new ArrayList<>();

        // If customer exists
        SqlRowSet rsOrder = template.queryForRowSet(SQL_GET_ORDERS_BY_CUSTOMER_ID, customerId);

        while (rsOrder.next()) {
            orders.add(toOrder(rsOrder));
        }

        return Optional.of(orders);
    }
}
