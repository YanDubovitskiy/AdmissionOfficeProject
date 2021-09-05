package Service;

import DAO.FacultyDAO;
import Entity.Faculty;
import Logic.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacultyService extends Util implements FacultyDAO {
    Connection connection = getConnection();

    @Override
    public Faculty getFacultyById(Integer id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM faculty WHERE id = ?";

        Faculty faculty = new Faculty();

        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                faculty.setId(resultSet.getInt("id"));
                faculty.setName(resultSet.getString("name"));
                faculty.setDean(resultSet.getString("dean"));
                faculty.setBudgetPlaces(resultSet.getInt("budget_places"));
                faculty.setFeePayingPlaces(resultSet.getInt("fee_paying_places"));

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
        return faculty;
    }

    @Override
    public List<Faculty> getAllFaculties() throws SQLException {
        List<Faculty> faculties = new ArrayList<>();

        String sql = "SELECT * FROM faculty";

        Statement statement = null;

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                Faculty faculty = new Faculty();
                faculty.setId(resultSet.getInt("id"));
                faculty.setName(resultSet.getString("name"));
                faculty.setDean(resultSet.getString("dean"));
                faculty.setBudgetPlaces(resultSet.getInt("budget_places"));
                faculty.setFeePayingPlaces(resultSet.getInt("fee_paying_places"));

                faculties.add(faculty);
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
        return faculties;
    }
}
