import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class Stage2 {

    static final String cvsSplitBy = ",";

    public static DirectedGraph<Integer> generateGraph(LinkedList<String> genresLines) {
        DirectedGraph<Integer> graph = new DirectedGraph<Integer>();
        for (String line : genresLines) {
            String[] genres = line.split(cvsSplitBy);
            String lastGenre = null;
            for (String genre : genres) {
                if(!graph.containsVertex(genre))
                    graph.addVertex(genre);
                if (lastGenre != null){
                    Arc<Integer> arc = graph.getArc(lastGenre, genre);
                    if (arc == null){
                        graph.addArc(lastGenre, genre, 1);
                    } else {
                        arc.setLabel(arc.getLabel() + 1);
                    }
                }
                lastGenre = genre;
            }
        }
        return graph;
    }

    public static LinkedList<String> getMostSearchesGenresAfterAGenre(DirectedGraph<Integer> graph, String genre, int amount) {
        LinkedList<String> genresToReturn = new LinkedList<String>();
        Iterator<Arc<Integer>> arcs = graph.getArcs(genre);
        LinkedList<Arc<Integer>> sortedArcs = new LinkedList<Arc<Integer>>();
        while (arcs.hasNext()) {
            sortedArcs.add(arcs.next());
        }
        Collections.sort(sortedArcs, Collections.reverseOrder());
        Iterator<Arc<Integer>> sortedArcsIterator = sortedArcs.iterator();
        while (sortedArcsIterator.hasNext() && genresToReturn.size() < amount) {
            Arc<Integer> arc = sortedArcsIterator.next();
            genresToReturn.add(arc.getDestinyVertex());
        }
        return genresToReturn;
    }

    public static LinkedList<String> getSequenceWithHigherSearchRatio(DirectedGraph<Integer> graph, String genre) {
        LinkedList<String> higherRatioSequence = new LinkedList<String>();
        higherRatioSequence.addLast(genre);
        boolean existsVertex = false;
        while (graph.getArcs(higherRatioSequence.getLast()).hasNext() && !existsVertex) {
            Iterator<Arc<Integer>> arcs = graph.getArcs(higherRatioSequence.getLast());
            Arc<Integer> higherArc = null;
            while (arcs.hasNext()) {
                Arc<Integer> currentArc = arcs.next();
                if ((higherArc == null || currentArc.getLabel() > higherArc.getLabel()) &&
                    !higherRatioSequence.contains(currentArc.getDestinyVertex())) {
                    higherArc = currentArc;
                }
            }
            if (higherArc != null) {
                higherRatioSequence.addLast(higherArc.getDestinyVertex());
            } else {
                existsVertex = true;
            }
        }
        return higherRatioSequence;
    }

    public static DirectedGraph<Integer> getGraphWithAffinedGenres(DirectedGraph<Integer> graph, String genre) {
        DirectedGraph<Integer> graphToReturn = new DirectedGraph<Integer>();
        // recorrer el grafo con DFS buscando ciclos        
        // cuando el método de DFS encuentra un ciclo tiene que agregar todos los vertices y arcos grafo a devolver graphToReturn        
        return graphToReturn;
    }

    private static void DFS(DirectedGraph<Integer> graph, String startVertex) {
        HashMap<String,String> visitedVertexes = new HashMap<String,String>();
        var vertexes = graph.getVertexes();
        while (vertexes.hasNext()) {
            var vertex = vertexes.next();
            visitedVertexes.put(vertex, "WHITE");
        }        
        DFSVisit(graph, visitedVertexes, startVertex);    
    }

    private static void DFSVisit(DirectedGraph<Integer> graph, HashMap<String, String> visitedVertexes, String vertex) {
        visitedVertexes.put(vertex, "YELLOW");
        var i = graph.getAdjacent(vertex);
        while (i.hasNext()) {
            String adjacentVertex = i.next();
            if (visitedVertexes.get(adjacentVertex) == "WHITE")
                DFSVisit(graph, visitedVertexes, adjacentVertex);
            else if (visitedVertexes.get(adjacentVertex) == "YELLOW") {   
                // has cicle             
            }
        }
        visitedVertexes.put(vertex, "BLACK");
    }
}
