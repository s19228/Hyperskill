package GUI2;

import javax.rmi.CORBA.Util;
import java.util.Arrays;
import java.util.Comparator;

import static java.util.Arrays.*;

public class Main {

    public static void main(String[] args) {

        Employee em1 = new Employee("Jan", "Boczusz", 1500);
        Employee em2 = new Employee("Marian", "Deska", 2500);
        Employee em3 = new Employee("Konrad", "Szafa", 45500);
        Employee em4 = new Employee("Janina", "Stol", 5500);
        Employee em5 = new Employee("Urszula", "Wol", 7500);
        Employee em6 = new Employee("Bozena", "Krowa", 9500);
        Employee em7 = new Employee("Janka", "Kon", 10500);
        Employee em8 = new Employee("Anita", "Firanka", 11500);
        Employee em9 = new Employee("Despaczita", "Koronalia", 21500);

        Employee[] employyesList = {em1, em2, em3, em4, em5, em6, em7, em8, em9};

        EmployeeComparator empc = new SalaryComparator();

        System.out.println(Employee.findMaxEmployee(employyesList, empc));

        EmployeeComparator empc2 = new NameComparator();

        System.out.println(Employee.findMaxEmployee(employyesList, empc2));

        String testString = "Ala ma kota";

        Box box = new Box();

        box.setObject(testString);

        String newString = (String) box.getObject();

        System.out.println(newString);

        //Integer testInteger = (Integer) box.getObject();
        //System.out.println(testInteger);

        UpgradedBox<String> box2 = new UpgradedBox<>();

        box2.setObject(testString);
        String newString2 = box2.getObject();
        System.out.println(newString2);

        //Integer testIneger2 = box2.getObject();

        String s1 = "Ala ma kota";
        String s2 = "Ala ma kotaka";

        boolean result = Utils.areEqual(s1, s2);
        System.out.println(result);

        ItemComparator<Employee> ice = (o1, o2) -> {
            if (o1.getSalary() > o2.getSalary())
                return 1;
            else if (o1.getSalary() < o2.getSalary())
                return -1;
            else
                return 0;
        };

        System.out.println(Utils.findMaxItem(employyesList, ice));

        Integer[] integerList = {12,52,32,5,87,125,325,87,45,965,854,122,588};

        IntegerComparator itcom = new IntegerComparator();
        System.out.println(Utils.findMaxItem(integerList, itcom));

        UpgradesSalaryComparator usc = new UpgradesSalaryComparator();
        System.out.println(Utils.findMaxItem(employyesList, usc));

        System.out.println(Arrays.toString(integerList));

        Arrays.sort(integerList, (o1, o2) -> o1.compareTo(o2));

        System.out.println(Arrays.toString(integerList));



    }


}
