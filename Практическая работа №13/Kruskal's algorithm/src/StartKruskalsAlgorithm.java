import java.util.*;

public class StartKruskalsAlgorithm {
    public static int KruskalAlgorithm(ArrayList<Graph> graph) {
        SetGraph union = new SetGraph(graph.size()+1);
        Collections.sort(graph);

        ArrayList<Graph> buff = new ArrayList<>();
        for(Graph i: graph) {
            if(union.merge(i.A,i.B)){
                buff.add(i);
            }
        }
        graph.clear();
        graph.addAll(buff);
        return 0;
    }

    public static void main(String[] args) {
        ArrayList<Graph> graph = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int a,b,m;

        System.out.println("Ввод ребер графа: ");
        while(true){
            a = scanner.nextInt();
            if(a==0) break;
            m = scanner.nextInt();
            b = scanner.nextInt();
            graph.add(new Graph(a,m,b));
        }
        System.out.println("Исходный граф: ");
        for (Graph item : graph) {
            System.out.println(item.A + "->" + item.B);
        }
        System.out.println(KruskalAlgorithm(graph));
        System.out.println("Результат: ");
        for (Graph value : graph) {
            System.out.println(value.A + "->" + value.B);
        }
        System.out.println("В данной работе используется язык graphviz. Посмотреть граф можно на сайте graphvix.org.");
    }
}

