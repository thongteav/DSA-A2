/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deque;

import java.util.NoSuchElementException;

/**
 * This class maintains a deque using underlying nodes
 * 
 * @author Thong Teav
 */
public class LinkedDeque<E> implements DequeADT<E>{
    //variables-----------------------------------------------------------------
    private int numElements;
    private Node<E> frontNode;
    private Node<E> rearNode;
    //--------------------------------------------------------------------------
    
    //constructor---------------------------------------------------------------
    public LinkedDeque(){
        numElements = 0;
        frontNode = null;
        rearNode = null;
    }
    //--------------------------------------------------------------------------
    
    //helper methods------------------------------------------------------------
    /**
     * Inserts an element in the rear of the deque
     * 
     * @param element a specified element to be inserted
     */
    @Override
    public void enqueueRear(E element) {
        Node<E> newNode = new Node<E>(element);//create a new node using the specified element
        if(rearNode == null){//if the deque is empty
            frontNode = newNode;//the new node is the front of deque
            rearNode = newNode;//it's also the rear of the deque
        }
        else {//if the deque is not empty
            rearNode.next = newNode;//put the new node after the rear of the deque
            newNode.previous = rearNode;//rear node is one before the new node
            rearNode = newNode;//the new node becomes the rear of the deque
        }
        numElements++;//increase the element count
    }

    /**
     * Removes and returns the element at the front of the deque if it's not empty or throws an exception if it's empty
     * 
     * @return element at the front of the deque
     * @throws NoSuchElementException 
     */
    @Override
    public E dequeueFront() throws NoSuchElementException{
        if(frontNode != null){//if the deque is not empty
            E frontElement = frontNode.element;//reference to front element for later use
            frontNode = frontNode.next;//the 2nd node from the front is now at the front
            if(frontNode != null){//check if the new front node isn't null to prevent null pointer exception
                frontNode.previous = null;//remove reference the previous front node
            }
            numElements--;//decrease the element count
            if (numElements == 0){//if the deque is empty after removal
                rearNode = null;
                frontNode = null;
            }
            return frontElement;//return the element at the front before the dequeue
        }
        else {//if the deque is empty
            throw new NoSuchElementException("Can't dequeue front on an empty deque");
        }
    }

    /**
     * Returns the element in the front of the deque without removing it
     * 
     * @return the element at the front
     * @throws NoSuchElementException 
     */
    @Override
    public E first() throws NoSuchElementException{
       if(frontNode != null){//if the deque is not empty
           return frontNode.element;//return the element in the front
       }
       else {//if the deque is empty
           throw new NoSuchElementException("The deque is empty");
       }
    }

    /**
     * Inserts the element in the front of the deque
     * 
     * @param element a specified element to be inserted
     */
    @Override
    public void enqueueFront(E element) {
        Node<E> newNode = new Node<E>(element);//create a new node
        if(frontNode == null){//if the deque is emtpy
            frontNode = newNode;//the new node is the front node
            rearNode = newNode;//it's also the rear node
        }
        else {//if the deque is not empty
            newNode.next = frontNode;//put the front node after the new node
            frontNode.previous = newNode;//the new node is in front of the current front node
            frontNode = newNode;//the new node becomes the new front node
        }
        numElements++;//increase the element count
    }

    /**
     * Removes and returns the element at the rear of the deque
     * 
     * @return element at the rear of the deque
     * @throws NoSuchElementException 
     */
    @Override
    public E dequeueRear() throws NoSuchElementException{
        if(rearNode != null){//if the deque is not empty
            E rearElement = rearNode.element;//reference to the element at the rear
            rearNode = rearNode.previous;//the new rear node is the node before the current rear node
            if(rearNode != null){//check if the new rear node isn't null
                rearNode.next = null;//removes reference to the old rear node
            }
            numElements--;//decrease the element count
            if (numElements == 0){//if the deque is empty
                rearNode = null;
                frontNode = null;
            }
            return rearElement;//return the element that was removed
        }
        else {//if the deque is empty
            throw new NoSuchElementException("Can't dequeue rear on an empty deque");
        }
    }

    /**
     * Returns the element at the rear of the deque without removing it
     * 
     * @return element at the rear of the deque
     * @throws NoSuchElementException 
     */
    @Override
    public E last() throws NoSuchElementException{
        if(rearNode != null){//if the deque is not empty
            return rearNode.element;//if the element at the rear
        }
        else {//if the deque is empty
            throw new NoSuchElementException();
        }
    }

    /**
     * Checks if the deque is empty
     * 
     * @return true if deque is empty and false if otherwise
     */
    @Override
    public boolean isEmpty() {
        return numElements == 0;
    }

    /**
     * Returns the number of elements in the deque
     * 
     * @return an integer representing the number of elements
     */
    @Override
    public int size() {
        return numElements;
    }
    //--------------------------------------------------------------------------
    
    //toString method-----------------------------------------------------------
    @Override
    public String toString(){
        String output = "[";
        Node currentNode = frontNode;
        while (currentNode != null){
            output += currentNode.element;
            output += (currentNode.next != null) ? "," : "";
            currentNode = currentNode.next;
        }
        output += "]";
        return output;
    }
    //--------------------------------------------------------------------------
    
    //private class-------------------------------------------------------------
    /**
     * A private class maintaining the node and references the nodes before and after it
     * 
     * @param <E> 
     */
    private class Node<E> {
        public E element;
        public Node<E> next;
        public Node<E> previous;
        
        public Node(E element){
            this.element = element;
            next = null;
            previous = null;
        }
    }
    //--------------------------------------------------------------------------
}
