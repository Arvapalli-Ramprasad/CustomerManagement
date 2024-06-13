package com.example.Customers.Services;

import com.example.Customers.Models.Customer;
import com.example.Customers.Repositories.CustomerRepository;
import com.example.Customers.Requests.UpdateCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    public CustomerRepository customerRepository;

    //All the service layers works based on controller requests
    public String addCustomer(Customer customer) throws Exception{
        //gettting the customer by customer emailId
        Customer customer1 = customerRepository.findByEmail(customer.getEmail());
        if(customer1==null){////if customer email not there in db then add the customer to the customer to the customer db
            customer = customerRepository.save(customer);
            return "The Customer has been saved successfully with customerId "+customer.getCustomerId();
        }
        else {//if customer email already in db
            throw new Exception("The Customer email already exists");
        }

    }
    //Getting customer by passing customerId
    public Customer getCustomerById(Integer customerId) throws Exception{
        //finding the customer in customerdb using customerId
        Optional<Customer> customer = customerRepository.findById(customerId);
        if(customer.isPresent()){//if present return else thrwo excetion
            return customer.get();
        }
        else {
            throw new Exception("Customer not found with customerID: " + customerId);
        }
    }

    //delete customer by passing customerId
    public String deleteCustomerById(Integer customerId) throws Exception{
        //finding the customer in customerdb using customerId
        Optional<Customer> customer = customerRepository.findById(customerId);
//        customerRepository.delete();
        if(customer.isPresent()){//if present delete else thrwo excetion
            customerRepository.delete(customer.get());
            return "The customer has been deleted successfully with customerId "+customerId;
        }
        else {
            throw new Exception("No customer exists in DB with customerId "+customerId);
        }
    }

    //updating customer
    public String updateCustomer(UpdateCustomer updateCustomer, Integer customerId) throws Exception{
        //finding the customer in customerdb using customerId
        Optional<Customer> customer = customerRepository.findById(customerId);
        if(customer.isPresent()){//if present then edit based on required attributes to edit
            Customer customer1 = customer.get();
            customer1.setAddress(updateCustomer.getAddress());
            customer1.setState(updateCustomer.getState());
            customer1.setCity(updateCustomer.getCity());
            customer1.setEmail(updateCustomer.getEmail());
            customer1.setPhone(updateCustomer.getPhone());
            customer1.setStreet(updateCustomer.getStreet());
            customerRepository.save(customer1);
            return "The customer has been updated successfully";
        }
        else {
            throw new Exception("No customer exists with customerId"+customerId);
        }

    }
    //to search and pagination
    public Page<Customer> searchCustomers(String search, Pageable pageable) {
        return customerRepository.searchCustomers(search, pageable);
    }
}
