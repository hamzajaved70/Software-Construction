package lab2;
import java.util.Random;
public class Multiply {
    public Matrix iterativeMultiply(Matrix m1, Matrix m2, int row1, int column1, int column){
        // The following function deals with the oterative multiplication
       int sum = 0; //For keeping the result obtained by multiplying two matrices
	   Multiply mul = new Multiply(); //For using print function
	   Matrix result = new Matrix(m1.getRow(),m1.getRow());
       for (int c = 0 ; c < row1 ; c++ )
       {
          for (int d = 0 ; d < column ; d++ )
          {   
             for (int k = 0 ; k < column1 ; k++ )
             {
                sum = sum + m1.getValue(c, k)* m2.getValue(k, d);
             }

             result.setMatrix(c, d, sum);
             sum = 0;
          }
       }	  
	   System.out.println("Result of Iterative is as below:");
	   mul.print(result, result.getRow(), result.getRow());
	   return result;
   }
    
    public Matrix populate(Matrix m1, int row, int column){ //Deals with populating the matrix with random numbers
	   int r1 = 0, col = 0; 
	   Random rand = new Random();
	   while(r1 < row){
		   while(col < column){
		   	int temp = rand.nextInt(50) + 1; //Matrix is assigned a number between 1 and 50
		   	m1.setMatrix(r1, col, temp); 
		   	col++;
		   }
		   col = 0;
		   r1++;  
	   }
	   return m1;
   }
    
    public void print(Matrix m1, int row, int col){ //Prints the matix
	   for(int i =0; i < row; i++ ){
		   System.out.println("");
		   for(int j = 0; j < col; j++ ){
			   m1.printMatrix(i,j); //Prints a gap and then the matrix
		   }
	   }
	   System.out.println("");
   }
    
}
