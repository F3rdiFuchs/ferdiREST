package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;

import com.Controller.GroupController;
import com.model.Group.Group;
import com.model.Group.TGroup;
import com.service.GroupService.GroupService;

public class GroupControllerTest {

	@Test
	public void getGroupsLinkTest()
	{
		GroupController groupController = mock(GroupController.class);
		List<Group> groupList = Arrays.asList(new Group(), new Group());
		Link link = mock(Link.class);
		GroupService groupsService = mock(GroupService.class);
		
		when(groupsService.listAllGroups()).thenReturn(groupList);
		when(link.withSelfRel()).thenReturn(link);
		
		//Result object<TGroup>
		List<TGroup> rgroupList = Arrays.asList(new TGroup(), new TGroup());
		rgroupList.get(0).add(link);
		rgroupList.get(1).add(link);
		
		ResponseEntity<List<TGroup>> test = (ResponseEntity<List<TGroup>>) groupController.getGroups();
		
		assertEquals(test,rgroupList);
	}
}
