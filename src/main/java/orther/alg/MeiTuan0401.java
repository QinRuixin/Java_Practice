package orther.alg;

import java.util.Scanner;

/**
 * @author qin
 * @description 美团面试题
 * @date 2021-04-01
 */
public class MeiTuan0401 {
//两个时间段[t1-t2],[t3-t4]，例[08:00-10:00],[09:00-11:00]求交集。

    static double start = 0;
    static double end = 0;

    static void getAns(double Astart, double Aend, double Bstart, double Bend) {
        // 8-10
        // 6-7  6-9  6-11
        // 9-10 9-11
        // 11-12
        if (Astart > Bstart) {
            if (Astart > Bend) {
                return;
            }
            start = Astart;
            end = Math.min(Aend, Bend);
            return;
        } else if (Astart < Bstart) {
            if (Aend < Bstart) {
                return;
            }
            start = Bstart;
            end = Math.min(Aend, Bend);
            return;
        } else {
            start = Astart;
            end = Math.min(Aend, Bend);
        }

    }

    static void setZero() {
        start = 0;
        end = 0;
    }

    static void testAns(double Astart, double Aend,
                        double Bstart, double Bend,
                        double expectS, double expectE) {
        getAns(Astart, Aend, Bstart, Bend);
        System.out.println(Math.abs(start - expectS) < 0.0000001 && Math.abs(end - expectE) < 0.0000001);
        setZero();
    }

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        testAns(8, 10, 6, 7, 0, 0);
        testAns(8, 10, 6, 9, 8, 9);
        // 6-7  6-9  6-11
        // 9-9.5 9-11
        // 11-12
        testAns(8, 10, 6, 11, 8, 10);
        testAns(8, 10, 9, 9.5, 9, 9.5);
        testAns(8, 10, 9, 11, 9, 10);
        testAns(8, 10, 11, 12, 0, 0);


    }
}

