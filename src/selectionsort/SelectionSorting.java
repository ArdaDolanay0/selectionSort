/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectionsort;

import java.text.DecimalFormat;

/**
 * 
 * @author PluffyMechDuffens
 */
public class SelectionSorting {

    private static DecimalFormat formatter = new DecimalFormat("##.##########" + " sec");
    private int c;
    private double duration;
    private int[] nums;
    private double durationR;
/**Constructor
 *pre:none
 * post:sets the private variable nums to the parameter nums
 * 
 */    
    public SelectionSorting(int[] nums) {
        this.nums = nums;
    }
/**Instance Method
 * des: using Iterative selection sort sorts the nums array
 * pre:none
 * post:sorts an array and returns the sorted array
 * @return 
 */
    public int[] Isorting() {

        long startTime = System.nanoTime(); //sets a timer
        int min;
        for (int i = 0; i < nums.length; i++) { //runs a for loop from 0 to the nums array's length increasing +1 from every Iteration
            min = i;
            for (int j = i + 1; j < nums.length; j++) { //runs a for loop i+1 times where i is the corresponding integer in the first for loop until it reaches nums array's length, increasing by +1 every Iteration
                if (nums[j] < nums[min]) {  //compares the second loop integer j to the minimum value
                    min = j; //the index stored in min becomes j's index if j is smaller
                }
                c = nums.length * (i + 1); //records all the comparisons that occur
            }

            if (min != i) { //if minium number is not equal first loop's integer number
                int temp = nums[i]; //changes the places between the numbers so that smaller comes first
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }
        long endTime = System.nanoTime(); //stops timer
        duration = endTime - startTime; //records the duration
        return nums;
    }
    
    /**Instance Method
     * des: using Recursive selection sort sorts the nums array
     * pre:none
     * post: sorts an array and returns the sorted array
     * @param startingIndex
     * @return 
     */
    public int[] Rsorting(int startingIndex) {
     
        if (startingIndex == nums.length) { //when the starting index is equal to the array's length the array is returned
            return nums;
        }
        int minIndex = startingIndex; 

        for (int index = startingIndex + 1; index < nums.length; index++) { //runs a loop a where the loop iterative variable is +1 of startingindex and continues until it is equal to num.length-1 
            if (nums[index] < nums[minIndex]) { //compares the loop integer to the minimum value
                minIndex = index; //the value stored in min becomes index if min is smaller
            }
            c = nums.length * (startingIndex + 1); //records all the comparisons that occur
        }
        //if minium number is not equal first loop's integer number
        //changes the places between the numbers so that smaller comes first
        int temp = nums[startingIndex];  
        nums[startingIndex] = nums[minIndex]; 
        nums[minIndex] = temp;
        return Rsorting(startingIndex + 1); //recurs through the method until base condition is met
    }
    /**Instance Method
     * des:returns the formated duration variable 
     * pre:The user must have picked Iterative way for their sorting the nums array 
     * post: returns the variable duration, formated using Decimal format
     */
    public String Duration() {
        return formatter.format(duration / 1000000000);
    }
    /**Instance Method
     * des:
     * @param startingIndex
     * @return 
     */
    public String DurationR(int startingIndex) {
        long startTime = System.nanoTime();
        Rsorting(startingIndex);
        long endTime = System.nanoTime();
        return formatter.format((durationR = endTime - startTime) / 1000000000);
    }

    public int comparisons() {
        return c;
    }
}
