package com.service.GroupService;

import java.util.List;

import org.springframework.hateoas.Link;

import com.model.Group.Group;
import com.model.User.User;

public interface GroupService {
	List<Group> listAllGroups();
	List<User> getUserInGroup(Integer groupId);
	Group getGroupById(Integer id);
	Link generateLink(Group group);
	Link generateLinkwithUser(Group group);
}
