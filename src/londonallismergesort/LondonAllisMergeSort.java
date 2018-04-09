/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package londonallismergesort;

import java.util.Random;

/**
 *
 * @author allis
 */
 /*********************************************************
 *** Class Name: LondonAlliMergeSort *********************
 *** Class Author: Allistair London************************
 **********************************************************
 *** This class is used to fill the given array with ******
 *** random numbers. Also used to call the required *******
 *** functions from the supporting classes. ***************
 *** Date:  4/06/2018**************************************
 *** I got some help from stackoverflow.com and ***********
 *** geeksforgeeks.org ************************************
 *** classmate Angelica Jones suggested the code to *******
 *** document the elapsed time in nanoseconds *************
 *********************************************************/
public class LondonAllisMergeSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //
        //
        //an instance of the class IntWrapper is declared
        IntWrapper cCompare = new IntWrapper();
        //an instance of the class IntWrapper is declared
        IntWrapper cSwap = new IntWrapper();
        //
        long start = System.currentTimeMillis();
        //an instance of the class Random() is declared
        Random rnd = new Random();
        //an array is declared with size of 1000 elements
        Integer[] compose = new Integer[1000];
        //for loop is used to populate the array
        //with randomly generated numbers
        for(int i = 0; i < compose.length; i++)
        {
            compose[i] = rnd.nextInt();
        }
        //random array of elements are printed
        System.out.println("Unsorted Random Numbers :");

        for(int i = 0; i < compose.length; i++)
        {
            //ensures a max of 10 numbers are assigned to a line
            System.out.print(" " + compose[i]);
            if(i % 10 == 0)
                System.out.print("\n\n");
        }
        //mergeSort() from the MergeSort2Way class is called
        MergeSort2Way.mergeSort(compose, cCompare, cSwap);
        
        System.out.println("\n\n");
        
        System.out.println("After MergeSort :");
        //this for loop is used to print out the
        //elements of the sorted array
        for(int i = 0; i < compose.length; i++)
        {
            System.out.print(" " + compose[i]);
            if(i % 10 != 0) {
            } else {
                System.out.print("\n\n");
            }
        }
        
        //Inserts a blank line
        System.out.println("\n");
        //
        long end1 = System.currentTimeMillis();
        long totalTime1 = end1 -start;
        //prints the accumulated number of comparisons.
        System.out.println("Compares :" + cCompare.val);
        //prints the accumulatd number of swaps
        System.out.println("Swaps :" + cSwap.val);
        //prints the total time taken to run the sort.
        //time is measured in nanoseconds
        System.out.println("The total time taken was :" + totalTime1 + " nanoseconds");
        //inserts two blank lines
        System.out.println("\n\n");
        
        //calls the mergeSort() from the MergeSort class
        MergeSort.mergeSort(compose, cCompare, cSwap);
        //
        System.out.println("After MergeSort 3-Way :");
        //for loop used to print the elements of
        //the 3-Way variant of merge sort algorithm
        for(int i = 0; i < compose.length; i++)
        {
            System.out.print(" " + compose[i]);
            if(i % 10 != 0) {
            } else {
                System.out.print("\n\n");
            }
        }
        //print blank line
        System.out.println("\n");
        //
        long end = System.currentTimeMillis();
        long totalTime = end -start;
        //accumulated number of compares are printed.
        System.out.println("Compares :" + cCompare.val);
        //accumulated number of swaps are printed
        System.out.println("Swaps :" + cSwap.val);
        //total time taken to complete the sort is displayed
        //time is displayed in nano seconds
        System.out.println("The total time taken was :" + totalTime + " nanoseconds");
    }
    
}
