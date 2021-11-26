import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(method(s));
    }

    public static double method(String s){
        String[] strs = s.split("\\.");
        double f = 0;
        double l = 0;
        for(int i = 0 ; i < strs[0].length() ;i++){
            double tmp =  strs[0].charAt(i) - '0';
            f = f*10 + tmp;
        }
        for(int j = strs[1].length()-1 ; j >=0 ; j--){
            double tmp = strs[1].charAt(j) - '0';
            l = l/10 + tmp;
        }
        l /= 10;
        return f+l;
    }
}