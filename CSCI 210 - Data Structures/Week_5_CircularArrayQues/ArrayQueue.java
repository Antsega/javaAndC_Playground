public class ArrayQueue<T> implements QueueInterface<T>
{
    public static final int MAX = 10;

    //use only these 3 instance variables!
    //you are NOT ALLOWED to add more instance variables
    private T elements[];
    private int front;
    private int rear;

    public ArrayQueue()
    {
        //awkward syntax!
        elements = (T[]) new Object[MAX];
        /* the usual initialisations
        front = MAX - 1;
        rear = MAX - 1;
        */
        //tweaked here to deliberately force early wrapping!
        front = MAX - 3;
        rear = MAX - 3;
    }
    
    //implement your methods with Javadoc comments here
    //again, you are NOT ALLOWED to add more instance variables

    /*
     * if front and rear point to the same element
     */
    public Boolean isEmpty() {
        return front == rear;
    }

    /*
     * The que is full if the rear and front point to the same location AFTER wrapping has occured
     */
    public Boolean isFull() {
        return ((rear + 1) % MAX) == front;
    }

    /*
     * if full, throws Overflow exception
     * else
     * increments rear, wraps to front if neccesary
     * adds the item to the que
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
     * if empty, throws Underflow exception
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
