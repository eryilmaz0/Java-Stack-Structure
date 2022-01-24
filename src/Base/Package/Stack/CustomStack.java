package Base.Package.Stack;

public class CustomStack<T> implements Stack<T> {
    private T[] stack;
    private int stackCapacity;
    private boolean stackHasCapacity;

    public CustomStack() {
        this.stack = (T[]) new Object[0];
        this.stackCapacity = 0;
        this.stackHasCapacity = false;
    }


    public CustomStack(int stackCapacity){
        this.stack = (T[]) new Object[0];
        this.stackCapacity = stackCapacity;
        this.stackHasCapacity = true;
    }


    @Override
    public void clear() {
        this.stack = (T[]) new Object[0];
        System.out.println("Stack Cleared.");
    }

    @Override
    public void printStackInfo(){
        String stackCapacityText = this.stackHasCapacity ? Integer.toString(this.stackCapacity) : "Dynamic";
        System.out.println("************ STACK INFO ************");
        System.out.println("Stack Capacity : " +stackCapacityText);
        System.out.println("Stack Count : " +this.stack.length);
        System.out.println("Stack Members :");

        for(T value : this.stack){
            System.out.println(value);
        }
    }

    @Override
    public boolean pop(T value) {
        if(this.isStackAtRange()) return false;

        T[] tempStack = this.stack;
        this.stack = (T[]) new Object[tempStack.length + 1];

        for(int i = 0; i < tempStack.length; i++){
            this.stack[i] = tempStack[i];
        }

        this.stack[tempStack.length] = value;
        return true;
    }

    @Override
    public void push() {

        if(this.stack.length < 1){
            System.out.println("Stack Is Empty.");
            return;
        }
        T[] tempStack = this.stack;
        this.stack = (T[]) new Object[tempStack.length - 1];

        T pushedValue = tempStack[tempStack.length - 1];

        for(int i = 0; i < this.stack.length; i++){
            this.stack[i] = tempStack[i];
        }

        System.out.println(pushedValue +"Has Pushed From Stack.");
    }

    @Override
    public boolean add(int orderNumber, T value) {
        int index = orderNumber - 1;
        boolean indexSliderEnable = false;

        if(this.isStackAtRange()) return false;

        if(orderNumber == 1){
            boolean result = this.addElementIntoFirstIndex(value);
            return result;
        }

        if(orderNumber == this.stack.length){
            boolean result = this.addElementIntoLastIndex(value);
            return result;
        }

        //Add Value Into Stack
        T[] tempStack = this.stack;
        this.stack = (T[])new Object[tempStack.length + 1];

        for(int i = 0; i < this.stack.length; i++){

            if(i == index){
                this.stack[i] = value;
                indexSliderEnable = true;
                continue;
            }

            if(indexSliderEnable){
                this.stack[i] = tempStack[i - 1];
                continue;
            }

            this.stack[i] = tempStack[i];
        }

        return true;
    }

    @Override
    public boolean replace(int orderNumber, T value) {
        int index = orderNumber - 1;
        this.stack[index] = value;
        return true;
    }



    //Helper Methots
    private boolean isStackAtRange(){
        if(!this.stackHasCapacity) return false;
        if(this.stack.length < this.stackCapacity) return false;
        return true;
    }

    private boolean addElementIntoFirstIndex(T value){
        T[] tempStack = this.stack;
        this.stack = (T[])new Object[tempStack.length + 1];

        this.stack[0] = value;

        for(int i = 0; i < tempStack.length; i++){
            this.stack[i + 1] = tempStack[i];
        }
        return true;
    }

    private boolean addElementIntoLastIndex(T value){
        T[] tempStack = this.stack;
        this.stack = (T[])new Object[tempStack.length + 1];

        for(int i = 0; i < tempStack.length; i++){
            this.stack[i] = tempStack[i];
        }

        this.stack[tempStack.length] = value;
        return true;
    }
}
