public class Item<T>
{
    protected T info;
    protected Item<T> next;

    public Item()
    {
        info = null;
        next = null;
    }

    public Item(T info)
    {
        this.info = info;
        next = null;
    }
}