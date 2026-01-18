package com.ps.interprater.one;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class User {
	private List<String> permissions;
	private String username;

	public User(String username, String... permissions) {
		this.username = username;
		this.permissions = new ArrayList<>();
		Stream.of(permissions).forEach(e -> this.permissions.add(e.toLowerCase()));
	}

	public User(List<String> permissions, String username) {
		super();
		this.permissions = new ArrayList<>(permissions);
		this.username = username;
	}

	public List<String> getPermissions() {
		return permissions;
	}

	public String getUsername() {
		return username;
	}

}
