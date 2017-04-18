/**
 * @authors Diana Virginia Hernández Mejía , Cuauhtémoc Gonzalo Zamarripa Armida, 
 * Víctor Cuauhtémoc Vargas Ramírez, Marco Antonio Chacón Amaro  y 
 * Susana Muñoz Acosta 
 */
public class SudokuAuxM {
    /**
     * Atributos
     */
    int sudoku [][];
    int res [][];
    ConjuntoA pos[][];
    ConjuntoA universo;
    /**
     *Constructor por omision
     */
    public SudokuAuxM() {
    }
    /**
     *Constructor completo
     * @param sudoku[][] int matriz
     * @param res[][] int matriz
     */
    public SudokuAuxM(int sudoku[][], int res[][]){
        this.sudoku=sudoku;
        this.res=res;
        pos=new ConjuntoA[9][9];
        universo = new <Integer> ConjuntoA();
        //Se agregan los numeros pertenecientes al conjunto universo
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
    /**
     *Metodo: Obtener respuesta
     * @return int matriz de respuesta
     */
    public int[][] getRes() {
        return res;
    }
    /**
     *Metodo: Resolver soduko con iterator
     */
    public void sudokuSolver(){
        int i=0,j=0;
        boolean regreso=false;
        while(i<9){                
            while(-1<j&&j<9){
                //System.out.println(i+" "+j+regreso);
                if(sudoku[i][j]==0){
                    pos[i][j]=posibilidades(i,j);
                    if(pos[i][j].getCardinalidad()!=0){
                        res[i][j]=(Integer)pos[i][j].quitaAleat();
                        sudoku[i][j]=-1;
                        j++;
                    }
                    else{
                        regreso=true;
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
                   
            }
            if(j<0){
                i--;
                j=8;
            }
            else{
                i++;
                j=0;
            }
        }
    }
    /**
     * Metodo publico: Resolver Sudoku de forma recursiva
     * Este metodo llamara al metodo privado
     */
    public void sudokuSolverR(){
        sudokuSolver(0,0,false);
    }
   /**
    * Metodo privado: Resolver Sudoku de forma recursiva
    * @param i int
    * @param j int
    * @param regreso boolean
    */
    private void sudokuSolver(int i, int j, boolean regreso){
        if(i<9){
            if(j<9){
                if(sudoku[i][j]==0){
                    pos[i][j]=posibilidades(i,j);
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
    /**
     * Metodo: Posibildades, calcula los posibles valores de numeros en la casilla
     * @param i int 
     * @param j int
     * @return ConjuntoA de todas las posibilidades de una casilla
     */
    private ConjuntoA<Integer> posibilidades(int i, int j){
        ConjuntoA res = (ConjuntoA)universo.diferencia(elementosRenglon(i)).diferencia(elementosColumna(j)).diferencia(elementosArea(i,j)); 
        return res;
    }
    /**
     * Metoodo: Elementos Renglón
     * @param i int
     * @return ConjuntoA de todos los elementos de cierto renglon
     */
    private ConjuntoA elementosRenglon(int i){
        ConjuntoA ren = new <Integer>ConjuntoA();
        for(int k=0;k<9;k++){
            if(res[i][k]!=0){
                ren.agrega(res[i][k]);
            }
        }
        return ren;
    }
    /**
     * Metoodo: Elementos Columna
     * @param j int
     * @return ConjuntoA de todos los elementos de cierta columna
     */
    private ConjuntoA elementosColumna(int j){
        ConjuntoA col = new <Integer>ConjuntoA();
        for(int k=0;k<9;k++){
            if(res[k][j]!=0){
                col.agrega(res[k][j]);
            }
        }
        return col;
    }
    /**
     * Metoodo: Elementos por cierta Area
     * @param i int
     * @param j int
     * @return ConjuntoA con los elementos de cierta area 
     */
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
