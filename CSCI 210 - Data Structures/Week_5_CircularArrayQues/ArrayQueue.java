/*
 * Creates a circular array to handle Queue processing
 */
public class ArrayQueue<T> implements QueueInterface<T>
{
    public static final int MAX = 10;

    //use only these 3 instance variables!
    //you are NOT ALLOWED to add more instance variables
    private T elements[];
    private int front;
    private int rear;

    /*
     * Creates an array with a length of MAX
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
     * checks if front and rear point to the same element BEFORE wrapping, 
     */
    public Boolean isEmpty() {
        return front == rear;
    }

    /*
     * Checks if rear and front point to the same location AFTER wrapping
     * @returns true || false
     */
    public Boolean isFull() {
        return ((rear + 1) % MAX) == front;
    }

    /*
     * Checks if array is full before process
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
     * Checks if Queue is empty,
     * else
     * grabs first item in que
     * increments pointer, wraps to front if neccesary
     * return the item that was removed
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
