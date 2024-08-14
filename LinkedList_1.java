// Here I learn about insertion in LINKED LIST 

import java.util.Scanner;

class Node {
    int data;
    Node next;

    // CONSTRUCTOR
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList_1 {

    Node head;

    // CREATE A LINKED LIST
    public void createList(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // CODE FOR TRAVERSE
    public int traverse() {
        Node current = head;
        int count = 0;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    // CODE FOR INSERT ELEMENT: AT BEGINNING
    public void insertionAtBeginning(int data) {
        Node newNode = new Node(data); // NODE THAT GOING TO INSERT
        newNode.next = head; // LINK NEW NODE TO CURRENT HEAD
        head = newNode; // UPGRADE THE HEAD TO NEW NODE

    }

    // CODE FOR INSERT ELEMENT: AT LAST
    public void insertionAtEnd(int data) {
        Node newNode = new Node(data); // NODE THAT GOING TO INSERT
        // CONDTIION IF LIST WAS EMPTY: NEW NODE BECOME HEAD
        if (head == null) {
            head = newNode;
        } else { // NEED TO TRAVERSE TILL END OF NODE
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode; // ATTACH NEW NODE AT THE END

        }
    }

    // CODE FOR INSERT ELEMENT: AT THE MIDDLE OF LIST
    public void insertion(int data, int p) {
        Node newNode = new Node(data); // NODE THAT GOING TO INSERT

        // IF LIST IS EMPTY OR POSITION VALUE IS 1, INSERT AT BEGINNING
        if (head == null || p == 1) {
            head = newNode;
        }

        Node temp = head;
        int count = 1;

        // TRAVERSER THE LIST TO FIND NODE BEFORE THE DESIRED POSTION
        while (temp != null && count < p - 1) {
            temp = temp.next;
            count++;
        }

        // IF POSITION VALUE BEYOND THE SIZE OF LIST
        if (temp == null) {
            System.out.println("ERROR: position value exceed the size of list.");
            return;
        }

        // INSERT NEW NODE AT DESIRED POSITION
        newNode.next = temp.next;
        temp.next = newNode;

    }

    // METHOD TO DISPLAY LINKED LIST
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] a) {
        LinkedList_1 list = new LinkedList_1(); // CREATION OF OBJECT

        // CREATE LIST
        list.createList(1);
        list.createList(2);
        list.createList(3);
        list.createList(4);

        // OUTPUT FROM TRAVERSE
        System.out.println("Traversal OUTPUT:- " + list.traverse());

        list.insertionAtBeginning(14);
        System.out.println("INSERTION AT BEGINNING:");
        list.display();

        System.out.println("INSERT AT END:");
        list.insertionAtEnd(234);
        list.display();

        // INSERT ELEMENT IN MIDDLE: USER WILL DECIDE AT WHICH
        // POSITION ELEMENT WILL INSERT

        Scanner sc = new Scanner(System.in);
        System.out.println("Decide the position for insertion:");
        int p = sc.nextInt();

        sc.close();

        list.insertion(78, p);
        list.display();

    }

}