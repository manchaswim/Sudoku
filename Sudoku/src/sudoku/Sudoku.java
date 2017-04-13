
package sudoku;
import ejemploconjunto.*;
import java.util.ArrayList;
public class Sudoku{
    
    public static void main(String[] args) {
        int sudoku[][]={{0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},};
        
        int res[][]={{0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},
                        {0,0,0, 0,0,0, 0,0,0},};
        Sudoku solver = new Sudoku(sudoku, res);
        solver.sudokuSolver();
        int ans[][]=solver.getRes();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    int sudoku [][];
    int res [][];

    ConjuntoA pos[][];
    ConjuntoA universo;
    
     Sudoku(int sudoku[][], int res[][]){
         
        this.sudoku=sudoku;
        this.res=res;
         
        pos=new ConjuntoA[9][9];
        universo = new <Integer> ConjuntoA();
        
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
     
    //Este metodo es la versión iterativa, no lo borren por si el recursivo falla
    //De aquï podemos corrgir errores
    public void sudokuSolverIterative(){

        int i=0,j=0;
        boolean regreso=false;
        while(i<9){
                j=0;
                
            while(j<9){
                //System.out.println(i+" "+j+regreso);
                if(sudoku[i][j]==0){
                    posibilidades(i,j);
                    sudoku[i][j]=-1;
                    if(pos[i][j].getCardinalidad()!=0){
                        res[i][j]=(Integer)pos[i][j].quitaAleat();
                        j++;
                    }
                    else{
                        regreso=true;
                        sudoku[i][j]=0;
                        res[i][j]=0;
                        j--;
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
    
    public void sudokuSolver(){//metodo que llama al recursivo
        sudokuSolver(0,0,false);
    }
    
    private void sudokuSolver(int i, int j, boolean regreso){//metodo que resuelve el sudoku
        if(i<9){
            if(j<9){
                if(sudoku[i][j]==0){
                    posibilidades(i,j);
                    sudoku[i][j]=-1;
                    if(pos[i][j].getCardinalidad()!=0){
                        res[i][j]=(Integer)pos[i][j].quitaAleat();
                        j++;
                    }
                    else{
                        sudoku[i][j]=0;
                        res[i][j]=0;
                        regreso=true;
                        j--;
                    }
                }
                else{ if(sudoku[i][j]==-1){
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
                }
                if(j<0){
                    j=8;
                    i--;
                }
                sudokuSolver(i,j,regreso);
            }
            else
                sudokuSolver(i+1,0,regreso);
        }
    }
    
    private void posibilidades(int i, int j){//Calcula los posibles valores de numeros en una casilla
        ConjuntoA res = (ConjuntoA)universo.diferencia(elementosRenglon(i)).diferencia(elementosColumna(j)).diferencia(elementosArea(i,j)); 
        pos[i][j]=res;
    }
    
    private ConjuntoA elementosRenglon(int i){//agrega a un conjunto todos los elementos de un cierto renglón
        ConjuntoA ren = new <Integer>ConjuntoA();
        for(int k=0;k<9;k++){
            if(res[i][k]!=0){
                ren.agrega(res[i][k]);
            }
        }
        return ren;
    }
    
    private ConjuntoA elementosColumna(int j){//agrega a un conjunto todos los elementos de una cierta columna
        ConjuntoA col = new <Integer>ConjuntoA();
        for(int k=0;k<9;k++){
            if(res[k][j]!=0){
                col.agrega(res[k][j]);
            }
        }
        return col;
    }
    
    private ConjuntoA elementosArea(int i, int j){//agrega a un conjunto los elementos de una cierta area.
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
                    fR=8;

            if(j<=2){
                fC=2;
            }
            else
                if(j<=5){
                    fC=5;
                }
                else
                    fC=8;

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
