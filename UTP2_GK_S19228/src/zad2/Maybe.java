/**
 * @author Gryka Konrad S19228
 */

package zad2;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Maybe<T> {

    private T m;

    public Maybe(T m) {
        this.m = m;
    }

    public static <R> Maybe<R> of(R m) {
        return new Maybe<>(m);
    }

    public void ifPresent(Consumer cons) {
        if (this.m != null)
            cons.accept(m);
    }

    ;

    public <R> Maybe<R> map(Function<T, R> func) {
        if (this.m != null)
            return new Maybe<>(func.apply(this.m));
        else
            return new Maybe<>(null);
    }

    public boolean isPresent() {
        return m != null;
    }

    public T orElse(T m) {
        if (this.m != null)
            return this.m;
        else
            return m;
    }

    public T get() {
        if (m == null)
            throw new NoSuchElementException(" maybe is empty");
        return this.m;
    }

    public Maybe<T> filter(Predicate<T> predict) {
        if (predict.test(this.m)) {
            return this;
        } else if (this.m == null) {
            return this;
        } else
            return Maybe.of(null);
    }

    @Override
    public String toString() {
        if (this.m == null)
            return "Maybe is empty";
        else
            return "Maybe has value " + this.m;
    }
}
