public class Tester
{
    public static void main()
    {
        QueueInterface<Character> q = new ArrayQueue<Character>();

        //insert into the queue, with wrapping
        for (Character ch = 'a'; ch <= 'h'; ++ch)
            q.insert(ch);

        //remove the first 5 items, with wrapping
        for (int i = 1; i <= 5; ++i)
            System.out.print(q.remove());
        System.out.println();

        //now fill the queue
        for (Character ch = 'A'; ch <= 'F'; ++ch)
            q.insert(ch);

        //test the new QueueOverflow exception
        try {
            q.insert('!');
        }
        catch (QueueOverflowException overflow) {
        System.out.println("Exception: " + overflow.getMessage());
        System.err.println("Exception: " + overflow.getMessage());
//        System.exit(2);
        }

        //empty the queue
        while (!q.isEmpty())
            System.out.print(q.remove());
        System.out.println();

        System.out.println("done");
    }
}
