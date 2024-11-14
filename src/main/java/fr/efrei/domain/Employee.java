package fr.efrei.domain;

public class Employee extends Person {
    private String employeeId;
    private double salary;
    public Employee() {}
    public Employee(String firstName, String lastName, String email, String phone, Address address, int age, String employeeId, double salary, String password) {
        super(firstName, lastName, email, phone, address, age, password);
        this.employeeId = employeeId;
        this.salary = salary;
    }

    public Employee(Builder builder) {
        super(builder);
        this.employeeId = builder.employeeId;
        this.salary = builder.salary;
    }
    @Override
    public String toString() {
        return "Employee{" + super.toString() + ", employeeId=" + employeeId + ", salary=" + salary + "}";
    }

    public String getEmployeeId() {
        return employeeId;
    }


    public double getSalary() {
        return salary;
    }



    public static class Builder extends Person.Builder {
        private String employeeId;
        private double salary;
        public Builder setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }
        public Builder setSalary(double salary) {
            this.salary = salary;
            return this;
        }
        public Employee build() {
            return new Employee(this);
        }
    }
}
