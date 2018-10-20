/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedSet;

/**
 * 
 * @author Thong Teav
 */
public class LinkedRRSetTest {
    public static void main(String[] args){
        LinkedRRSet<Integer> sortedLinkedSet = new LinkedRRSet<>();
        System.out.println(">>>>>>>>>>>>>>>>Testing RETAIN<<<<<<<<<<<<<<<<<<<");
        System.out.println("Adding integers: 5, 2, 8, 12, 15, 7, 6, 1, 4, 9 , 11, 17, 14");
        sortedLinkedSet.add(5);
        sortedLinkedSet.add(2);
        sortedLinkedSet.add(8);
        sortedLinkedSet.add(12);
        sortedLinkedSet.add(15);
        sortedLinkedSet.add(7);
        sortedLinkedSet.add(6);
        sortedLinkedSet.add(1);
        sortedLinkedSet.add(4);
        sortedLinkedSet.add(9);
        sortedLinkedSet.add(11);
        sortedLinkedSet.add(17);
        sortedLinkedSet.add(14);
        System.out.println(sortedLinkedSet);
        System.out.println("");
        
        /***********************************************************************
        Testing retain method
        ***********************************************************************/        
        System.out.println("Retain from null to null (Retain all)");
        System.out.println("Removed set: " + sortedLinkedSet.retain(null, null));
        System.out.println(sortedLinkedSet);
        System.out.println("");       
        
        System.out.println("Retain from 2(inclusive) to 15(exclusive)");
        System.out.println("Removed set: " + sortedLinkedSet.retain(2, 15));
        System.out.println(sortedLinkedSet);
        System.out.println("");
        
        System.out.println("Retain from null to 12(exclusive)");
        System.out.println("Removed set: " + sortedLinkedSet.retain(null, 12));
        System.out.println(sortedLinkedSet);
        System.out.println("");
        
        System.out.println("Retain from 4(inclusive) to null");
        System.out.println("Removed set: " + sortedLinkedSet.retain(4, null));
        System.out.println(sortedLinkedSet);
        System.out.println("");
        
        System.out.println("Retain from 1(inclusive) to 9(exclusive)");
        System.out.println("Removed set: " + sortedLinkedSet.retain(1, 9));
        System.out.println(sortedLinkedSet);
        System.out.println("");
        
        System.out.println("Retain from 5(inclusive) to 20(exclusive)");
        System.out.println("Removed set: " + sortedLinkedSet.retain(5, 20));
        System.out.println(sortedLinkedSet);
        System.out.println("");
        
        System.out.println("Retain from 1(inclusive) to 10(exclusive) (Should retain everything)");
        System.out.println("Removed set: " + sortedLinkedSet.retain(1, 10));
        System.out.println(sortedLinkedSet);
        System.out.println("");
        
        System.out.println("Adding an integer: 13");
        sortedLinkedSet.add(13);
        System.out.println(sortedLinkedSet);
        System.out.println("");
        
        System.out.println("Retain from 10 to 12 (Should remove all)");
        System.out.println("Removed set: " + sortedLinkedSet.retain(10, 12));
        System.out.println(sortedLinkedSet);
        System.out.println("");       
        
        System.out.println("Adding integers: 5, 2, 8, 12");
        sortedLinkedSet.add(5);
        sortedLinkedSet.add(2);
        sortedLinkedSet.add(8);
        sortedLinkedSet.add(12);
        System.out.println(sortedLinkedSet);
        System.out.println("");
        
        System.out.println("Retain from 15 to 25 (Should remove everything)");
        System.out.println("Removed set: " + sortedLinkedSet.retain(15, 25));
        System.out.println(sortedLinkedSet);
        System.out.println("");
        
        System.out.println(">>>>>>>>>>>>>>>>Testing REMOVE<<<<<<<<<<<<<<<<<<<");
        System.out.println("Adding integers: 5, 2, 8, 12, 15, 7, 6, 1, 4, 9 , 11, 17, 14");
        sortedLinkedSet.add(5);
        sortedLinkedSet.add(2);
        sortedLinkedSet.add(8);
        sortedLinkedSet.add(12);
        sortedLinkedSet.add(15);
        sortedLinkedSet.add(7);
        sortedLinkedSet.add(6);
        sortedLinkedSet.add(1);
        sortedLinkedSet.add(4);
        sortedLinkedSet.add(9);
        sortedLinkedSet.add(11);
        sortedLinkedSet.add(17);
        sortedLinkedSet.add(14);
        System.out.println(sortedLinkedSet);
        System.out.println("");
        
        /***********************************************************************
        Testing remove method
        ***********************************************************************/        
        System.out.println("Remove from 19 to 25 (Should retain everything)");
        System.out.println("Removed set: " + sortedLinkedSet.remove(-1, 0));
        System.out.println(sortedLinkedSet);
        System.out.println("");
        
        System.out.println("Remove from 7(inclusive) to 9(exclusive)");
        System.out.println("Removed set: " + sortedLinkedSet.remove(7, 9));
        System.out.println(sortedLinkedSet);
        System.out.println("");
        
        System.out.println("Remove from null to 4(exclusive)");
        System.out.println("Removed set: " + sortedLinkedSet.remove(null, 4));
        System.out.println(sortedLinkedSet);
        System.out.println("");
        
        System.out.println("Remove from 15(inclusive) to null");
        System.out.println("Removed set: " + sortedLinkedSet.remove(15, null));
        System.out.println(sortedLinkedSet);
        System.out.println("");
        
        System.out.println("Remove from 1(inclusive) to 5(exclusive)");
        System.out.println("Removed set: " + sortedLinkedSet.remove(1, 5));
        System.out.println(sortedLinkedSet);
        System.out.println("");
        
        System.out.println("Remove from 12(inclusive) to 20(exclusive)");
        System.out.println("Removed set: " + sortedLinkedSet.remove(12, 20));
        System.out.println(sortedLinkedSet);
        System.out.println("");
        
        System.out.println("Remove from 7(inclusive) to 8(exclusive) (Should retain everything)");
        System.out.println("Removed set: " + sortedLinkedSet.remove(7, 8));
        System.out.println(sortedLinkedSet);
        System.out.println("");        
        
        System.out.println("Remove from null to null (Remove all)");
        System.out.println("Removed set: " + sortedLinkedSet.remove(null, null));
        System.out.println(sortedLinkedSet);
        System.out.println("");
    }
}
