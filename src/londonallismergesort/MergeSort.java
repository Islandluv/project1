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
*** Class Name: MergeSort ********************************
*** Class Author: Allistair London************************
**********************************************************
*** This class sorts a given array by utilization of******
*** of a variant of the merge sort algorithm *************
*** Instead of dividing the array into 2, it is split ***
*** into 3 parts ****************************************
*** Date:  4/06/2018**************************************
*** I got some help from stackoverflow.com and ***********
*** geeksforgeeks.org ************************************
*********************************************************/
public class MergeSort {
    
    /******************************************************************
    **Method Name: mergeSort()*****************************************
    **Method Author: Allistair London**********************************
    *******************************************************************
    **Purpose of the Method: A given array is sorted using a variant **
    **of the mergesort. (3-way) ***************************************
    **Method Inputs: Integer [] nArray, IntWrapper compares, **********
    * IntWrapper swaps*************************************************
    **Date 04/08/2018**************************************************
     * @param nArray
     * @param compares
     * @param swaps
    ******************************************************************/
    public static void mergeSort(Integer[] nArray, IntWrapper compares, IntWrapper swaps)
    {
        //Check if array is empty
        if(nArray == null)
        {
            return;
        }
        
        //creates a duplicate of array
        Integer[] iArray = new Integer[nArray.length];
        
        //uses a loop to copy elements into array
        System.arraycopy(nArray, 0, iArray, 0, iArray.length);
        
        //this method (mergeSortRec()) is called to sort array
        mergeSortRec(iArray, 0, nArray.length, nArray, compares, swaps);
        
        //a system loop is used to return elements to original array
        System.arraycopy(iArray, 0, nArray, 0, iArray.length);
    }
    /******************************************************************
    **Method Name: mergeSortRec()**************************************
    **Method Author: Allistair London**********************************
    *******************************************************************
    **Purpose of the Method: this recursive method is summoned by *****
    **mergeSort() method. THis method completes the actual sorting ***
    **Method Inputs: Integer[] nArray, int lowValue, int highValue, ***
    **Integer[] dArray, IntWrapper compares, IntWrapper swaps *********
    **Date 04/08/2018**************************************************
     * @param nArray
     * @param lowValue
     * @param highValue
     * @param dArray
     * @param compares
     * @param swaps
    ******************************************************************/
    public static void mergeSortRec(Integer[] nArray, int lowValue, int highValue, Integer[] dArray, IntWrapper compares, IntWrapper swaps)
    {
        //check if array only have one element.
        //if one element then nothing is done
        if(highValue - lowValue < 2)
            return;
        
        //array is split into three parts
        int middleOne = lowValue + ((highValue - lowValue) /3);
        int middleTwo = lowValue + 2 * ((highValue - lowValue) / 3) + 1;
        
        //three sub-arrays are recursively sorted.
        mergeSortRec(dArray, lowValue, middleOne, nArray, compares, swaps);
        mergeSortRec(dArray, middleOne, middleTwo, nArray, compares, swaps);
        mergeSortRec(dArray, middleTwo, highValue, nArray, compares, swaps);
        
        //the sorted sub-array are merged
        merge(dArray, lowValue, middleOne, middleTwo, highValue, nArray, compares, swaps);
        
    }
    
    /******************************************************************
    **Method Name: merge()********************************************
    **Method Author: Allistair London**********************************
    *******************************************************************
    **Purpose of the Method: this recursive method is summoned by *****
    **mergeSort() method. THis method completes the actual sorting ***
    **Method Inputs: Integer[] nArray, int lowValue, int highValue, ***
    **Integer[] dArray, IntWrapper compares, IntWrapper swaps *********
    **Date 04/08/2018**************************************************
     * @param nArray
     * @param lVal
     * @param middleOne
     * @param middleTwo
     * @param hVal
     * @param dArray
     * @param compares
     * @param swaps
    ******************************************************************/
    public static void merge(Integer[] nArray, int lVal, int middleOne, int middleTwo, int hVal, Integer[] dArray, IntWrapper compares, IntWrapper swaps)
    {
        int alpha = lVal, bravo = middleOne, charlie = middleTwo, delta = lVal;
        
        //the smallest of the smaller range is identified
        while ((alpha < middleOne) && (bravo < middleTwo) && (charlie < hVal))
        {
            //accumulates the comparisons
            compares.val++;
            
            if  (nArray[alpha].compareTo(nArray[bravo]) < 0)
            {
                if (nArray[alpha].compareTo(nArray[charlie]) < 0)
                {
                    dArray[delta++] = nArray[alpha++];
                    //accumulates the amount of swaps
                    swaps.val++;
                }
                else
                    dArray[delta++] = nArray[charlie++];
            }
            else
            {
                if (nArray[bravo].compareTo(nArray[charlie]) < 0)
                {
                    dArray[delta++] = nArray[bravo++];
                    swaps.val++;
                }
                else
                    dArray[delta++] = nArray[charlie++];
            }
        }
        //
        //If ist and 2nd ranges have remaining values
        while((alpha < middleOne) && (bravo < middleTwo))
        {
            if (nArray[alpha].compareTo(nArray[bravo]) < 0)
            {
                dArray[delta++] = nArray[alpha++];
                swaps.val++;
            }
                
            else
                dArray[delta++] = nArray[bravo++];
        }
        //if 2nd and 3rd ranges have remaining values
        while((bravo < middleTwo) && (charlie < hVal))
        {
            if(nArray[bravo].compareTo(nArray[charlie]) < 0)
            {
                dArray[delta++] = nArray[bravo++];
                swaps.val++;
            }
            else
                dArray[delta++] = nArray[charlie++];
        }
        //if 1st and 3rd ranges have remaining values
        while((alpha < middleOne) && (charlie < hVal))
        {
            if(nArray[alpha].compareTo(nArray[charlie]) < 0)
            {
                dArray[delta++] = nArray[alpha++];
                swaps.val++;
            }             
            else
                dArray[delta++] = nArray[charlie++];
        }
        
        //remaining values of first range is copied
        while (alpha < middleOne)
            dArray[delta++] = nArray[alpha++];
        //remaining value of second range is copied
        while (bravo < middleTwo)
            dArray[delta++] = nArray[bravo++];
        //remaining value of third range is copied.
        while (charlie < hVal)
            dArray[delta++] = nArray[charlie++];
    }
}
