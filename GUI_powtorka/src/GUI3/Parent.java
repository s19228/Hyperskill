package GUI3;

import java.util.Observable;
import java.util.Observer;

//anotacja SuppressWarning wynika z użycia klasy Observable, uznanej za przestarzałą (jest to jednak przykład dydaktyczny)
@SuppressWarnings("deprecation")
public class Parent implements Observer {

    // klasa Parent implementuje interfejs Obserwator i zostanie powiadomiona zawsze, jeżeli obiekt obserowany się odpowiednio zmieni
    @Override
    public void update(Observable arg0, Object arg1) {
        // w takiej sytuacji wypisany zostanie odpowiedni komunikat na konsoli
        if (arg0 instanceof Student) {
            Student s = (Student)arg0;
            System.out.println("Parents of student " + s.getName() + " " + s.getSurname() + " (średnia = " + s.getSubjectsAverage() + ") were notified!");
        }
    }
}
