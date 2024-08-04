import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    private List<Integer> list = new ArrayList<>();
    private int max;
    private int min;
    private int diff;
    protected Random random;

    public Randoms(int min, int max) {
        this.max = max;
        this.min = min;
    }

    public void random() {
        diff = max - min;
        random = new Random();
        int i = random.nextInt(diff + 1) + min;
        list.add(i);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            boolean result = true;
            int q = 0;

            @Override
            public boolean hasNext() {
                random();
                if (q < list.size()) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public Integer next() {
                int task = 0;
                if (q < list.size()) {
                    task = list.get(q);
                    q++;
                }
                return task;
            }
        };
    }
}
