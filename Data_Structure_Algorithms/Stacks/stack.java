package Data_Structure_Algorithms.Stacks;

import java.util.Stack;

public class stack {

    public static String RemoveConsecutives(Stack<Character> st,String str) {
        for(int i=0;i<str.length();i++){ 
            char ch=str.charAt(i);
            if(st.size()==0 ||st.peek()!=ch){
                st.push(ch);
               
            }
            
            else {
              st.pop();     
            }   
        }
        StringBuilder sb=new StringBuilder();
        while(st.size()!=0){
            char ch=st.pop();
            sb.append(ch);
        }
        int i=0,j=sb.length()-1;
        while(i<j){
            char ich=sb.charAt(i);
            char jch=sb.charAt(j);
            sb.setCharAt(i, jch);
            sb.setCharAt(j, ich);
            i++;
            j--;
        }
        return sb.toString();
    }
   


    public static boolean chkOperator(String var) {
        int len= var.length();
        char ch=var.charAt(0);
        if(len==1 && (ch=='+' || ch=='-'||ch=='*'|| ch=='/') ){
           return true;
        }
        else{
            return false;
        }
        
    }

    public static int calculate(int x,int y,char ch) {
        if(ch=='+'){
            return x+y;
        }
        else if(ch=='-'){
            return y-x;
        }
        else if(ch=='*'){
            return y*x;
        }
        else 
            return y/x;
        }

    public static int postFix(String[] str) {
        Stack<Integer> stk=new Stack<>();
      int N=str.length;
      for(int i=0;i<N;i++){
        String var=str[i];
        if (chkOperator(var)){
            int x=stk.pop();
            int y=stk.pop();
            char opr=var.charAt(0);
         int ans=calculate(x,y,opr);
         stk.push(ans);
        }
        else{
            int val=Integer.parseInt(var);
            stk.push(val);
        }
      }
       return stk.peek();
    }
   

    public static int[] prevSmaller(int[] A) {
            int [] ans=new int[A.length];
                ans[0]=-1;
                Stack <Integer> stk=new Stack<>();
                stk.push(A[0]);
                for(int i=1;i<A.length;i++){
                    while(stk.size()>0 && stk.peek()>=A[i]){
                       int var= stk.pop();
                    }
                    if(stk.size()==0){
                        ans[i]=-1;
                    }
                    else{
                        ans[i]=stk.peek();
                    }
                    stk.push(A[i]);
                }
                return ans;
    }

    public boolean validPranthesis(String S){
        Stack<Character>stk=new Stack<>();
        for(char c:S.toCharArray()){
            if(c=='('||c=='{'||c=='['){
                stk.push(c);
            }
            else {
                 if(stk.isEmpty()){
                     return false;
                 }
                 char top=stk.pop();
                 if((top!='}'&& c=='{')||(c=='('&&top!=')')||(c=='['&&top!=']')){
                     return false;
                 }
            }
        }
        return stk.isEmpty();
    }
   
   
    public static void main(String[] args) {
        // Stack<String>st=new Stack<>();
        // Stack<Character>S=new Stack<>();
        // String str="abcccddbghjjkhl";
        // st.push(str);
        // Stack <Integer> stk=new Stack<>();
        // stk.push(23);
        // stk.push(45);
        // stk.push(34);
        // stk.push(56);
        // stk.push(85);
        // stk.push(14);
        // System.out.println(stk);
        // while(stk.size()>0){
        //     System.out.print(stk.peek()+" ");
        //     stk.pop();
        // }
        // System.out.println(stk);
        // stk.pop();
        // System.out.println(stk);
        // stk.pop();
        // System.out.println(stk);
        //System.out.println(RemoveConsecutives(S, str));
   
        //String A[]={"2","3","+","3","*"};
       // System.out.println(postFix(A));

    //    int []B={34,35,27,42,5,28,39,20,28};
    //    int C[]=prevSmaller(B);
    //    for(int value :prevSmaller(C)){
    //     System.out.println(value);
    //    }

    
    }
}
