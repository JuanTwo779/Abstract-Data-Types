public class Main {
    public static void main(String[] args)
    {
        Stack nums = new Stack();
        //push, pop, peek, empty, print

        System.out.println("Empty?: " + nums.isEmpty());

        nums.push(7);
        nums.push(20);
        nums.push(12);

        nums.show();

        System.out.println("------------------------");
        System.out.println("POP: " + nums.pop());
        nums.show();

        System.out.println("------------------------");
        System.out.println("PEEK: " + nums.peek());
        nums.show();

        System.out.println("------------------------");
        System.out.println("The size is: " + nums.size());

        System.out.println("Empty?: " + nums.isEmpty());
    }
}