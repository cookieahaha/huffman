package me.kukkii.huffman;
import java.util.HashSet;

public class Leaf<T> extends Node<T>{

  private T c;

  public Leaf(T c, int sum){
    super();
    this.c = c;
    this.sum = sum;
    charSet = new HashSet<T>();
    charSet.add(c);
  }

  public T getChar(){
    return c;
  }

  public String toString(){
    return c + " " + "(" + sum + ")";
  }
}
