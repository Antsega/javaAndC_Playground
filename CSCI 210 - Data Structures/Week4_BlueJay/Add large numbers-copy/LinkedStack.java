public class LinkedStack<T> implements StackInterface<T> {
    private Item<T> top;

    public LinkedStack() {
        top = null;
    }

    public void push(T element) {
        Item<T> item = new Item<T>(element);

        if (!isEmpty())
            item.next = top;

            top = item;
    }

    public T pop() throws StackUnderflowException {
        if (isEmpty())
            throw new StackUnderflowException("Pop attempted on empty stack");
        else {
            T info = top.info;
            top = top.next;
            return info;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

}