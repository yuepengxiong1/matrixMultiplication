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

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int setMatrixRowColumn; // this will be set by the user when its passed in through command line.
        int n = (int)(Math.random() * 5) + 1; // generates number from 1-6. for first array. +1 is safetynet incase of 0. number of rows for array3
        int m = (int)(Math.random() * 5) + 1; // generates number from 1-6. for second array. +1 is safetynet incase of 0. number of cols for array3
        int stored = 0; //this just save the calculation when multiplying the matries since it takes multi steps in the for loop. helps to understand the calculation
        
        //first checks if there are aruments passed in or not
        if(args.length == 0){
            System.out.println("Nothing was passed in through command line. Enter a number or 2 files.");
        } else if (args.length == 1){
            
            //get the string of the user input, convert to int
            setMatrixRowColumn = Integer.parseInt(args[0]);
 
            //State how the matrix is formed. Row must equal column. (n by F) (F by m) where F is the argumet set by user and is constant. 
            //n and m is randomly generated
            System.out.println("Creating 2 matries of: " + n + " by " + setMatrixRowColumn + " and " + setMatrixRowColumn + " by " + m);
            System.out.println("User submitted row/column match: " + setMatrixRowColumn);

            //set 2d array to the dimensions of given number from command line
            int[][] array1 = new int[n][setMatrixRowColumn]; //(n,setMatrixRowColumn)
            int[][] array2 = new int[setMatrixRowColumn][m];//((setMatrixRowColumn,m))
            int[][] array3 = new int[n][m]; //array of n rows by m columns
            
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
            for (int row = 0; row < n; row++){// iterate for every row in array1
                for(int column = 0; column < m; column++){//iterate for every column for array2
                    for (int i = 0; i < setMatrixRowColumn; i++) {//iterate for every row for array2
                        array3[row][column] += array1[row][i] * array2[i][column]; //array3[row,column] ("stored" variable is keeping track) += array1[its row, iterate its column] * array2[iterares its row, its column]
                        System.out.println("Calculation for Array3 (" + row + "," + column + "): " + array3[row][column] + " = " + stored + " added with " + array1[row][i] + " x " + array2[i][column]);
                        stored = array3[row][column];
                    }
                    System.out.println("Calculation for Array3 (" + row + "," + column + "): Is finished");
                    stored = 0; //reset for next element in 2d array
                }
            }

            //This just prints Array1 and its elements
            for(int i = 0; i < n; i++){
                for(int j = 0; j < setMatrixRowColumn; j++){
                    System.out.println("ARRAY 1: Row: " + (i + 1) + " Col: " + (j + 1) + " Contains: " + array1[i][j]);
                }
            }
            //This just prints Array2 and its elements
            for(int i = 0; i < setMatrixRowColumn; i++){
                for(int j = 0; j < m; j++){
                    System.out.println("ARRAY 2: Row: " + (i + 1) + " Col: " + (j + 1) + " Contains: " + array2[i][j]);
                }
            }
            //This just prints Array3 and its elements
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    System.out.println("ARRAY 3: Row: " + (i + 1) + " Col: " + (j + 1) + " Contains: " + array3[i][j]);
                }//end for of j   
            }//end for of i
        }//end if of args.length is 1
    }//end main
}//end class
