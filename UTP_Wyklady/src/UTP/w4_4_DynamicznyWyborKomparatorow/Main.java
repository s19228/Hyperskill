package UTP.w4_4_DynamicznyWyborKomparatorow;

import java.util.Arrays;
import java.util.List;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Main {

    public static void main(String[] args) {

        List<Employee> elist = Arrays.asList(
                new Employee("Jan", "Kowalski", 3500),
                new Employee("Jan", "Malinowski", 3500),
                new Employee("Jan", "Kowalski", 1400),
                new Employee("Admam", "Kowalski", 5700)
        );
/*
        // opis porządków
        String[] mi = {"Porządek naturalny", "Porządek wg pensji"};

        //Lista komparatorow
        Comparator<Employee> comp; // na tej zmiennej zapiszemy comarator do odwrocenia

        List<Comparator<Employee>> clist = Arrays.asList(
                Comparator.naturalOrder(),
                Comparator.reverseOrder(),
                comp = (e1, e2) -> e1.getSalary() - e2.getSalary(),
                comp.reversed()// w odwrotnym porzadku
        );

        String menuDescr = "wybierz porzadek:";
        for (int i = 0, j = 0; i < mi.length; i++){
            menuDescr += "\n" + ++j + " - " + mi[i]
                    + "\n" + ++j + " - odwrocony" + mi[i];
        }

        //Dialogowa czesc aplikacji umozliwiajaca wybory comp

        int idx = 0;
        while (true){
            try{
                idx = new Scanner(showInputDialog(menuDescr).nextInt());
                elist.sort(Comparator<? super Employee>) clist.get(idx-1);
                showMessageDialog(null, elist);

            } catch (NullPointerException e) {
                break;
            }
            catch (Exception e){
                break;
            }
        }

*/

    }


}
