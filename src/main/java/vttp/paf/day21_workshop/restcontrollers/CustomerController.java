package vttp.paf.day21_workshop.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import vttp.paf.day21_workshop.models.Customer;
import vttp.paf.day21_workshop.services.CustomerService;

import static vttp.paf.day21_workshop.models.Customer.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private CustomerService customerSvc;

    @GetMapping("/customers")
    public ResponseEntity<String> getCustomers(
        @RequestParam(name="limit", defaultValue="5") int limit,
        @RequestParam(name="offset", defaultValue="0") int offset
    ) 
    {
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();

        customerSvc.getCustomers(limit, offset).stream()
            .map(r -> toJsonObject(r))
            .forEach(j -> arrBuilder.add(j));

        return ResponseEntity.ok(arrBuilder.build().toString());
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<String> getCustomerById(
        @PathVariable(name="id", required=true) int id
    ) 
    {
        Optional<Customer> opt = customerSvc.getCustomerById(id);
        
        if(opt.isEmpty()) {
            JsonObjectBuilder objBuilder = Json.createObjectBuilder();

            JsonObject jsonObj = objBuilder
                .add("message", "Customer id does not exist")
                .add("status", "404")
                .build();

            return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(jsonObj.toString());
        }

        Customer customer = opt.get();

        return ResponseEntity.ok().body(toJsonObject(customer).toString());
    }
}
