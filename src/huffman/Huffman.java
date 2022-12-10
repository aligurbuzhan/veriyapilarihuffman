package huffman;

import java.util.PriorityQueue;
import java.util.Comparator;
//sayi adında bir tamsayı ve arrayliste adında bir varchar tanımladım
class huffmandüğüm {
  int sayi;
  char arrayliste;
  huffmandüğüm left;
  huffmandüğüm right;
}//sağ ve sol düğümler

// düğümleri birbiri ile kıyaslamak için
class ImplementComparator implements Comparator<huffmandüğüm> {
  public int compare(huffmandüğüm x, huffmandüğüm y) {
    return x.sayi - y.sayi;
  }
}

// huffman algoritmam
public class Huffman {
  public static void printCode(huffmandüğüm root, String s) {
    if (root.left == null && root.right == null && Character.isLetter(root.arrayliste)) {

      System.out.println(root.arrayliste + "   |  " + s);

      return;
    }
    printCode(root.left, s + "0");
    printCode(root.right, s + "1");
  }

  public static void main(String[] args) {

    int n = 4;
    char[] charArray = { 'İ', 'N', 'C', 'E' };
    int[] charfreq = { 1, 2, 3, 4 };

    PriorityQueue<huffmandüğüm> q = new PriorityQueue<huffmandüğüm>(n, new ImplementComparator());

    for (int h = 0; h < n; h++) {
      huffmandüğüm hn = new huffmandüğüm();

      hn.arrayliste = charArray[h];
      hn.sayi = charfreq[h];

      hn.left = null;
      hn.right = null;

      q.add(hn);
    }

    huffmandüğüm root = null;

    while (q.size() > 1) {

      huffmandüğüm x = q.peek();
      q.poll();

      huffmandüğüm y = q.peek();
      q.poll();

      huffmandüğüm f = new huffmandüğüm();

      f.sayi = x.sayi + y.sayi;
      f.arrayliste = '-';
      f.left = x;
      f.right = y;
      root = f;

      q.add(f);
    }//ÇIKTISI İÇİN
    System.out.println(" Karakter | Huffman Kodu ");
    System.out.println("--------------------");
    printCode(root, "");
  }
}