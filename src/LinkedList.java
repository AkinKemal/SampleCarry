public class LinkedList implements LinkedListInterface {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public Node head = null;
    public int limit = 10;

    //Listenin ilk başına eleman ekleme
    @Override
    public void addBegin(int data) {
        if (data >= limit) {
            System.out.println(ANSI_RED + "The number to be added cannot be greater than 9." + ANSI_RESET);
            System.out.println("Sample: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9");
        } else {
            Node element = new Node(data);
            if (head == null) {
                head = element;
                printNewLinkedList();
                printAddData(data);
            } else {
                element.next = head;
                head = element;
                printAddData(data);
            }
        }
    }

    //Listenin en sonuna eleman ekleme
    @Override
    public void addEnd(int data) {
        if (data >= limit) {
            System.out.println(ANSI_RED + "The number to be added cannot be greater than 9." + ANSI_RESET);
            System.out.println("Sample: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9");
        } else {
            Node element = new Node(data);
            if (head == null) {
                head = element;
                printNewLinkedList();
                printAddData(data);
            } else {
                Node walk = head;
                while (walk.next != null) {
                    walk = walk.next;
                }
                walk.next = element;
                element.next = null;
                printAddData(data);
            }
        }
    }

    //Listeye belirlenen indexleri ekleme
    @Override
    public void addIndex(int data, int index) {
        if (data >= limit) {
            System.out.println(ANSI_RED + "The number to be added cannot be greater than 9." + ANSI_RESET);
            System.out.println("Sample: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9");
        } else {
            if (index < size()) {
                Node element = new Node(data);
                if (head == null && index == 0) {
                    head = element;
                    printNewLinkedList();
                    printAddData(data);
                } else if (head != null && index == 0) {
                    element.next = head;
                    head = element;
                    printAddData(data);
                } else if (size() == index) {
                    Node walk = head;
                    Node prev = null;
                    while (walk.next != null) {
                        prev = walk;
                        walk = walk.next;
                    }
                    prev.next = element;
                    element.next = walk;
                    printAddData(data);
                } else {
                    int counter = 0;
                    Node walk = head;
                    Node prev = null;
                    while (walk != null) {
                        if (counter == index) {
                            break;
                        }
                        prev = walk;
                        walk = walk.next;
                        counter++;
                    }
                    element = prev.next;
                    element.next = walk;
                    printAddData(data);
                }
            } else {
                System.out.println(ANSI_RED + "WARNING!" + ANSI_RESET + " The specified index could not be found.");
            }
        }
    }

    //İki Linked List birleştirilip yeni bir yeni Linked List oluşturma
    @Override
    public LinkedList add(LinkedList l1, LinkedList l2) {
        LinkedList l3 = new LinkedList();
        Node walk01 = null;
        Node walk02 = null;
        if (l1.head != null) {
            walk01 = l1.head;
        }
        if (l2.head != null) {
            walk02 = l2.head;
        }
        int data;
        int temporary;
        int carry = 1;
        boolean carryBoolean = true;
        while (walk01 != null || walk02 != null) {
            if (walk01 != null && walk02 != null) {
                temporary = (walk01.data + walk02.data);
            } else if (walk01 != null) {
                temporary = (walk01.data);
            } else {
                temporary = (walk02.data);
            }
            if (temporary > 9 && carryBoolean) {
                data = temporary % 10;
                carryBoolean = false;
            } else if (temporary > 9) {
                data = ((temporary % 10) + carry) % 10;
                if ((temporary % 10) + carry < 9) {
                    carryBoolean = true;
                }
            } else if (carryBoolean) {
                data = (temporary % 10);
            } else {
                data = ((temporary % 10) + carry) % 10;
                if ((temporary % 10) + carry < 9) {
                    carryBoolean = true;
                }
            }
            l3.addEnd(data);
            if (walk01 != null) {
                walk01 = walk01.next;
            }
            if (walk02 != null) {
                walk02 = walk02.next;
            }
            if (walk01 == null && walk02 == null && !carryBoolean) {
                l3.addEnd(1);
            }
        }
        return l3;
    }

    @Override
    public int size() {
        Node walk = null;
        int counter = 0;
        if (head != null) {
            walk = head;
            while (walk.next != null) {
                counter++;
                walk = walk.next;
            }
        }
        return counter;
    }

    @Override
    public void printList() {
        Node walk = null;
        if (head != null) {
            walk = head;
            System.out.print("head" + ANSI_RED + " -> " + ANSI_RESET);
            while (walk != null) {
                System.out.print(walk.data + ANSI_RED + " -> " + ANSI_RESET);
                walk = walk.next;
            }
            System.out.println("null");
        }
    }

    public void printAddData(int data) {
        System.out.println(ANSI_GREEN + "✅" + ANSI_RESET + " " + data + ", " + ANSI_GREEN + "successfully" + ANSI_RESET + " prepended.");
    }

    public void printNewLinkedList() {
        System.out.println(ANSI_GREEN + "✅" + ANSI_RESET + " A new LinkedList has been " + ANSI_GREEN + "successfully" + ANSI_RESET + " created.");
    }
}
