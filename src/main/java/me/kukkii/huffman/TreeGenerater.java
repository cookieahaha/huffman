package me.kukkii.huffman;

import java.util.TreeSet;
import java.util.HashMap;
import java.util.Set;
import java.util.List;

public class TreeGenerater<T>{

  private List<T> array;

  public TreeGenerater(List<T> array){
    this.array = array;
  }

  private Frequency<T> count(){
    Frequency<T> f = new Frequency();
    for(int i=0; i<array.size(); i++){
         f.add(array.get(i));
    }
    //f.displayAll();
    return f;
  }

  public Node<T> createTree(){
    Frequency<T> freq = count();
    TreeSet<Node<T>> treeSet = new TreeSet<Node<T>>();
    for(T c : freq.getKeySet()){
      Node<T> node = new Leaf<T>(c, freq.getValue(c));
      treeSet.add(node);
    }
//    for(Node<T> node : treeSet){
//      System.out.println(node.toString());
//    }
    Node<T> fork = null;
    while(treeSet.size() > 1){
      Node<T> x = treeSet.first();
      treeSet.remove(x);
      Node<T> y = treeSet.first();
      treeSet.remove(y);
      fork = new Fork<T>(y, x);
      treeSet.add(fork);
      System.out.println(x + "    " +  y + "    " +  fork);
    }
    return fork;
  }

  private static class Frequency<T>{
    HashMap<T, Integer> map;

    public Frequency(){
      map = new HashMap<T, Integer>();
    }

    public void add(T c){
      Integer i = map.put(c, map.get(c));
      if(i == null){
        map.put(c, 1);
      }
      else{
        map.put(c, i+1);
      }
    }

    public void displayAll(){
      for(T c : map.keySet()){
        System.out.println(c + " " + map.get(c));
      }
    }

    public Set<T> getKeySet(){
      return map.keySet();
    }

    public int getValue(T c){
      return map.get(c);
    }
  }

}
