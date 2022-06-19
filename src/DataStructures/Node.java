/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 *
 * @author isaac
 */
public class Node {

    private Object element;
    private Node next;

    /**
     * Node constructor
     * @param element
     */
    public Node(Object element) {
        this.element = element;
        this.next = null;
    }

    /**
     * Getter for element
     *
     * @return element
     */
    public Object getElement() {
        return element;
    }
    
    /**
     * Setter for element
     * @param element
     */
    public void setElement(Object element) {
        this.element = element;
    }

    /**
     * Getter for next
     * @return next
     */
    public Node getNext() {
        return next;
    }
    
    /**
     * Setter for next
     * @param next
     */
    public void setNext(Node next) {
        this.next = next;
    }

}
