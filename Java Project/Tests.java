public class Tests {

    public static void runTests(DequeADT<Integer> deque) {
        System.out.println("Initializing tests for " + deque.toString());

        deque.pushFront(1);
        deque.pushFront(2);
        deque.pushFront(3);
        deque.pushFront(4);
        deque.pushFront(5);
        deque.pushBack(6);
        deque.pushBack(7);
        deque.pushBack(8);
        deque.pushBack(9);
        deque.pushBack(10);

        if (deque.size() == 10)
            System.out.println("Initialization SUCCESS");
        else
            System.out.println("Initialization FAILURE");

        System.out.println("Testing add for " + deque.toString());

        deque.pushBack(23);
        deque.pushFront(-11);
        if (deque.size() == 12 && deque.front() == -11 && deque.back() == 23)
            System.out.println("TEST 1 : ADDING -> SUCCESS");
        else
            System.out.println("TEST 1 : ADDING -> FAILURE");

        System.out.println("Testing remove for " + deque.toString());

        deque.popBack();
        deque.popFront();
        if (deque.size() != 10 || deque.front() == -11 || deque.back() == 23)
            System.out.println("TEST 2 : REMOVE -> FAILURE ");
        else
            System.out.println("TEST 2 : REMOVE -> SUCCESS");

        System.out.println("Testing swap for " + deque.toString());

        deque.pushBack(20);
        deque.pushFront(19);
        deque.swap(19, 20);
        if (deque.front() == 20 || deque.back() == 19)
            System.out.println("TEST 3 : SWAP -> SUCCESS");
        else
            System.out.println("TEST 3 : SWAP -> FAILURE");

        System.out.println("End of tests for deque");

    }

    public static void main(String[] args) {

        DequeADT<Integer> arrDeque = new ArrayDeque<>();
        DequeADT<Integer> dllDeque = new DLLDeque<>();

        runTests(arrDeque);
        runTests(dllDeque);
    }
}
