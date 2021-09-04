package Dialog;

import Entity.Application;
import Entity.Faculty;
import Service.ApplicationService;
import Service.FacultyService;

import java.sql.SQLException;
import java.util.Scanner;

public class Dialog {

    public static void interaction() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Faculty faculty;
        Application application;
        while (true) {
            System.out.println("Welcome to the Admission Office\n" +
                    "To make an application: enter 1\n" +
                    "To delete an existing: enter 2\n" +
                    "To update an existing: enter 3\n" +
                    "To see an existing application: enter 4\n" +
                    "To see all applications: enter 5\n" +
                    "To exit: enter \"exit\"");

            String input = scanner.nextLine();

            switch (input){
                case("1"):
                    workWithInput(1);
                    break;
                case ("2"):
                    workWithInput(2);
                    break;
                case("3"):
                    workWithInput(3);
                    break;
                case("4"):
                    workWithInput(4);
                    break;
                case("5"):
                    workWithInput(5);
                    break;
                case("exit"):
                    System.exit(0);
                default:
                    System.err.println("Wrong input");
            }
        }
    }

    public static void workWithInput(int selectedCase) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        FacultyService facultyService = new FacultyService();
        ApplicationService applicationService = new ApplicationService();
        switch(selectedCase){
            case (1):
                System.out.println("Write your first name");
                String firstName = scanner.next();
                System.out.println("Write your last name");
                String lastName = scanner.next();
                System.out.println("Write your points summary");
                Integer pointsSummary = scanner.nextInt();
                for(Faculty faculty : facultyService.getAllFaculties()){
                    System.out.println(faculty);
                }
                System.out.println("Enter faculty number");
                Integer facultyId = scanner.nextInt();
                Faculty faculty = facultyService.getFacultyById(facultyId);
                applicationService.add(new Application(firstName,lastName,faculty,pointsSummary));
                    break;

                case (2):
                System.out.println("Enter application id");
                Integer applicationIdToDelete = scanner.nextInt();
                applicationService.delete(applicationIdToDelete);
                    break;

                case(3):
                System.out.println("Enter application id");
                Integer applicationIdToUpdate = scanner.nextInt();
                System.out.println("first_name\n"+"last_name\n"+"points_summary\n" +"faculty_id\n");
                System.out.println("Write column name to update");
                String columnName = scanner.next();
                System.out.println("Enter new value");
                String newValue = scanner.next();

                applicationService.update(applicationIdToUpdate,columnName,newValue);
                    break;

            case (4):
                System.out.println("Enter application id");
                Integer applicationIdToShow = scanner.nextInt();
                applicationService.getApplicationById(applicationIdToShow);
                break;

                case (5):
                applicationService.getAllApplications();
                    break;

        }
    }
}
