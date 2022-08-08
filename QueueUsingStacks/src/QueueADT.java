public class QueueADT
{
    StackADT pushStack = new StackADT();
    StackADT popStack = new StackADT();

    //enqueue() - add value to back of queue
    public void enqueue(String data)
    {
        pushStack.push(data); //we queue elements into the pushStack first
    }

    private void movePushToPop()
    {
        int size = pushStack.size;
        for (int i = 0; i < size; i++)
        {
            String top = pushStack.pop();
            popStack.push(top);
        }
    }

    //dequeue() - remove value at the front and return it
    public String dequeue()
    {
        if(popStack.isEmpty())
        {
            movePushToPop(); //move elements from push stack to popStack
        }
        return popStack.pop(); //pop from popStack to get "front" value
    }

    //queueFront() - return value at front
    public String queueFront()
    {
        if(popStack.isEmpty())
        {
            movePushToPop(); //move elements from push stack to popStack
        }
        return popStack.peek();
    }

    //isEmpty()
    public boolean empty()
    {
        return pushStack.isEmpty() && popStack.isEmpty();
    }

    //print
    public void print()
    {
        if(popStack.isEmpty())
        {
            movePushToPop(); //move elements from push stack to popStack
        }
        popStack.print();

        StackADT temp = new StackADT();
        if (pushStack.isEmpty())
        {
            return;
        }
        else //prints the push stack in reverse
        {
            //stores pushStack elements in reverse to a temp stack
            int size = pushStack.size;
            for (int i = 0; i < size; i++)
            {
                String top = pushStack.pop();
                temp.push(top);
            }
            temp.print();

            //stores elements back into push stack is correct order
            int tempSize = temp.size;
            for (int i = 0; i < tempSize; i++)
            {
                String tempTop = temp.pop();
                pushStack.push(tempTop);
            }
        }
    }
}

