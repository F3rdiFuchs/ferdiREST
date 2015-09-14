package com.service.GroupService;

import java.util.List;

import com.model.Groups.Groups;
import com.model.User.User;

public interface GroupsService {
	public Groups getGroupById(Integer id);
	public List<User> getUserInGroup(Integer groupId);
    public List<Groups> listGroups();

}
