public class Stack
{

    int stack[] = new int[5]; //use pre-made linked list for at3
    int top = 0;

    public void push(int data)
    {
        stack[top] = data;
        top++; //e.g., top is now 1
    }

    public int pop()
    {
        int data;
        top--; //before decrement, top refers to null value over the actual top
        data = stack[top];
        stack[top] = 0;
        return data;
    }

    public int peek()
    {
        int data;
        data = stack[top - 1];
        return data;
    }

    public int size()
    {
        return top;
    }

    public boolean isEmpty()
    {
        return top <= 0;
    }

    public void show()
    {
        for (int n: stack)
        {
            System.out.print(n + " ");
        }
        System.out.println("");
    }

}
