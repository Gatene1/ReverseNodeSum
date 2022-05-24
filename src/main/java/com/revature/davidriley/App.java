package com.revature.davidriley;

public class App {

    static Node nodeClass = new Node();

    // This will take num1 and num2 and make the linked lists of each of the digits.
    public static Node convertNumberIntoReverseLinkedList(Node head, int num) {
        short numOfDigits = 0;
        int divisor = 100;
        Node tempNode = head;

        // While there are digits to count in the number. If the number is 0.234, there are no more numbers.
        while ((((num % divisor) / (divisor / 10)) >= 1) || (num / divisor >= 1)){
            // if divisor is 100, the below says Node newNode = new Node((num % 100) / 10)), so 716 will be node(1).
            Node newNode = new Node((num % divisor) / (divisor / 10));
            newNode.setPrev(tempNode);
            tempNode.setNext(newNode);
            tempNode = tempNode.getNext();
            divisor *= 10;
        }

        return head;
    }

    public static void main(String args[]) {
        int num1 = 716;
        int num2 = 592;
        int min = 0;

        // make the two heads of the two linked lists be equal to the last digit of both ints above.
        Node head = new Node(num1 % 10);
        Node head2 = new Node(num2 % 10);

        head = convertNumberIntoReverseLinkedList(head, num1);
        head2 = convertNumberIntoReverseLinkedList(head2, num2);

        num1 = nodeClass.convertLinkedListIntoInt(head);
        num2 = nodeClass.convertLinkedListIntoInt(head2);


        System.out.println("  " + num1);
        System.out.println("+ " + num2);
        System.out.println("--------");
        System.out.println("  " + (num1 + num2));

    }
}