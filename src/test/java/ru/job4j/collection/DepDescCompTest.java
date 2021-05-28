package ru.job4j.collection;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

public class DepDescCompTest {

    @Test
    public void compare() {
        int rsl = new DepDescComp().compare(
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        MatcherAssert.assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenUpDepartmentGoBefore() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K2/SK1"
        );
        MatcherAssert.assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenUpDepartmentGoAfter() {
        int rsl = new DepDescComp().compare(
                "K2/SK1/SSK1",
                "K2/SK1"
        );
        MatcherAssert.assertThat(rsl, greaterThan(0));
    }

}