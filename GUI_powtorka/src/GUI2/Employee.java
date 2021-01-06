package GUI2;

public class Employee {

    private String name;
    private String surname;
    private int salary;

    public Employee(String name, String surname, int salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Employye{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public static Employee findMaxEmployee(Employee[] tab, EmployeeComparator comparator) {
        // Zabezpieczenia przed bezsensownymi danymi
        if (tab == null || tab.length == 0 || comparator == null)
            return null;

        // Ustawienie maximum na pierwszego pracownika
        Employee max = tab[0];
        // Przeglądanie dalszych pracowników z tablicy
        for (int i = 1; i < tab.length; i++) {
            // Jeżeli któryś z pracowników jest większy niż obecne maksimum,
            if (comparator.compare(tab[i], max) > 0)
                // to on powinien stać się obecnym maksimum
                max = tab[i];
        }
        // Zwracanie znalezionego maksimum
        return max;
    }



}
