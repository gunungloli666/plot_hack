/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fjr.test;

import java.util.ArrayList;

/**
 *
 * @author mamat
 */
public class Test {
    
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i=0; i< 10; i++){
            list.add(i);
        }
        
        list.remove(2);
        list.add(2, 12);
        
        for(int i=0; i< list.size(); i++){
            System.out.println(list.get(i));
        }
        System.out.println(list.get(list.size()-1));
    }
    
}
