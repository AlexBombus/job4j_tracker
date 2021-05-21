package ru.job4j.collection;

import java.util.Comparator;

public class JobSorter {

    static class SortUpByName implements Comparator<Job> {
        @Override
        public int compare(Job o1, Job o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    static class SortDownByName implements Comparator<Job> {
        @Override
        public int compare(Job o1, Job o2) {
            return o2.getName().compareTo(o1.getName());
        }
    }

    static class SortUpByPriority implements Comparator<Job> {
        @Override
        public int compare(Job o1, Job o2) {
            return Integer.compare(o1.getPriority(), o2.getPriority());
        }
    }

    static class SortDownByPriority implements Comparator<Job> {
        @Override
        public int compare(Job o1, Job o2) {
            return Integer.compare(o2.getPriority(), o1.getPriority());
        }
    }

}
