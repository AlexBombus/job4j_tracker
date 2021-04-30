package ru.job4j.tracker;

/**
 * Может данный класс нужно в отдельный пакет поместить?
 * Он же к самой программе отношение не имеет. Так мы на тестах можем кучу непонятного нагородить.
 */
public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String askStr(String question) {
        return answers[position++];
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}
