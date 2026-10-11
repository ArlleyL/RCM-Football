package com.rcmfootball.rcmfootball.request;

import com.rcmfootball.rcmfootball.model.users.Users;

public record UsersRequest(
			String username,
			String password
		) {
	public UsersRequest toDto(Users user) {
		return new UsersRequest(
				user.getUsername(),
				user.getPassword()
			);
	}
}
