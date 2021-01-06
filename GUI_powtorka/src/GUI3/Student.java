package GUI3;

import GUI3.SchoolSubject;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Observable;


//nasza klasa Student
//większość zawartości klasy może zostać wygenerowana automatycznie
//w tym celu w Eclipse należy kliknąć prawym przyciskiem myszy wewnątrz klasy i wybrać opcję Source
//w IntelliJ podobny efekt można uzyskać przy pomocy opcji Generate
// anotacja SuppressWarning wynika z użycia klasy Observable, uznanej za przestarzałą (jest to jednak przykład dydaktyczny)
@SuppressWarnings("deprecation")
public class Student extends Observable implements Comparable<Student>, Iterable<SchoolSubject> {

    private String name;
    private String surname;
    private SchoolSubject subjects[];

    public Student(String name, String surname, int subjectNumber) {
        this.name = name;
        this.surname = surname;
        this.subjects = new SchoolSubject[subjectNumber];
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
        return "Student [name=" + name + ", surname=" + surname + ", subjects=" + Arrays.toString(subjects) + "]";
    }

    // dodajmy przedmiot na określoną pozycję w naszej tablicy
    public void addSubject(SchoolSubject subject, int position) {
        // zabezpieczenia przed bezsensownymi danymi wejściowymi
        if (subjects == null || subjects.length <= position)
            return;
        subjects[position] = subject;
        // to jest fragment zadania dla wzorca Obserwator
        // jeżeli po ustawieniu nowego przedmiotu średnia spadnie poniżej 3.0, zostaną powiadomieni wszyscy obserwatorzy (w naszym wypadku rodzice)
        if (getSubjectsAverage() < 3.0) {
            // jeżeli po zmianie przedmiotu średnia zostanie obniżona poniżej 3.0 ustaw, że obiekt jest zmieniony i powiadom obserwatorów
            setChanged();
            notifyObservers();
        }
    }

    // metoda zwracająca długość tablicy przedmiotów
    public int getSubjectsLength() {
        return subjects == null ? 0 : subjects.length;
    }

    // metoda wyznaczająca średnią arytmetyczną z przedmiotów dla danego studenta
    public double getSubjectsAverage() {
        // zabezpieczenie przed bezsensownymi danymi
        if (subjects == null || subjects.length == 0)
            return 0;
        // obliczanie średniej
        double average = 0;
        for (SchoolSubject subject : subjects) {
            if (subject != null)
                average += subject.getGrade();
        }
        return average / subjects.length;
    }

    // naprostsza implementacja naszej metody porównującej
    @Override
    public int compareTo(Student otherStudent) {
        if (getSubjectsAverage() != otherStudent.getSubjectsAverage())
            return Double.compare(getSubjectsAverage(), otherStudent.getSubjectsAverage());
        else if (surname.compareToIgnoreCase(otherStudent.surname) != 0)
            return surname.compareToIgnoreCase(otherStudent.surname);
        else
            return name.compareToIgnoreCase(otherStudent.name);
    }

    // implementacja interfejsu Iterable wymaga dodania metody zwracającej obiekt Iteratora
    // zwracany obiekt Iteratora ma pozwolić na jednokrotne przejrzenie wszystkich elementów składowych
    @Override
    public Iterator<SchoolSubject> iterator() {
        return new SubjectIterator();
    }

    // w tym celu stwórzmy klasę wewnętrzną (klasa wewnętrzna ma dostęp do pól, nawet prywatnych, klasy otaczającej)
    private class SubjectIterator implements Iterator<SchoolSubject> {

        // potrzebna nam będzie pozycja obecnego elementu
        private int position;

        public SubjectIterator() {
            // pozycja ma początkowo wartość zero
            position = 0;
        }

        // tak długo jak nie osiągneliśmy długości tablicy przedmiotów, jest dostępny jeszcze jakiś przedmiot
        @Override
        public boolean hasNext() {
            return position < subjects.length;
        }

        // zwróćmy obecny przedmiot i przesuńmy pozycję na następny przedmiot w tablicy
        @Override
        public SchoolSubject next() {
            return subjects[position++];
        }

    }
}
