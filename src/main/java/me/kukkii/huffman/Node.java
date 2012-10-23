package me.kukkii.huffman;
import java.util.Set;

public abstract class Node<T> implements Comparable<Node<T>>{

  protected Node<T> right;
  protected Node<T> left;
  protected int sum = 0;
  protected Set<T> charSet;

  public Node(){
  }

  public Node<T> getLeft(){
    return left;
  }

  public Node<T> getRight(){
    return right;
  }

  public int getSum(){
    return sum;
  }

  public Set<T> getCharSet(){
    return charSet;
  }

  public int compareTo(Node node){
    if(this.getSum() == node.getSum()){
      return this.hashCode() - node.hashCode();
    }
    else{
      return this.getSum() - node.getSum();
    }
  }
}
