package UTP.w2_1_Progamowanie_Funkcyjne;

import java.util.ArrayList;
import java.util.List;

public class TestClass<T,S>{

    //Parametry typu określa się przed typem zwracanym przez metodę <T, S>
    //

    public static <T, S> List <T> create (List<S> src, Filter<S> f, Transformer<T,S> t){
        List <T> target = new ArrayList<>();
        for (S e : src)
            if (f.test(e)) target.add(t.transform(e));
            return target;
    }

}
