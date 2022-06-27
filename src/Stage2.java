import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.SortedSet;

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
}
