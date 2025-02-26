package Data_Structure_Algorithms.Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Graph {

    public static ArrayList<ArrayList<Integer>> createGraph(int nodes,int B[][]){
        int noOfNodes=nodes;
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=0;i<=noOfNodes;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<B.length;i++){
            list.get(B[i][0]).add(B[i][1]);
          list.get(B[i][1]).add(B[i][0]);
        }
        return  list;
    }

    //Prob 1 : Find Path Exist or not or directed Graph .
    public static boolean isPathExists(int B[][],int A){

        int TotalNodes= B.length;
        ArrayList<ArrayList<Integer>>list = new ArrayList<>();
        for(int i=0;i<=TotalNodes;i++){
            list.add(new ArrayList<Integer>());
        }
        boolean []isVisited=new boolean[TotalNodes+1];
        for(int i=0;i<TotalNodes;i++){
            int source=B[i][0];
            int destination= B[i][1];
            list.get(source).add(destination);
            // list.get(destination).add(source);
        }
        Queue<Integer> q=new ArrayDeque<>();
        q.add(1);
        isVisited[1]=true;
        while(!q.isEmpty()){
            int neighbour=q.poll();
            if(neighbour==A){
                return true;
            }
            for(int i=0;i<list.get(neighbour).size();i++){
                int neighbourNodes=list.get(neighbour).get(i);
                if(!isVisited[neighbourNodes]){
                    q.add(neighbourNodes);
                    isVisited[neighbourNodes]=true;
                }
            }
        }

        return false;
    }


    //Prob 2: Find Shortest path in undirected graph
    public static int shortestPath(int nodes,int B[][],int source, int destination){
        int noOfNodes=nodes;
        ArrayList<ArrayList<Integer>>list=createGraph(noOfNodes,B);
        boolean isVisited[]=new boolean[noOfNodes+1];
        int distance[]=new int[noOfNodes+1];
        Arrays.fill(distance, -1);
        ArrayDeque<Integer> q=new ArrayDeque<>();
        q.add(source);
        isVisited[source]=true;
        distance[source]=0;
        while(!q.isEmpty()){
            int neigbour=q.poll();
            for(int i=0;i<list.get(neigbour).size();i++){
                int neigbourChildrens=list.get(neigbour).get(i);
                if(!isVisited[neigbourChildrens]){
                    q.add(neigbourChildrens);
                     isVisited[neigbourChildrens]=true;
                     distance[neigbourChildrens]=1+distance[neigbour];
                }
            }
        }

        return distance[destination];

    }

    //prob 3 perform dfs
    public static void dfs(int a,boolean visited[],ArrayList<ArrayList<Integer>>list){
        System.out.println(a);
        visited[a]=true;
        for(int neighbour:list.get(a)){
            if(!visited[neighbour]){
                dfs(neighbour,visited,list);
            }
        }
    }
    public static void PrintDfs(int nodes,int B[][],int startNode){
        int noOfNodes=nodes;
        int ans=0;
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=0;i<=noOfNodes;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<B.length;i++){
            list.get(B[i][0]).add(B[i][1]);
            list.get(B[i][1]).add(B[i][0]);
        }
        boolean isVisited[]=new boolean[noOfNodes+1];
        dfs(startNode,isVisited,list);
        int connectedComponents = 0;

        // Iterate through all nodes
//        for (int i = 1; i <= nodes; i++) {
//            if (!isVisited[i]) {
//                // Start a DFS for each unvisited node
//                connectedComponents++;
//                dfs(i, isVisited, list);
//            }
//        }

//        System.out.println(connectedComponents + "connected components");



    }

    // Prob 4 Cycyle detation in directed graph
    public static boolean checkCycyle(int nodes,int B[][]){
       ArrayList<ArrayList<Integer>>list=createGraph(nodes,B);
        boolean isVisited[]=new boolean[nodes+1];
        boolean isPathVisited[]=new boolean[nodes+1];
        for(int i=1;i<=nodes;i++){
            if(!isVisited[i]){
            if(cycyleDfs(i,isVisited,isPathVisited,list)){
                return  true;
            }

            }
        }
        return false;
    }
    public static boolean cycyleDfs(int node,boolean[]visited,boolean[] isPathVisited,ArrayList<ArrayList<Integer>>list){
        visited[node]=true;
        isPathVisited[node]=true;
        for(int neighbour:list.get(node)){
            if(isPathVisited[neighbour]){
                return true;
            }
            if(!visited[neighbour]){
                if(cycyleDfs(neighbour,visited,isPathVisited,list)){
                    return true;
                }
            }
        }
        isPathVisited[node]=false;
        return false;
    }

    //  prob  5 check path exists from source to destination in directed graph
    public int solve(int[] A, int B,int C) {
        ArrayList<ArrayList<Integer>>list=createDirectetGraph(A);
        boolean visited[]=new boolean[A.length+1];
        visited[C]= true;
        boolean result=dfsForDirectedPathCheck(C,visited,list,B);
        return result ? 1 :0;


    }
    public  boolean dfsForDirectedPathCheck(int current,boolean visited[],ArrayList<ArrayList<Integer>>list,int target){
        if (current == target) {
            return true;
        }
        visited[current] = true;
        for (int neighbor : list.get(current)) {
            if (!visited[neighbor]) {
                if (dfsForDirectedPathCheck(neighbor, visited, list,target)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static  ArrayList<ArrayList<Integer>> createDirectetGraph(int A[]){
        int noOfNodes = A.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= noOfNodes; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 1; i < A.length; i++) {
            int from = A[i];
            int to = i + 1;
            list.get(from).add(to);
        }
        return list;
    }


    //////////////////////////////////////////////////////////////////




    public static void main(String[] args) {
        int B[][]={{1,2},{2,4},{4,1},{3,2},{4,5},{6,7},{7,8}};
        int BB[][]={{1,2},{1,3},{2,3},{2,5},{3,4},{4,2}};
        int A=1;
        int C=4;
        int nodes=8;
//        System.out.println(isPathExists(B, A));
//       System.out.println(shortestPath(nodes,B, A,C ));
//        PrintDfs(nodes,B,A);
//        System.out.println(checkCycyle(5,BB));// for checking this comment line 18
    }
    
}
