package me.kukkii.huffman;

import java.util.TreeSet;

public class Huffman{

  static String text = "kutd;iuyturefghj;ilukeyjtaherwu567kuytjhghrjykjathrgrtkyrjhrgrjkwlutyml09'=9-098u56y43tfnm,.iouiy;lw";

  public static void main(String args[]){
    createTree(text);
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
return null;
  }

}
