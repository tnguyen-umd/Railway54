package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.GroupRepository;
import com.vti.backend.datalayer.IGroupRepository;
import com.vti.entity.Group;

/**
 * This class is businesslayer of group
 * 
 * @Description: .
 * @author: TNguyen
 * @create_date: Sep 19, 2022
 * @version: 1.0
 * @modifer: TNguyen
 * @modifer_date: Sep 19, 2022
 */
public class GroupService implements IGroupService {

	private IGroupRepository repository;

	/**
	 * Constructor for class GroupService.
	 * 
	 * @Description: .
	 * @author: TNguyen
	 * @create_date: Sep 19, 2022
	 * @version: 1.0
	 * @modifer: TNguyen
	 * @modifer_date: Sep 19, 2022
	 */
	public GroupService() {
		repository = new GroupRepository();
	}

	/*
	 * @see com.vti.backend.businesslayer.IGroupService#getListGroups()
	 */
	public List<Group> getListGroups() throws ClassNotFoundException, SQLException {
		// logic service
		return repository.getListGroups();
	}
}
