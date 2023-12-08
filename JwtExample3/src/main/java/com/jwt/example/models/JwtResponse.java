
package com.jwt.example.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JwtResponse {
	private String jwtToken;
	private String username;

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public static JwtResponseBuilder builder() {
		return new JwtResponseBuilder();
	}

	public static class JwtResponseBuilder {
		private String jwtToken;
		private String username;

		JwtResponseBuilder() {
		}

		public JwtResponseBuilder jwtToken(String jwtToken) {
			this.jwtToken = jwtToken;
			return this;
		}

		public JwtResponseBuilder username(String username) {
			this.username = username;
			return this;
		}

		public JwtResponse build() {
			JwtResponse jwtResponse = new JwtResponse();
			jwtResponse.setJwtToken(this.jwtToken);
			jwtResponse.setUsername(this.username);
			return jwtResponse;
		}
	}

}
