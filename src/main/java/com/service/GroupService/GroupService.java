package com.service.GroupService;

import java.util.List;

import com.model.Group.Group;
import com.model.User.User;

public interface GroupService {
	List<Group> listAllGroups();
	List<User> getUserInGroup(Integer groupId);
	Group getGroupById(Integer id);
}
