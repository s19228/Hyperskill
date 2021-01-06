package UTP.w3_2_Lambda_Wyrazenia;

public class ScopeLambda {

    void doWork(Worker w){
        w.work();
    }

    void defineAndDoWork(String [] s){

        String pref = "(";
        String suff = ")";

        //lambda bez parametrow

        doWork(()->{
            System.out.println(this.getClass());
            for (int i = 0 ; i< s.length; i++){
                s[i] = pref + s[i] + suff;
            }
        });




    }

}
