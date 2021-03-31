package orther.alg.Huawei0331;

import java.util.*;

/**
 * @author qin
 * @description 华为笔试
 * @date 2021-03-31
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String curStr;
        HashMap<Character, Integer> teamMap = new HashMap<>();
        while (sc.hasNext()){
            curStr = sc.nextLine();
            if(curStr.length()<2){
                break;
            }
            char team1 = curStr.charAt(0);
            char team2 = curStr.charAt(2);
            if(!teamMap.containsKey(team1)){
                teamMap.put(team1,0);
            }
            if(!teamMap.containsKey(team2)){
                teamMap.put(team2,0);
            }
            char score1 = curStr.charAt(4);
            char score2 = curStr.charAt(6);
            if(score1 > score2){
//                Integer curTeamScore1 = teamMap.getOrDefault(team1, 0);
                Integer curTeamScore1 = teamMap.get(team1);
                teamMap.put(team1, curTeamScore1+3);
            }else if(score1 < score2){
                Integer curTeamScore2 = teamMap.get(team2);
                teamMap.put(team2, curTeamScore2+3);
            }else{
                Integer curTeamScore1 = teamMap.get(team1);
                teamMap.put(team1, curTeamScore1+1);
                Integer curTeamScore2 = teamMap.get(team2);
                teamMap.put(team2, curTeamScore2+1);
            }
        }
        TreeMap<Character, Integer> sortedMap = new TreeMap<>();
        ArrayList<Character> list = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            if(teamMap.containsKey(c)){
                list.add(c);
            }
        }
        list.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if(teamMap.get(o1).equals(teamMap.get(o2))){
                    return o2-o1;
                }
                return teamMap.get(o1)-teamMap.get(o2);
            }
        });
        for (int i = list.size()-1; i >=0 ; i--) {
            System.out.print( list.get(i)+" "+teamMap.get(list.get(i)) );
            if(i!=0){
                System.out.print(",");
            }
        }

    }
}

/**
a-b 3:0
a-c 2:1
b-a 3:1
c-a 2:1
b-c 4:3
c-b 4:2

 */