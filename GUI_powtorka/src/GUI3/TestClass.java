package GUI3;

import java.util.Iterator;

public class TestClass<T> implements Iterable<T> {

    T object;

    public TestClass() {
        this.object = object;
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }

    public boolean hasNext(){
        return true;
    }

    public TestClass next (){
        return new TestClass<T>();
    }



}
