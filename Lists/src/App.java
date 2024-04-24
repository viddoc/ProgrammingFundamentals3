//Tommy Hudson List Testing


public final class App {

    /**
     * This is the main method that will be used to test the dynamicArray and List classes.
     * @param args The command line arguments.
     */
    public static void main(String[] args) 
    {
        //Testing the dynamicArray class
        dynamicArray<Integer> intArr = new dynamicArray<Integer>(0,1,2,3,4,5,6,7,8,9,10);
        intArr.print();
        intArr.append(11);
        intArr.delete(0);
        System.out.println("The array contains 11: " + intArr.contains(11));
        System.out.print("Search for 100: ");
        intArr.search(100);
        System.out.println("The size of the integer array is: " + intArr.size());
        intArr.clear();
        System.out.println("Integer array cleared.");
        System.out.println("The array is empty: " + intArr.isEmpty());

        //Testing the List classes
        SinglyLinkedList<Double> dblSLL = new SinglyLinkedList<Double>();
        DoublyLinkedList<String> strDLL = new DoublyLinkedList<String>();
        dblSLL.append(100.0);
        dblSLL.append(200.0);
        dblSLL.append(300.0);
        dblSLL.append(400.0);
        dblSLL.append(500.0);
        System.out.println();
        strDLL.append("Hello");
        strDLL.append("this");
        strDLL.append("is my");
        strDLL.append("custom");
        strDLL.append("list");
        dblSLL.print();
        System.out.println();
        strDLL.print();
        dblSLL.prepend(50.0);
        strDLL.removeFirst();
        strDLL.removeLast();
        strDLL.set(0, "This");
        strDLL.append("Doubly Linked List");
        dblSLL.insert(250.0, 3);
        dblSLL.print();
        System.out.println();
        strDLL.print();
        

    }
}
