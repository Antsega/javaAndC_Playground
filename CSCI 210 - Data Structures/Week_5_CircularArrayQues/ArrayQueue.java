/*
 * Creates a circular array to handle Queue processing
 */
public class ArrayQueue<T> implements QueueInterface<T>
{
    // array size
    public static final int MAX = 10;

    //use only these 3 instance variables!
    //you are NOT ALLOWED to add more instance variables
    private T elements[];
    private int front;
    private int rear;

    /*
     * Constructs an array with the size of max
     * positions front and rear 
     */
    public ArrayQueue()
    {
        elements = (T[]) new Object[MAX];
        //tweaked here to deliberately force early wrapping!
        front = MAX - 3;
        rear = MAX - 3;
    }
    

    /*
     * @return true if front and rear point to the same value;
     * false otherwise
     */
    public Boolean isEmpty() {
        return front == rear;
    }

    /*
     * @returns true if rear and front point to the same location AFTER rear wrapping; 
     * false otherwise
     */
    public Boolean isFull() {
        return ((rear + 1) % MAX) == front;
    }

    /*
     * If array is already full, 
     * @return OverflowException;
     * else
     * increments rear, wraps to front if neccesary
     * adds the item to the queue
     */
    public void insert(T num) throws QueueOverflowException {
        if (isFull()) {
            throw new QueueOverflowException("Cannot insert element into full queue.");
        }
        else {
            rear = (rear + 1) % MAX;
            elements[rear] = num;
        }
}
    /*
     * If Queue is already Empty,
     * @return UnderflowException;
     * else
     * grabs T item in front of Queue
     * increments front pointer, wraps to front if neccesary
     * @return the item that was removed
     */
    public T remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException("Queue is Empty");
        }
        T removedElement = elements[front];
        elements[front] = null;
        front = (front + 1) % MAX;
        return removedElement;
    }
}
