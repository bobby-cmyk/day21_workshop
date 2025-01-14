package vttp.paf.day21_workshop.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp.paf.day21_workshop.models.Customer;
import static vttp.paf.day21_workshop.models.Customer.*;

import static vttp.paf.day21_workshop.repositories.Queries.*;


@Repository
public class CustomerRepository {
    
    @Autowired
    private JdbcTemplate template;

    public List<Customer> getCustomers(final int limit, final int offset) {
        final List<Customer> customers = new ArrayList<>();

        final SqlRowSet rs = template.queryForRowSet(SQL_GET_CUSTOMERS, limit, offset);

        while (rs.next()) {
            customers.add(toCustomer(rs));
        }

        return (Collections.unmodifiableList(customers));
    }

    public Optional<Customer> getCustomerById(int id) {
        SqlRowSet rs = template.queryForRowSet(SQL_GET_CUSTOMER_BY_ID, id);
        
        // If empty
        if (!rs.next()) {
            return Optional.empty();
        }

        Customer customer = toCustomer(rs);
        
        return Optional.of(customer);
    }

    
}
