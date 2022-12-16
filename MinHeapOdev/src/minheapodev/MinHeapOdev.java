/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package minheapodev;

import java.util.Scanner;

/**
 *
 * @author Samet
 */
public class MinHeapOdev {

   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Kullanıcıdan sayıları alır ve diziye atar
    System.out.println("Lutfen sayilari girin (virgulle ayrilmis sekilde yaz):");
    String input = sc.nextLine();
    String[] parts = input.split(",");
    int[] numbers = new int[parts.length];
    for (int i = 0; i < parts.length; i++) {
      numbers[i] = Integer.parseInt(parts[i].trim());
    }

    // Dizinin üçlü min heap olup olmadığını kontrol etme
    boolean isMinHeap = true;
    for (int i = 1; i < numbers.length; i++) {
      int parentIndex = (i - 1) / 3;
      if (numbers[parentIndex] > numbers[i]) {
        isMinHeap = false;
        break;
      }
    }

    // Diziyi üçlü min heap'e dönüştürür.
    for (int i = 1; i < numbers.length; i++) {
      int currentIndex = i;
      while (currentIndex > 0) {
        int parentIndex = (currentIndex - 1) / 3;
        if (numbers[parentIndex] > numbers[currentIndex]) {
          int temp = numbers[parentIndex];
          numbers[parentIndex] = numbers[currentIndex];
          numbers[currentIndex] = temp;
          currentIndex = parentIndex;
        } else {
          break;
        }
      }
    }

    // Sonucu ekrana yazdırır
    if (isMinHeap) {
      System.out.println("Dizi zaten uclu min heap'tir.");
    } else {
      System.out.println("Dizi uclu min heap haline getirildi.");
    }

    // Dizinin heap halini ekrana yazdırır
    System.out.println("Heap halinde dizi:");
    for (int i = 0; i < numbers.length; i++) {
      System.out.print(numbers[i] + " ");
    }
    System.out.println();

    sc.close();
  }
    
}
