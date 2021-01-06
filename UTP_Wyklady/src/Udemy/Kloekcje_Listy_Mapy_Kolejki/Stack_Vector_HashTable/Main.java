package Udemy.Kloekcje_Listy_Mapy_Kolejki.Stack_Vector_HashTable;

import java.util.Stack;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        Stack<String> stos = new Stack<>();

        stos.push("dupa1");
        stos.push("dupa2");
        stos.push("dupa3");
        stos.push("dupa4");
        stos.push("dupa5");
        stos.push("dupa6");
        System.out.println(stos.peek());

        while (!stos.isEmpty()){
            System.out.println(stos.pop());
        }

        Vector<String> wektor = new Vector<>();

        wektor.add("dupa");
        System.out.println(wektor.get(0));




    }

}
