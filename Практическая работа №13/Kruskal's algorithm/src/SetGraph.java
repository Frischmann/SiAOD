public class SetGraph {
    int[] number;
    int[] rang;

    SetGraph(int size) {
        number=new int[size];
        rang=new int[size];
        for(int i=0;i<size;++i){
            number[i]=i;
        }
    }

    int set(int x) {
        return x==number[x]? x:(number[x]=set(number[x]));
    }

    boolean merge(int A, int B){
        if(set(A)==set(B))
            return false;

        if(rang[A]<rang[B])
            number[A]=B;

        else {
            number[B]=A;
            if(rang[A]==rang[B])
                rang[A]++;
        }
        return true;
    }
}

