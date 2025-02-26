package Data_Structure_Algorithms.Graphs;

import java.util.*;

public class Graph3 {

    static class helper{
        int node;
        int distance;
        public helper(int node,int distance){
            this.node=node;
            this.distance=distance;
        }

        public int getNode() {
            return node;
        }

        public void setNode(int node) {
            this.node = node;
        }

        public int getdistance() {
            return distance;
        }

        public void setdistance(int distance) {
            this.distance = distance;
        }
    }

    static class Pair {
        int destination, weight;

        public Pair(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }


    //given N courses and their pre-requisite check it is possible to complete all courses

    //Topological sort
    public ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>>grapList){
        ArrayList<Integer>ans=new ArrayList<>();
      int nodes=grapList.size();
      int inorder[]=new int[nodes+1];
        Arrays.fill(inorder,0);
        for(int i=1;i<=nodes;i++){
            ArrayList<Integer>curr=grapList.get(i);
            for(int neigbour:curr){
                inorder[neigbour]++;
            }
        }
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for (int i=1;i<=nodes;i++){
            if(inorder[i]==0){
                queue.add(i);
            }
        }
        while (queue.size()>0){
            int i=queue.poll();
            ans.add(i);
            for(int neigh:grapList.get(i)){
                inorder[neigh]--;
                if(inorder[neigh]==0){
                    queue.add(neigh);
                }

            }

        }
        if (ans.size() != nodes) {
            return new ArrayList<>(); // Return an empty list if the graph has a cycle
        }

        return ans;
    }


    public static ArrayList<String> findAllRecipes(String[]recipes,ArrayList<ArrayList<String>>ingradients,String[]supplies){
        HashSet<String>available=new HashSet<>(Arrays.asList(supplies));
        HashMap<String,Integer>inorder=new HashMap<>();
        HashMap<String,ArrayList<String>>graph=new HashMap<>();
        ArrayList<String>ans=new ArrayList<>();
        for(int i=0;i<recipes.length;i++){
            inorder.put(recipes[i],ingradients.get(i).size());
         for(String ingradient:ingradients.get(i)){
             if (!graph.containsKey(ingradient)) {
                 // If the ingredient is not already a key in the map, initialize it with an empty ArrayList
                 graph.put(ingradient, new ArrayList<>());
             }
             graph.get(ingradient).add(recipes[i]);
         }
        }
        PriorityQueue<String>pq=new PriorityQueue<>();
        pq.addAll(available);
        while(!pq.isEmpty()){
            String current=pq.poll();
            if(inorder.containsKey(current)){
                ans.add(current);
            }
            if(graph.containsKey(current)){
                for(String dependent:graph.get(current)){
                    inorder.put(dependent,inorder.get(dependent)-1);
                    if(inorder.get(dependent)==0){
                        pq.add(dependent);
                }


                }
            }
        }

        return ans;
    }

    public  static ArrayList<Integer> Dijekstra(int A, ArrayList<ArrayList<Integer>> B, int C) {
       ArrayList<ArrayList<Pair>>pairList=new ArrayList<>();
       for(int i=0;i<=A;i++){
           pairList.add(new ArrayList<Pair>());
       }
       for(ArrayList<Integer>list:B){
           int source=list.get(0);
           int destination=list.get(1);
           int weight=list.get(2);
           pairList.get(destination).add(new Pair(source,weight));
           pairList.get(source).add(new Pair(destination,weight));
       }

        int ans[]=new int[A];
       Arrays.fill(ans,Integer.MAX_VALUE);
        PriorityQueue<helper>pq=new PriorityQueue<>(new Comparator<helper>() {
            @Override
            public int compare(helper o1, helper o2) {
                if(o1.distance<=o2.distance){
                    return -1;
                }
                return 1;
            }
        });

        pq.add(new helper(C,0));
        while(pq.size()>0){
            helper temp=pq.poll();
            int node=temp.node;
            int distance=temp.distance;
            if(ans[node]==Integer.MAX_VALUE){
                ans[node]=distance;
                for(Pair p:pairList.get(node)){
                   if(ans[p.destination]==Integer.MAX_VALUE){
                       pq.add(new helper(p.destination,p.weight+distance));
                   }
                }
            }
        }
        ArrayList<Integer>list=new ArrayList<>();
        for(int i=0;i<ans.length;i++){
            list.add(ans[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int A = 6;
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(Arrays.asList(0, 4, 9)));
        B.add(new ArrayList<>(Arrays.asList(3, 4, 6)));
        B.add(new ArrayList<>(Arrays.asList(1, 2, 1)));
        B.add(new ArrayList<>(Arrays.asList(2, 5, 1)));
        B.add(new ArrayList<>(Arrays.asList(2, 4, 5)));
        B.add(new ArrayList<>(Arrays.asList(0, 3, 7)));
        B.add(new ArrayList<>(Arrays.asList(0, 1, 1)));
        B.add(new ArrayList<>(Arrays.asList(4, 5, 7)));
        B.add(new ArrayList<>(Arrays.asList(0, 5, 1)));

        int C = 4;
       String[] recipes = {"bread","sandwich","burger"};

       ArrayList<ArrayList<String>>ingredients =new ArrayList<>();
       ingredients.add(new ArrayList<>(Arrays.asList("yeast","flour")));
        ingredients.add(new ArrayList<>(Arrays.asList("bread","meat")));
        ingredients.add(new ArrayList<>(Arrays.asList("sandwich","meat","bread")));
       String[]supplies = {"yeast","flour","meat"};
        System.out.println(findAllRecipes(recipes,ingredients,supplies));
//        System.out.println(Dijekstra(A,B,C));
    }
}
