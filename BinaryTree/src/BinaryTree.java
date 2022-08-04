public class BinaryTree {
    private class Node //inner class for nodes
    {
        private int data;
        private Node leftChild;
        private Node rightChild;

        public Node(int data) //non-default constructor
        {
            this.data = data;
        }

    }
    private Node root; //root node of tree

    //method for adding nodes
    public void addNode(int data)
    {
        Node newNode = new Node(data);

        if (root == null) //does tree have a root (any elements)?
        {
            root = newNode; //root is the new node
        }
        else
        {
            Node current = root; //start with root to traverse tree

            Node parent;

            while(true) //loops until we find a null for left or right child
            {
                parent = current; //set parent node as the root

                if(data < current.data) //if input data is less than current/root data,
                {
                    current = current.leftChild; //change current node to left node of current/root

                    if(current == null) // if the left node is empty
                    {
                        parent.leftChild = newNode; //new child
                        return;
                    }
                }
                else //if input data is greater than current data,
                {
                    current = current.rightChild; //change current data to right node of current

                    if (current == null) // if right node is empty
                    {
                        parent.rightChild = newNode;//new child
                        return;
                    }
                }
            }
        }
    }

    //in order traversal


}
