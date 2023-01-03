package com.bellanger.technical_test.dto.response;

import com.bellanger.technical_test.dto.commons.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private String username;
    private String country;
    private Timestamp birthdate;
    private Gender gender;
    private String phoneNumber;
}
