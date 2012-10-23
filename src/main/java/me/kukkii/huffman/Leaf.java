package me.kukkii.huffman;
import java.util.HashSet;

public class Leaf extends Node{

  private Character c;

  public Leaf(Character c, int sum){
    super();
    this.c = c;
    this.sum = sum;
    charSet = new HashSet<Character>();
    charSet.add(c);
  }

  public Character getChar(){
    return c;
  }

  public String toString(){
    return c + " " + "(" + sum + ")";
  }
}
