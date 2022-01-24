package Base.Package;

import Base.Package.Stack.CustomStack;
import Base.Package.Stack.Stack;

public class Main {

    public static void main(String[] args) {

        //Stack<String> stack = new CustomStack<>();
        Stack<String> stack = new CustomStack<>(3);
        System.out.println(stack.pop("Value 1"));
        System.out.println(stack.pop("Value 2"));
        System.out.println(stack.pop("Value 3"));
        System.out.println(stack.pop("Value 1")); //Fails

        stack.printStackInfo();

        stack.push();
        //stack.push();
        //stack.push();
        //stack.push();
        //stack.push();
        //stack.push(); //Fails

        stack.replace(1, "Value 1 Replaced");
        stack.printStackInfo();

        stack.replace(2, "Value 2 Replaced");
        stack.printStackInfo();

        //stack.add(1, "Value 1 Added");
        //stack.printStackInfo();

        //stack.add(4, "Value 2 Added");
        //stack.printStackInfo();

        //stack.add(2, "Final Value");
        //stack.printStackInfo();

        stack.add(2, "Added Value");
        stack.printStackInfo();

        stack.add(3, "Added Value");
        stack.printStackInfo();

        stack.add(1, "1");
        stack.printStackInfo();

        stack.add(7, "7");
        stack.printStackInfo();


    }
}
