package com.model.Group;

import java.util.List;

import com.model.User.User;

public interface GroupDAO {
	List<Group> listAllGroups();
	List<User> getUserInGroup(Integer groupId);
	Group getGroupById(Integer id);
}
