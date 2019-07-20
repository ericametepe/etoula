package com.keya.artisanback.exposition;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Subscriber {
    private String email;
    private String password;
    private String phone;
    private String role;

}
