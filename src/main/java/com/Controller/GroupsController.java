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

import com.model.Groups.Groups;
import com.model.Groups.TGroup;
import com.model.User.TUser;
import com.model.User.User;


@RestController
public class GroupsController {
	
	/*
	@RequestMapping(value="/groups", method = RequestMethod.GET)
	public HttpEntity<List<TGroup>> getGroups()
	{
		List<Groups> groupList = new ArrayList<Groups>();
		List<TGroup> tgroupList = new ArrayList<TGroup>();
		groupList = groupsService.listGroups();
		
		for(Integer Index=0;Index<groupList.size();Index++)
		{
			tgroupList.add(new TGroup());
		}
		for(Integer Index=0;Index<groupList.size();Index++)
		{
			Groups group = groupList.get(Index);
			Link slink = linkTo(methodOn(GroupsController.class).getGroup(group.getGroupId().toString())).withSelfRel();
			tgroupList.get(Index).add(slink);
		}
		return new ResponseEntity<List<TGroup>>(tgroupList,HttpStatus.OK);
	}

	@RequestMapping(value="/groups/{id}", method = RequestMethod.GET)
	public Groups getGroup(@PathVariable (value="id") String id)
	{
		Groups group = null;
		try
		{
			group = groupsService.getGroupById(Integer.parseInt(id));
			group.add(linkTo(methodOn(GroupsController.class).getGroup(group.getGroupId().toString())).withSelfRel());
			group.add(linkTo(methodOn(GroupsController.class).getGroup(group.getGroupId().toString())).slash("user").withRel("user"));
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
		return group;
	}
	
	@RequestMapping(value="/groups/{id}/user", method = RequestMethod.GET)
	public HttpEntity<List<TUser>> getUserInGroup(@PathVariable (value="id") String id)
	{
		List<TUser> tuserList = new ArrayList<TUser>();
		List<User> userList = new ArrayList<User>();
		userList = groupsService.getUserInGroup(Integer.parseInt(id));

		
		
		for(Integer Index=0;Index<userList.size();Index++)
		{
			tuserList.add(new TUser());
		}
		for(Integer Index=0;Index<userList.size();Index++)
		{
			User user = userList.get(Index);
			Link slink = linkTo(methodOn(UserController.class).getUser(user.getUserId().toString())).withSelfRel();
			tuserList.get(Index).add(slink);
		}
		
		return new ResponseEntity<List<TUser>>(tuserList,HttpStatus.OK);
		
	}
	
	*/
}
