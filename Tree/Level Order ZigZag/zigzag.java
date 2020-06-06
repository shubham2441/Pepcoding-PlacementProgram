import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

        Stack < Node > st = new Stack < > ();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }
                st.push(t);
            }
        }

        return root;
    }


  public static int size(Node node) {
    int s = 0;

    for (Node child : node.children) {
      s += size(child);
    }
    s += 1;

    return s;
  }

  public static int max(Node node) {
    int m = Integer.MIN_VALUE;

    for (Node child : node.children) {
      int cm = max(child);
      m = Math.max(m, cm);
    }
    m = Math.max(m, node.data);

    return m;
  }

  public static int height(Node node) {
    int h = -1;

    for (Node child : node.children) {
      int ch = height(child);
      h = Math.max(h, ch);
    }
    h += 1;

    return h;
  }

  public static void traversals(Node node){
    System.out.println("Node Pre " + node.data);

    for(Node child: node.children){
      System.out.println("Edge Pre " + node.data + "--" + child.data);
      traversals(child);
      System.out.println("Edge Post " + node.data + "--" + child.data);
    }

    System.out.println("Node Post " + node.data);
  }

  public static void levelOrderLinewiseZZQueue(Node node){
    // write your code here
    Queue <Node> queuePrint = new ArrayDeque <Node> ();
    Queue  <Node > queueOrder = new ArrayDeque<Node> ();
    //Stack <Node> stPrint = new Stack<Node>();
    Node mark = new Node();
    mark.data = Integer.MIN_VALUE;
    queueOrder.add(node);
    queuePrint.add(node);
    queueOrder.add(mark);
    int curLevel=1;
    while(queueOrder.size()>0){
        Node tempOrder = queueOrder.remove();
        if(tempOrder.data == Integer.MIN_VALUE){
            System.out.println();
            if(queueOrder.size()!=0){
                queueOrder.add(mark);
                curLevel++;
            }
        } else{
            Node tempPrint = queuePrint.remove();
            System.out.print(tempPrint.data+" ");
            for(int i=0;i<tempOrder.children.size();i++){
                Node child = tempOrder.children.get(i);
                queueOrder.add(child);
            }
            
            if((curLevel+1)%2==0){
                for(int i=tempOrder.children.size()-1;i>=0;i--){
                    Node child = tempOrder.children.get(i);
                    queuePrint.add(child);
                }
            }else{
                for(int i=0;i<tempOrder.children.size();i++){
                    Node child = tempOrder.children.get(i);
                    queuePrint.add(child);
                }
            }
        }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    levelOrderLinewiseZZ(root);
  }

}