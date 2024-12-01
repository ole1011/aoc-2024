package de.ole101.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Day 01, Part 1 & 2
 */
public class Day01 {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("src/main/resources/day01.txt"));
        List<Integer> leftList = getNumbers(lines, 0);
        List<Integer> rightList = getNumbers(lines, 1);

        int sum = 0;
        for (int i = 0; i < leftList.size(); i++) {
            sum += Math.abs(leftList.get(i) - rightList.get(i));
        }

        System.out.println("Total difference sum: " + sum);

        Map<Integer, Long> rightCountMap = rightList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long similarityScore = leftList.stream()
                .mapToLong(left -> left * rightCountMap.getOrDefault(left, 0L))
                .sum();
        System.out.println("Total similarity score: " + similarityScore);
    }

    private static List<Integer> getNumbers(List<String> lines, int index) {
        return lines.stream()
                .map(line -> line.split("\\s+")[index])
                .mapToInt(Integer::parseInt)
                .sorted()
                .boxed()
                .toList();
    }
}
