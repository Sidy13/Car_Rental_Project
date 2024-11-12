package fr.efrei.domain;

public class Employee extends Person {
    private int employeeId;
    private double salary;
    public Employee() {}
    public Employee(String firstName, String lastName, String email, String phone, Address address, int age, int employeeId, double salary, String password) {
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
    public static Employee createEmployee(String firstName, String lastName, String email, String phone, Address address, int age, int employeeId, double salary, String password){
        return  (Employee) new Builder()
                .setEmployeeId(employeeId)
                .setSalary(salary)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPhone(phone)
                .setAddress(address)
                .setAge(age)
                .build();

    }
    public static class Builder extends Person.Builder {
        private int employeeId;
        private double salary;
        public Builder setEmployeeId(int employeeId) {
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
