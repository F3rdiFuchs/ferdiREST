package com.service.GroupService;

import java.util.List;

import com.model.Group.Group;
import com.model.Group.GroupDAO;
import com.model.User.User;

public class GroupServiceImpl implements GroupService {
	private GroupDAO groupsDAO;

	public GroupDAO getGroupsDAO() {
		return groupsDAO;
	}

	public void setGroupsDAO(GroupDAO groupsD) {
		this.groupsDAO = groupsD;
	}

	public List<Group> listAllGroups() {
		return this.groupsDAO.listAllGroups();
	}

	public List<User> getUserInGroup(Integer groupId) {
		return this.groupsDAO.getUserInGroup(groupId);
	}

	public Group getGroupById(Integer id) {
		return this.groupsDAO.getGroupById(id);
	}

}
