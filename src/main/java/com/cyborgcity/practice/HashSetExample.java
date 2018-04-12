package com.cyborgcity.practice;

import java.util.*;

/**
 * Created by Ravi on 18-07-2017.
 */
public class HashSetExample {
    public static void main(String args[]){


        Set<String> hashSet=new HashSet<String>();
        hashSet.add("audi");

        //fail-fast
        Iterator<String> iterator=hashSet.iterator();
        while(iterator.hasNext()){
            hashSet.add("newElement1"); //unComment to avoid ConcurrentModificationException
            System.out.println(iterator.next());
        }


        //fail-fast
        Enumeration<String> listEnum= Collections.enumeration(hashSet);
        while(listEnum.hasMoreElements()){
            hashSet.add("newElement2"); //unComment to avoid ConcurrentModificationException
            System.out.println(listEnum.nextElement());
        }

        //enhanced for loop is fail-fast
        for(String string:hashSet){
            hashSet.add("newElement3"); //unComment to avoid ConcurrentModificationException
            System.out.println(string);
        }

    }
}
