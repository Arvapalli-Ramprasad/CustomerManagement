package com.example.Customers.Repositories;

import com.example.Customers.Models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository//customer repo to save the customers into customerDb
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByEmail(String email);//function to find by email, it is used to add the unique emailId customers every tym

    //JPQL query to serch and sort based on first name , lastname, email &  phone
    @Query("SELECT c FROM Customer c WHERE " +
            "LOWER(c.firstname) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(c.lastname) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(c.email) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(c.phone) LIKE LOWER(CONCAT('%', :search, '%'))")
    //pagination and search done below
    Page<Customer> searchCustomers(@Param("search") String search, Pageable pageable);
}
