package me.kukkii.huffman;

import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;

public class Huffman{

  static String text = "kutd;iuyturefghj;ilukeyjtaherwu567kuytjhghrjykjathrgrtkyrjhrgrjkwlutyml09'=9-098u56y43tfnm,.iouiy;lw";

  public static void main(String args[]){
    Node fork  = createTree(text);
    List<Integer> list = encode(text, fork);
    for(int i : list){
      System.out.print(i);
    }
    System.out.println();
  }

  public static Frequency count(String text){
    char[] array = text.toCharArray();
    Frequency f = new Frequency();
    for(int i=0; i<array.length; i++){
         f.add(array[i]);
    }
    //f.displayAll();
    return f;
  }

  public static Node createTree(String text){
    Frequency freq = count(text);
    TreeSet<Node> treeSet = new TreeSet<Node>();
    for(char c : freq.getKeySet()){
      Node node = new Leaf(c, freq.getValue(c));
      treeSet.add(node);
    }
    for(Node node : treeSet){
      System.out.println(node.toString());
    }
    Node fork = null;
    while(treeSet.first() != treeSet.last()){
      Node x = treeSet.first();
      treeSet.remove(treeSet.first());
      fork = new Fork(treeSet.first(), x);
      treeSet.remove(treeSet.first());
      treeSet.add(fork);
    }
    return fork;
  }

  public static List<Integer> encode(String text, Node fork){
    List<Integer> list = new ArrayList<Integer>();    
    for(int i=0; i<text.length(); i++){
      char c = text.charAt(i);
      encodeChar(c, fork, list);
    }
    return list;
  }

  public static void encodeChar(char c, Node node, List<Integer> list){
    if(node instanceof Leaf){
      return;
    }
    else if(node.getLeft().getCharSet().contains(c)){
      list.add(1);
      encodeChar(c, node.getLeft(), list);
    }
    else{
      list.add(0);
      encodeChar(c, node.getLeft(), list);
    }
  } 

}
