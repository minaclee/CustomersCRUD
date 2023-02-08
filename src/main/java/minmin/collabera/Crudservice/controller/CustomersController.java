package minmin.collabera.Crudservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import minmin.collabera.Crudservice.exception.UserNotFoundException;
import minmin.collabera.Crudservice.model.Customers;
import minmin.collabera.Crudservice.repo.CustomerRepository;

@RestController
public class CustomersController {

    @Autowired
    private CustomerRepository customerRepo;

    @PostMapping("/customer")
    public Customers newCustomer(@RequestBody Customers newCustomer) {
        return customerRepo.save(newCustomer);
    }

    @GetMapping("/customers")
    public List<Customers> getAllCustomers() {
        return customerRepo.findAll();
    }

    @GetMapping("/customer/{id}")
    Customers getMovieById(@PathVariable Long id) {
        return customerRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/customer/{id}")
    public Customers updateMovie(@RequestBody Customers newCustomer, @PathVariable Long id) {
        return customerRepo.findById(id)
                .map(customer -> {
                    customer.setName(newCustomer.getName());
                    customer.setAddress(newCustomer.getAddress());
                    customer.setCustomerType(newCustomer.getCustomerType());
                    return customerRepo.save(customer);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/customer/{id}")
    public String deleteUser(@PathVariable Long id) {
        if (!customerRepo.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        customerRepo.deleteById(id);
        return "User with id " + id + " has been deleted success.";
    }

}
