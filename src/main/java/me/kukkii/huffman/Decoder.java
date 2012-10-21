package me.kukkii.huffman;

import java.util.ArrayList;
import java.util.List;

public class Decoder{

  private Node node;
  private List<Integer> intList;

  public Decoder(Node node, List<Integer> intList){
    this.node = node;
    this.intList = intList;
  }

  public List<Character> decode(){
    List<Character> charList = new ArrayList<Character>();
    int i = 0;
    while(i <  intList.size()){
      i = decodeInt(i, node, charList);
    }
    return charList;
  }

  private int decodeInt(int i, Node node, List<Character> charList){
    if(node instanceof Leaf){
      charList.add(((Leaf)node).getChar());
      System.out.println(i + " " + ((Leaf)node).getChar());
      return i;
    }
    else if(intList.get(i) == 0){
      i += 1;
      return decodeInt(i, node.getLeft(), charList);
    }
    else if(intList.get(i) == 1){
      i += 1;
      return decodeInt(i, node.getRight(), charList);
    }
    return 0;
  }
}
