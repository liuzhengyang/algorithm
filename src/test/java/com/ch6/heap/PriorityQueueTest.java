package com.ch6.heap;

import static org.junit.Assert.*;

import org.junit.Test;

public class PriorityQueueTest {
    @Test
    public void add() throws Exception {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(4);
        priorityQueue.add(6);
        priorityQueue.add(10);
        priorityQueue.add(5);
        priorityQueue.add(1);
        priorityQueue.add(7);
        priorityQueue.add(2);
        priorityQueue.add(3);
        priorityQueue.validate(0);
        System.out.println(priorityQueue);
    }

}