package lab2;

public class Matrix {
    private int row;
    private int column;
    private int[][] matrix; //hold values of matrix
    
    public Matrix(int row, int column){ //constructor 
	matrix = new int[row][column]; 
	this.row = row; 
	this.column = column; 
    }
    
    public int getRow(){
        return this.row;
    }
    
    public int getColumn(){
        return this.column;
    }
    
    public void setRowandColumn(int row, int column){
        this.row = row; //for storing the row size
	this.column = column;
    }
    
    public void setMatrix(int row, int column, int temp){
	this.matrix[row][column] = temp; //Assigns a postion at a particular row and column a particular value i.e. temp in this case
    }
    
    public int getValue(int row,int column){ 
	return 	this.matrix[row][column];
    }
    
    public int[][] getMatrix(){
	return this.matrix; //Assigns a postion at a particular row and column a particular value i.e. temp in this case
    }
    
    public void printMatrix(int row, int column){
	System.out.print(" " + this.matrix[row][column]);
    }
}
