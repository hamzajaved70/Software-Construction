
package lab2;
import java.util.Scanner;

public class Lab2 {

    
    public static void main(String[] args) {
        
        int count = 1;
	   int row = 0, row1 = 0, column1 = 0,column = 0,r1 = 0,col = 0,temp = 0;
	   Matrix m1 = null; //First matrix
	   Matrix m2 = null; //Second Matrix
	   Multiply mul = new Multiply(); //For utilizing the functions in this class
	   Scanner reader = new Scanner(System.in);
	   while(count < 3){
		   System.out.println("Enter the dimensions (row) of matrix: " + count);
		   row = reader.nextInt();
		   System.out.println("Enter the dimensions (column) of matrix: " + count);
		   column = reader.nextInt();
		   if(count == 1){ //First matix is set here
			   System.out.println("The first matrix is: ");
			   m1 = mul.populate(new Matrix(row,column), row, column);
			   mul.print(m1,m1.getRow(), m1.getRow());
		   }else{
			   if(count == 2){ //Second matrix is set here
				   r1 = 0; col = 0;
				   System.out.println("The second matrix is: ");
				   m2 = mul.populate(new Matrix(row,column), row, column);
				   mul.print(m2, m2.getRow(), m2.getRow());
			   }   
		   }
		   count++;
	   }  	   	
	   
	   mul.iterativeMultiply(m1, m2, m1.getRow(), m1.getRow(), m1.getRow());
    }
    
}
