package Test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.Controller.GroupController;
import com.model.Group.Group;
import com.model.Group.TGroup;
import com.service.GroupService.GroupService;

public class GroupControllerTest {

	GroupController groupController;
	GroupService groupService;
	Link link;
	
	@Before
	public void before()
	{
		groupController = new GroupController();
		groupService = mock(GroupService.class);
		groupController.setGroupService(groupService);
		link = mock(Link.class);
	}
	
	@Test
	public void getGroupsLinkTest()
	{
		List<TGroup> tGroupList = Arrays.asList(new TGroup(), new TGroup());
		ResponseEntity<List<TGroup>> expectedResult = new ResponseEntity<List<TGroup>>(tGroupList, HttpStatus.OK);
		tGroupList.get(0).add(link);
		tGroupList.get(1).add(link);
		
		List<Group> groupList = Arrays.asList(new Group(), new Group());
		when(groupService.listAllGroups()).thenReturn(groupList);
		when(groupService.generateLink(new Group())).thenReturn(link);
		
		ResponseEntity<List<TGroup>> functionReturn = (ResponseEntity<List<TGroup>>) groupController.getGroups();
	
		assertEquals(expectedResult,functionReturn);
	}
	
	@Test
	public void getGroupLinkTest()
	{
		Group expectedGroup = new Group();
		expectedGroup.add(link);
		expectedGroup.add(link);
		
		Group tg = new Group();
		
		when(groupService.getGroupById(anyInt())).thenReturn(tg);
		when(groupService.generateLink(tg)).thenReturn(link);
		when(groupService.generateLinkwithUser(tg)).thenReturn(link);
		
		Group resultGroup = groupController.getGroup("1");
		
		assertEquals(expectedGroup,resultGroup);
	}
}
