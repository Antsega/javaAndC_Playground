
public interface QueueInterface<T>
{
    void insert(T element);

    T remove() throws QueueUnderflowException;

    Boolean isEmpty();
}
