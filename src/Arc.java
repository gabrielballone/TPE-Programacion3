public class Arc<T extends Comparable<T>> implements Comparable<Arc<T>> {

    private String originVertex;
    private String destinyVertex;
    private T label;

    public Arc(String originVertex, String destinyVertex, T label) {
        this.originVertex = originVertex;
        this.destinyVertex = destinyVertex;
        this.label = label;
    }

    public String getOriginVertex() {
        return originVertex;
    }

    public String getDestinyVertex() {
        return destinyVertex;
    }

    public T getLabel() {
        return label;
    }

    public void setLabel(T label) {
        this.label = label;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((destinyVertex == null) ? 0 : destinyVertex.hashCode());
        result = prime * result + ((originVertex == null) ? 0 : originVertex.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Arc<T> other = (Arc<T>) obj;
        if (destinyVertex == null) {
            if (other.destinyVertex != null)
                return false;
        } else if (!destinyVertex.equals(other.destinyVertex))
            return false;
        if (originVertex == null) {
            if (other.originVertex != null)
                return false;
        } else if (!originVertex.equals(other.originVertex))
            return false;
        return true;
    }

    @Override
    public int compareTo(Arc<T> o) {
        return this.label.compareTo(o.getLabel());
    }

}
