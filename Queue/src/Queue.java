public class Queue
{
    int queue[] = new int[5];
    int size;
    int front; //left
    int rear; //right, if we have values

    public void enQueue(int data) //push
    {
        if(!isFull())
        {
            queue[rear] = data;
            rear = (rear + 1) % 5;
            size++;
        }
        else
            System.out.println("Queue is full");
    }

    public int deQueue() //pop
    {
        int data = queue[front];
        if(!isEmpty())
        {
            front = (front + 1) % 5;
            size--;
        }
        else
            System.out.println("Queue is empty");


        return data;
    }

    public void first() //peek
    {
        System.out.println("The element in the front of the queue is: ");
        int data = queue[front];
        System.out.println(data);
    }

    public int size()
    {

        return this.size;
    }

    public boolean isEmpty()
    {
        return size==0;
    }

    public boolean isFull()
    {
        return size()==5;
    }

    public void show()
    {
        System.out.println("Elements: ");
        for (int i = 0; i < size; i++)
        {
            System.out.print(queue[(front + i) % 5] + " ");
        }
        System.out.println(" ");

        for (int n: queue)
        {
            System.out.print(n + " ");
        }
    }
}
