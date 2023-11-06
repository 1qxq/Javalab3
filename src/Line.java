
public class Line {
    private String stroka;
    public Line(){
        this.stroka = "2 3 5 2 4 2 6 8 2 2 5";
    }
    public Line(String str){
        this.stroka = str;
    }
    public void EditStroka(){
        System.out.println( "Задание 1:");
        String[] StringArray = this.stroka.split(" ");
        int[] IntMassive = new int[StringArray.length];
        for( int g = 0; g < StringArray.length; g++){
            System.out.print( StringArray[g] + ", ");
            IntMassive[g] = Integer.parseInt(StringArray[g]);
        }
        int schet = 1;
        int flag = 0;
        int value = 0;
        int output = 0;
        for (int h = 0; h< IntMassive.length; h++){
            schet = 0;
            for( int y = 0; y < IntMassive.length; y++){
                if( IntMassive[h] == IntMassive[y] ){
                    value = IntMassive[h];
                    schet++;
                }
            }
            if( schet > flag ){
                flag = schet;
                output = value;
            }
        }
        System.out.println("\n");
        System.out.println( "Чаще всего встречается: " + output +"\n");
        System.out.println( "Кол-во раз: " + flag +"\n");
    }
}
