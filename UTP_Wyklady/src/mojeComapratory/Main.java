package mojeComapratory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        Student s1 = new Student("Angelika", "Dupodajna", 19);
        Student s2 = new Student("Monika", "Cosika", 23);
        Student s3 = new Student("Agnieszka", "Sieorzeszka", 18);
        Student s4 = new Student("Ilona", "Zpeknietegokondona", 24);
        Student s5 = new Student("Magda", "Chuj", 17);

        List<Student> students = Arrays.asList(s1, s2, s3, s4, s5);

        System.out.println(students);

        students.sort((o1, o2) -> {
            if (o1.getAge() == o2.getAge())
                return 0;
            else if (o1.getAge()> o2.getAge())
                return 1;
            else
                return -1;
        });

        System.out.println(students);

    }


}
