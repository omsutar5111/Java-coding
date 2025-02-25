package DSA.Advanced_Dsa.Graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class Graph2 {
    //problem RotteN Oranges

    public class  Pair{


         int x;
        int y;
        int t;
        public Pair(int x, int y,int t){
            this.x=x;
            this.y=y;
            this.t=t;
        }
        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    public  int RottenOranges(int [][] mat){
        Queue<Pair> queue=new ArrayDeque<>();
        int countOnes=0;
        int [] xx={0,1,0,-1};
        int []yy={1,0,-1,0};
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==2){
                    queue.add(new Pair(i,j,0));
                }
                else if(mat[i][j]!=0){
                    countOnes++;
                }
            }
        }
        int time = 0;
         while (!queue.isEmpty()){
             Pair p=queue.poll();
             int x=p.getX();
             int y=p.getY();
             int t= p.t;
             time=Math.max(t,time);
             for(int k=0;k<4;k++){
                 int r=x+xx[k];
                 int c=y+yy[k];
                 if( r>=0 && r<mat.length && c>=0 && c<mat[0].length && mat[r][c]==1){
                     mat[r][c]=2;
                     countOnes--;
                     queue.add(new Pair(r,c,time+1));

                 }
             }


         }
        if(countOnes == 0){
            return time;
        }
        return -1;
    }

///Find number of  Islands
     public int island(int [][]A){
        int N=A.length,M=A[0].length;
        int ans=0;
        boolean[][]visited=new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j]&&A[i][j]==1){
                    ans++;
                    DFS(i,j,A,visited,N,M);
                }
            }
        }
        return ans;
     }

     public void DFS(int x,int y,int[] []A,boolean[][]visited,int N,int M){
        visited[x][y]=true;
        for(int dx=-1;dx<=1;dx++){
            for(int dy=-1;dy<=1;dy++){
                int newX=x+dx,newY=y+dy;
                if(newX==0&& newY==0){
                    continue;
                }
                if(newX>=0 && newY>=0 && newX<N && newY<M && !visited[newX][newY] && A[newX][newY]==1){
                   DFS(newX,newY,A,visited,N,M);
                }
            }
        }
     }


     //

    public static void main(String[] args) {
        Graph graph=new Graph();

    }
}
