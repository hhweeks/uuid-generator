package com.hans.uuidgenerator;

import com.sun.tools.javac.util.Pair;
import org.springframework.stereotype.Component;

@Component
public class PalindromeFinder {

    public int findLargestPalindromeLength(String string){

        return findLargestPalindromeString(string).length();
    }

    public String findLargestPalindromeString(String string){

        int len = string.length();
        int maxLenPalindrome=0;
        int left=0;
        int right=0;

        for(int i=0; i<len; i++){
            for(int j=i; j<len; j++){
                for(int k=0; k<=j-i; k++){
                    char endl=string.charAt(i+k);
                    char endr=string.charAt(j-k);
                    if(endl!=endr){
                        break;//don't check the rest of this substring
                    }
                    if(k==j-i){
                        if(j-i>maxLenPalindrome){
                            maxLenPalindrome=j-i;
                            left = i;
                            right = j;
                        }
                    }
                }
            }
        }

        return string.substring(left,right+1);

//        Boolean[][] isSubstringPalindrome = new Boolean[len][len];
//
//        for(int i=0;i<len;i++){
//            isSubstringPalindrome[i][i]=true;
//        }
//
//        Pair<Integer, Integer> endpoints = _findLargestPalindromeRec(string, 0, len, isSubstringPalindrome);
//
//        return string.substring(endpoints.fst, endpoints.snd);
    }

    private Pair<Integer, Integer> _findLargestPalindromeRec(String string, Integer left, Integer right, Boolean[][] isSubstringPalindrome){

        return null;
    }
}
