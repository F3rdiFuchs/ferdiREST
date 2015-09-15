package com.service.GroupsService;

import java.util.List;

import com.model.Groups.Groups;
import com.model.Groups.GroupsDAO;
import com.model.User.User;

public class GroupsServiceImpl implements GroupsService{
	private GroupsDAO groupsDAO;

	public GroupsDAO getGroupsDAO() {
		return groupsDAO;
	}

	public void setGroupsDAO(GroupsDAO groupsDAO) {
		this.groupsDAO = groupsDAO;
	}

	public List<Groups> listAllGroups() {
		return this.groupsDAO.listAllGroups();
	}

	public List<User> getUserInGroup(Integer groupId) {
		return this.groupsDAO.getUserInGroup(groupId);
	}

	public Groups getGroupById(Integer id) {
		return this.getGroupById(id);
	}

}
