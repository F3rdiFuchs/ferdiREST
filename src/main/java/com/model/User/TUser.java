package com.model.User;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

public class TUser extends ResourceSupport{
	private Link id;

	public Link getId() {
		return id;
	}

	public void setId(Link id) {
		this.id = id;
	}
}
