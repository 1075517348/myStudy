package my.GenericInfo;

import java.util.List;

public class Test<N extends Integer> {
    private N min, max;

    public N getMin() {
        return min;
    }

    public N getMax() {
        return max;
    }

    public Test(N min, N max) {
        this.min = min;
        this.max = max;
    }

    public void add(N added) {
        if (min == null || added.doubleValue() < min.doubleValue()) {
            min = added;
        }
        if (max == null || added.doubleValue() > max.doubleValue()) {
            max = added;
        }
    }
    public void takeList(List<? extends String> list){
        list.get(1);
    }
    public static void main(String[] args) {
        Test<Integer> t = new Test<Integer>(3, 4);
        System.out.println(t.getMax());
        System.out.println(t.getMin());
    }
}
