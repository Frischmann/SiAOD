public class Graph implements Comparable<Graph> {
    public int A;
    public int mass;
    public int B;

    Graph(int A, int mass, int B) {
        this.A=A;
        this.B=B;
        this.mass=mass;
    }

    @Override
    public int compareTo(Graph o) {
        if(mass!=o.mass){
            return mass<o.mass? -1:1;
        }
        return 0;
    }
}

