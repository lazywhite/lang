public class Yanghui{
    public static void main(String[] args){ 
        gen(7);
    }
    public static void gen(int num){ 
        for(int i=1;i<=num;i++){
            for(int z=1;z<=num-i;z++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print(getByIndex(i, j) + " ");
            }
            System.out.println();
        }
    }
    public static int getByIndex(int x, int y){
        if (y == 1 || x == y){
            return 1;
        }else{
            return getByIndex(x -1, y-1) + getByIndex(x-1, y);
        }
    }
}
