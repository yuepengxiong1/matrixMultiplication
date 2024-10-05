package classes;
import classes.MatrixFileWriter;

public class MatrixMultiplier {
    private int row1; //row 1 of array1
    private int col2; //column 2 of array2
    private int setMatrixRowColumn; //this is the set row/column that is the same for both arrays for multiplication to work correctly
    private int stored = 0; //this will store the value of the calculation for the array3

    int[][] array1 = new int[row1][setMatrixRowColumn]; //(n,setMatrixRowColumn)
    int[][] array2 = new int[setMatrixRowColumn][col2];//((setMatrixRowColumn,m))


    //this constructor will set variables when you call this
    public MatrixMultiplier(int[][] array1, int[][] array2, int row1, int setMatrixRowColumn, int col2){
        this.row1 = row1;
        this.setMatrixRowColumn = setMatrixRowColumn;
        this.col2 = col2;
        this.array1 = array1;
        this.array2 = array2;
        
        
        
    }

    //when you call this method it will multiply the 2 arrays
    public void multiply(){
        int[][] array3 = new int[row1][col2]; //array of n rows by m columns
        for (int row = 0; row < row1; row++){// iterate for every row in array1
            for(int column = 0; column < col2; column++){//iterate for every column for array2
                for (int i = 0; i < setMatrixRowColumn; i++) {//iterate for every row for array2
                    array3[row][column] += array1[row][i] * array2[i][column]; //array3[row,column] ("stored" variable is keeping track) += array1[its row, iterate its column] * array2[iterares its row, its column]
                    System.out.println("Calculation for Array3 (" + row + "," + column + "): " + array3[row][column] + " = " + stored + " added with " + array1[row][i] + " x " + array2[i][column]);
                    stored = array3[row][column];
                }
                System.out.println("Calculation for Array3 (" + row + "," + column + "): Is finished");
                stored = 0; //reset for next element in 2d array
            }
        }
        //write the array to a file
        MatrixFileWriter thirdArray = new MatrixFileWriter(array3, row1, col2);
        thirdArray.writeFile("3");
    }
}
