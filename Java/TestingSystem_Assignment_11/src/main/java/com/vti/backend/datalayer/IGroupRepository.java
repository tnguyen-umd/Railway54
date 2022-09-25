package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Group;

public interface IGroupRepository {
	List<Group> getListGroups() throws ClassNotFoundException, SQLException;
}
