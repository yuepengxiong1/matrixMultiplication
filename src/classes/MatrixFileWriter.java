package classes;
import java.io.FileWriter; 
import java.io.BufferedWriter;
import java.io.IOException;

public class MatrixFileWriter {
   private int array[][]; //this will set the array so it can be printed out
   private int row; //this will set the row of the array
   private int column; //this will set the column of the array

   //this will set variables in App.java that calls on this constructor
    public MatrixFileWriter(int[][] array1, int row, int column) {
        this.array = array1;
        this.row = row;
        this.column = column;
    }

    //this will write the array to a file. number that is passed in will differenciate the file name
    public void writeFile(String arrayNumber){
        /*
         * Github Copilot explanation of BufferedWriter incase needed for review:
         * BufferedWriter is a wrapper around Writer classes like FileWriter. It adds buffering capabilities to the writer, 
         * which means it collects a chunk of data in memory before writing it to the file in one go. 
         * This reduces the number of I/O operations, making it more efficient, especially for larger amounts of data.
         */

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("matrix" + arrayNumber + ".txt"))) {
            //writer.write(row + " by " + column);
           // writer.newLine();
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    writer.write(array[i][j] + " ");
                }
                writer.newLine();
            }
            System.out.println("Array" + arrayNumber + " has been written to file. File name: matrix" + arrayNumber + ".txt");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
