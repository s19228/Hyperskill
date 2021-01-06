import java.util.List;

public class Gen <T> {

    private  T obj;
    private List<T> list;
    private Object Integer;

    public Gen(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void showType(){
        System.out.println("Typ T to: " + obj.getClass().getCanonicalName());
    }

    public void calkiemNowaMetoda(T obj){
        if (obj.getClass() == Integer){
            System.out.println("To jest intidzer");
        }
    }

}
