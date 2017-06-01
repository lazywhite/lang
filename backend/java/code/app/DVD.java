/*
 * dvd.java
 * copyright (c) 2017 white <white@whites-mac-air.local>
 *
 * Distributed under terms of the MIT license.
 */
import java.util.Date;
import java.util.Scanner;

public class DVD {
    /* 影片名称 */
    public static final String[] name = new String[10];
    /* * state    0: 未借出   1: 已借出 */
    public static final int[] state = new int[10];
    /* 借阅时间 */
    public static final int[] date= new int[10];
    /* 已借阅次数 */
    public static final int[] count = new int[10];
    public static Scanner sc;
    static{
        init();
    }
    public static void init(){
        name[0] = "泰坦尼克";
        state[0] = 0;
        date[0] = 1;
        count[0] = 1;
        name[1] = "人猿泰山";
        state[1] = 1;
        date[1] = 10;
        count[1] = 3;
        name[2] = "攻壳机动队";
        state[2] = 0;
        date[2] = 0;
        count[2] = 1;
        name[3] = "变形金刚5";
        state[3] = 0;
        date[3] = 0;
        count[3] = 1;
        name[4] = "复仇者联盟";
        state[4] = 1;
        date[4] = 5;
        count[4] = 11;
        sc = new Scanner(System.in);
    }
    public static void main(String[] args){

        System.out.println("欢迎访问DVD借阅系统, 请选择操作");
        while(true){
            System.out.println("1. 查看影片");
            System.out.println("2. 添加影片");
            System.out.println("3. 删除影片");
            System.out.println("4. 借阅影片");
            System.out.println("5. 归还影片");
            System.out.println("6. 退出系统");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    showInfo(name, state, date, count);
                    break;
                case 2:
                    addVideo(name, state, date, count);
                    break;
                case 3:
                    delVideo(name, state, date, count);
                    break;
                case 4:
                    loanVideo(name, state, date, count);
                    break; 
                case 5:
                    returnVideo(name, state, date, count);
                    break; 
                case 6:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
    public static void showInfo(String[] name, int[] state, int[] date, int[] count){
        System.out.println("==============影片信息====================");
        System.out.printf("%-16s%-16s%-16s%-16s", "影片名称","状态","借出日期","借出次数");
        System.out.println();
        for(int i=0;i<name.length;i++){
            if(name[i] != null){
                String s = state[i] == 0? "可借":"已借出";
                System.out.printf("%-16s%-16s%-16s%-16s\n", name[i], s, Integer.toString(date[i]), Integer.toString(count[i]));

            }
        }
        System.out.println("------------------------------------------");
    }
    public static void addVideo(String[] name, int[] state, int[] date, int[] count){
        while(true){
            System.out.println("输入影片名称");
            String n = sc.next();
            for(int i=0;i<name.length;i++){
                if(name[i] == null){
                    name[i] = n;
                    state[i] = 0;
                    date[i] = 0;
                    count[i] = 0;
                    break;
                }
            }
            System.out.println("添加成功!");
            System.out.println("继续添加吗?(Y/N)");
            String ctn = sc.next();
            if(ctn.equalsIgnoreCase("Y")){
                continue;
            }else{
                break;
            }
        }
    }
    public static void delVideo(String[] name, int[] state, int[] date, int[] count){
        while(true){
            System.out.println("输入影片名称");
            String n = sc.next();
            int index = -1;
            for(int i=0;i<name.length;i++){
                if(name[i] == null){
                    break;
                }
                if(name[i].equals(n)){
                    index = i;
                    break;
                }
            }
            if(index != -1){
                for(int i=index;i<name.length-1;i++){
                    name[i] = name[i+1];
                    state[i] = state[i+1];
                    date[i] = date[i+1];
                    count[i] = count[i+1];
                }
                name[name.length -1 ] = null;
                state[name.length -1 ] = 0;
                date[name.length -1 ] = 0;
                count[name.length -1 ] = 0;
                System.out.println("删除成功!");
            }else{
                System.out.println("没有找到记录!");
            }
            System.out.println("继续删除吗?(Y/N)");
            String ctn = sc.next();
            if(ctn.equalsIgnoreCase("Y")){
                continue;
            }else{
                break;
            }
        }
    }
    public static void loanVideo(String[] name, int[] state, int[] date, int[] count){
        while(true){
            System.out.println("输入影片名称");
            String n = sc.next();
            int index = -1;
            for(int i=0;i<name.length;i++){
                if(name[i] == null){
                    break;
                }
                if(name[i].equals(n)){
                    index = i;
                    break;
                }
            }
            if(index != -1){
                if(state[index] == 0){
                    System.out.println("请输入借阅时间");
                    int time = sc.nextInt();
                    state[index]  = 1;
                    date[index] = time;
                    count[index]+= 1;
                    System.out.println("借阅成功");
                }else{
                    System.out.println("影片已经被借阅了");
                }
            }else{
                System.out.println("没有找到记录!");
            }
            System.out.println("继续借吗?(Y/N)");
            String ctn = sc.next();
            if(ctn.equalsIgnoreCase("Y")){
                continue;
            }else{
                break;
            }
        }

    }
    public static void returnVideo(String[] name, int[] state, int[] date, int[] count){
        while(true){
            System.out.println("输入影片名称");
            String n = sc.next();
            int index = -1;
            for(int i=0;i<name.length;i++){
                if(name[i] == null){
                    break;
                }
                if(name[i].equals(n)){
                    index = i;
                    break;
                }
            }
            if(index != -1){
                if(state[index] == 1){
                    state[index]  = 0;
                    date[index] = 0;
                    System.out.println("归还成功");
                }else{
                    System.out.println("影片状态出错, 无法归还");
                }
            }else{
                System.out.println("没有找到影片");
            }
            System.out.println("继续归还吗?(Y/N)");
            String ctn = sc.next();
            if(ctn.equalsIgnoreCase("Y")){
                continue;
            }else{
                break;
            }
        }

    }
}

