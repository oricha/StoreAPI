package com.kmuniz.storeapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create a function that takes a single integer parameter, n,
 * and returns the first n elements of the Fibonacci sequence.
 *
 *     g(1) = [ 0 ]
 *     g(2) = [ 0, 1 ]
 *     g(3) = [ 0, 1, 1 ]
 *     g(4) = [ 0, 1, 1, 2 ]
 *     g(5) = [ 0, 1, 1, 2, 3 ]
 */
public  class Solution {

    public static void main(String[] args){

        int n = 3;
        System.out.println(fibonacci(n) );
    }
    public static List<Integer> fibonacci( int number){

        List<Integer> result  = new ArrayList<>(Arrays.asList());

        result.add(0);

        if( number == 1){
             return result;
        }
        if( number >= 2){
            result.add(1) ;
        }

        for(int i = 3; i <= number; i++){
            int tmp = result.get(result.size()-1) + result.get(result.size()-2);
            result.add(tmp);
        }

         return result;

    }

}
