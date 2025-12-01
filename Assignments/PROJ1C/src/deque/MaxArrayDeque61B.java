package deque;

import java.util.Comparator;

public class MaxArrayDeque61B<T> extends ArrayDeque61B<T>{

    private Comparator<T> c;

    public MaxArrayDeque61B(Comparator<T> c){
        this.c = c;
    }

    public T max(){
        return this.max(c);
    }

    public T max(Comparator<T> c){

        if (this.isEmpty()){
            return null;
        }

        T maxElem = get(0);
        for (int i = 0; i < size(); i++){
            if (c.compare(get(i), maxElem) > 0){
                maxElem = get(i);
            }
        }
        return maxElem;
    }
}
