/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs2169_lab9;

/**
 *
 * @author Hoang
 */
public class Queue<E> {

    private Node<E> front;
    private Node<E> back;
    
    public Queue() {
        front = null;
        back = null;
    }
    
    public boolean isEmpty() {
        return front == null;
    }
    
    public E peek() {
        return front.item;
    }
    
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E retval = front.item;
        front = front.next;
        return retval;
    }
    
    public boolean offer(E item) {
        Node<E> node = new Node<E>(item);
        if (isEmpty()) {
            front = node;
            back = node;
        } else {
            back.next = node;
            back = node;
        }
        return true;
    }
}
