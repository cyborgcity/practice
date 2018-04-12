package com.cyborgcity.practice.trie;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by Ravi on 29-04-2017.
 */
public class TrieNode {
    char data;
    boolean is_End_Of_String;
    Collection<TrieNode> child;

    public TrieNode(char data) {
        this.data = data;
        this.child = new LinkedList<>();
        this.is_End_Of_String = false;
    }
    public TrieNode subNode(char c){
        if(child != null){
            for(TrieNode eachNode : child){
                if(eachNode.data == c)
                    return eachNode;
            }
        }
        return null;
    }
}
