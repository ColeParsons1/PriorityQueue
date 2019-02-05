/**
 * Program:The PriorityQueue(heap) class 
 * @author David Parsons
 * Date-10/26/17
 * Professor: D. Jugan
 * Summary:Adds or removes customers depending on which method is called.References the customer object
 * and compares the priority to correctly modify the heap.
 *
 */
public class PriorityQueue {
	
	private PriorityCustomer[] heap;  //field for customer object
	   private int size;
	  
	   
	   public PriorityQueue () {
	      heap = new PriorityCustomer[50]; //the customer object
	      size = 0;  //the size
	      
	   }
	   //
	  
	   
	   public int getSize () {
	      return size;
	   }
	   
	   
	   
	   public void add (PriorityCustomer c) {
	      
	      //condition for a full heap
	      if (size + 2 > heap.length) {
	         System.out.println ("The heap is full");
	         return;
	      }
	      
	      
	      
	      //increment size by 1
	      size ++;
	      
	      //add new object to the next open position in the heap
	      heap [size] = c;
	      
	      //create a variable to keep track of where our object is in the heap
	      int index = size;
	      
	      //continue to compare the object to it's parents until it reaches the root
	      while (index > 1) {
	      
	         // parent index
	         int parentIndex = index / 2;
	      
	         //compare object to  parent 
	         if (( heap[index]).getPriority () > heap[parentIndex].getPriority()) {
	         
	            //swap objects
	        	 PriorityCustomer temp = heap[index];
	            heap[index] = heap[parentIndex];
	            heap[parentIndex] = temp;
	            
	            
	            index = parentIndex;
	         } else {
	            //parent value is larger...no swap needed...break out
	            break;
	         }
	      }   
	   }
	   
	   public PriorityCustomer remove () {
	      
	      //if heap is empty
	      if (size == 0) {
	         System.out.println ("The heap is already empty");
	         return null;
	      }
	      
	      //store temporary reference to root object
	      PriorityCustomer temp = heap [1];
	      
	      //move object in the last position to the root
	      heap [1] = heap [size];
	      heap [size] = null;
	      size--;
	      
	      
	      //store the index of the object moved to the root
	      int index = 1;
	      
	      // compare index 
	      while (index <= size / 2) {
	      
	         //store index and values 
	         int leftChildIndex = index * 2;
	         int rightChildIndex = leftChildIndex + 1;
	         
	         int leftChildValue = heap [leftChildIndex].getPriority ();
	         int rightChildValue = Integer.MIN_VALUE;
	         
	         //is there a right child
	         if (rightChildIndex <= size) {
	            rightChildValue = heap [rightChildIndex].getPriority ();
	         }
	         
	         //determine the largest 
	         int largerValue;
	         int largerIndex;
	         
	         if (rightChildValue > leftChildValue) {
	            largerValue = rightChildValue;
	            largerIndex = rightChildIndex;
	         } else {
	            largerValue = leftChildValue;
	            largerIndex = leftChildIndex;
	         }
	         
	         //determine if a swap should be made with the parent and the larger child
	         if (heap[index].getPriority () < largerValue) {
	         
	            //swap
	        	 PriorityCustomer swap = heap [index];
	            heap [index] = heap [largerIndex];
	            heap [largerIndex] = swap;
	            
	            //update index
	            index = largerIndex;
	         } else {
	            
	            break;
	         }
	         
	      }
	      
	      //return root
	      return temp;
	      
	   }


	}
