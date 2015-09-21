package com.model.Group;

import java.util.List;

import org.springframework.hateoas.Link;

import com.model.User.User;

public interface GroupDAO {
	List<Group> listAllGroups();
	List<User> getUserInGroup(Integer groupId);
	Group getGroupById(Integer id);
	public Link generateLink(Group group);
	public Link generateLinkwithUser(Group group);
}
