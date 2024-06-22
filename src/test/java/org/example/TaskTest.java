package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    public void testSimpleTaskMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testSimpleTaskNotMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Написать");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testEpicMatchesTrue() {
        String[] subtasks = {"Позвонить родителям", "Купить хлеб", "написать тесты", "отправить домашку"};
        Task epic = new Epic(5, subtasks);

        boolean actual = epic.matches("хлеб");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testEpicMatchesFalse() {
        String[] subtasks = {"Позвонить родителям", "Купить хлеб", "написать тесты", "отправить домашку"};
        Task epic = new Epic(5, subtasks);

        boolean actual = epic.matches("машина");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testMeetingTopicTrue() {
        Task meeting = new Meeting(
                8,
                "Сходить в бассейн",
                "Планировщик задач",
                "в 18:00 в четверг"
        );

        boolean actual = meeting.matches("бассейн");

        Assertions.assertTrue(actual);
    }
    @Test
    public void testMeetingProjectTrue() {
        Task meeting = new Meeting(
                8,
                "Сходить в бассейн",
                "Планировщик задач",
                "в 18:00 в четверг"
        );

        boolean actual = meeting.matches("задач");

        Assertions.assertTrue(actual);
    }
    @Test
    public void testMeetingFalse() {
        Task meeting = new Meeting(
                8,
                "Сходить в бассейн",
                "Планировщик задач",
                "в 18:00 в четверг"
        );

        boolean actual = meeting.matches("хлеб");

        Assertions.assertFalse(actual);
    }

}
