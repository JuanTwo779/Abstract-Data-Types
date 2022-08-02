import java.util.Stack;

public class Main
{
    public static void main(String[] args)
    {
        Stack<String> games = new Stack<>();

        //push method adds value to top of stack
        games.push("Call of duty");
        games.push("Guitar Hero");
        games.push("Spider");
        games.push("Minecraft");

        System.out.println(games);
        System.out.println("--------------------------------------------------");

        //pop method returns top value and removes it from stack
        System.out.println(games.pop());
        System.out.println(games);
        System.out.println("--------------------------------------------------");

        //peek method returns top value
        System.out.println("The game at the top of the stack is: ");
        System.out.println(games.peek());
        System.out.println("--------------------------------------------------");

        //size method returns the number of elements stored in stack
        System.out.println("The size of the stack is: ");
        System.out.println(games.size());
        System.out.println("--------------------------------------------------");

        //empty method returns true if stack is empty, else false
        System.out.println(games.empty());
    }
}