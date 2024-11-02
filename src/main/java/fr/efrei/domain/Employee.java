package fr.efrei.domain;

public class Employee extends Person {
    private int employeeId;
    private double salary;
    public Employee() {}
    public Employee(String firstName, String lastName, String email, String phone, String address, int age, int employeeId, double salary) {
        super(firstName, lastName, email, phone, address, age);
        this.employeeId = employeeId;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + super.toString() + ", employeeId=" + employeeId + ", salary=" + salary + "}";
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
