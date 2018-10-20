/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deque;

import java.util.NoSuchElementException;

/**
 * This class maintains a deque using underlying array
 * @author Thong Teav
 */
public class ArrayDeque<E> implements DequeADT<E>{
    //variables-----------------------------------------------------------------
    private final int INITIAL_CAPACITY = 10;
    private E[] elements;
    private int numElements;
    private int front, rear;//front and rear represent the next available position in the array
    //--------------------------------------------------------------------------
    
    //constructor---------------------------------------------------------------
    public ArrayDeque(){
        numElements = 0;
        front = 0;
        rear = 0;
        elements = (E[]) (new Object[INITIAL_CAPACITY]);
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
        if (numElements >= elements.length){
            expandCapacity();//expand the array when it's full
        }
        
        if(isEmpty()){
            front = 0;
            rear = 0;
        }        
        
        elements[rear] = element;//put the element in the rear
        
        if(isEmpty()){//if the array is empty
            front = (front - 1 + elements.length) % elements.length;//update the next available front position
        }
        rear = (rear + 1) % elements.length;//update the next available rear position
        
        numElements++;//increase the element count
    }

    /**
     * Removes and returns the element at the front of the deque if it's not empty or throws an exception if it's empty
     * 
     * @return the element at the front
     * @throws NoSuchElementException 
     */
    @Override
    public E dequeueFront() throws NoSuchElementException{
        if (numElements > 0){//if the dequeue is not empty
            front = (front + 1) % elements.length;//get the position of the front element
            E frontElement = elements[front];//get the element at the front
            elements[front] = null;//remove the reference to the element
            numElements--;//decrease the element count
            return frontElement;//return the element at the front
        } 
        else {
            throw new NoSuchElementException();
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
        if (numElements > 0){//if the deque is not empty
            return elements[(front + 1) % elements.length];//return the elemnts in the front
        } 
        else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Inserts the element in the front of the deque
     * 
     * @param element a specified element to be inserted
     */
    @Override
    public void enqueueFront(E element) {
        if (numElements >= elements.length){
            expandCapacity();//expand the capicity if the array is full
        }
        
        if(isEmpty()){
            front = 0;
            rear = 0;
        }    
        
        elements[front] = element;//insert the element
        if(isEmpty()){//if the array is empty
            rear = (rear + 1) % elements.length;//update the rear position
        }
        front = (front - 1 + elements.length) % elements.length;//update the next available front position
        numElements++;//increase the element count
    }

    /**
     * Removes and returns the element at the front of the deque
     * 
     * @return element at the rear of the deque
     * @throws NoSuchElementException 
     */
    @Override
    public E dequeueRear() throws NoSuchElementException{
        if (numElements > 0) {//if the deque is not empty
            rear = (rear - 1 + elements.length) % elements.length;//get the position of the rear element
            E rearElement = elements[rear];//get the rear element
            elements[rear] = null;//remove the element from the array            
            numElements--;//decrease the element count
            return rearElement;//return the element at the rear
        } 
        else {
            throw new NoSuchElementException();
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
        if (numElements > 0) {//if deque is not emepty
            return elements[(rear - 1 + elements.length) % elements.length];//return the rear element
        } 
        else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Checks if the deque is empty.
     * 
     * @return true if deque is empty and false if otherwise
     */
    @Override
    public boolean isEmpty() {
        return numElements == 0;
    }

    /**
     * Returns the number of elements in the deque.
     * 
     * @return an integer representing the number of the elements
     */
    @Override
    public int size() {
        return numElements;
    } 
    
    /**
     * Expands the capacity of the array by creating a larger array and copies the elements over to the new array
     */ 
    private void expandCapacity(){
        E[] largerArray = (E[]) (new Object[numElements * 2]);//create a new and larger array
        System.out.println("Expanding the array...");
        
        for(int i = 0; i < numElements; ++i){//copy the elements to the new array
            front = (front + 1) % elements.length;
            largerArray[i] = elements[front];
        }
        elements = largerArray;//update the array to larger array
        front = largerArray.length - 1;//the next available front position
        rear = numElements;//the next available rear position
    }
    
    public String toString(){
        String output = "[";
        for(int i = 0; i < elements.length; ++i){
            output += elements[i];
            output += (i < elements.length - 1) ? "," : "";
        }
        output += "]";
        return output;
    }
}
