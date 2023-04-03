package ru.urfu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
/*
Используемая коллекция - HashSet, так как операции add(), remove() и важный для данной задачи contains()
"стоят" константу (O(1)) благодаря HashMap (данная сложность операций также верна для LinkedHashSet,
который можно было использовать в данной задачи, но нет надобности в его двусвязности)
В случае, если метод hashCode даёт много коллизий, то сложность становится (O(log n) для Java 8 и выше, O(n) для Java 7)
Суть: переопределяем для класса User методы equals() и hashCode, дабы использовать contains(),
проходимся по первой коллекции collA и с помощью метода contains() ищем совпадения во
второй коллекции collB, данные совпадения сохраняем и выводим в результат.
Обход коллекции collA занимает O(n)
*/
public class Main {

    public static void main(String[] args) {
        User user1 = new User("123", "123", "123");
        User user2 = new User("123", "123", "123");
        HashSet<User> A = new HashSet<>();
        HashSet<User> B = new HashSet<>();
        A.add(user1);
        B.add(user2);
        System.out.println(findDuplicates(A, B));
    }

    private static List<User> findDuplicates(Collection<User> collA, Collection<User> collB) {
        List<User> result = new ArrayList<>();
        for (User e: collA) {
            if (collB.contains(e)) {
                result.add(e);
            }
        }
        return result;
    }
}
