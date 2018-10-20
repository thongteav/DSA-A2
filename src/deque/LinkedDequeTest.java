/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deque;

import java.util.NoSuchElementException;

/**
 * Test class for deque with underlying nodes
 * 
 * @author Thong Teav
 */
public class LinkedDequeTest {
    public static void main(String[] args) {
        LinkedDeque<Integer> deque = new LinkedDeque<>();
        System.out.println(deque.toString());
        System.out.println("");
        
        try{
            System.out.println("Trying to dequeue an empty deque");
//            deque.dequeueFront();
            deque.dequeueRear();
        }
        catch (NoSuchElementException e){
            System.out.println(e.getMessage());
            System.out.println("");
        }
        
        System.out.println("Enqueue to the front: 5, 20, 11, 4, 9");
        deque.enqueueFront(5);
        deque.enqueueFront(20);
        deque.enqueueFront(11);
        deque.enqueueFront(4);
        deque.enqueueFront(9);
        System.out.println(deque.toString());
        System.out.println("Front: " + deque.first());
        System.out.println("Last: " + deque.last());
        System.out.println("");
        
        System.out.println("Dequeue from the rear: " + deque.dequeueRear());
        System.out.println("Dequeue from the rear: " + deque.dequeueRear());
        System.out.println(deque.toString());
        System.out.println("Front: " + deque.first());
        System.out.println("Last: " + deque.last());
        System.out.println("");
        
        System.out.println("Dequeue from the front: " + deque.dequeueFront());
        System.out.println("Dequeue from the front: " + deque.dequeueFront());
        System.out.println(deque.toString());        
        System.out.println("Front: " + deque.first());
        System.out.println("Last: " + deque.last());
        System.out.println("");
        
        System.out.println("Enqueue to the rear: 7, 1, 31, 14, 16");
        deque.enqueueRear(7);
        deque.enqueueRear(1);
        deque.enqueueRear(31);
        deque.enqueueRear(14);
        deque.enqueueRear(16);
        System.out.println(deque.toString());
        System.out.println("");
        
        System.out.println("Dequeue from the front: " + deque.dequeueFront());
        System.out.println(deque.toString());
        System.out.println("");
    }
}
