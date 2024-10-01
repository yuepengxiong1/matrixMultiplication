/*
 * Yuepeng Xiong
 * 9/26/24
 * 
 * Use arguments from command line or if no arguments are inputted, ask for files. Look for text files that contains numbers and 
 * put them into in each array, then multiply each array and output a new text file
 * 
 * 
 * 
 */
import java.util.Scanner;





public class App {
    public static void main(String[] args) throws Exception {
        //File file1 = new File("tester");
        //File file2 = new File("");
        Scanner scanner = new Scanner(System.in);
        int setMatrixRowColumn;


        System.out.println(args.length);
        //first checks if there are 2 aruments passed in
        if(args.length == 0){
            System.out.println("Nothing was passed in through command line. Enter a number or 2 files.");

        } else if (args.length == 1){
            setMatrixRowColumn = Integer.parseInt(args[0]);
            System.out.println(setMatrixRowColumn);
            int[][] array1 = new int[setMatrixRowColumn][setMatrixRowColumn];
            int[][] array2 = new int[setMatrixRowColumn][setMatrixRowColumn];

            for (int i = 0; i < setMatrixRowColumn; i++){
                for(int j = 0; j <setMatrixRowColumn; j++){
                    array1[i][j] = (int)(Math.random() * 100);
                }
            }

            for (int i = 0; i < setMatrixRowColumn; i++){
                for(int j = 0; j <setMatrixRowColumn; j++){
                    System.out.println("Output of row " + i + " colomn " + j + ": " + array1[i][j]);
                }
            }
        }
    

      
    }
}
