public class Arc<T> {

    private int originVertex;
    private int destinyVertex;
    private T label;

    public Arc(int originVertex, int destinyVertex, T label) {
        this.originVertex = originVertex;
        this.destinyVertex = destinyVertex;
        this.label = label;
    }

    public int getOriginVertex() {
        return originVertex;
    }

    public int getDestinyVertex() {
        return destinyVertex;
    }

    public T getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;
        if(obj == null || obj.getClass()!= this.getClass())
            return false;
        Arc arc = (Arc) obj;
        return (this.originVertex == arc.getOriginVertex() && this.destinyVertex == arc.getDestinyVertex());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + originVertex;
        result = 31 * result + destinyVertex;
        return result;
    }

}
