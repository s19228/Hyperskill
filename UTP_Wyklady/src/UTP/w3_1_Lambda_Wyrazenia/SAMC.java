package UTP.w3_1_Lambda_Wyrazenia;

import java.util.Collection;

public interface SAMC {

    void doWork(Collection c);
    default public void done(){
        System.out.println("Done");
    }

}
