package ru.job4j.collection;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class JobSorterTest {
    private Job job1 = new Job("Make bug", 1);
    private Job job2 = new Job("Fix bug", 4);
    private Job job3 = new Job("X task", 2);
    private Job job4 = new Job("Fix bug", 3);
    private List<Job> input = Arrays.asList(job1, job2, job3, job4);

    @Test
    public void whenSortUpByName() {
        input.sort(new JobSorter.SortUpByName());
        assertEquals(input.get(0).getName(), "Fix bug");
        assertEquals(input.get(1).getName(), "Fix bug");
        assertEquals(input.get(2).getName(), "Make bug");
        assertEquals(input.get(3).getName(), "X task");
    }

    @Test
    public void whenSortDownByName() {
        input.sort(new JobSorter.SortDownByName());
        assertEquals(input.get(0).getName(), "X task");
        assertEquals(input.get(1).getName(), "Make bug");
        assertEquals(input.get(2).getName(), "Fix bug");
        assertEquals(input.get(3).getName(), "Fix bug");
    }

    @Test
    public void whenSortUpByPriority() {
        input.sort(new JobSorter.SortUpByPriority());
        assertEquals(input.get(0).getPriority(), 1);
        assertEquals(input.get(1).getPriority(), 2);
        assertEquals(input.get(2).getPriority(), 3);
        assertEquals(input.get(3).getPriority(), 4);
    }

    @Test
    public void whenSortDownByPriority() {
        input.sort(new JobSorter.SortDownByPriority());
        assertEquals(input.get(0).getPriority(), 4);
        assertEquals(input.get(1).getPriority(), 3);
        assertEquals(input.get(2).getPriority(), 2);
        assertEquals(input.get(3).getPriority(), 1);
    }

    @Test
    public void whenSortUpByNameAndDownByPriority() {
        input.sort(new JobSorter.SortUpByName().thenComparing(new JobSorter.SortDownByPriority()));
        assertEquals(input.get(0), job2);
        assertEquals(input.get(1), job4);
        assertEquals(input.get(2), job1);
        assertEquals(input.get(3), job3);
    }

}