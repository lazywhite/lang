package app;
public class Drawing{
    public static void main(String[] args){
        /* 
         * 图形均为5行
         */
        //倒立三角
        for(int i=1;i<=5;i++){
            for(int j=1;j<i;j++){
                System.out.print(" ");
            }
            for(int k=9;k>=2*i-1;k--){
                System.out.print("*");
            }
            System.out.println();
        }
        //正立三角形
        for(int i=1;i<=5;i++){
            for(int j=1;j<=5-i;j++){
                System.out.print(" ");
            }
            for(int k=1;k<=2*i-1;k++){
                System.out.print("*");
            }
            System.out.println();
        }    
        //平行四边形
        for(int i=1;i<6;i++){
            for(int j=1;j<6-i;j++){ 
                System.out.print(" ");
            }
            for(int j=1;j<6;j++)
                System.out.print("*");
            System.out.println();
        }
        //乘法表
        for(int i=1;i<10;i++) {
            for(int j=1;j<=i;j++){
                String s = i + "*" + j + "=" + i * j;
                s = getFixSizeStr(s, 10);
                System.out.print(s);
            }
            System.out.println();
        }

    }
    public static String getFixSizeStr(String str, int len){
        StringBuilder strb = new StringBuilder();
        strb.append(str);
        while(strb.length() < len) {
            strb.append(" ");
        }
        return strb.toString();
    }
}
