public class LinkedQueue<T> implements QueueInterface<T>
{
    private Item<T> front;
    private Item<T> rear;

    public LinkedQueue()
    {
        front = null;
        rear = null;
    }

    public void insert(T element)
    {
        Item<T> item = new Item<T>(element);

        //queue is empty
        if (isEmpty()) {
            front = item;
            rear = item;
        }
        //queue is not empty
        else {
            rear.next = item;
            rear = item;
        }
    }

    public T remove() throws QueueUnderflowException
    {
        if (isEmpty())
            throw new QueueUnderflowException("Remove attempted on empty queue");
        else {
            T info = front.info;
            front = front.next;
            return info;
        }
    }

    public Boolean isEmpty()
    {
        return front == null;
    }
}
