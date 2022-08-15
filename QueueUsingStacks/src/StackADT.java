public class StackADT
{
    private Node top;
    public int size;

    // inner node class
    public class Node
    {
        private char data;
        private Node next; //single linked list

        public Node(char data)
        {
            this.data = data;
        }
    }

    //Adds new node to the stack
    public void push(char data)
    {
        Node newNode = new Node(data);
        newNode.next = top; //assigns the old top to the new nodes address
        top = newNode; //assigns the tops of stack with new node
        size++;
    }

    //Removes top of stack node and returns its data
    public char pop()
    {
        char temp = ' ';
        if(!isEmpty()) //checks that there is something to pop
        {
            temp = top.data; //hold data of top
            top = top.next; //set new top
            size--;
        }
        else
        {
            System.out.println("Stack is empty");
            return 0;
        }
        return temp;
    }

    //Returns the data of the top node
    public char stackTop()
    {
        if (top == null) //checks if stack is empty
        {
            System.out.println("Stack is empty");
        }
        else
        {
            return top.data;
        }
        return 0;
    }

    //Checks if stack is empty
    public boolean isEmpty()
    {
        return top == null;
    }

    //Prints out the data values of all nodes in the stack
    public void print()
    {
        Node current = top; //start from the top
        if (current == null)
        {
            System.out.println("Stack is empty");
            return;
        }

        while(current != null) //loop to move along the stack
        {
            System.out.print(current.data + " ");
            current = current.next; //assign current to the next node
        }

    }

}
