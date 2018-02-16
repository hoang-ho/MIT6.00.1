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
public class Node<E> {
    
    E item;
    Node<E> next;
    
    public Node(E e) {
        this.item = e;
        this.next = null;
    }
    
}
