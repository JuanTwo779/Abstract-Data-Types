public class StackADT
{
    private Node top;
    public int size;

    // node class (link)
    public class Node
    {
        private String data;
        private Node next; //single linked list

        public Node(String data)
        {
            this.data = data;
        }
    }
    // node class (link)

    /*
     * Method for adding new nodes to the stack
     * */
    public void push(String data)
    {
        Node newNode = new Node(data);
        newNode.next = top; //assigns the old top to the new nodes address
        top = newNode; //assigns the tops of stack with new node
        size++;
    }

    /*
     * Method for removing and returning top node
     * */
    public String pop()
    {
        String temp = null;
        try //empty stack exception
        {
            if(!isEmpty()) //checks that there is something to pop
            {
                temp = top.data; //hold data of top
                top = top.next; //set new top
                size--;
            }
        }
        catch(Exception e)
        {
            System.out.println("Stack is empty");
        }
        return temp;
    }

    /*
     * Method for returning the data of the top node (peek)
     * */
    public String peek()
    {
        if (top == null) //checks if stack is empty
            System.out.println("Stack is empty");
        return top.data;
    }

    /*
     * Method to check if the stack is empty
     * */
    public boolean isEmpty()
    {
        return top == null; //true if top is null
    }

    /*
     * Method to print out the data values of all nodes in the stack
     * */
    public void print()
    {
        Node current = top; //start from the top

        while(current != null) //loop to move along the stack
        {
            System.out.print(current.data + " ");

            current = current.next; //assign current to the next node
        }
        //System.out.println(" ");
    }
}

