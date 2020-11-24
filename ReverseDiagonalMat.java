
public class ReverseDiagonalMat {

	public static void main(String[] args) {
        int [][] a = {{ 1, 2, 3, 4},
                      { 5, 6, 7, 8},
                      { 9,10,11,12},
                      {13,14,15,16}};
        int a1[][]= {{1,2,3},
                     {4,5,6},
                     {7,8,9}};
        int a2[][]= {{1,2},
                     {3,4}};
        int [][] a3 = {{ 1, 2, 3, 4, 5},
                       { 6, 7, 8, 9,10},
                       {11,12,13,14,15},
                       {16,17,18,19,20},
                       {21,22,23,24,25}};
        System.out.println("==========5x5==============");
        findReverseDiagonalOrder(a3);
        System.out.println("==========4x4==============");
        findReverseDiagonalOrder(a);
        System.out.println("===========3x3=============");
        findReverseDiagonalOrder(a1);
        System.out.println("===========2x2=============");
        findReverseDiagonalOrder(a2);
    }

    public static void findReverseDiagonalOrder(int[][] a) {
        int m = a.length;

        int row=0;
        int col = m-1;

        for(int i=0;i<m*m;i++) {
            System.out.println(a[row][col]);
            if(col==m-1) {
                if(row==0)
                    col--;
                else {
                    col= (row==col)? 0:col-(row+1);
                    row= (row==m-1)? 1:0;
                }
            }
            else if(row==m-1) {
                if(col-1==0 && col>0)
                col--;
                else {
                    row = m-col;
                    col=0;
                }

            }
            else {
                row++;
                col++;
            }
        }
    } 
}
