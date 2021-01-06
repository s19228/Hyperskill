package Udemy.Kloekcje_Listy_Mapy_Kolejki.Wildcards;

import java.util.List;

public class SuperClass<T> {

    private T obj;

    public static void tester(List <? extends SuperClass>lista) {

    }


    public SuperClass(T obj) {
        this.obj = obj;
    }

    public SuperClass() {

    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "SuperClass obj="  + obj;
    }



}
