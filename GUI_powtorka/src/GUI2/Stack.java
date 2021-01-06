package GUI2;

public interface Stack<T> {

    T pop();
    void push (T elt);
    boolean empty();
    boolean full();

    default boolean notEmpty() {
        return !empty();
    }

    default boolean notFull() {
        return !full();
    }
}
