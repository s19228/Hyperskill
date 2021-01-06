package GUI2;

public class NameComparator implements EmployeeComparator {
    @Override
    public int compare(Employee e1, Employee e2) {
        return (int) Math.signum(e1.getName().compareToIgnoreCase(e2.getName()));
    }
}
