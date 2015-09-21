package com.Controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Group.Group;
import com.model.Group.TGroup;
import com.model.User.TUser;
import com.model.User.User;
import com.service.GroupService.GroupService;


@RestController
public class GroupController {
	private GroupService groupService;
	
	public GroupService getGroupService() {
		return groupService;
	}

	@Autowired(required = true)
	@Qualifier(value = "groupsService")
	public void setGroupService(GroupService groupServ) {
		this.groupService = groupServ;
	}

	@RequestMapping(value = "/groups", method = RequestMethod.GET)
	public HttpEntity<List<TGroup>> getGroups()
	{
		List<Group> groupList = new ArrayList<Group>();
		List<TGroup> tgroupList = new ArrayList<TGroup>();
		groupList = groupService.listAllGroups();
		
		for (Integer index = 0; index < groupList.size(); index++)
		{
			tgroupList.add(new TGroup());
		}
		for (Integer index = 0; index < groupList.size(); index++)
		{
			Group group = groupList.get(index);
			Link slink = groupService.generateLink(group);
			tgroupList.get(index).add(slink);
		}
		return new ResponseEntity<List<TGroup>>(tgroupList, HttpStatus.OK);
	}

	@RequestMapping(value = "/groups/{id}", method = RequestMethod.GET)
	public Group getGroup(@PathVariable (value = "id") String id)
	{
		Group group = null;
		try
		{
			group = groupService.getGroupById(Integer.parseInt(id));
			group.add(groupService.generateLink(group));
			group.add(groupService.generateLinkwithUser(group));
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
		return group;
	}
	
	@RequestMapping(value = "/groups/{id}/user", method = RequestMethod.GET)
	public HttpEntity<List<TUser>> getUserInGroup(@PathVariable (value = "id") String id)
	{
		List<TUser> tuserList = new ArrayList<TUser>();
		List<User> userList = new ArrayList<User>();
		userList = groupService.getUserInGroup(Integer.parseInt(id));
		
		for (Integer index = 0; index < userList.size(); index++)
		{
			tuserList.add(new TUser());
		}
		for (Integer index = 0; index < userList.size(); index++)
		{
			User user = userList.get(index);
			Link slink = linkTo(methodOn(UserController.class).getUser(user.getUserId().toString())).withSelfRel();
			tuserList.get(index).add(slink);
		}
		return new ResponseEntity<List<TUser>>(tuserList, HttpStatus.OK);
	}
}
