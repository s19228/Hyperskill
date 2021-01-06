package UTP.w3_1_Lambda_Wyrazenia;

public class LampSample {

    static void arrOp(int[] arr, IntProcesor ip) {
        for ( int i = 0; i < arr.length; i++){
            arr[i] = ip.process(arr[i]);
        }
    }

    static IntProcesor getProcessor() {
        return (int x) -> x + 1;
    }


}
