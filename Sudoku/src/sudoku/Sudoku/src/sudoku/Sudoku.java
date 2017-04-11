
package sudoku;
import ejemploconjunto.*;
import java.util.ArrayList;
public class Sudoku {
    
   
    
    int sudoku [][]= {{0,2,9, 4,6,0, 7,5,3},
                      {5,3,1, 8,7,2, 9,6,4},
                      {7,6,4, 5,9,3, 1,2,8},
                      
                      {4,7,3, 6,2,0, 5,8,1},
                      {1,8,0, 0,0,5, 2,3,0},
                      {2,0,5, 1,0,8, 4,7,0},
                      
                      {9,0,0, 3,0,0, 8,0,2},
                      {6,5,2, 9,8,0, 3,0,7},
                      {3,0,8, 2,0,0, 6,0,5}};
    
    
    int res [][]= {{0,2,9, 4,6,0, 7,5,3},
                      {5,3,1, 8,7,2, 9,6,4},
                      {7,6,4, 5,9,3, 1,2,8},
                      
                      {4,7,3, 6,2,0, 5,8,1},
                      {1,8,0, 0,0,5, 2,3,0},
                      {2,0,5, 1,0,8, 4,7,0},
                      
                      {9,0,0, 3,0,0, 8,0,2},
                      {6,5,2, 9,8,0, 3,0,7},
                      {3,0,8, 2,0,0, 6,0,5}};

    ConjuntoA pos[][];
    ConjuntoA universo = new <Integer> ConjuntoA();
    
     Sudoku(){
         
        pos=new ConjuntoA[9][9];
        
        universo.agrega(1);
        universo.agrega(2);
        universo.agrega(3);
        universo.agrega(4);
        universo.agrega(5);
        universo.agrega(6);
        universo.agrega(7);
        universo.agrega(8);
        universo.agrega(9);
    }

    public int[][] getRes() {
        return res;
    }
     
    

    public static void main(String[] args) {
        Sudoku sol = new Sudoku();
        sol.sudokuSolver();
        int res [][]= sol.getRes();
        for(int i =0;i<9;i++){
            for(int j =0;j<9;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    public void sudokuSolver(){

        int i=0,j=0;
        boolean regreso=false;
        while(i<9){
                j=0;
            while(j<9){
                if(sudoku[i][j]==0){
                    posibilidades(i,j);
                    sudoku[i][j]=-1;
                    if(pos[i][j].getCardinalidad()!=0){
                        res[i][j]=(Integer)pos[i][j].quitaAleat();
                        j++;
                    }
                    else{
                        j--;
                        regreso=true;
                    }
                }
                else if(sudoku[i][j]==-1){
                    if(pos[i][j].getCardinalidad()!=0){
                        res[i][j]=(Integer)pos[i][j].quitaAleat();
                        regreso=false;
                        j++;
                    }
                    else{
                        sudoku[i][j]=0;
                        res[i][j]=0;
                        j--;
                    }
                }
                else{
                    if(regreso){
                        j--;
                    }
                    else{
                        j++;
                    }
                }
                if(j<0){
                    i--;
                    j=8;
                }   
            }
            i++;
        }
    }
    
    private void posibilidades(int i, int j){
        ConjuntoA res = (ConjuntoA)universo.diferencia(elementosRenglon(i)).diferencia(elementosColumna(j)).diferencia(elementosArea(i,j)); 
        pos[i][j]=res;
    }
    
    private ConjuntoA elementosRenglon(int i){
        ConjuntoA ren = new <Integer>ConjuntoA();
        for(int k=0;k<9;k++){
            if(res[i][k]!=0){
                ren.agrega(res[i][k]);
            }
        }
        return ren;
    }
    
    private ConjuntoA elementosColumna(int j){
        ConjuntoA col = new <Integer>ConjuntoA();
        for(int k=0;k<9;k++){
            if(res[k][j]!=0){
                col.agrega(res[k][j]);
            }
        }
        return col;
    }
    
    private ConjuntoA elementosArea(int i, int j){
        ConjuntoA area = new <Integer>ConjuntoA();
        int fR, fC;
        if(i<=2){
                fR=2;
            }
            else
                if(i<=5){
                    fR=5;
                }
                else
                    fR=8;//Debe estar validado

            if(j<=2){
                fC=2;
            }
            else
                if(j<=5){
                    fC=5;
                }
                else
                    fC=8;//Debe estar validado

            i=fR-2;
            j=fC-2;
            while(i<=fR){
                j=fC-2;
                while(j<=fC){
                    if(res[i][j]!=0){
                        area.agrega(res[i][j]);
                    }
                    j++;
                }
                i++;
            }
        return area;
    }

}
