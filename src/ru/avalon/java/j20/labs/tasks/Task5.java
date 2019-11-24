package ru.avalon.java.j20.labs.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import ru.avalon.java.j20.labs.Task;
import ru.avalon.java.j20.labs.core.RandomArrayFactory;

import java.util.List;
import java.util.Set;

/**
 * Задание №5.
 *
 * <p>
 * Тема: "Изучение отличия между списками и наборами".
 */
public class Task5 implements Task {

    /**
     * Фабрика, генерирующая массивы чисел случайного характера.
     */
    private final RandomArrayFactory arrayFactory = new RandomArrayFactory();

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        final Integer[] array = arrayFactory.getInstance(20);

        List<Integer> list = new ArrayList<>(Arrays.asList(array));

        Set<Integer> set = new HashSet<>();
        set.addAll(list);

        System.out.println("  Содержимое листа for-each:");
        for (Integer e : list) {
            System.out.print(", " + e);
        }
        System.out.println("\n");

        System.out.println("  Содержимое Set-а for-each:");
        for (Integer e : set) {
            System.out.print(", " + e);
        }
        System.out.println("\n");

        /**
         * TODO(Студент): Выполните задание №5
         *
         * 1. Проинициализируйте переменные list и set объектами подходящих
         * классов.
         *
         * 2. В обе коллекции поместите элементы массива array.
         *
         * 3. С использованием отладчика проверьте корректность выполнения
         * задания.
         */
    }
}
