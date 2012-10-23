package me.kukkii.huffman;

import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class HuffmanImage{

  static BufferedImage image = null;

  public static void main(String args[]){

    try{
      image = ImageIO.read(new File("/Users/cookieahaha/Desktop/google.jpeg"));
    }
    catch(Exception e){
      e.printStackTrace();
    }
    List<Integer> array = new ArrayList<Integer>();
    for(int w=0; w<image.getTileWidth(); w++){
      for(int h=0; h<image.getTileHeight(); h++){  
        array.add(image.getRGB(w, h));
      }
    }

    TreeGenerater<Integer> tg = new TreeGenerater<Integer>(array);
    Node<Integer> fork  = tg.createTree();
    Encoder<Integer> encoder = new Encoder<Integer>(fork);

    for(Integer c : fork.getCharSet()){
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

    Decoder<Integer> decoder = new Decoder<Integer>(fork,list);
    List<Integer> charList = decoder.decode();
    for(Integer i : charList){
      System.out.print(i);
    }
    System.out.println();

    System.out.println("imageSize= " + image.getTileWidth()*image.getTileHeight()*24);
    System.out.println("encodedSize= " + list.size());
  }

}
