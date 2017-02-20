import java.util.ArrayList;

public class Vertex {
    public char vertexName;
    public Vertex parent;
    public int startTime;
    public int endTime;
    public String color;
    public ArrayList<Vertex> neighbours;

    public Vertex(char c){
        this.vertexName = c;
        this.parent = null;
        startTime = 0;
        endTime = 0;
        color = "white";
        neighbours = new ArrayList<>();
    }

    @Override
    public String toString(){
        if(parent != null){
            return "{ Vertex: " + vertexName + ", Start Time: " + startTime + ", End Time: " + endTime + ", Parent: " + parent.vertexName + ", Color: " + color + " }";
        }
        return "{ Vertex: " + vertexName + ", Start Time: " + startTime + ", End Time: " + endTime + ", Parent: " + null + ", Color: " + color + " }";
    }
}
