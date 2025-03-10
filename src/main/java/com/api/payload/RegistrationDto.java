package com.api.payload;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationDto {

   @NotEmpty
    @Size(min=2, message = "min should be 2 letters")
    private String name;
    @Email
    private String email;
    @Size(min=10,max = 10, message = "should be 10digit")
    private String mobile;


}