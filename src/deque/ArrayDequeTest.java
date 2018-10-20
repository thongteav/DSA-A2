/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deque;

/**
 * Test class for deque using underlying array
 * @author Thong Teav
 */
public class ArrayDequeTest {
  
    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        System.out.println("Empty deque...");
        System.out.println(deque.toString());
        System.out.println("");
        
        System.out.println("Enqueue to the rear: 5, 6, 2, 7, 10");
        System.out.println("Insert 5");
        deque.enqueueRear(5);
        System.out.println("Front: " + deque.first());
        System.out.println("Last: " + deque.last());
        System.out.println("Insert 6");
        deque.enqueueRear(6);
        System.out.println("Insert 2");
        deque.enqueueRear(2);
        System.out.println("Insert 7");
        deque.enqueueRear(7);
        System.out.println("Insert 10");
        deque.enqueueRear(10);
        System.out.println(deque.toString());
        System.out.println("");
        
        System.out.println("Dequeue from the front: " + deque.dequeueFront());
        System.out.println(deque.toString());
        System.out.println("Dequeue from the front: " + deque.dequeueFront());
        System.out.println(deque.toString());    
        System.out.println("Dequeue from the front: " + deque.dequeueFront());
        System.out.println(deque.toString());   
        System.out.println("Front: " + deque.first());
        System.out.println("Last: " + deque.last());
        System.out.println("");
        
        System.out.println("Dequeue from the front: " + deque.dequeueFront());
        System.out.println(deque.toString());
        System.out.println("Dequeue from the front: " + deque.dequeueFront());
        System.out.println(deque.toString()); 
        
        System.out.println("Enqueue to the front: 3, 4, 1, 15");
        System.out.println("Insert 3");
        deque.enqueueFront(3);
        System.out.println("Front: " + deque.first());
        System.out.println("Last: " + deque.last());
        System.out.println("Insert 4");
        deque.enqueueFront(4);
        System.out.println("Insert 1");
        deque.enqueueFront(1);
        System.out.println("Insert 15");
        deque.enqueueFront(15);
        System.out.println(deque.toString());
        System.out.println("");
        
        System.out.println("Front: " + deque.first());
        System.out.println("Last: " + deque.last());
        System.out.println("");
        
        System.out.println("Enqueue to the rear: 22, 12, 40, 60, 55, 99, 123, 44");
        System.out.println("Insert 22");
        deque.enqueueRear(22);
        System.out.println("Insert 12");
        deque.enqueueRear(12);
        System.out.println("Insert 40");
        deque.enqueueRear(40);
        System.out.println("Insert 60");
        deque.enqueueRear(60);
        System.out.println("Insert 55");
        deque.enqueueRear(55);
        System.out.println("Insert 99");
        deque.enqueueRear(99);
        System.out.println("Insert 123");
        deque.enqueueRear(123);
        System.out.println("Insert 44");
        deque.enqueueRear(44);
        System.out.println(deque.toString());
        System.out.println("");
        
        System.out.println("Front: " + deque.first());
        System.out.println("Last: " + deque.last());
        System.out.println("");        
    }    
}
