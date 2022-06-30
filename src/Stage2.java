import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Stage2 {

    static final String cvsSplitBy = ",";
    static HashSet<Arc<Integer>> affinedArcsSolution = new HashSet<Arc<Integer>>();
    static String genreA = null;

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

    public static LinkedList<String> getMostSearchedGenresAfterAGenre(DirectedGraph<Integer> graph, String genre, int amount) {
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
        boolean onlyRepeatedVertexesLeft = false;
        while (graph.getArcs(higherRatioSequence.getLast()).hasNext() && !onlyRepeatedVertexesLeft) {
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
                onlyRepeatedVertexesLeft = true;
            }
        }
        return higherRatioSequence;
    }

    public static DirectedGraph<Integer> getGraphWithAffinedGenres(DirectedGraph<Integer> graph, String genre) {
        DirectedGraph<Integer> graphToReturn = new DirectedGraph<Integer>();
        Stage2.genreA = genre;
        var arcs = graph.getArcs(Stage2.genreA);
        while (arcs.hasNext()) {
            Arc<Integer> arc = arcs.next();
            affinedArcsSolution.add(arc);
            boolean foundCicle = DFS(graph, arc);
            if (foundCicle) {
                var arcsToReturn = affinedArcsSolution.iterator();
                while (arcsToReturn.hasNext()) {
                    var arcToReturn = arcsToReturn.next();
                    graphToReturn.addArc(arcToReturn.getOriginVertex(), arcToReturn.getDestinyVertex(), arcToReturn.getLabel());
                    graphToReturn.addVertex(arcToReturn.getOriginVertex());
                    graphToReturn.addVertex(arcToReturn.getDestinyVertex());
                }
            }
            affinedArcsSolution = new HashSet<Arc<Integer>>();
        }
        return graphToReturn;
    }

    private static boolean DFS(DirectedGraph<Integer> graph, Arc<Integer> arc) {
        HashMap<String,String> visitedVertexes = new HashMap<String,String>();
        var vertexes = graph.getVertexes();
        while (vertexes.hasNext()) {
            var vertex = vertexes.next();
            visitedVertexes.put(vertex, "WHITE");
        }
        return DFSVisit(graph, visitedVertexes, arc);
    }

    private static boolean DFSVisit(DirectedGraph<Integer> graph, HashMap<String, String> visitedVertexes, Arc<Integer> currentArc) {
        visitedVertexes.put(currentArc.getDestinyVertex(), "YELLOW");
        var arcs = graph.getArcs(currentArc.getDestinyVertex());
        while (arcs.hasNext()) {
            Arc<Integer> arc = arcs.next();
            if (arc.getDestinyVertex().equals(Stage2.genreA)) {
                Stage2.affinedArcsSolution.add(arc);
                return true;
            }
            else if (visitedVertexes.get(arc.getDestinyVertex()) == "WHITE"){
                Stage2.affinedArcsSolution.add(arc);
                if (DFSVisit(graph, visitedVertexes, arc))
                    return true;
            }
        }
        Stage2.affinedArcsSolution.remove(currentArc);
        visitedVertexes.put(currentArc.getDestinyVertex(), "BLACK");
        return false;
    }
}
