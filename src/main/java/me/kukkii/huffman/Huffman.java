package me.kukkii.huffman;

import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;

public class Huffman{

  static String text = "kutd;iuyturefghj;ilukeyjtaherwu567kuytjhghrjykjathrgrtkyrjhrgrjkwlutyml09'=9-098u56y43tfnm,.iouiy;lw";

  public static void main(String args[]){
    Node fork  = createTree(text);
    Encoder encoder = new Encoder(fork);
    List<Integer> list = encoder.encode(text);
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

}
