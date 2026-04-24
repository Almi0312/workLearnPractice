package learn_streams.task1;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Task1 {
    public static void main(String[] args) {
        ListProcessor listProcessor = new ListProcessor();
        List<String> words = new java.util.ArrayList<>(List.of("java", "lambda", "stream", "functional"));
        List<String> filterWords = listProcessor.filter(words, word -> word.length() > 5);
        List<Integer> mapWords = listProcessor.map(filterWords, String::length);
        listProcessor.forEach(mapWords, System.out::println);
    }
}
