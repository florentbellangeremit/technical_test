package com.bellanger.technical_test.dto.request;

import com.bellanger.technical_test.dto.commons.Gender;
import com.bellanger.technical_test.dto.request.constraint.BirthdateConstraint;
import com.bellanger.technical_test.dto.request.constraint.CountryConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Validated
@AllArgsConstructor
public class UserRequest {
    private long id;
    @NotNull(message = "Username can't be null")
    @NotBlank(message = "Username can't be empty")
    private String username;
    @NotNull(message = "Country can't be null")
    @NotBlank(message = "Country can't be empty")
    @CountryConstraint
    private String country;
    //TODO Passer en local date time
    @NotNull(message = "Birthdate can't be null")
    @BirthdateConstraint
    private Timestamp birthdate;
    private Gender gender;
    private String phoneNumber;
}
