package Offer.a63数据流中的中位数;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    int sum = 0;
    Queue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
    Queue<Integer> minQueue = new PriorityQueue<>();

    public void Insert(Integer num) {
        if (sum % 2 == 0) {
            maxQueue.add(num);
            minQueue.add(maxQueue.remove());
        } else {
            minQueue.add(num);
            maxQueue.add(minQueue.remove());
        }
        sum++;
    }

    public Double GetMedian() {
        if (sum % 2 == 1) {
            return Double.valueOf(minQueue.peek());
        } else {
            return (Double.valueOf(minQueue.peek()) + Double.valueOf(maxQueue.peek())) / 2;
        }
    }
}