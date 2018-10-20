/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedSet;

/**
 * This is a sub class of LinkedSet and it puts the elements in a natural order.
 * 
 * @author Thong Teav
 */
public class LinkedRRSet<E extends Comparable<E>> extends LinkedSet<E> {    
    // adds the element to the set in a natural order provided that it
    // is not already in the set, and returns
    // true if the set did not already contain the element
    @Override
    public boolean add(E o) {
        Node<E> newNode = new Node<E>(o);
        //if the set is empty
        if (firstNode == null) {
            firstNode = newNode;//first node should points to the new node
        } else {
            Node<E> prev = null;
            Node<E> current = firstNode;
            //compare the node with other nodes in the set
            //should check if current node is null first so that it won't give nullpointer exception
            //as long as it's bigger than the current node's element
            while (current != null && o.compareTo(current.element) > 0) {
                prev = current;
                current = current.next;
            }

            if (current != null && o.compareTo(current.element) == 0) {
                return false; //if the element already exists, don't add and return false to indicate failure
            } 
            else if (prev == null){//if there's only 1 element in the linked set                
                newNode.next = current;//the current first node becomes the node after the new node
                firstNode = newNode;//the new node becomes the first node
            } 
            else 
            {//insert the new node between the previous node and current node
                prev.next = newNode;
                newNode.next = current;
            }
        }
        numElements++;//increase the element count
        return true;//indicate node succesfully added
    }
    
    /**
     * Retains elements within the range and removes and return elements outside the range.
     * 
     * @param start element as the beginning of the range, is inclusive
     * @param end element as the end of the range, is exclusive
     * @return the removed set of elements
     */
    public LinkedRRSet retain(E start, E end){
        LinkedRRSet<E> removedSet = new LinkedRRSet<>();//set for the removed elements

        if (firstNode == null || (start == null && end == null)) {
            return removedSet;//return empty set if the set is empty or if the set is retained
        } 
           
        Node<E> currentNode = firstNode, prevNode = null;
        //if the start is null or the start is lower than the first element but end is higher than the element
        if(start == null || (currentNode.element.compareTo(start) >= 0 && currentNode.element.compareTo(end) < 0)){
            while(currentNode != null && currentNode.element.compareTo(end) < 0) {
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
            removedSet.firstNode = currentNode; //remove everything after current node including itself
            prevNode.next = null;//remove reference
            return removedSet;//return the removed set
        }
        if(end == null){//if the end is null
            while(currentNode != null && currentNode.element.compareTo(start) < 0){//stop at the node equal or greater than start
                prevNode = currentNode;             
                currentNode = currentNode.next;
            }
            removedSet.firstNode = firstNode;//remove from the first node
            prevNode.next = null;//stop reference after the previous node
            firstNode = currentNode;//the current node is now the new first node
            return removedSet;//return the removed set
        }
        
        //if the range is outside our linked set scope
        if(currentNode.element.compareTo(start) > 0 && currentNode.element.compareTo(end) > 0){
            //delete everything
            removedSet.firstNode = this.firstNode;
            this.firstNode = null;
            return removedSet;
        }
        
        Node<E> breakNode = null;
        while(currentNode != null && currentNode.element.compareTo(end) < 0){
            if(currentNode.element.compareTo(start) < 0){
                breakNode = currentNode;//find the node before the retain set first node
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        if(breakNode.next == currentNode){//if the break node next is current node, meaning no element to keep between the range
            //remove everything
            removedSet.firstNode = this.firstNode;
            this.firstNode = null;
            return removedSet;
        }
        removedSet.firstNode = firstNode;//remove from the first node
        firstNode = breakNode.next;//retain set starts after the break node
        breakNode.next = currentNode;//connect the break node to current node which is the node after the retain set last node
        prevNode.next = null;//the last node of the retain set should point to nothing
        return removedSet;//return the removed set
    }
    
    /**
     * Removes and returns the elements within the range and retain the elements outside the range.
     * 
     * @param start element as the beginning of the range, is inclusive
     * @param end element as the end of the range, is exclusive
     * @return the removed set of elements
     */
     public LinkedRRSet remove(E start, E end){
        LinkedRRSet<E> removedSet = new LinkedRRSet<>();//set for the removed elements

        if (firstNode == null) {//if the set is empty
            return removedSet;//return an empty set
        }  
        
        if (start == null && end == null) {//if the start and end are null, then remove everything
            removedSet.firstNode = this.firstNode;//copy reference from first node to the removed set first node
            this.firstNode = null;//set first node to null
            return removedSet;
        }
        
        Node<E> currentNode = firstNode, prevNode = null;              
        //if the start is null or if start is lower than element in first node, then remove from the first node until the end element
        if(start == null || currentNode.element.compareTo(start) >= 0 && currentNode.element.compareTo(end) < 0){
            removedSet.firstNode = firstNode;//the first node is the first node of the removed set
            while(currentNode != null && currentNode.element.compareTo(end) < 0) {//loop until the end element
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
            firstNode = currentNode;//our retain set starts from the current node
            prevNode.next = null;//remove reference from the removed set last node
            return removedSet;//return the removed set
        }
        
        if(end == null){//if the end is null, so the end is open ended, remove from the start element until end of the set
            while(currentNode != null && currentNode.element.compareTo(start) < 0){//loop until the start element
                prevNode = currentNode;               
                currentNode = currentNode.next;
            }
            removedSet.firstNode = currentNode;//remove set first node is the start element or from the current node
            prevNode.next = null;//remove reference from the retain set last node
            return removedSet;
        }
        
        if(currentNode.element.compareTo(start) > 0 && currentNode.element.compareTo(end) > 0){//if the range is outside the scope of our linked set, just return the empty set
            return removedSet;
        }
        
        Node<E> breakNode = null;
        while(currentNode != null && currentNode.element.compareTo(end) < 0){
            if(currentNode.element.compareTo(start) < 0){//find the node where the retain set breaks
                breakNode = currentNode;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        if(breakNode.next == currentNode){//if the retain set break node's next node is the current node, meaning no elements to be removed
            return removedSet;//return the empty set
        }
        removedSet.firstNode = breakNode.next;//first node of removed set begins after where the retain set breaks
        breakNode.next = currentNode;//connect the retain set to the remaining nodes
        prevNode.next = null;//remove reference for the last node of removed set
        return removedSet;
    }
        
    public String toString(){
        String output = "[";
        
        Node<E> currentNode = firstNode;
        while(currentNode != null){
            output += currentNode.element;
            if(currentNode.next != null){
                output += ",";
            }
            currentNode = currentNode.next;
        }
        output += "]";
        return output;
    }
}
