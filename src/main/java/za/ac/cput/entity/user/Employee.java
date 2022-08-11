package za.ac.cput.entity.user;

/*
Employee.java
Author: Tarren-Marc Adams - 214041794
Date: 6 April 2022
 */

public class Employee {
    private Long employeeId;
    private String employeeName;
    private String employeeSurname;

    private Employee(Builder builder) {
        this.employeeId = builder.employeeId;
        this.employeeName = builder.employeeName;
        this.employeeSurname = builder.employeeSurname;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeSurname='" + employeeSurname + '\'' +
                '}';
    }

    public static class Builder {
        private Long employeeId;
        private String employeeName;
        private String employeeSurname;

        public Builder employeeId(Long employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder employeeName(String employeeName) {
            this.employeeName = employeeName;
            return this;
        }

        public Builder employeeSurname(String employeeSurname) {
            this.employeeSurname = employeeSurname;
            return this;
        }

        public Builder copy(Employee employee) {
            this.employeeId = employee.employeeId;
            this.employeeName = employee.employeeName;
            this.employeeSurname = employee.employeeSurname;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}
