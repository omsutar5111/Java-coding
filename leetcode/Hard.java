package leetcode;

public class Hard {

    public static int trap(int[] height) {
        int n=height.length;
        int prefMax[]=new int[n];
        int suffMax[]=new int[n];
        prefMax[0]=height[0];
        suffMax[n-1]=height[n-1];
        for(int i=1;i<n;i++){

            prefMax[i]=Math.max(prefMax[i-1],height[i]);
        }
        for(int j=n-2;j>=0;j--){
            suffMax[j]=Math.max(suffMax[j+1],height[j]);
        }
        int rain=0;

        for(int i=1;i<=n-2;i++){
            int water =Math.min(prefMax[i-1],suffMax[i+1])-height[i];
            if(water>0){
                rain+=water;
            }
        }
        return rain;
    }


    public static void main(String[] args) {
       int[] height = {4,2,0,3,2,5};
        System.out.println(trap(height));
    }
}
