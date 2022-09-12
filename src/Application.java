public class Application {

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        LinkedList l3;

        l1.addEnd(5);
        l1.addEnd(3);
        l1.addEnd(1);
        l1.addEnd(3);
        l1.addEnd(9);
        l1.addEnd(9);

        l2.addEnd(2);
        l2.addEnd(7);
        l2.addEnd(1);
        l2.addEnd(1);
        l2.addEnd(1);

        l1.printList();
        l2.printList();

        l3 = l1.add(l1, l2);
        l3.printList();
    }
}
