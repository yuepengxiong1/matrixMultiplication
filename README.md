## Getting Started

How to use:

Run the matrixMultiplication.jar file to get started.

Pass in 2 text files seperated by a space OR pass in ONE integer value after the .jar text at the end of command.

Examples of output using 2 arguments:
java -jar --enable-preview matrixMultiplication.jar array1.txt array2.txt

Array1 is: 2 by 2
Array2 is: 2 by 2
Array1:
1 3
4 5
Array2:
10 20
30 40
The max size of array3 is: 2 by 2
Calculation for Array3 (0,0): 10 = 0 added with 1 x 10
Calculation for Array3 (0,0): 100 = 10 added with 3 x 30
Calculation for Array3 (0,0): Is finished
Calculation for Array3 (0,1): 20 = 0 added with 1 x 20
Calculation for Array3 (0,1): 140 = 20 added with 3 x 40
Calculation for Array3 (0,1): Is finished
Calculation for Array3 (1,0): 40 = 0 added with 4 x 10
Calculation for Array3 (1,0): 190 = 40 added with 5 x 30
Calculation for Array3 (1,0): Is finished
Calculation for Array3 (1,1): 80 = 0 added with 4 x 20
Calculation for Array3 (1,1): 280 = 80 added with 5 x 40
Calculation for Array3 (1,1): Is finished
Array3 has been written to file.
Program has ended. Press enter to exit.


Example of passing in 1 integer:
java -jar --enable-preview matrixMultiplication.jar 2
Creating 2 matries of: 1 by 2 and 2 by 2
User submitted row/column match: 2
Array3 dimensions are: 1 by 2
Calculation for Array3 (0,0): 928 = 0 added with 32 x 29
Calculation for Array3 (0,0): 1108 = 928 added with 90 x 2
Calculation for Array3 (0,0): Is finished
Calculation for Array3 (0,1): 1920 = 0 added with 32 x 60
Calculation for Array3 (0,1): 5520 = 1920 added with 90 x 40
Calculation for Array3 (0,1): Is finished
Array3 has been written to file.
Array1 has been written to file.
Array2 has been written to file.
Program has ended. Press enter to exit.


Example of including a irregular Matrix:
java -jar --enable-preview matrixMultiplication.jar array1.txt array2.txt
The number of columns in Array1 are not the same as rows in Array2. They must be the same to perform matrix multiplication.
One or both of the arrays are not a square/rectangle (Its possible that its IRREGULAR). They must be square/rectangle to perform matrix multiplication.
Report:
Array1 is square/rectangle?: false
Array2 is square/rectangle?: true
Program has ended. Press enter to exit.


Example of both arrays with no matching row/column:
java -jar --enable-preview matrixMultiplication.jar array1.txt array2.txt
The number of columns in Array1 are not the same as rows in Array2. They must be the same to perform matrix multiplication.
One or both of the arrays are not a square/rectangle (Its possible that its IRREGULAR). They must be square/rectangle to perform matrix multiplication.
Report:
Array1 is square/rectangle?: false
Array2 is square/rectangle?: true
Program has ended. Press enter to exit.