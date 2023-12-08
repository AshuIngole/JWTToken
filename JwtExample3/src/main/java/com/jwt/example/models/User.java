package com.jwt.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
	
	@JsonProperty("id")
	private String userId;
	@JsonProperty("name")
	private String name;
	@JsonProperty("email")
	private String email;
	
}
