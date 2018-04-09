/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package londonallismergesort;

/**
 *
 * @author allis
 */
/*********************************************************
*** Class Name: MergeSort2Way*****************************
*** Class Author: Allistair London************************
**********************************************************
*** This class sorts a given array by utilization of the *
* merge sort algorithm ***********************************
*** Date:  4/06/2018**************************************
* i got some help from stackoverflow.com and *************
* geeksforgeeks.org **************************************
*********************************************************/
public class MergeSort2Way {
    
    /******************************************************************
    **Method Name: mergeSort()*****************************************
    **Method Author: Allistair London**********************************
    *******************************************************************
    **Purpose of the Method: A given array is sorted using the ********
    * merge sort algorithm. *******************************************
    **Method Inputs: Integer [] nArray, IntWrapper compares, **********
    * IntWrapper swaps*************************************************
    **Date 04/08/2018**************************************************
     * @param nArray
     * @param compares
     * @param swaps
    ******************************************************************/
    public static void mergeSort(Integer [] nArray, IntWrapper compares, IntWrapper swaps)
    {
        if(nArray.length > 1)
        {
            //The arrays are splitted into two halves
            Integer[] lArray = leftSide(nArray);
            Integer[] rArray = rightSide(nArray);
            
            //recursively sorts the two arrays
            mergeSort(lArray, compares, swaps);
            mergeSort(rArray, compares, swaps);
            
            //merges the two sorted arrays (lArray, rArray) into
            //one sorted list
            merge(nArray, lArray, rArray, compares, swaps);
        }
    }
    /******************************************************************
    **Method Name: Integer[] leftSide()********************************
    **Method Author: Allistair London**********************************
    *******************************************************************
    **Purpose of the Method: is to return the left half of the array **
    **Method Inputs: Integer [] nArray ********************************
    **Date 04/08/2018**************************************************
     * @param nArray
     * @return 
    ******************************************************************/
    public static Integer[] leftSide (Integer[] nArray)
    {
        //divides the array into two and assign
        //to variable.
        int lSize = nArray.length / 2;
        Integer[]lArray = new Integer[lSize];
        System.arraycopy(nArray, 0, lArray, 0, lSize);
        return lArray; //returns the left side of array (lArray)
    }
    /******************************************************************
    **Method Name: Integer[] rightSideSide()***************************
    **Method Author: Allistair London**********************************
    *******************************************************************
    **Purpose of the Method: is to return the right half of the array *
    **Method Inputs: Integer [] nArray ********************************
    **Date 04/08/2018**************************************************
     * @param nArray
     * @return 
    ******************************************************************/
    public static Integer[] rightSide(Integer[] nArray)
    {
        //splits the nArray into two and assign to variable
        //representing the left and right sides
        int lSize = nArray.length / 2;
        int rSide = nArray.length - lSize;
        Integer[] rArray = new Integer[rSide];
        for(int i = 0; i < rSide; i++)
        {
            rArray[i] = nArray[i + lSize];
        }
        return rArray; //retruns the right half of array (rArray)
    }
    /******************************************************************
    **Method Name: merge()*********************************************
    **Method Author: Allistair London**********************************
    *******************************************************************
    **Purpose of the Method: This method merges the left and right ****
    * arrays into one completely sorted arran. ************************
    *Method Inputs: Integer[] sequence, Integer[] left, ****************
    *Integer[]right, IntWrapper compares, IntWrapper swaps ***********
    *Date 04/08/2018**************************************************
     * @param sequence
     * @param left
     * @param right
     * @param compares
     * @param swaps
    ******************************************************************/
    public static void merge(Integer[] sequence, Integer[] left, Integer[]right, IntWrapper compares, IntWrapper swaps)
    {
        int leftIndex = 0; //left array (lArray) index
        int rightIndex = 0; //right array (rArray) index.
        
        for(int i = 0; i < sequence.length; i++)
        {
            //accumulate comparisons
            compares.val++;
            
            if(rightIndex >= right.length || (leftIndex < left.length && left[leftIndex] <= right[rightIndex]))
            {
                sequence[i] = left[leftIndex];
                leftIndex++;
                //accumulates amount of swaps
                swaps.val++;
            }
            else
            {
                sequence[i] = right[rightIndex];
                rightIndex++;
                //accumulates amount of swaps
                swaps.val++;
            }
        }
    }
    
    
}
