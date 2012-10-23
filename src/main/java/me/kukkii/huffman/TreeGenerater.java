package me.kukkii.huffman;

import java.util.TreeSet;
import java.util.HashMap;
import java.util.Set;

public class TreeGenerater{

  private char[] array;

  public TreeGenerater(char[] array){
    this.array = array;
  }

  public Frequency count(){
    Frequency f = new Frequency();
    for(int i=0; i<array.length; i++){
         f.add(array[i]);
    }
    //f.displayAll();
    return f;
  }

  public Node createTree(){
    Frequency freq = count();
    TreeSet<Node> treeSet = new TreeSet<Node>();
    for(char c : freq.getKeySet()){
      Node node = new Leaf(c, freq.getValue(c));
      treeSet.add(node);
    }
//    for(Node node : treeSet){
//      System.out.println(node.toString());
//    }
    Node fork = null;
    while(treeSet.size() > 1){
      Node x = treeSet.first();
      treeSet.remove(x);
      Node y = treeSet.first();
      treeSet.remove(y);
      fork = new Fork(y, x);
      treeSet.add(fork);
      System.out.println(x + "    " +  y + "    " +  fork);
    }
    return fork;
  }

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

    public Set<Character> getKeySet(){
      return map.keySet();
    }

    public int getValue(char c){
      return map.get(c);
    }
  }

}
