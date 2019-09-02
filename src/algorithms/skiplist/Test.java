package algorithms.skiplist;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        BingSkipList skipList = new BingSkipList();
        Random random = new Random();
        for(int i=0;i<10000;i++){
            skipList.zadd(random.nextFloat());
        }
        int pos = skipList.zrank("random-6098");
        System.out.println(pos);
    }
}
