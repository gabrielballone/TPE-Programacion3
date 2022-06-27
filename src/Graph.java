import java.util.Iterator;

public interface Graph<T> {

    // Adds a vertex
    public void addVertex(int vertexId);

    // Deletes a vertex
    public void deleteVertex(int vertexId);

    // Adds an arc with a label that connects vertexId1 with vertexId2
    public void addArc(int vertexId1, int vertexId2, T label);

    // Deletes the arc that connects vertexId1 with vertexId2
    public void deleteArc(int vertexId1, int vertexId2);

    // Verifies if a vertex exists
    public boolean containsVertex(int vertexId);

    // Verifies if exists an arc between two vertexes
    public boolean containsArc(int vertexId1, int vertexId2);

    // Gets the arc that connects vertexId1 with vertexId2
    public Arc<T> getArc(int vertexId1, int vertexId2);

    // Returns the total amount of vertexes in the graph
    public int getVertexesAmount();

    // Returns the total amount of arcs in the graph
    public int getArcsAmount();

    // Returns an iterator that allows to travel all the vertexes stored in the graph
    public Iterator<Integer> getVertexes();

    // Returns an iterator that allows to travel all the vertexes adjacent to vertexId
    public Iterator<Integer> getAdjacent(int vertexId);

    // Returns an iterator that allows to travel all the arcs stored in the graph
    public Iterator<Arc<T>> getArcs();

    // Returns an iterator that allows to travel all the arcs stored in the graph that starts from vertexId
    public Iterator<Arc<T>> getArcs(int vertexId);

}
