package Data_Structure_Algorithms.Binary_Trees;



import java.util.*;

public class trees {
    static boolean flag = true;
    static int prev = Integer.MIN_VALUE;

    /**
     * Innertrees
     */
    public static class node {
        int data;
        node left;
        node right;

        node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "node [data=" + data + ", left=" + left + ", right=" + right + "]";
        }

    }

    public static boolean searchInBST(node root, int k) {
        if (root == null) {
            return false;
        }
        if (root.data == k) {
            return true;
        }
        if (root.data < k) {
            return searchInBST(root.right, k);
        }
        if (root.data > k) {
            return searchInBST(root.left, k);
        }
        return true;

    }

    public static node addNodeInBST(node root, int k) {
        if (root == null) {
            node newNode = new node(k);
            root = newNode;
            return root;
        }
        if (root.data != k) {
            if (root.data < k) {
                return addNodeInBST(root.right, k);
            }
            if (root.data > k) {
                return addNodeInBST(root.left, k);
            }
        }
        // traverse(root);
        return root;

    }

    public static boolean checkIfBST(node root) {
        isBST(root);
        return flag;
    }

    public static void isBST(node root) {
        if (root == null) {
            return;
        }
        isBST(root.left);
        if (root.data < prev) {
            flag = false;
            return;
        }

        if (root.data > prev) {
            prev = root.data;
        }
        isBST(root.right);
    }

    public static node  MirrorTree(node root){
        if(root==null){
            return null;
        }
        node temp=root.left;
        root.left=MirrorTree(root.right);
        root.right=MirrorTree(temp);
        return root;
    }

    public static void main(String[] args) {
        node n1 = new node(20);
        node n2 = new node(15);
        node n3 = new node(30);
        node n4 = new node(10);
        node n5 = new node(18);
        node n6 = new node(25);
        n1.left = n2;
        n2.left = n4;
        n2.right = n5;
        n1.right = n3;
        n3.left = n6;

        // System.out.println(n1);
        // traverse(n1);
        // System.out.println(height(n1));
        // System.out.println(searchInBST(n1, 25));
        // System.out.println(addNodeInBST(n1, 50));;
//        System.out.println(checkIfBST(n1));
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
              list=printLevelOrder(n1);
          for(int i=0;i<list.size();i++){
              ArrayList<Integer>list2=list.get(i);
              for(int j=0;j<list2.size();j++){
                  System.out.print(list2.get(j)+" ");
              }
              System.out.println();
          }
    }

    public static ArrayList<ArrayList<Integer>> printLevelOrder(node root) {
        ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
        Queue<node>q=new ArrayDeque<>();
        q.add(root);
        while(q.size()>0){
          ArrayList<Integer>row=new ArrayList<>();
         int size=q.size();
         for(int i=0;i<size;i++){
             node rem=q.remove();
             row.add(rem.data);
             if(rem.left!=null){
                 q.add(rem.left);
             }
             if(rem.right!=null){
                 q.add(rem.right);
             }
         }
         ans.add(row);
        }
        return ans;
    }

    static void traverse(node root) {

        if (root == null) {
            return;
        }

        traverse(root.left);
        System.out.println(root.data);
        traverse(root.right);

    }

    public static int size(node root) {
        if (root == null) {
            return 0;
        }
        int ls = size(root.left);
        int rs = size(root.right);
        return ls + rs + 1;
    }

    public static int sum(node root) {
        if (root == null) {
            return 0;
        }
        int ls = sum(root.left);
        int rs = sum(root.right);
        return ls + rs + root.data;
    }

    public static int height(node root) {
        if (root == null) {
            return -1;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }
}
