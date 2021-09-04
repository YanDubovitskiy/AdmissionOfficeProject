package Entity;

import java.time.LocalDate;
import java.util.Objects;

public class Application {
   private Integer id;
   private String firstName;
   private String lastName;
   private Faculty faculty;
   private Integer pointsSummary;

   public Application( String firstName, String lastName, Faculty faculty, Integer pointsSummary) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.faculty = faculty;
      this.pointsSummary = pointsSummary;
   }

   public Application() {
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public Faculty getFaculty() {
      return faculty;
   }

   public void setFaculty(Faculty faculty) {
      this.faculty = faculty;
   }

   public Integer getPointsSummary() {
      return pointsSummary;
   }

   public void setPointsSummary(Integer pointsSummary) {
      this.pointsSummary = pointsSummary;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Application)) return false;
      Application that = (Application) o;
      return Objects.equals(getId(), that.getId()) && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getFaculty(), that.getFaculty()) && Objects.equals(getPointsSummary(), that.getPointsSummary());
   }

   @Override
   public int hashCode() {
      return Objects.hash(getId(), getFirstName(), getLastName(), getFaculty(), getPointsSummary());
   }

   @Override
   public String toString() {
      return "Application{" +
              "id=" + id +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", faculty=" + faculty +
              ", pointsSummary=" + pointsSummary +
              '}';
   }
}
