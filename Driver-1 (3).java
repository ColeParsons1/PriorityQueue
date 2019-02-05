/**Program:Driver for the PriorityQueue
 * @author David Parsons
 * Professor: D. Jugan
 * Date-10/26/17
 * Summary:Inside of a for loop, random instance is created for determining if adding to the heap.
 * If added, the new line length is displayed and total customers serviced is displayed at the end 
 * of the simulation.
 * 
 * 
 */

import java.util.Random;// import random

public class Driver { //driver class

	public static void main(String[] args) { //main method
		
		int count=0;		//to count length of line
		int removeCount=0;		//to count how many customers are serviced
		int CurrentHighest=0; //to store the longest length of the line
		
		
		
		
		
		
		PriorityQueue line = new PriorityQueue (); //create instance of linked list class
		
		for(int i=0;i<60;i++) { //for loop for iterations
			System.out.println("-------------------------------------------");  //display passing of time
			
			Random number = new Random(); //random class
			
			int newbie=1+number.nextInt(3);  //create random number
			
			
			
			
			if(newbie==2) { //condition for random equaling 2
				
				
				if(count>=CurrentHighest) { //condition for highest number(line length)
					
					CurrentHighest=count; //set current highest
				}
				
				count++;  //increment by 1
				line.add(new PriorityCustomer()); //add new customer
				
				System.out.println("New Customer added, queue length is now"+" "+count);  //display when added
				
				
				
				
				
			}
				
				
				if(count==0) {  //condition for empty line
					
					count++;  //increment by 1
					line.add(new PriorityCustomer()); //add new customer
					System.out.println("New Customer added, queue length is now"+" "+count);  //display
					
					
					
					
				}
			    
			    
				
				int dq=1+number.nextInt(5); //random instance for removing from line(servicing)
				if(dq==2) {  //condition for if it is 2
					removeCount++; //increment by 1
					count--;  //decrement by 1    
					
					//display number id and remove customer from line
					System.out.println("Customer"+" "+line.remove()+" "+"has been serviced, queue length now"+" "+count);
					
					
					
				
				
				
				
				
				
				
				
							
			}
			
			
			
			
		}
		
		System.out.println("Total customers serviced:"+" "+removeCount); //display total customers serviced(removed from line)
		System.out.println("Max Line length:"+" "+(CurrentHighest+1));  //display longest line length
		
		
		
			
		}//end main method
		
		
			
			
		
	}//end class