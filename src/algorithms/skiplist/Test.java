package algorithms.skiplist;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        BingSkipList<Integer> skipList = new BingSkipList<Integer>();
        Random random = new Random();
        Set<Integer> numbers = new HashSet<Integer>();
        for(int i=0;i<50;i++){
        	numbers.add(random.nextInt(100));
        }
        Iterator<Integer> iter = numbers.iterator();
        while(iter.hasNext()) {
        	skipList.insert(iter.next());
        }
        skipList.printAll();
    }
}
