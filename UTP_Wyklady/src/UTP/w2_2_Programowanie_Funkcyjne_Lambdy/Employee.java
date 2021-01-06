package UTP.w2_2_Programowanie_Funkcyjne_Lambdy;

public class Employee {

    private String lname;
    private String fname;
    private Integer age;
    private Double salary;

    public Employee(String lname, String fname, Integer age, Double salary) {
        this.lname = lname;
        this.fname = fname;
        this.age = age;
        this.salary = salary;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee lname='" + lname + ", fname='" + fname;
    }
}
