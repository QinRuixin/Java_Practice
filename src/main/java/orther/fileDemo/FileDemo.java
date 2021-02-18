package orther.fileDemo;

import java.io.*;

/**
 * @author qin
 * @date 2020-05-27
 */
public class FileDemo {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\10444\\Desktop\\＋＋日谈.txt");
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String tempTimeAndTeller="2020-05-22 22:00:00";
//            String tempStory = "";
            String tempStr;
            while ((tempStr = bufferedReader.readLine()) != null) {
                if (tempStr.length() < 4) {
                    continue;
                }
                if (tempStr.substring(0, 4).equals("2020")) {
                    tempTimeAndTeller = tempStr;
                    continue;
                }
                if(tempStr.length()<50){
                    continue;
                }
                String tempTime = tempTimeAndTeller.substring(0,19);
                String tempTeller = tempTimeAndTeller.substring(20);
                if(tempTeller.equals("(80000000)")){
                    System.out.println("匿名");
                }else {
                    int endIdx = tempTeller.indexOf('(');
                    System.out.println(tempTeller.substring(0,endIdx));
                }
                System.out.println(tempTime);
                System.out.println(tempStr);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
