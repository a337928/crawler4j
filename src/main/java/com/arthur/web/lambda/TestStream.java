package com.arthur.web.lambda;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by wangtao on 2017/10/22.
 */
public class TestStream {
    public static void main(String[] args){
        Stream.iterate(new int[]{0, 1}, t ->
                        new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .forEach(t -> System.out.println("Array is t is [" + t[0] + "," + t[1] +"]"));

        Stream.iterate(new int[]{0, 1}, t ->
            new int[]{t[1], t[0] + t[1]})
              .limit(10)
              .map(t -> t[0])
              .forEach(System.out::println);

        IntSupplier f = new IntSupplier() {
            private int previous = 0;
            private int current = 1;
            @Override
            public int getAsInt() {
                int oldPrevious = this.previous;
                int nextValue = oldPrevious + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        };

        IntStream.generate(f)
                 .limit(10)
                 .forEach(System.out::println);

    }
}
