package com.sk.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;
import lombok.NonNull;

@Data
public class AccountDTO {
	@NotEmpty
	private String username;
	@NotBlank
	@Size(min=5)
	private String password;
	@NotBlank
	@Size(min=5)
    private String phone;
}
