package me.kukkii.huffman;
import java.util.Set;

public abstract class Node implements Comparable<Node>{

  protected Node right;
  protected Node left;
  protected int sum = 0;
  protected Set<Character> charSet;

  public Node(){
  }

  public Node getLeft(){
    return left;
  }

  public Node getRight(){
    return right;
  }

  public int getSum(){
    return sum;
  }

  public Set<Character> getCharSet(){
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
