import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class DirectedGraph<T> implements Graph<T> {

    private HashSet<Integer> vertexes;
    private HashSet<Arc<T>> arcs;

    @Override
    public void addVertex(int vertexId) {
        vertexes.add(vertexId);
    }

    @Override
    public void deleteVertex(int vertexId) {
        vertexes.remove(vertexId);
    }

    @Override
    public void addArc(int vertexId1, int vertexId2, T label) {
        arcs.add(new Arc<T>(vertexId1, vertexId2, label));
    }

    @Override
    public void deleteArc(int vertexId1, int vertexId2) {
        vertexes.remove(new Arc<T>(vertexId1, vertexId2, null));
    }

    @Override
    public boolean containsVertex(int vertexId) {
        return vertexes.contains(vertexId);
    }

    @Override
    public boolean containsArc(int vertexId1, int vertexId2) {
        return arcs.contains(new Arc<T>(vertexId1, vertexId2, null));
    }

    @Override
    public Arc<T> getArc(int vertexId1, int vertexId2) {
        for (var arc: arcs)
            if (arc.equals(new Arc<T>(vertexId1, vertexId2, null)))
                return arc;
        return null;
    }

    @Override
    public int getVertexesAmount() {
        return vertexes.size();
    }

    @Override
    public int getArcsAmount() {
        return arcs.size();
    }

    @Override
    public Iterator<Integer> getVertexes() {
        return vertexes.iterator();
    }

    @Override
    public Iterator<Integer> getAdjacent(int vertexId) {
        var adjacent = new ArrayList<Integer>();
        for (var arc: arcs)
            if (arc.getOriginVertex() == vertexId)
                adjacent.add(arc.getDestinyVertex());
        return adjacent.iterator();
    }

    @Override
    public Iterator<Arc<T>> getArcs() {
        return arcs.iterator();
    }

    @Override
    public Iterator<Arc<T>> getArcs(int vertexId) {
        var arcsFromVertex = new ArrayList<Arc<T>>();
        for (var arc: arcs)
            if (arc.getOriginVertex() == vertexId)
                arcsFromVertex.add(arc);
        return arcsFromVertex.iterator();
    }
}
