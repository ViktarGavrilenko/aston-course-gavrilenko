package org.example.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

//      1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей
//      к большей).
        List<Transaction> transactions2011SortByValue = transactions
                .stream()
                .filter(a -> a.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .toList();
        System.out.println(transactions2011SortByValue);

//      2. Вывести список неповторяющихся городов, в которых работают трейдеры.
        List<String> setCites = transactions
                .stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .toList();
        System.out.println(setCites);

//      3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
        List<Trader> listTraderFromCambridgeSortByName = transactions
                .stream()
                .map(Transaction::getTrader)
                .filter(a -> a.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .toList();
        System.out.println(listTraderFromCambridgeSortByName);

//      4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном
//      порядке.
        String traderNamesSort = transactions
                .stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .collect(Collectors.joining(" "));
        System.out.println(traderNamesSort);

//      5. Выяснить, существует ли хоть один трейдер из Милана.
        boolean isAnyOneFromMilan = transactions
                .stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .anyMatch(a -> a.equals("Milan"));
        System.out.println(isAnyOneFromMilan);

//      6. Вывести суммы всех транзакций трейдеров из Кембриджа.
        transactions
                .stream()
                .filter(a -> a.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(a -> System.out.print(a + " "));
        System.out.println();

//      7. Какова максимальная сумма среди всех транзакций?
        int maxValue = transactions
                .stream()
                .map(Transaction::getValue)
                .max(Integer::compareTo)
                .get();
        System.out.println(maxValue);

//      8. Найти транзакцию с минимальной суммой.
        Transaction minValue = transactions
                .stream()
                .min(Comparator.comparing(Transaction::getValue))
                .get();
        System.out.println(minValue);
    }
}