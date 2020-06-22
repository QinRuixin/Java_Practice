package orther.fileDemo.csvDemo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author qin
 * @date 2020-06-12
 */
public class CsvDemo {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\10444\\Desktop\\1cats.csv");
        List<CatPO> cats = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
            CatPO cat = new CatPO();
//            String tempStory = "";
            String tempStr;
            int idx = 0;
            bufferedReader.readLine();
            while (bufferedReader.ready()){
                tempStr = bufferedReader.readLine();
//                System.out.println(tempStr);
                String[] strings = tempStr.split(",");
//                for (int i = 0; i < strings.length; i++) {
//                    System.out.println(strings[i]);
//                }
                cat.setId(Integer.valueOf(strings[0]));
                cat.setName(strings[1]);
                cat.setGender("男".equals(strings[2])?0:1);
                  cat.setYear("".equals(strings[3])?-1:
                          (strings[3].charAt(0)>='0'&&strings[3].charAt(0)<='9'?Integer.valueOf(strings[3]):Integer.valueOf("20"+strings[3].substring(strings[3].length()-2)))
                  );
//                cat.setYear(strings[3]==null?-1:2018);
                cat.setSterilization(0);  //10
                cat.setTemperament(strings[9]);
                cat.setAppearance(strings[10]);
                cat.setExperience(strings[11]);
                cat.setSituation(strings[12]+" "+strings[13]);
                if(strings.length>14){
                    cat.setAdvice(strings[14]);
                }else {
                    cat.setAdvice("无");
                }

                cat.printCat();

                ++idx;
//                if(idx>3)
//                    break;
            }
            String regEx = "((20[0-9]{2})-(0?[1-9]|1[0-2])-((0?[1-9])|([12][0-9])|30|31) ([0-9]|[12][0-9]):((0?[1-9])|([1-5][0-9])):((0?[1-9])|([1-5][0-9])))" +
                    " (.*)\\(.*\\)";
//    String regEx = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
            Pattern pattern = Pattern.compile(regEx);

//                int splitPoint = matcher.end();
//                String tempTime = tempTimeAndTeller.substring(0,splitPoint);
//                String tempTeller = tempTimeAndTeller.substring(splitPoint+1);
//                System.out.println(tempTimeAndTeller);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
