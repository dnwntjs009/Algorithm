import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Node {
    String data;
    Node lt, rt;

    Node(String data) {
        this.data = data;
    }
}

public class Main {
    static HashMap<String, Node> nodeMap = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String root = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            nodeMap.putIfAbsent(root, new Node(root));
            Node rootNode = nodeMap.get(root);

            if (!left.equals(".")) {
                nodeMap.putIfAbsent(left, new Node(left));
                rootNode.lt = nodeMap.get(left);
            }

            if (!right.equals(".")) {
                nodeMap.putIfAbsent(right, new Node(right));
                rootNode.rt = nodeMap.get(right);
            }
        }

        Node root = nodeMap.get("A");
        preorder(root);
        sb.append("\n");
        inorder(root);
        sb.append("\n");
        postorder(root);

        System.out.println(sb);

    }

    static void preorder(Node node) {
        if (node == null) return;
        sb.append(node.data);
        preorder(node.lt);
        preorder(node.rt);
    }

    static void inorder(Node node) {
        if (node == null) return;
        inorder(node.lt);
        sb.append(node.data);
        inorder(node.rt);
    }

    static void postorder(Node node) {
        if (node == null) return;
        postorder(node.lt);
        postorder(node.rt);
        sb.append(node.data);
    }
}