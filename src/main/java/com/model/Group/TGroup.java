package com.model.Group;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

public class TGroup extends ResourceSupport{
	private Link id;

	public Link getId() {
		return id;
	}

	public void setId(Link id) {
		this.id = id;
	}


}
