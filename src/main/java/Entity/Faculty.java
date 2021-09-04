package Entity;

import java.util.Objects;

public class Faculty {
        private Integer id;
        private String name;
        private String dean;
        private int budgetPlaces;
        private int feePayingPlaces;


    public Faculty() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDean() {
            return dean;
        }

        public void setDean(String dean) {
            this.dean = dean;
        }

        public int getBudgetPlaces() {
            return budgetPlaces;
        }

        public void setBudgetPlaces(int budgetPlaces) {
            this.budgetPlaces = budgetPlaces;
        }

        public int getFeePayingPlaces() {
            return feePayingPlaces;
        }

        public void setFeePayingPlaces(int feePayingPlaces) {
            this.feePayingPlaces = feePayingPlaces;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Faculty)) return false;
        Faculty faculty = (Faculty) o;
        return getBudgetPlaces() == faculty.getBudgetPlaces() && getFeePayingPlaces() == faculty.getFeePayingPlaces() && Objects.equals(getId(), faculty.getId()) && Objects.equals(getName(), faculty.getName()) && Objects.equals(getDean(), faculty.getDean());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDean(), getBudgetPlaces(), getFeePayingPlaces());
    }

    @Override
    public String toString() {
        return "Faculty{" +
                + id + ". " +
                 name +
                '}';
    }
}
