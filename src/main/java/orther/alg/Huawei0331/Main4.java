package orther.alg.Huawei0331;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            int tmpNum = 0;
            if (curChar >= '0' && curChar <= '9' ){
                while (curChar >= '0' && curChar <= '9') {
                    tmpNum = tmpNum * 10 + (curChar - '0');
                    i++;
                    curChar = s.charAt(i);
                }
                list.add(tmpNum);
            }
        }
        Collections.sort(list);
        int res = 0;
        if(list.size()==0){
            System.out.println(res);
            return;
        }
        int curLastIdx = 0;
        int curP = list.get(curLastIdx);

        boolean notDo = true;
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i).equals(list.get(curLastIdx))){
                int cnt = 2;
                i++;
                while (i<list.size() && list.get(i).equals(list.get(curLastIdx)) ){
                    cnt++;
                    i++;
                }
                int tmpRes = (curP + cnt) / (curP + 1) * (curP + 1);
                res += tmpRes;
                notDo = false;
            }else{
                res += list.get(curLastIdx)+1;
                notDo = true;
            }
            curLastIdx = i;
            if(curLastIdx<list.size()){
                curP = list.get(curLastIdx);
            }
        }
        if(curLastIdx<list.size()){
            res += list.get(curLastIdx)+1;
        }
        System.out.println(res);
    }
}

// [1, 1, 2]  [1, 1, 2, 2, 2, 3, 3, 3, 3]