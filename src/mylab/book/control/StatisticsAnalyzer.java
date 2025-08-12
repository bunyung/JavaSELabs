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
        System.out.println("===== 출판물 통계 분석 =====");
        printAveragePriceByType();
        printTypeDistribution();
        printYearRatio(2007);
    }

    private void printAveragePriceByType() {
        System.out.println("1. 타입별 평균 가격:");
        Map<String, Double> avg = books.stream()
                .collect(Collectors.groupingBy(Publication::getTypeName,
                        Collectors.averagingInt(Publication::getPrice)));

        // 소설, 참고서, 잡지 순으로 출력 (있으면)
        List<String> order = Arrays.asList("소설", "참고서", "잡지");
        for (String t : order) {
            if (avg.containsKey(t)) {
                System.out.printf("   - %s: %,d원\n", t, Math.round(avg.get(t)));
            }
        }
        System.out.println();
    }

    private void printTypeDistribution() {
        System.out.println("2. 출판물 유형 분포:");
        int total = books.size();
        Map<String, Long> counts = books.stream()
                .collect(Collectors.groupingBy(Publication::getTypeName, Collectors.counting()));

        List<String> order = Arrays.asList("소설", "참고서", "잡지");
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
        System.out.printf("3. %d년에 출판된 출판물 비율: %.2f%%\n", year, percent);
    }
}