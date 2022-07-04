/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import Classes.Article;
import Classes.HashObject;

/**
 *
 * @author isaac
 */
public class LinkedList {

    private Node head;
    private int length;

    /**
     * LinkedList constructor
     */
    public LinkedList() {
        this.head = null;
        this.length = 0;
    }

    /**
     * Adds Node at the start of the list
     *
     * @param element
     */
    public void addStart(Object element) {
        Node node = new Node(element);
        if (isEmpty()) {
            setHead(node);
        } else {
            node.setNext(getHead());
            setHead(node);
        }
        this.length++;
    }

    /**
     * Adds Node at the end of the list
     *
     * @param element
     */
    public void addEnd(Object element) {
        Node node = new Node(element);
        if (isEmpty()) {
            setHead(node);
        } else {
            Node pointer = getHead();
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            pointer.setNext(node);
        }
        this.length++;
    }

    /**
     * Adds Node at the specified index of the list
     *
     * @param pos
     * @param element
     */
    public void addInIndex(int pos, Object element) {
        Node node = new Node(element);
        if (isEmpty()) {
            setHead(node);
            this.length++;
        } else {
            if (pos > 0) {
                Node pointer = getHead();
                for (int i = 0; i < pos - 1; i++) {
                    if (pointer.getNext() == null) {
                        break;
                    }
                    pointer = pointer.getNext();
                }
                node.setNext(pointer.getNext());
                pointer.setNext(node);
                this.length++;
            } else {
                addStart(element);
            }

        }

    }

    /**
     * Deletes the Node at the start of the list
     */
    public void deleteStart() {
        if (!isEmpty()) {
            Node temp = getHead();
            setHead(temp.getNext());
            temp.setNext(null);
            this.length--;
        }
    }

    /**
     * Deletes the Node at the end of the list
     */
    public void deleteEnd() {
        if (!isEmpty()) {
            if (getLength() == 1) {
                setHead(null);
            } else {
                Node pointer = getHead();
                while (pointer.getNext().getNext() != null) {
                    pointer = pointer.getNext();
                }
                pointer.setNext(null);
            }

            this.length--;
        }
    }

    /**
     * Deletes the Node at the specified index of the list
     *
     * @param pos
     */
    public void deleteInIndex(int pos) {
        if (!isEmpty()) {
            if (pos <= 0) {
                deleteStart();
            } else {
                Node pointer = getHead();
                for (int i = 0; i < pos - 1; i++) {
                    if (pointer.getNext() == null) {
                        break;
                    }
                    pointer = pointer.getNext();
                }
                Node temp = pointer.getNext();
                boolean isNull = temp == null;
                if (!isNull) {
                    pointer.setNext(temp.getNext());
                    temp.setNext(null);
                    this.length--;
                } else {
                    deleteEnd();
                }
            }

        }
    }

    /**
     * Prints list in console
     */
    public void printList() {
        if (!isEmpty()) {
            Node pointer = getHead();
            while (pointer != null) {
                System.out.println(pointer.getElement());
                pointer = pointer.getNext();
            }
        } else {
            System.out.println("Sin elementos");
        }

    }

    /**
     * Gets element in the specified list index
     *
     * @param pos
     * @return element
     */
    public Object getElementInIndex(int pos) {
        if (!isEmpty()) {
            Node pointer = getHead();
            for (int i = 0; i < pos; i++) {
                if (pointer.getNext() == null) {
                    break;
                }
                pointer = pointer.getNext();
            }
            return pointer.getElement();
        } else {
            return null;
        }

    }

    /**
     * Deletes the given element from the list
     *
     * @param element
     */
    public void deleteByElement(Object element) {
        if (!isEmpty()) {
            Node pointer = getHead();
            if (element == pointer.getElement()) {
                deleteStart();
            } else {
                boolean found = false;
                while ((pointer.getNext() != null) && (!found)) {
                    if (pointer.getNext().getElement() == element) {
                        found = true;
                        break;
                    }
                    pointer = pointer.getNext();
                }
                if (found) {
                    Node temp = pointer.getNext();
                    pointer.setNext(temp.getNext());
                    temp.setNext(null);

                    this.length--;
                } else {
                    System.out.println("El elemento no existe en la lista");
                }

            }
        }
    }

