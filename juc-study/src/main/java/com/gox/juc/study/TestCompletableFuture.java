package com.gox.juc.study;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


/**
 *
 */
public class TestCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture
                .supplyAsync(()->"hello")
                .thenCombineAsync(CompletableFuture.supplyAsync(()->" world"),(a,b)->a+b);

        System.out.println(future.get());
    }
}
