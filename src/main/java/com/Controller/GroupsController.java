package com.Controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Groups.Groups;
import com.service.GroupService.GroupsService;

@RestController
public class GroupsController {
	private GroupsService groupsService;

	public GroupsService getGroupsService() {
		return groupsService;
	}
	
	@Autowired(required=true)
	@Qualifier(value="groupsService")
	public void setGroupsService(GroupsService groupsService) {
		this.groupsService = groupsService;
	}
	
	@RequestMapping(value="/groups", method = RequestMethod.GET)
	public HttpEntity<List<Groups>> getGroups()
	{
		List<Groups> groupList = new ArrayList<Groups>();
		
		
		try
		{
			groupList = groupsService.listGroups();
			for(Groups group : groupList)
			{
				group.add(linkTo(methodOn(GroupsController.class).getGroup(group.getGroupId().toString())).withSelfRel());
			}
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
		return new ResponseEntity<List<Groups>>(groupList,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/groups/{id}", method = RequestMethod.GET)
	public Groups getGroup(@PathVariable (value="id") String id)
	{
		Groups group = null;
		try
		{
			group = groupsService.getGroupById(Integer.parseInt(id));
		}
		catch(Exception e)
		{
			
		}
		return group;
	}

}
