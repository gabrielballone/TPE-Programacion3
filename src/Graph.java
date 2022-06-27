import java.util.Iterator;

public interface Graph<T> {

    // Adds a vertex
    public void addVertex(String vertexId);

    // Deletes a vertex
    public void deleteVertex(String vertexId);

    // Adds an arc with a label that connects vertexId1 with vertexId2
    public void addArc(String vertexId1, String vertexId2, T label);

    // Deletes the arc that connects vertexId1 with vertexId2
    public void deleteArc(String vertexId1, String vertexId2);

    // Verifies if a vertex exists
    public boolean containsVertex(String vertexId);

    // Verifies if exists an arc between two vertexes
    public boolean containsArc(String vertexId1, String vertexId2);

    // Gets the arc that connects vertexId1 with vertexId2
    public Arc<T> getArc(String vertexId1, String vertexId2);

    // Returns the total amount of vertexes in the graph
    public int getVertexesAmount();

    // Returns the total amount of arcs in the graph
    public int getArcsAmount();

    // Returns an iterator that allows to travel all the vertexes stored in the graph
    public Iterator<String> getVertexes();

    // Returns an iterator that allows to travel all the vertexes adjacent to vertexId
    public Iterator<String> getAdjacent(String vertexId);

    // Returns an iterator that allows to travel all the arcs stored in the graph
    public Iterator<Arc<T>> getArcs();

    // Returns an iterator that allows to travel all the arcs stored in the graph that starts from vertexId
    public Iterator<Arc<T>> getArcs(String vertexId);

}
