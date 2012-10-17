package me.kukkii.huffman;
import java.util.HashSet;

public class Fork extends Node{

  public Fork(Node right, Node left){
    this.right = right;
    this.left = left;
    this.sum = right.getSum() + left.getSum();
    this.charSet = new HashSet<Character>();
    charSet.addAll(right.getCharSet());
    charSet.addAll(left.getCharSet()); 
  }
 
}
