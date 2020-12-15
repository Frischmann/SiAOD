import java.util.*;

public class HashTable< E> {
    ArrayList<LinkedList<E>>table;
    int size;

    public HashTable(int size) {
        this.size = size;
        this.table = new ArrayList<>(this.size);

        for(int i=0;i < 10;i++){
            table.add(new LinkedList<E>());
        }
    }

    int hash(int value){
        return (int)value%size;
    }

    int hash(E n) {
        Insurance key = (Insurance) n;
        return key.number % size;
    }

    void add(E b) {
        table.get(hash(b)).addLast(b);
        if (table.get(hash(b)).size() > 2) rehash();
    }

    void rehash(){
        ArrayDeque<E> t =new ArrayDeque<>();
        for (int i = 0; i < size; ++i) {
            for (E el : table.get(i)) {
                t.add(el);
            }
        }
        size = size * 2 + 1;
        table.clear();
        table = new ArrayList<>(size);
        for(int i=0;i<size;i++){
            table.add(new LinkedList<E>());
        }
        while (!t.isEmpty()) {
            add(t.getFirst());
            t.pop();
        }
    }
    void search(int value){
        for(E t:table.get(hash(value))){
            Insurance c= (Insurance) t;
            if(c.number == value){
                System.out.println(c);
            }
        }
    }

    void delete(int value){
        for(E t:table.get(hash(value))){
            Insurance c= (Insurance) t;
            if(c.number == value){
                table.get(hash(value)).remove(t);
            }
        }
    }
    void print(){
        for(int i=0;i<size;i++){
            if(!table.get(i).isEmpty()) {
                System.out.println(i+" : ");
                for (int j = 0; j < table.get(i).size(); j++) {
                    System.out.println("\t"+table.get(i).get(j));
                }
            }
        }
    }
}
