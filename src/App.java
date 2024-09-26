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
import java.io.File;
import java.util.Scanner;
import classes.matrixMulti;



public class App {
    public static void main(String[] args) throws Exception {
        File file1 = new File("tester");
        File file2 = new File("");
        int maxNumbers; // sets the maximum length of the next array so there is no extra calculation
        String input; //takes user input as a string
        String[] array1;//populates the array based on input and spaces
        String[] array2;
        Scanner scanner = new Scanner(System.in);


        //this if statement checks if user passes any files through command line.
        //if they didnt, this will ask for the user to input numbers
        if (args.length == 0){
            System.out.print("Enter the first set of integers for the first array (do not press enter): ");
            input = scanner.nextLine();
            array1 = input.split(" "); //this sets array1 to input and populates each element for every space
            maxNumbers = array1.length; 
            input = ""; //resets input
            
            System.out.print("Enter the second set of integers for the second array (max " + maxNumbers + ", do not press enter. Extras will be ignored):");
            input = scanner.nextLine();
            array2 = input.split(" ");
            
            System.out.println(matrixMulti(array1, array2));
        }
    }
}
