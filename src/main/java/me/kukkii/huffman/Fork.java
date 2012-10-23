package me.kukkii.huffman;
import java.util.HashSet;

public class Fork<T> extends Node<T>{

  public Fork(Node left, Node right){
    this.right = right;
    this.left = left;
    this.sum = right.getSum() + left.getSum();
    this.charSet = new HashSet<T>();
    charSet.addAll(right.getCharSet());
    charSet.addAll(left.getCharSet()); 
  }

  public String toString(){
    String s = "";
    for(T c : getCharSet()){
      s += c;
    }
    return s + " " + "(" + sum + ")";
  }
 
}
