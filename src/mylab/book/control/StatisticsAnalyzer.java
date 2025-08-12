package mylab.book.control;

import mylab.book.entity.*;
import java.util.*;
import java.util.stream.*;

public class StatisticsAnalyzer {
    private List<Publication> books;

    public StatisticsAnalyzer(List<Publication> books) {
        this.books = new ArrayList<>(books);
    }

    public void printStatistics() {
        System.out.println("===== ���ǹ� ��� �м� =====");
        printAveragePriceByType();
        printTypeDistribution();
        printYearRatio(2007);
    }

    private void printAveragePriceByType() {
        System.out.println("1. Ÿ�Ժ� ��� ����:");
        Map<String, Double> avg = books.stream()
                .collect(Collectors.groupingBy(Publication::getTypeName,
                        Collectors.averagingInt(Publication::getPrice)));

        // �Ҽ�, ����, ���� ������ ��� (������)
        List<String> order = Arrays.asList("�Ҽ�", "����", "����");
        for (String t : order) {
            if (avg.containsKey(t)) {
                System.out.printf("   - %s: %,d��\n", t, Math.round(avg.get(t)));
            }
        }
        System.out.println();
    }

    private void printTypeDistribution() {
        System.out.println("2. ���ǹ� ���� ����:");
        int total = books.size();
        Map<String, Long> counts = books.stream()
                .collect(Collectors.groupingBy(Publication::getTypeName, Collectors.counting()));

        List<String> order = Arrays.asList("�Ҽ�", "����", "����");
        for (String t : order) {
            if (counts.containsKey(t)) {
                double percent = counts.get(t) * 100.0 / total;
                System.out.printf("   - %s: %.2f%%\n", t, percent);
            }
        }
        System.out.println();
    }

    private void printYearRatio(int year) {
        long total = books.size();
        long cnt = books.stream().filter(b -> b.getPublishDate().getYear() == year).count();
        double percent = total == 0 ? 0 : (cnt * 100.0 / total);
        System.out.printf("3. %d�⿡ ���ǵ� ���ǹ� ����: %.2f%%\n", year, percent);
    }
}