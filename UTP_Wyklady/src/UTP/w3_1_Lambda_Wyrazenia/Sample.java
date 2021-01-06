package UTP.w3_1_Lambda_Wyrazenia;

public class Sample {

    static void arrOp(int[] arr, IntProcesor ip) {
        for ( int i = 0; i < arr.length; i++){
            arr[i] = ip.process(arr[i]);
        }
    }

    static void aarrOp(String[] arr, StringProcessor p) {
        for ( int i = 0; i < arr.length; i++){
            arr[i] = p.process(arr[i]);
        }
    }


}
