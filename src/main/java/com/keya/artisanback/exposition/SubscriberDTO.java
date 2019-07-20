package com.keya.artisanback.exposition;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SubscriberDTO {
    private String email;
    private String password;
    private String phone;
    private String role;
}
