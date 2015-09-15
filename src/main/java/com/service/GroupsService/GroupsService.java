package com.service.GroupsService;

import java.util.List;

import com.model.Groups.Groups;
import com.model.User.User;

public interface GroupsService {
	public List<Groups>listAllGroups();
	public List<User> getUserInGroup(Integer groupId);
	public Groups getGroupById(Integer id);
}
