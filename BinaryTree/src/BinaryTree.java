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

        public String toString()
        {
            return "Node data: " + data;
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
                parent = current; //set parent node as the current

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
    //goes for smallest value to highest (left side first; ascending order)
    public void inOrderTraverseTree(Node current)
    {
        if (current != null)
        {
            inOrderTraverseTree(current.leftChild); //traverse left node if current is not empty
            System.out.println(current); //invoke toString
            inOrderTraverseTree(current.rightChild);
        }
    }

    //preOrderTraverse
    //root --> left side --> right side
    public void preOrderTraverseTree(Node current)
    {
        if (current != null)
        {
            System.out.println(current); //invoke toString
            preOrderTraverseTree(current.leftChild);
            preOrderTraverseTree(current.rightChild);
        }
    }

    //postOrderTraverse
    //left children --> right children --> root
    public void postOrderTraverseTree(Node current)
    {
        if (current != null)
        {
            postOrderTraverseTree(current.leftChild);
            postOrderTraverseTree(current.rightChild);
            System.out.println(current); //invoke toString
        }
    }

    //method to find node with a certain value
    public Node findNode(int inputData)
    {
        Node current = root;

        while (current.data != inputData)
        {
            if(inputData < current.data)
            {
                current = current.leftChild;
            }
            else
            {
                current = current.rightChild;
            }

            if (current == null)
            {
                return null;
            }
        }
        return current;
    }

    //Method to delete node
    //reassigning nodes and their children + traversing the tree
    public boolean remove(int inputData)
    {
        Node current = root;
        Node parent = root;

        boolean isItALeftChild = true;

        while(current.data != inputData)
        {
            parent = current;

            if(inputData < current.data)
            {
                isItALeftChild = true;

                current = current.leftChild;
            }
            else
            {
                isItALeftChild = false;

                current = current.rightChild;
            }

            if (current == null)
            {
                return false;
            }
        }

        if (current.leftChild == null && current.rightChild == null)
        {
            if(current == root)
            {
                root = null;
            }
            else if(isItALeftChild)
            {
                parent.leftChild = null;
            }
            else
            {
                parent.rightChild = null;
            }
        }

        else if(current.rightChild == null)
        {
            if (current == root)
            {
                root = current.leftChild;
            }
            else if (isItALeftChild)
            {
                parent.leftChild = current.leftChild;
            }
            else
            {
                parent.rightChild = current.leftChild;
            }
        }

        else if(current.leftChild == null)
        {
            if (current == root)
            {
                root = current.rightChild;
            }
            else if (isItALeftChild)
            {
                parent.leftChild = current.rightChild;
            }
            else
            {
                parent.rightChild = current.rightChild;
            }
        }

        else
        {
            Node replacement = getReplacement(current);

            if(current == root)
            {
                root = replacement;
            }
            else if (isItALeftChild)
            {
                parent.leftChild = replacement;
            }
            else
            {
                parent.rightChild = replacement;
            }

            replacement.leftChild = current.leftChild;
        }

        return true;
    }

    public Node getReplacement(Node replaceNode)
    {
        Node replacementParent = replaceNode;
        Node replacement = replaceNode;

        Node current = replaceNode.rightChild;

        while (current != null)
        {
            replacementParent = replacement;

            replacement = current;

            current = current.leftChild;
        }

        if (replacement != replaceNode.rightChild)
        {
            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replaceNode.rightChild;
        }

        return replacement;
    }

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();

        //add method assigns root
        tree.addNode(50);
        tree.addNode(25);
        tree.addNode(15);
        tree.addNode(30);
        tree.addNode(75);
        tree.addNode(85);

        tree.inOrderTraverseTree(tree.root);

        System.out.println("--------------------------------");

        tree.preOrderTraverseTree(tree.root);

        System.out.println("--------------------------------");

        tree.postOrderTraverseTree(tree.root);

        System.out.println("--------------------------------");

        System.out.println("Search for 75");
        System.out.println(tree.findNode(75));

    }


}
