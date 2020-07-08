import LinkedList.Node;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LinkedListDemo {

    public static void main(String[] args) throws IOException {


        Scanner console = new Scanner(System.in);
        Node nodePtr = new Node();

        PrintMainMenu();


        while(true) {
            int option = console.nextInt();
            switch (option) {
                case 1:
                   nodePtr = createLinkedListItem(nodePtr);
                    PrintMainMenu();
                    break;
                case 2:
                   nodePtr = addMultipleLinkedListItems(nodePtr);
                    PrintMainMenu();
                    break;
                case 3:
                    deleteLinkedListItem();
                    PrintMainMenu();
                    break;
                case 4:
                    showNumberOfItems();
                    PrintMainMenu();
                    break;
                case 5:
                    showAllItems();
                    PrintMainMenu();
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }

    private static void PrintMainMenu() {
        System.out.println("---------------------------------");
        System.out.println("Linked List Operations Menu");
        System.out.println("---------------------------------");
        System.out.println("0. Print this Main Menu");
        System.out.println("1. Add a new item");
        System.out.println("2. Add multiple items");
        System.out.println("3. Delete an item");
        System.out.println("4. Show number of items");
        System.out.println("5. Show all Items");
        System.out.println("6. Exit");
        System.out.println("Enter your choice");
    }

    private static void showAllItems() {
    }

    private static void showNumberOfItems() {
    }

    private static void deleteLinkedListItem() {
    }

    private static Node addMultipleLinkedListItems(Node nodePtr) throws IOException {

        System.out.println("**** Adding LinkedList Items ***** ");
        System.out.println("Enter the # of LinkedList items to be added: ");
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        int count = Integer.parseInt(br.readLine());
        System.out.println("Printing items of LinkedList");
        if(nodePtr.getNodeNext() == null)
        {
            System.out.println(nodePtr.getData());
            BuildLinkedListWithMultipleItems(nodePtr, count);
        }
        else {
            Node nodeNav = nodePtr;
            System.out.println(nodeNav.getData());
            while (nodeNav.getNodeNext() != null)
            {
                nodeNav = nodeNav.getNodeNext();
                System.out.println(nodeNav.getData());
            }

            BuildLinkedListWithMultipleItems(nodeNav, count);
        }
        return nodePtr;
    }

    private static void BuildLinkedListWithMultipleItems(Node nodePtr, int count) {
        Node temp = nodePtr;

        int tempCount = 1;

        while(tempCount <= count)
        {
            temp.setData(tempCount);
            temp.setNodeNext(new Node());
            temp = temp.getNodeNext();
            tempCount++;
        }

        Node printNode = nodePtr;

        while (printNode.getNodeNext() != null)
        {
            System.out.println(printNode.getData());
            printNode = printNode.getNodeNext();
        }
    }

    private static Node createLinkedListItem(Node nodePtr)throws IOException{

        System.out.println("**** Adding a LinkedList Item ***** ");
        System.out.println("Enter the LinkedList data value : ");
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        int value = Integer.parseInt(br.readLine());

        Node tempPtr = nodePtr;

        if (tempPtr.getData() == 0 && tempPtr.getNodeNext() == null) {
            tempPtr = new Node();
            tempPtr.setData(value);
            tempPtr.setNodeNext(null);
            nodePtr = tempPtr;

            System.out.println("Node(s) that was added is  so far : " + nodePtr.getData());
        }
        else if (tempPtr.getNodeNext() == null) {
            tempPtr = new Node();
            tempPtr.setData(value);
            tempPtr.setNodeNext(null);
            nodePtr.setNodeNext(tempPtr);

            System.out.println("Node(s) that was added is  so far : ");
            Node tempNode = nodePtr;

            while (tempNode.getNodeNext() != null)
            {
                System.out.println(tempNode.getData());
                tempNode = tempNode.getNodeNext();
            }
            System.out.println(tempNode.getData());
        }
        else {
            while(tempPtr.getNodeNext() != null)
            {
                tempPtr = tempPtr.getNodeNext();
            }

            Node newNode = new Node();
            newNode.setData(value);
            newNode.setNodeNext(null);
            tempPtr.setNodeNext(newNode);

            System.out.println("Node(s) that was added is  so far : ");

            Node tempNode = nodePtr;

            while (tempNode.getNodeNext() != null)
            {
                System.out.println(tempNode.getData());
                tempNode = tempNode.getNodeNext();
            }
            System.out.println(tempNode.getData());
        }
        return nodePtr;
    }
}
