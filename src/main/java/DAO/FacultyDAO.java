package DAO;

import Entity.Application;
import Entity.Faculty;

import java.sql.SQLException;
import java.util.List;

public interface FacultyDAO {

    // read
   Faculty getFacultyById(Integer id) throws SQLException;

    List<Faculty> getAllFaculties() throws SQLException;

}
