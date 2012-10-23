package me.kukkii.huffman;

import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;

public class Huffman{

  static String text = "kutd;iuyturefghj;ilukeyjtaherwu567kuytjhghrjykjathrgrtkyrjhrgrjkwlutyml09'=9-098u56y43tfnm,.iouiy;lw";

  public static void main(String args[]){

    List<Character> array = new ArrayList<Character>();
    for(int i=0; i<text.length(); i++){
      array.add(i, text.charAt(i));
    }

    TreeGenerater tg = new TreeGenerater(array);
    Node fork  = tg.createTree();
    Encoder encoder = new Encoder(fork);

    for(char c : fork.getCharSet()){
      System.out.print(c + " ");
      List<Integer> list = encoder.encodeChar(c);
      for(int i : list){
        System.out.print(i);
      }
      System.out.println();
    }

    List<Integer> list = encoder.encode(array);
    for(int i : list){
      System.out.print(i);
    }
    System.out.println();

    Decoder decoder = new Decoder(fork,list);
    List<Character> charList = decoder.decode();
    for(char i : charList){
      System.out.print(i);
    }
    System.out.println();
  }

}
