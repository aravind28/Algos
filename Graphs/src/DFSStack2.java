import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

public class DFSStack2 {

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
        s.push(vertex);

       while(!s.isEmpty()){
           Vertex u = s.pop();
           if(u.color == "white"){
               time = time + 1;
               u.startTime = time;
               u.color = "gray";
               s.push(u);
               for(Vertex v : u.neighbours){
                   if(v.color == "white"){
                       v.parent = u;
                       s.push(v);
                   }
               }
           }
           else if(u.color == "gray"){
               time = time + 1;
               u.endTime = time;
               u.color = "black";
           }

       }
       return graph;
    }

    public static void main(String[] args){
        HashMap<Character, Vertex> graph = new HashMap<Character, Vertex>();
        char[] listOfVertices = {'u', 'v', 'w', 'x', 'y', 'z'};
        graph = createVertices(graph, listOfVertices);

        graph = addEdge(graph, 'u', 'x');
        graph = addEdge(graph, 'u', 'v');
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

