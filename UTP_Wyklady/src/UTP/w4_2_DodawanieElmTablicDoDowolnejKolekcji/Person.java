package UTP.w4_2_DodawanieElmTablicDoDowolnejKolekcji;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private int nr;

    public Person(String firstName, String lastName, int age, int nr) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nr = nr;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", nr=" + nr +
                '}';
    }
}
