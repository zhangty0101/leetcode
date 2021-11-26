package listAndTree.zigzagLevelOrder;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = readByChinese(100304);
        System.out.println(s);
    }
    public static String readByChinese(long num) {
        if(num == 0) {
            return "零";
        }

        List<String> chFormat = new ArrayList<>();//todo
        chFormat.add("");
        chFormat.add("十");
        chFormat.add("百");
        chFormat.add("千");
        chFormat.add("万");
        chFormat.add("十");
        chFormat.add("百");
        chFormat.add("千");
        chFormat.add("亿");
        chFormat.add("十");
        chFormat.add("百");
        chFormat.add("千");
        List<String> format = new ArrayList<>();//todo
        format.add("零");
        format.add("一");
        format.add("二");
        format.add("三");
        format.add("四");
        format.add("五");
        format.add("六");
        format.add("七");
        format.add("八");
        format.add("九");

        List<String> resList = new ArrayList<>();
        int cnt = 0;
        boolean flag = false;
        while(num>0) {
            int index = (int) num % 10;
            if(format.get(index).equals("零")) {
                if(!resList.get(resList.size()-1).equals("零")) {
                    resList.add(format.get(index));
                }
            } else {
                resList.add(format.get(index) + chFormat.get(cnt));
            }
            num = num / 10;
            cnt++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=resList.size()-1; i>=0; i--) {
            // todo 处理连续的零的情况
            sb.append(resList.get(i));
        }
        return sb.toString();
    }
}