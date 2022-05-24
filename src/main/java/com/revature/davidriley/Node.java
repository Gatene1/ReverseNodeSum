package com.revature.davidriley;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.valueOf;

public class Node {
    private int data;
    private Node next;
    private Node prev;

    public Node(int data) {
        this.next = null;
        this.prev = null;
        this.data = data;
    }
    public Node() {

    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node addToEnd (Node head, int data) {
        Node tempNode = head;

        while (tempNode != null) {
            if (tempNode.next == null)
                break;
            tempNode = tempNode.next;
        }

        Node newNode = new Node(data);

        tempNode.next = newNode;
        newNode.prev = tempNode;

        return newNode;
    }

    public int returnReverseNodeData(Node head) {
        Node tempNode = head;
        List<Integer> intList = new ArrayList<Integer>();
        int contiguousInt = 0;
        String stringOfInt = "";

        while (tempNode != null) {
            intList.add(tempNode.data);
            tempNode = tempNode.next;
        }

        for (int listInteger : intList) {
            stringOfInt = listInteger + stringOfInt;
        }

        contiguousInt = valueOf(stringOfInt);

        return contiguousInt;
    }

    public void printLinkedList(Node head) {
        Node tempNode = head;

        while (tempNode != null) {
            if (tempNode.next == null)
                System.out.print(tempNode.data);
            else
                System.out.print(tempNode.data + " -> ");
            tempNode = tempNode.next;
        }
    }

    public int convertLinkedListIntoInt(Node head) {
        Node tempNode = head;
        List<Integer> intListToConvert = new ArrayList<Integer>();
        int multiplierForEachDigit = 1;
        int convertedInt = 0;

        while(tempNode != null) {
            intListToConvert.add(tempNode.data);
            tempNode = tempNode.next;
        }

        for (int addingZeroes = 1; addingZeroes < intListToConvert.size(); addingZeroes++) {
            multiplierForEachDigit *= 10;
        }

        for (int convertingListToInt = 0; convertingListToInt < intListToConvert.size(); convertingListToInt++) {
            convertedInt += intListToConvert.get(convertingListToInt) * multiplierForEachDigit;
            multiplierForEachDigit /= 10;
        }

        return convertedInt;
    }
}
