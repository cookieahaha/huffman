package me.kukkii.huffman;

import java.util.List;
import java.util.ArrayList;

public class Encoder<T>{

  private Node<T> node;

  public Encoder(Node<T> node){
    this.node = node;
  }

  public List<Integer> encode(List<T> array){
    List<Integer> list = new ArrayList<Integer>();
    for(int i=0; i<array.size(); i++){
      T c = array.get(i);
      encodeChar(c, node, list);
    }
    return list;
  }

  public List<Integer> encodeChar(T c){
    List<Integer> list = new ArrayList<Integer>();
    encodeChar(c, node, list);
    return list;
  }

  public void encodeChar(T c, Node<T> node, List<Integer> list){
    if(node instanceof Leaf){
      return;
    }
    else if(node.getLeft().getCharSet().contains(c)){
      list.add(0);
      encodeChar(c, node.getLeft(), list);
    }
    else{
      list.add(1);
      encodeChar(c, node.getRight(), list);
    }
  }

}