    /**
     * Gets the Node at the specified list index
     *
     * @param pos
     * @return Node
     */
    public Node getNodeByIndex(int pos) {
        if (!isEmpty()) {
            Node pointer = getHead();
            for (int i = 0; i < pos; i++) {
                if (pointer.getNext() == null) {
                    break;
                }
                pointer = pointer.getNext();
            }
            return pointer;
        } else {
            return null;
        }

    }

    // Código para ordenar lista, modificar para el orden alfabético
//    public void reorderListToAscending() {
//        int originalLength = getLength();
//        for (int i = 0; i < originalLength; i++) {
//            Node lowestElementNode = getLowestNbIdNode(getNodeByIndex(i));
//            deleteByElement(lowestElementNode.getElement());
//            addInIndex(i, lowestElementNode.getElement());
//        }
//    }
//
//    public Node getLowestNbIdNode(Node auxHead) {
//        Node pointer = auxHead;
//        Node lowestElementNode = pointer;
//
//        while (pointer.getNext() != null) {
//            if ((int) lowestElementNode.getElement() > (int) pointer.getNext().getElement()) {
//                lowestElementNode = pointer.getNext();
//            }
//            pointer = pointer.getNext();
//        }
//
//        return lowestElementNode;
//
//    }
    /**
     * Checks if the given object is currently inside the list
     *
     * @param element
     * @return boolean
     */
    public boolean isObjectInList(Object element) {
        Node pointer = getHead();
        boolean found = false;
        while (pointer != null) {
            if (pointer.getElement() == element) {
                found = true;
                break;
            }
            pointer = pointer.getNext();
        }
        return found;
    }

    /**
     * Checks if the given article title is currently inside the list
     *
     * @param title
     * @return boolean
     */
    public boolean isTitleInList(String title) {
        Node pointer = getHead();
        while (pointer != null) {
            if (((Article) pointer.getElement()).getTitle().equals(title)) {
                return true;
            }
            pointer = pointer.getNext();
        }
        return false;
    }

    /**
     * Checks if the given hashObject is currently inside the list
     *
     * @param key
     * @return boolean
     */
    public boolean isHashObjectInList(String key) {
        Node pointer = getHead();
        while (pointer != null) {
            if (((HashObject) pointer.getElement()).getKey().equals(key)) {
                return true;
            }
            pointer = pointer.getNext();
        }
        return false;
    }

    /**
     * Getter for head
     *
     * @return head
     */
    public Node getHead() {
        return head;
    }

    /**
     * Setter for head
     *
     * @param head
     */
    public void setHead(Node head) {
        this.head = head;
    }

    /**
     * Getter for length
     *
     * @return head
     */
    public int getLength() {
        return length;
    }

    /**
     * Setter for length
     *
     * @param length
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Checks if the list is empty
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return getHead() == null;
    }
    
    /**
     * Checks if the wordRepetition Object is in the list and returns a boolean
     * @param object
     * @return boolean
     */
    public boolean isWordRepetitionIn(WordRepetition object) {
        Node pointer = getHead();
        while (pointer != null) {
            if (pointer.getElement().equals(object)) {
                return true;
            }
            pointer = pointer.getNext();
        }
        return false;
    }
    
    /**
     * Adds the string at the end of the list if its not already in the list
     * @param element 
     */
    public void addEndNoRep(String element) {
        Node node = new Node(element);
        if (isEmpty()) {
            setHead(node);
        } else {
            Node pointer = getHead();
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            if (!isStringInList(element)) {
                pointer.setNext(node);
            } else {
            }
        }
        this.length++;
    }
    
    /**
     * Checks if the String is in the list returning a boolean
     * @param element
     * @return boolean
     */
    public boolean isStringInList(String element) {
        Node pointer = getHead();
        boolean found = false;
        while (pointer != null) {
            if (((String) pointer.getElement()).equals(element)) {
                found = true;
                break;
            }
            pointer = pointer.getNext();
        }
        return found;
    }
    
    /**
     * From the authors list it returns an organized String of the authors
     * @return result
     */
    public String getAuthorsString() {
        String result = "";
        
        Node pointer = getHead();
        while (pointer.getNext() != null) {
            result += (String) pointer.getElement() + ", ";
            pointer = pointer.getNext();
        }
        result += (String) pointer.getElement() + ".";
        
        return result;
    }
    
    

}
