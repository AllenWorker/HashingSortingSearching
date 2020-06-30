/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.wa.tafe.hashingsortingsearching;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 *
 * @author AllenWorker
 */
public class Entry {
    public static void main(String[] args) throws IOException{
        int input;
        int[] data ={ 36, 29, 31, 125, 139, 131, 115, 105, 111, 40, 119, 47, 105, 57, 122, 109, 124, 115, 43, 120, 43, 27, 27, 32, 61, 37,
                        127, 29, 113, 121, 58, 114, 126, 53, 114, 96, 12, 127, 28, 42, 39, 113, 42, 18, 44, 18, 28, 48, 125, 107, 114, 34, 133,
                        45, 120, 30, 127, 31, 116, 146, 58, 109, 23, 105, 63, 27, 44, 105, 99, 41, 128, 121, 116, 125, 118, 44, 37, 113, 124,
                        37, 48, 127, 25, 109, 7, 31, 141, 46, 13, 27, 43, 117, 116, 27, 7, 68, 40, 31, 115, 124, 42, 128, 52, 71, 118, 117, 38,
                        27, 106, 33, 117, 116, 132, 104, 123, 35, 113, 122, 42, 117, 119, 32, 61, 37, 127, 29, 113, 121, 58, 114, 126, 53,
                        114, 96};
        //Arrays.sort(data);
        Sort.mergeSort(data, data.length);
        int highestStem = data[data.length-1]/10;
        //System.out.println(highestStem);
        StemAndLeaf[] stemTable = new StemAndLeaf[highestStem+1];
        for (int number : data){
            if (stemTable[number/10] != null){
                 stemTable[number/10].addLeaf(number % 10);
            }else{
                stemTable[number/10] = new StemAndLeaf(number / 10, number % 10);
            }
        }
        
        
        
        while (true){
            System.out.println("Please Input Number!");
            System.out.println("1: Show Table | 2: Search Number");
            System.out.flush();
            input = getSlection(); 
            if( input > 2 || input <= 0){
                System.out.print("End");
                break;
            }
            switch(input){
                case 1:
                    System.out.println("Show Stem-Leaf Table");
                    for (StemAndLeaf result : stemTable){
                        if(result != null){
                            System.out.println(result.toString());
                        }
                    }
                    break;
                
                case 2:
                    System.out.println("Search Number");
                    System.out.flush();
                    int number = getSlection();
                    int result = Arrays.binarySearch(data, number);
                    if (result >= 0) 
                        System.out.println(number + " found at index = " 
                                                              + result); 
                    else
                        System.out.println(number + " Not found"); 
                    break;
                    
                default:
                    
                    break;
            }
            //System.out.flush();
        }
    }
    public static int getSlection() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int s = tryParse(br.readLine());
        return s;
    }
    
    public static int tryParse(String text) {
        try {
                return Integer.parseInt(text);
            } catch (NumberFormatException e) {
                return 0;
            }
    }
}
