package com.example.validationDemo.domain;

import com.example.validationDemo.validation.Enum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data
public class AccountRequestBody {

    private static final long serialVersionUID = 99L;
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    @Email
    private String email;

    @Size(min = 5, max =50)
    private String password;

    @NotBlank
    @Enum(enumClass = AccountStutus.class)
    private String status;

    public Account toDomaion() {
        Account account = new Account();

        account.setName(name);
        account.setEmail(email);
        account.setPassword(password);
        account.setStatus(AccountStutus.valueOf(status));
        account.setCreationDate(new Date());
        return account;
    }
}
