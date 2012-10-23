package me.kukkii.huffman;

import java.util.ArrayList;
import java.util.List;

public class Decoder<T>{

  private Node<T> node;
  private List<Integer> intList;

  public Decoder(Node<T> node, List<Integer> intList){
    this.node = node;
    this.intList = intList;
  }

  public List<T> decode(){
    List<T> charList = new ArrayList<T>();
    int i = 0;
    while(i <  intList.size()){
      i = decodeInt(i, node, charList);
    }
    return charList;
  }

  private int decodeInt(int i, Node<T> node, List<T> charList){
    if(node instanceof Leaf){
      charList.add(((Leaf<T>)node).getChar());
      System.out.println(i + " " + ((Leaf<T>)node).getChar());
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
