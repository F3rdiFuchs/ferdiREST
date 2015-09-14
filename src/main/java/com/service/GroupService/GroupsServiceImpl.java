package com.service.GroupService;

import java.util.List;

import com.model.Groups.Groups;
import com.model.Groups.GroupsDAO;
import com.model.User.User;

public class GroupsServiceImpl implements GroupsService {
	private GroupsDAO groupsDAO;
	
	public GroupsDAO getGroupsDAO() {
		return groupsDAO;
	}

	public void setGroupsDAO(GroupsDAO groupsDAO) {
		this.groupsDAO = groupsDAO;
	}

	public Groups getGroupById(Integer id) {
		return this.groupsDAO.getGroupById(id);
	}

	public List<Groups> listGroups() {
		return this.groupsDAO.listGroups();
	}

	public List<User> getUserInGroup(Integer groupId) {
		return this.groupsDAO.getUserInGroup(groupId);
	}
}
