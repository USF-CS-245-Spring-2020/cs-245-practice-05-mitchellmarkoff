import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class MegaSort {
    public static void main(String args[])  {

        File textFile = null;  

        int[] ints = new int[1000000];       
       
        //Method of reading file was abstracted form a post on stack overflow
        // This is the exact quick sort I used in practice assignment 04

        try {
            textFile = new File(args[0]);
        } 
        
        catch (Exception e) {
            System.out.println("Invalid argument for file: " + e.getMessage());
        }

        try(BufferedReader br = new BufferedReader(new FileReader(textFile))) {
            int count = 0;

            while(br.ready()) {
                char[] c = br.readLine().toCharArray();

                boolean foundZero = false;

                int startingIndex = c.length-1;

                for(int i = 0; i<c.length - 1; i++) {
                    if(! foundZero) {
                        if(c[i] !='0') {
                            startingIndex = i;
                            foundZero = true;
                        }
                    }
                }

                String noLeadingZeros = "";

                for(int i = startingIndex; i != c.length; i++) {
                    noLeadingZeros += c[i];
                }

                ints[count++] = Integer.parseInt(noLeadingZeros);
            }

        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch(IOException e) {
            e.printStackTrace();
        }


        MegaSort t = new MegaSort();
        t.sort(ints);

        for(int j = 3; j>0; j--) {
            System.out.println(ints[j]);
        }
        

    }

    public void sort(int [] a) {
        qs(a,0,a.length-1);
    }

    public int partition(int [] arr, int low, int high) {
    int pivot = arr[high];  
        int i = (low-1);
        for (int j=low; j<high; j++) { 
            if (arr[j] < pivot) { 
                i++; 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    }

    void qs(int arr[], int low, int high) { 
        if (low < high) { 
            int pi = partition(arr, low, high); 
  
            qs(arr, low, pi-1); 
            qs(arr, pi+1, high); 
        } 
    }
}

        
        