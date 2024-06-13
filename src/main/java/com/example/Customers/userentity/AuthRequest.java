package com.example.Customers.userentity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {//for generating token we are using this DTO

    private String username;
    private String password;

}
