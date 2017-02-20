import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

public class DFSStack {

    // initializing a global variable for time
    static int time = 0;

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

    // this function makes sure that all vertices in the graph are visited
    public static HashMap<Character, Vertex> dfsAll(HashMap<Character, Vertex> graph){
        Iterator<Character> itr = graph.keySet().iterator();
        while(itr.hasNext()){
            char c = itr.next();
            if(graph.get(c).color == "white"){
                graph = dfsStack(graph, c);
            }
        }
        return graph;
    }

    // perform dfs from the given vertex
    public static HashMap<Character, Vertex> dfsStack(HashMap<Character, Vertex> graph, char c){

        Stack<Vertex> s = new Stack<Vertex>();
        Vertex vertex = graph.get(c);
        time = time + 1;
        vertex.startTime = time;
        vertex.color = "gray";
        s.push(vertex);

       while(!s.isEmpty()){
           Vertex u = s.peek();
           Vertex v;

           Iterator<Vertex> itr = u.neighbours.iterator();
           while(itr.hasNext()) {
               v = itr.next();
               if (!s.contains(v) && (v.color != "black")) {
                   v.parent = u;
                   s.push(v);
                   break;
               }
           }

           v = s.pop();
           if(v.color == "white"){
               time = time + 1;
               v.startTime = time;
               v.color = "gray";
               s.push(v);
           } else{
               time = time + 1;
               v.endTime = time;
               v.color = "black";
           }
       }
       return graph;
    }

    public static void main(String[] args){
        HashMap<Character, Vertex> graph = new HashMap<Character, Vertex>();
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

        graph = dfsAll(graph);

        // print all the vertices with their start time, end time and parent data
        Iterator<Character> itr2 = graph.keySet().iterator();
        while(itr2.hasNext()){
            Vertex v = graph.get(itr2.next());
            System.out.println(v);
            System.out.println();
        }
    }
}

