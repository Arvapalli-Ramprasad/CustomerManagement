package com.example.Customers.Controllers;
import com.example.Customers.Models.Customer;
import com.example.Customers.Requests.UpdateCustomer;
import com.example.Customers.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

//Adding customer to the customerDb using postmaping
    @PostMapping("addCustomer")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity addCustomer(@RequestBody Customer customer){
        try {
            String response = customerService.addCustomer(customer);
            return new ResponseEntity(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    //Getting customer from the customerdb using @GetMapping
    //handling using try catch if the customerId not exists

    @GetMapping("getCustomer")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity getCustomerById(@RequestParam Integer customerId){
        try {
            Customer customer = customerService.getCustomerById(customerId);
            return new ResponseEntity<>(customer,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    //Deleting customer from the customerdb using @DeleteMapping
    //handling using try catch if the customerId not exists
    @DeleteMapping("deleteCustomer")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity deleteCustomerById(@RequestParam Integer customerId){
        try{
            String response = customerService.deleteCustomerById(customerId);
            return new ResponseEntity(response,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    //Updating customer from the customerdb using @UpdateMapping
    //handling using try catch if the customerId not exists
    @PutMapping("updateCustomer/{customerId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity updateCustomer(@RequestBody UpdateCustomer updateCustomer, @PathVariable Integer customerId){
        try {
            String response = customerService.updateCustomer(updateCustomer,customerId);
            return new ResponseEntity(response,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    //Getting all customer list from the customerdb using @GetMapping
    //handling using try catch if the customerId not exists
    @GetMapping("getCustomers")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Page<Customer> getAllCustomers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "customerId") String sort,
            @RequestParam(defaultValue = "asc") String direction,
            @RequestParam(defaultValue = "") String search) {
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sort));
        return customerService.searchCustomers(search, pageable);
    }

}
