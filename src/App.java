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
import java.util.Scanner;
import classes.MatrixFileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import classes.MatrixMultiplier;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;


public class App {
    public static void main(String[] args) throws Exception {
        int setMatrixRowColumn; // this will be set by the user when its passed in through command line.

        //first checks if there are aruments passed in or not
        if(args.length == 0){
            System.out.println("Nothing was passed in through command line. Enter a number or 2 files.");
        
        //when you pass in a number
        } else if (args.length == 1){
            int n = (int)(Math.random() * 5) + 1; // generates number from 1-6. for first array. +1 is safetynet incase of 0. number of rows for array3
            int m = (int)(Math.random() * 5) + 1; // generates number from 1-6. for second array. +1 is safetynet incase of 0. number of cols for array3
            
            //get the string of the user input, convert to int
            setMatrixRowColumn = Integer.parseInt(args[0]);


            //State how the matrix is formed. Row must equal column. (n by F) (F by m) where F is the argumet set by user and is constant. 
            //n and m is randomly generated
            System.out.println("Creating 2 matries of: " + n + " by " + setMatrixRowColumn + " and " + setMatrixRowColumn + " by " + m);
            System.out.println("User submitted row/column match: " + setMatrixRowColumn);

            //set 2d array to the dimensions of given number from command line
            int[][] array1 = new int[n][setMatrixRowColumn]; //(n,setMatrixRowColumn)
            int[][] array2 = new int[setMatrixRowColumn][m];//((setMatrixRowColumn,m))
            
            System.out.println("Array3 dimensions are: " + n + " by " + m);
            
            //populate 2d array for array1
            for (int i = 0; i < n; i++){ //n is max rows of array1
                for(int j = 0; j < setMatrixRowColumn; j++){
                    array1[i][j] = (int)(Math.random() * 100);//generates number from 1-100
                }  
            }
   
            //populate 2d array for array2
            for (int i = 0; i < setMatrixRowColumn; i++){
                for(int j = 0; j < m; j++){ //m is max columns of array2
                    array2[i][j] = (int)(Math.random() * 100); //generates number from 1-100
                }
            }

            //multiply both 2d arrays
            MatrixMultiplier doTheMath = new MatrixMultiplier(array1, array2, n, setMatrixRowColumn, m);
            doTheMath.multiply();

            //Save the 3 arrays to text files
            MatrixFileWriter firstArray = new MatrixFileWriter(array1, n, setMatrixRowColumn);
            MatrixFileWriter secondArray = new MatrixFileWriter(array2, setMatrixRowColumn, m);
        
            firstArray.writeFile("1");
            secondArray.writeFile("2");
           
        //when you pass in 2 text files 
        } else if (args.length == 2){ 
            File file1 = new File(args[0]); //Assign a file with the first argument
            File file2 = new File(args[1]); //Assign a file with the second argument
            String[] lengthOfLine; //this will be used to check the length of the lines in the text file
            boolean isSquareArray1 = false; //this will check if the array is a square array
            boolean isSquareArray2 = false; //this will check if the array is a square array

            Scanner scannerForArray1 = new Scanner(file1); //this will scan the first file
            Scanner scannerForArray2 = new Scanner(file2); //this will scan the second file

            int[][] array1 = null; //this will be the first array
            int[][] array2 = null; //this will be the second array

            int rowArray1 = 1; //this is set to 1 because i didnt know that calling nextLine() will skip the first line
            int columnArray1 = scannerForArray1.nextLine().split(" ").length;
            int rowArray2 = 1;
            int columnArray2 = scannerForArray2.nextLine().split(" ").length;
            

            
            //Counting how many rows there are in the text file
            while (scannerForArray1.hasNextLine()) {
                rowArray1++;
                if(scannerForArray1.nextLine() == null){
                    break;
                 }   
            }
            while(scannerForArray2.hasNextLine()){
                 rowArray2++;   
                if(scannerForArray2.nextLine() == null){
                     break;
                }
            }
            scannerForArray1.close();
            scannerForArray2.close();

            //a little tedious. i wanted to reset it
            scannerForArray1 = new Scanner(file1);
            scannerForArray2 = new Scanner(file2);

            //checking the length of the lines to see if they are the same
            while(scannerForArray1.hasNextLine()){
                lengthOfLine = scannerForArray1.nextLine().split(" ");
                if(lengthOfLine.length != columnArray1){
                    System.out.println("The number of columns in Array1 are not the same as rows in Array2. They must be the same to perform matrix multiplication.");
                    isSquareArray1 = false;
                    break;
                }
                isSquareArray1 = true;
            }

            //same thing but for array2
            while(scannerForArray2.hasNextLine()){
                lengthOfLine = scannerForArray2.nextLine().split(" ");
                if(lengthOfLine.length != columnArray2){
                    System.out.println("The number of rows in Array2 are not the same as columns in Array1. They must be the same to perform matrix multiplication");
                    isSquareArray2 = false;
                    break;
                }
                isSquareArray2 = true;
            }

            //If the array is irregular, then it will execute this
            if (!isSquareArray1 || !isSquareArray2){
                System.out.println("One or both of the arrays are not a square/rectangle (Its possible that its IRREGULAR). They must be square/rectangle to perform matrix multiplication.");
                System.out.println("Report:\nArray1 is square/rectangle?: " + isSquareArray1 + "\nArray2 is square/rectangle?: " + isSquareArray2);
            } else {

            //this looks tedious but i figured out that if you dont do this, it will skip however many lines the first while loop went through
            scannerForArray1 = new Scanner(file1);
            scannerForArray2 = new Scanner(file2);

            //i could have probably had merged this with the while loop above this. Comment out code only for debugging purposes.
            while(scannerForArray1.hasNextLine()){
                array1 = new int[rowArray1][columnArray1];
                for (int i = 0; i < rowArray1; i++){
                    String[] values = scannerForArray1.nextLine().split(" ");
                    for (int j = 0; j < columnArray1; j++){
                        //System.out.println("Values at index " + j + " has " + values[j]);
                        array1[i][j] = Integer.parseInt(values[j]);
                        //System.out.println("Array1 at " + i + "," + j + " has " + array1[i][j]);
                    }
                }
            }

            while(scannerForArray2.hasNextLine()){
                array2 = new int[rowArray2][columnArray2];
                for (int i = 0; i < rowArray2; i++){
                    String[] values = scannerForArray2.nextLine().split(" ");
                    for (int j = 0; j < columnArray2; j++){
                       // System.out.println("Values at index " + j + " has " + values[j]);
                        array2[i][j] = Integer.parseInt(values[j]);
                        //System.out.println("Array2 at " + i + "," + j + " has " + array2[i][j]);
                        
                    }
                }
            }
                
            scannerForArray1.close();
            scannerForArray2.close();
  
            System.out.println("Array1 is: " + rowArray1 + " by " + columnArray1);
            System.out.println("Array2 is: " + rowArray2 + " by " + columnArray2);

            
            //Print out the arrays as how they are in the text file
            System.out.println("Array1: ");
            for (int i = 0; i < rowArray1; i++){
                for (int j = 0; j < columnArray1; j++){
                    System.out.print(array1[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("Array2: ");
            for (int i = 0; i < rowArray2; i++){
                for (int j = 0; j < columnArray2; j++){
                    System.out.print(array2[i][j] + " ");
                }
                System.out.println();
            }

            
            //Check if the 2 arrays can be multiplied to each other for matrix multiplication
            if(columnArray1 != rowArray2){
                System.out.println("These 2 arrays cannot perform matrix multiplication. The number of columns in Array1 must equal the number of rows in Array2.");
            } else {
                System.out.println("The max size of array3 is: " + rowArray1 + " by " + columnArray2);
                setMatrixRowColumn = columnArray1;
                MatrixMultiplier doTheMath2 = new MatrixMultiplier(array1, array2, rowArray1, setMatrixRowColumn, columnArray2);
                doTheMath2.multiply();

            }
        }
    }    
    //learning how to make a press any key to exit thingy 
     System.out.println("Program has ended. Press enter to exit.");
     System.in.read();

    }//end main
}

//end class
