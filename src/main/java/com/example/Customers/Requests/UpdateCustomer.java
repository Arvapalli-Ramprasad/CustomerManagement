package com.example.Customers.Requests;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//Customer DTO to update customer only giving access to the attributes given below
public class UpdateCustomer {
    private String street;
    private String address;
    private String city;
    private String state;
    private String email;
    private String phone;
}
