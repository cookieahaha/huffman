package me.kukkii.huffman;

import java.util.List;
import java.util.ArrayList;

public class Encoder{

  private Node node;

  public Encoder(Node node){
    this.node = node;
  }

  public List<Integer> encode(String text){
    List<Integer> list = new ArrayList<Integer>();
    for(int i=0; i<text.length(); i++){
      char c = text.charAt(i);
      encodeChar(c, node, list);
    }
    return list;
  }

  public List<Integer> encodeChar(char c){
    List<Integer> list = new ArrayList<Integer>();
    encodeChar(c, node, list);
    return list;
  }

  public void encodeChar(char c, Node node, List<Integer> list){
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

