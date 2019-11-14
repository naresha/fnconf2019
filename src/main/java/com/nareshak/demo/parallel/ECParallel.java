package com.nareshak.demo.parallel;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.ParallelListIterable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ECParallel {
    public static void main(String[] args) {
        ImmutableList<Integer> numbers = Lists.immutable.of(1, 2, 3, 4, 5, 6, 7, 8);
        ExecutorService threadPool =
                Executors.newFixedThreadPool(4);
        ParallelListIterable<Integer> parallelListIterable = numbers.asParallel(threadPool, 2);
        ParallelListIterable<Integer> numbersIncremented = parallelListIterable.collect(number -> {
            System.out.println(Thread.currentThread() + " " + number);
            return number + 1;
        });
        System.out.println(numbersIncremented.toList());
        threadPool.shutdown();
    }
}
