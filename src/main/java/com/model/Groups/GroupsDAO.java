package com.model.Groups;

import java.util.List;

public interface GroupsDAO {
	public List <Groups> listGroups()throws Exception;
	public Groups getGroupById(Integer id)throws Exception;
}
