import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

public class NoOfPaths {

    static HashMap<Character, Vertex> graph;
    static HashSet<Vertex> visited;
    static Stack<Vertex> topologicalOrder;
    static Stack<Vertex> tempStack;

    // creating vertices
    public static HashMap<Character, Vertex> createVertices(HashMap<Character, Vertex> graph, char[] listOfVertices){
        for(char c : listOfVertices){
            graph.put(c, new Vertex(c));
        }
        return graph;
    }

    // adding edges to the graph
    public static HashMap<Character, Vertex> addEdge(HashMap<Character, Vertex> graph, char vertex1, char vertex2){
        graph.get(vertex1).neighbours.add(graph.get(vertex2));
        return graph;
    }

    public static Stack<Vertex> topologicalSort(){
        for(char c : graph.keySet()){
            if (!visited.contains(graph.get(c))){
                tempStack.push(graph.get(c));
            }
        }

        while(!tempStack.isEmpty()){

        }
        return topologicalOrder;
    }

    public static void main(String[] args){
        visited = new HashSet<Vertex>();
        topologicalOrder = new Stack<Vertex>();
        tempStack = new Stack<Vertex>();

        graph = new HashMap<Character, Vertex>();

        char[] listOfVertices = {'u', 'v', 'w', 'x', 'y', 'z'};
        graph = createVertices(graph, listOfVertices);

        graph = addEdge(graph, 'u', 'v');
        graph = addEdge(graph, 'u', 'x');
        graph = addEdge(graph, 'v', 'y');
        graph = addEdge(graph, 'y', 'x');
        graph = addEdge(graph, 'x', 'v');
        graph = addEdge(graph, 'w', 'y');
        graph = addEdge(graph, 'w', 'z');
        graph = addEdge(graph, 'z', 'z');

        topologicalOrder = topologicalSort();

        Iterator<Character> itr2 = graph.keySet().iterator();
        while(itr2.hasNext()){
            Vertex v = graph.get(itr2.next());
            System.out.println(v);
            System.out.println();
        }

    }
}
