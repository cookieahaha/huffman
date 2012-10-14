package me.kukkii.huffman;

import java.util.HashMap;

public class Frequency{
  HashMap<Character, Integer> map;

  public Frequency(){
    map = new HashMap<Character, Integer>();    
  } 

  public void add(char c){
    Integer i = map.put(c, map.get(c));
    if(i == null){
      map.put(c, 1);
    }
    else{
      map.put(c, i+1);
    }
  }

  public void displayAll(){
    for(char c : map.keySet()){
      System.out.println(c + " " + map.get(c));
    }
  }
}
