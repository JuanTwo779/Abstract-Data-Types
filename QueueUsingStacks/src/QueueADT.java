public class QueueADT
{
    StackADT pushStack = new StackADT();
    StackADT popStack = new StackADT();

    //Adds value to back of queue
    public void enqueue(char data)
    {
        pushStack.push(data); //we queue elements into the pushStack first
    }

    //Moves all characters in the pushStack to the popStack
    private void movePushToPop()
    {
        int size = pushStack.size;
        for (int i = 0; i < size; i++)
        {
            char top = pushStack.pop();
            popStack.push(top);
        }
    }

    //Removes value at the front and returns it
    public char dequeue()
    {
        if (pushStack.isEmpty() && popStack.isEmpty())
        {
            System.out.println("Queue is empty");
            return 0;
        }
        else if(popStack.isEmpty())
        {
            movePushToPop(); //move elements from push stack to popStack
        }
        return popStack.pop(); //pop from popStack to get "front" value
    }

    //Returns value at the front
    public char queueFront()
    {
        if (pushStack.isEmpty() && popStack.isEmpty())
        {
            System.out.println("Queue is empty");
            return 0;
        }
        else if(popStack.isEmpty())
        {
            movePushToPop(); //move elements from push stack to popStack
        }
        return popStack.stackTop();
    }

    //Checks if queue is empty
    public boolean empty()
    {
        //if at least one is not empty, false is returned
        return pushStack.isEmpty() && popStack.isEmpty();
    }

    //Prints out all the values stored in the queue
    public void print()
    {
        if (pushStack.isEmpty() && popStack.isEmpty())
        {
            System.out.println("Queue is empty");
            return;
        }
        else if(popStack.isEmpty() && !pushStack.isEmpty())
        {
            movePushToPop(); //move elements from push stack to popStack
            popStack.print();
        }

        StackADT temp = new StackADT();
        if (!pushStack.isEmpty() && !popStack.isEmpty())
        {
            //stores pushStack elements in reverse to a temp stack
            while (!pushStack.isEmpty())
            {
                int size = pushStack.size;
                for (int i = 0; i < size; i++) {
                }
                char top = pushStack.pop();
                temp.push(top);
            }

            if (!temp.isEmpty())
            {
                temp.print();
            }

            //stores elements back into push stack in correct order
            int tempSize = temp.size;
            for (int i = 0; i < tempSize; i++)
            {
                char tempTop = temp.pop();
                pushStack.push(tempTop);
            }
        }
    }
}
