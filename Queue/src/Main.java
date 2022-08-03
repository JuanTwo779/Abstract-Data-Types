public class Main {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enQueue(7);
        q.enQueue(19);
        q.enQueue(1);
        q.enQueue(13);

        q.deQueue();
        q.deQueue();
        q.deQueue();

        q.enQueue(109);
        q.enQueue(100);
        q.enQueue(130);
        q.enQueue(145);

        System.out.println(q.isEmpty());

        System.out.println(q.size());

        //q.show();


    }
}