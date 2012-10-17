package me.kukkii.huffman;
import java.util.HashSet;

public class Leaf extends Node{

  private char c;

  public Leaf(char c, int sum){
    super();
    this.c = c;
    this.sum = sum;
    charSet = new HashSet<Character>();
    charSet.add(c);
  }

  public char getChar(){
    return c;
  }

  public String toString(){
    return c + ", " + sum;
  }
}
