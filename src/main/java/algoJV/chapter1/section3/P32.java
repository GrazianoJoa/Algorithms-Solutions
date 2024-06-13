package algoJV.chapter1.section3;

public class P32 {
    public static void main(String[] args) {
        Steque<Integer> steque = new Steque<Integer>();
        steque.push(2);
        steque.push(4);
        System.out.println(steque.pop());
        steque.enqueue(1);
        System.out.println(steque.toString());
    } 
}
