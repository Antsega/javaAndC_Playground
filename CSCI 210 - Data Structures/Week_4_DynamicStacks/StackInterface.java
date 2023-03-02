public interface StackInterface<T> {
    void push(T element);

    T pop() throws StackUnderflowException;

    boolean isEmpty();
}
