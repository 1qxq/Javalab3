import java.util.Random;
import java.util.Arrays;
public class Matrix {
    private String massive;
    private int size1;
    private int size2;
    private int size3;
    private int size4;
    private double[][]Matrix;
    private int[][]Mass;

    public  Matrix ()
    {
        this.size1 = 3;
        this.size2 = 3;
        this.size3 = 3;
        this.size4 = 3;
        this.massive = "dfs sdf sdf sdf sdf sdfsdf fd df f sdd";
        this.Matrix = new double[this.size2][this.size3];
        this.Mass = new int[this.size4][this.size4];
        this.RandomValue();
    }
    public  Matrix (int size, String massive, int size2, int size3, int size4, double[][] Matrix, int[][] Mass)
    {
        this.size1 = size;
        this.massive = massive;
        this.size2= size2;
        this.size3 = size3;
        this.size4 = size4;
        this.Matrix = Matrix;
        this.Mass = Mass;

    }
    public void SpiralMatrix(){
        String[] StringArray = this.massive.split(" ");
        int s = 1;
        int h = 0;
        int height = this.size1;
        String[][] array = new String[height][height];
        for( int r = 0; r< height; r++){
            for( int d = 0; d< height; d++) {
                array[r][d] = "1";
            }
        }
        //Заполняем периметр массива по часовой стрелке.
        for (int y = 0; y < height; y++) {
            if( s <= StringArray.length ){
                array[0][y] = StringArray[h];
                s++;
                h++;
            }else {
                array[0][y] = "0";
                s++;
                h++;
            }
        }
        for (int x = 1; x < height; x++) {
            if( s <= StringArray.length ){
                array[x][height - 1] = StringArray[h];
                s++;
                h++;
            }else{
                array[x][height - 1] = "0";
                s++;
                h++;
            }
        }
        for (int y = height - 2; y >= 0; y--) {
            if( s <= StringArray.length ){
                array[height - 1][y] = StringArray[h];
                s++;
                h++;
            }else{
                array[height - 1][y] = "0";
                s++;
                h++;
            }
        }
        for (int x = height - 2; x > 0; x--) {
            if( s <= StringArray.length ){
                array[x][0] = StringArray[h];
                s++;
                h++;
            }else{
                array[x][0] = "0";
                s++;
                h++;
            }
        }

        //Периметр заполнен. Продолжаем заполнять массив и задаём
        //координаты ячейки, которую необходимо заполнить следующей.
        int c = 1;
        int d = 1;
        //s++;
        while (s < height * height) {

            //Движемся вправо.
            while (array[c][d + 1] == "1") {
                if( s <= StringArray.length ) {
                    array[c][d] = StringArray[h];
                    s++;
                    d++;
                    h++;
                }else{
                    array[c][d] = "0";
                    s++;
                    d++;
                    h++;
                }
            }

            //Движемся вниз.
            while (array[c + 1][d] == "1") {
                if( s <= StringArray.length ) {
                    array[c][d] = StringArray[h];
                    s++;
                    c++;
                    h++;
                }else{
                    array[c][d] = "0";
                    s++;
                    c++;
                    h++;
                }
            }

            //Движемся влево.
            while (array[c][d - 1] == "1") {
                if( s <= StringArray.length ) {
                    array[c][d] = StringArray[h];
                    s++;
                    d--;
                    h++;
                }else{
                    array[c][d] = "0";
                    s++;
                    d--;
                    h++;
                }
            }

            //Движемся вверх.
            while (array[c - 1][d] == "1") {
                if( s <= StringArray.length ) {
                    array[c][d] = StringArray[h];
                    s++;
                    c--;
                    h++;
                }else{
                    array[c][d] = "0";
                    s++;
                    c--;
                    h++;
                }
            }
        }

        //При данном решении в центре всегда остаётся незаполненная ячейка.
        //Убираем её при помощи следующего цикла.
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < height; y++) {
                if (array[x][y] == "1") {
                    if( s <= StringArray.length ) {
                        array[x][y] = StringArray[h];
                    }else{
                        array[x][y] = "0";
                    }
                }
            }
        }
        System.out.println( "Задание 2:");
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < height; y++) {
                if (array[x][y].length() < 2) {
                    System.out.print(array[x][y] + ",  ");
                } else {
                    System.out.print(array[x][y] + ", ");
                }
            }
            System.out.println("");
        }
    }

    public void AvgMatrix(){
        float summ = 0;
        float schet = 0;
        for (int x = 0; x < this.size2; x++) {
            for (int y = 0; y < this.size3; y++) {
                if( this.Matrix[x][y] < 0 ){
                    summ += this.Matrix[x][y];
                    schet++;
                }
            }
        }
        float Result = 0;
        Result = summ/schet;
        System.out.print( "\n");
        System.out.println( "Задание 3:");
        if( summ == 0){
            System.out.print("В матрице нет отрицательных значений");
        }else{
            System.out.print("Среднее арифметической отрицательных значений матрицы: " + Result);
        }
    }
    public void DiagonalMatrix(){
        System.out.print( "\n");
        System.out.print( "Задание 4:");
        System.out.print( "\n");
        for (int x = 0; x < this.size4; x++) {
            for (int y = 0; y < this.size4; y++) {
                if (this.Mass[x][y] < 10) {
                    System.out.print(this.Mass[x][y] + ",  ");
                } else {
                    System.out.print(this.Mass[x][y] + ", ");
                }
            }
            System.out.println("");
        }
        String StringElements = new String();
        for (int i = 0; i < (Math.min(this.Mass[0].length, this.Mass.length)); i++) {
            StringElements += Integer.toString(this.Mass[i][this.Mass[0].length-i-1]) + " ";
        }
        System.out.print( "\n");
        System.out.print(StringElements);
    }
    public void RandomValue()
    {
        Random r = new Random();
        for(int i =0; i < this.size2; i++)
        {
            for (int j =0; j< this.size3;j ++) {
                this.Matrix[i][j] = r.nextDouble(10) - 5;
            }
        }
        for(int i =0; i < this.size4; i++)
        {
            for (int j =0; j< this.size4;j ++) {
                this.Mass[i][j] = r.nextInt(10) - 5;
            }
        }
    }
}
