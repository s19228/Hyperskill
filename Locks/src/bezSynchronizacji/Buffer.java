/**
 *
 *  @author Gryka Konrad S19228
 *
 */

package bezSynchronizacji;

/**
 * Bufor jest obiektem klasy bezSynchronizacji.Buffer zawierającej między innymi metody int get() - pobierającą liczbę z bufora i put(int n) - wstawiającą liczbę do bufora.
 * Bufor ma ograniczoną pojemność, podaną w momencie jego utworzenia (w szczególności, bufor może mieć pojemność większą niż 1).
 * W danej chwili dostęp do bufora może mieć albo producent, albo konsument.
 */

public interface Buffer {

    //metoda pobierającą liczbę z bufora
    int get() throws InterruptedException;

    //metoda wstawiającą liczbę do bufora
    void put(int n) throws InterruptedException;

}
