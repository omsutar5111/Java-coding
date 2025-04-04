package Data_Structure_Algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC_75 {

    public static List<Integer> asteroidCollision(int []asteroids){
        Stack<Integer>stk=new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            boolean destroyed=false;
            while(!stk.isEmpty()&&asteroids[i]<0 && stk.peek()>0){
                int top=stk.peek();
                if(Math.abs(asteroids[i])>top){
                    stk.pop();
                }
                else if(Math.abs(asteroids[i])>top){
                    stk.pop();
                    destroyed=true;
                    break;
                }
                else{
                    destroyed=true;
                    break;
                }
            }
                if(!destroyed){
                    stk.push(asteroids[i]);
                }
        }
        return new ArrayList<>(stk).reversed();
    }
    public static void main(String[] args) {

    }
}
