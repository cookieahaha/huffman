package me.kukkii.huffman;

public class Huffman{

  static String text = "kutd;iuyturefghj;ilukeyjtaherwu567kuytjhghrjykjathrgrtkyrjhrgrjkwlutyml09'=9-098u56y43tfnm,.iouiy;lw";

  public static void main(String args[]){
    count(text);
  }

  public static Frequency count(String text){
    char[] array = text.toCharArray();
    Frequency f = new Frequency();
    for(int i=0; i<array.length; i++){
         f.add(array[i]);
    }
    f.displayAll();
    return f;
  }

}
