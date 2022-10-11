package 面试;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node{
    int val;
    int val_use;
    Map<Integer, Character> char_use;
    List<Node> next;

    public Node(int val){
        this.val = val;
        this.next = new ArrayList<>();
        this.char_use = new HashMap<>();
    }
}
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node root = new Node(1);
        Map<Integer, Node> node_map = new HashMap<Integer, Node>();
        node_map.put(1, root);
        for(int i=1; i<n; ++i){
            int u = sc.nextInt();
            int v = sc.nextInt();
            if(u > v){
                u += v;
                v = u - v;
                u = u - v;
            }
            Node p = node_map.get(u);
            Node s = node_map.get(v);
            if(p == null){
                p = new Node(u);
                node_map.put(u, p);
            }
            if(s == null){
                s = new Node(v);
                node_map.put(v, s);
            }
            p.next.add(s);
        }
        visit(root);
        Map<Integer, Character> val_map = root.char_use;

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; ++i){
            sb.append(val_map.get(i));
        }
        System.out.print(sb.toString());
    }

    public static void visit(Node root){
        if(root.next.size() == 0){
            root.val_use = 1;
            root.char_use.put(root.val, 'B');
            return;
        }

        int sum = 0;
        Map<Integer, Character> val_map = new HashMap<>();
        for(int i=0; i<root.next.size(); ++i){
            visit(root.next.get(i));
            sum += root.next.get(i).val_use;
            val_map.putAll(root.next.get(i).char_use);
        }
        if((sum&1) == 1){
            val_map.put(root.val, 'R');
        }else{
            val_map.put(root.val, 'B');
            sum++;
        }
        root.val_use = sum;
        root.char_use = val_map;
    }
}
