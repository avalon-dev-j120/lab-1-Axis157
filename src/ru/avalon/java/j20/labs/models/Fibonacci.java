package ru.avalon.java.j20.labs.models;

import java.util.Iterator;

/**
 * Модель получения последовательности чисел Фибоначчи.
 *
 * <p>
 * Числа Фибонааччи (иногда пишут Фибона́чи[1]) — элементы числовой
 * последовательности 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377,
 * 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, … (последовательность A000045
 * в OEIS), в которой первые два числа равны либо 1 и 1, либо 0 и 1, а каждое
 * последующее число равно сумме двух предыдущих чисел. Названы в честь
 * средневекового математика Леонардо Пизанского (известного как Фибоначчи).
 *
 * @see
 * <a href="https://ru.wikipedia.org/wiki/%D0%A7%D0%B8%D1%81%D0%BB%D0%B0_%D0%A4%D0%B8%D0%B1%D0%BE%D0%BD%D0%B0%D1%87%D1%87%D0%B8">Числа
 * Фибоначчи</a>
 */
public class Fibonacci implements Iterable<Integer> {

    private int length;
    public final static int NUM1 = 0;
    public final static int NUM2 = 1;

    public Fibonacci(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    /**
     * Итератор, выполняющий обход последовательности чисел Фибоначчи.
     */
    private static class FibonacciIterator implements Iterator<Integer> {

        private Fibonacci fib;
        private int current = 0;
        private int buf1;
        private int buf2;

        public FibonacciIterator(Fibonacci f) {
            fib = f;
        }

        /**
         * Определяет, есть ли следующее значение последовательности чисел
         * Фибоначчи.
         *
         * @return {@code true}, если следующее число последовательности
         * существует. В обратном случае {@code false}.
         */
        @Override
        public boolean hasNext() {
            boolean result = current < (fib.getLength());
            return result;
        }

        /**
         * Возвращает следующее число последовательности чисел Фибоначчи.
         *
         * @return следующее число последовательности.
         */
        @Override
        public Integer next() {
            int ret;
            if(current>1) {
                ret = buf1 + buf2;
                buf1 = buf2;
                buf2 = ret;
                current++;
            }
            else if(current==1) {
                buf2=NUM2;
                ret=buf2;
                current++;
            }
            else {
                buf1=NUM1;
                ret = buf1;
                current++;
            }
            return ret;
        }
    }

    /**
     * Возвращает итератор, позволяющий выполнить обход последовательности чисел
     * Фибоначчи.
     *
     * @return итератор последовательности чисел Фибоначчи
     */
    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(this);
    }
}
