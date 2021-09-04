package DAO;

import Entity.Application;

import java.sql.SQLException;
import java.util.List;

public interface ApplicationDAO {
    //create
    void add(Application application) throws SQLException;

    // read
    Application getApplicationById(Integer id) throws SQLException;

    List<Application> getAllApplications() throws SQLException;

    //update
    void update(Integer id,String columnName, String newValue) throws SQLException;

    //delete
    void delete(Integer id) throws SQLException;

}
