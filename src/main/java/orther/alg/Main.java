package orther.alg;

import java.util.*;

class State{
    int m;
    double omg;
    double m_x_omg;
    State(int m, double omg, double m_x_omg){
        this.m = m;
        this.omg = omg;
        this.m_x_omg = m_x_omg;
    }
    void printState(){
        System.out.println(String.format("%d %.5f",m , omg));
    }
    State addState(int m2, double omg2){
        double total_m_x_omg = m_x_omg + m2*omg2;
        int total_m = m + m2;
        return new State(total_m, total_m_x_omg/total_m, total_m_x_omg);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m0 = sc.nextInt();
        double omg0 = sc.nextInt();
        int n = sc.nextInt();
        Stack<State> stateStack = new Stack<>();
//        State lastState = new State(m0, omg0, m0*omg0);
        stateStack.push(new State(m0, omg0, m0*omg0));
        sc.nextLine();
        for (int i = 0; i < n; i++) {
//            System.out.println(1);
            String command = sc.nextLine();
            if(command.charAt(0)=='B'){
                State curState = stateStack.pop();
                if(stateStack.empty()){
                    stateStack.push(curState);
                }
                curState = stateStack.peek();
                curState.printState();
            }else {
                int numIdx = 2;
                while (command.charAt(numIdx)!=' '){
                    ++numIdx;
                }
                int m1 = Integer.valueOf(command.substring(2,numIdx));
                double omg1 = Integer.valueOf(command.substring(numIdx+1));
                State lastState = stateStack.peek();
                State curState = lastState.addState(m1,omg1);
                curState.printState();
                stateStack.push(curState);
            }
        }
    }
}
