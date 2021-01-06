package UTP.w3_2_Lambda_Wyrazenia;

import java.util.ArrayList;
import java.util.List;

public class MetRef {

    static <S, T> List<T> create(List<S> src, Transformer <T, S>  t){
        List<T> target  = new ArrayList<>();
        for (S s : src)
            target.add(t.transform(s));
        return target;

    }

    static <R, T, S> List<R> create (List<T> src1, List<S> src2, Operator<R, T, S> o){
        List<R> res = new ArrayList<>();
        for (int i = 0 ; i < src1.size(); i++){
            res.add(o.oper(src1.get(i), src2.get(i)));
        }
        return res;
    }




}
