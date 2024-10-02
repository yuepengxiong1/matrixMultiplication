/*
 * Yuepeng Xiong
 * 9/26/24
 * 
 * Check if user input a number or 2 files. If a number, use that number to generate a 2 2d square array and
 * populate them with random numbers and multiply them. Generate text files for 3 arrays.
 * 
 * If user passes in 2 text files of a 2d array, accept them and do the same. Generate the third text file.
 * 
 */
import java.io.FileWriter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        FileWriter textFile1 = new FileWriter("matrix1.txt");
        FileWriter textFile2 = new FileWriter("matrix2.txt");
        FileWriter textFile3 = new FileWriter("matrix3.txt");
        Scanner scanner = new Scanner(System.in);
        int setMatrixRowColumn;
        int store[] = null;
        int counter = 0;
        
        //first checks if there are 2 aruments passed in
        if(args.length == 0){
            System.out.println("Nothing was passed in through command line. Enter a number or 2 files.");

        } else if (args.length == 1){
            //get the string of the user input, convert to int
            setMatrixRowColumn = Integer.parseInt(args[0]);

            //set 2d array to the dimensions of given number from command line
            int[][] array1 = new int[setMatrixRowColumn][setMatrixRowColumn];
            int[][] array2 = new int[setMatrixRowColumn][setMatrixRowColumn];
            int[][] array3 = new int[setMatrixRowColumn][setMatrixRowColumn];

            //populate 2d array for array1
            for (int i = 0; i < setMatrixRowColumn; i++){
                for(int j = 0; j <setMatrixRowColumn; j++){
                    array1[i][j] = (int)(Math.random() * 100);//generates number from 1-100
                    store[counter] = array1[i][j];
                    counter++;
                }
                counter++;
            }
            System.out.println(counter);
            //populate 2d array for array2
            for (int i = 0; i < setMatrixRowColumn; i++){
                for(int j = 0; j <setMatrixRowColumn; j++){
                    array2[i][j] = (int)(Math.random() * 100); //generates number from 1-100
                }
            }

            //multiply both 2d arrays
            for (int i = 0; i < setMatrixRowColumn; i++){
                for(int j = 0; j <setMatrixRowColumn; j++){
                    array3[i][j] = array1[i][j] * array2[i][j]; //multiply i and j part of array1 and array2 and put them into array3
                }
            }
           
      
        }
    
        
      
    }
}
