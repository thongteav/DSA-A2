/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deque;

import java.util.NoSuchElementException;

/**
 *
 * @author Thong Teav
 */
public interface DequeADT<E> {
    //adds one element to the rear of the queue
    public void enqueueRear(E element);
    //removes and returns the front element of the queue
    public E dequeueFront() throws NoSuchElementException;
    //returns without removing the front element of the queue
    public E first() throws NoSuchElementException;
    //adds one element to the front of the queue
    public void enqueueFront(E element);
    //removes and returns the rear element of the queue
    public E dequeueRear() throws NoSuchElementException;
    //returns without removing the rear element of the queue
    public E last() throws NoSuchElementException;
    //returns true if this queue contains no elements
    public boolean isEmpty();
    //returns the number of elements in the queue
    public int size();
}
