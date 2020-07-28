import java.util.*; 

public class Graph{
    private HashMap<Integer, Node> hm = new HashMap();

    public static class Node{
        private int id;
        LinkedList<Node> adj = new LinkedList();

        private Node(int id){
            this.id = id;
        }
    }
    private Node getNode(int id){ 
        return hm.get(id); 
    }


    public void addEdge(int source, int dest){
        Node s = getNode(source);
        Node d = getNode(dest);
        s.adj.add(d);
    }
    public boolean dfs(int source, int dest){
        Node s = getNode(source);
        Node d = getNode(dest);
        HashSet<Integer> visited = new HashSet();
        
        return hasPath(s,d,visited);
    }
    
    public boolean hasPath(Node s, Node d, HashSet<Integer> visited){
        if(visited.contains(s.id))return false;

        visited.add(s.id);
        if(s == d){
            return true;
        }
        for(Node c : s.adj){
            if(hasPath(c,d,visited)) return true;
        }
        return false;
    }
}