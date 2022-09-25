package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Group;

public interface IGroupService {
	List<Group> getListGroups() throws ClassNotFoundException, SQLException;
}
