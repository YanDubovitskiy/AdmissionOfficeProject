package Service;

import DAO.ApplicationDAO;
import Entity.Application;
import Entity.Faculty;
import Logic.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApplicationService extends Util implements ApplicationDAO {
    Connection connection = getConnection();

    @Override
    public void add(Application application) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO applications(first_name, last_name, faculty_id, points_summary) VALUES(?, ?, ?, ?)";
        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,application.getFirstName());
            preparedStatement.setString(2,application.getLastName());
            preparedStatement.setInt(3,application.getFaculty().getId());
            preparedStatement.setInt(4,application.getPointsSummary());

             preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }

    @Override
    public Application getApplicationById(Integer id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM applications WHERE id = ?";

        Application application = new Application();

        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();

            application.setId(resultSet.getInt("id"));
            application.setFirstName(resultSet.getString("first_name"));
            application.setLastName(resultSet.getString("last_name"));
            application.setPointsSummary(resultSet.getInt("points_summary"));

            Integer facultyId = resultSet.getInt("faculty_id");
            FacultyService facultyService = new FacultyService();
            Faculty faculty = facultyService.getFacultyById(facultyId);

            application.setFaculty(faculty);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return application;
    }

    @Override
    public List<Application> getAllApplications() throws SQLException {
        List<Application> applications = new ArrayList<>();

        String sql = "SELECT * FROM applications";

        Statement statement=null;

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                Application application = new Application();
                application.setId(resultSet.getInt("id"));
                application.setFirstName(resultSet.getString("first_name"));
                application.setLastName(resultSet.getString("last_name"));
                application.setPointsSummary(resultSet.getInt("points_summary"));

                Integer facultyId = resultSet.getInt("faculty_id");
                FacultyService facultyService = new FacultyService();
                Faculty faculty = facultyService.getFacultyById(facultyId);

                application.setFaculty(faculty);
                applications.add(application);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return applications;
    }

    @Override
    public void update(Integer id,String columnName, String newValue) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE applications SET ? = ? WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            if(columnName.equals("points_summary") || columnName.equals("faculty_id")){
                Integer newIntegerValue = Integer.parseInt(newValue);
                preparedStatement.setInt(2, newIntegerValue);
            }
            else {
                preparedStatement.setString(2, newValue);
            }

            preparedStatement.setString(1, columnName);
            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }

        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM applications WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
