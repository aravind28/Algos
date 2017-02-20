public class Edge {
    Vertex vertex1;
    Vertex vertex2;
    int cost;

    public Edge(Vertex v1, Vertex v2, int cost){
        this.vertex1 = v1;
        this.vertex2 = v2;
        this.cost = cost;
    }
}
