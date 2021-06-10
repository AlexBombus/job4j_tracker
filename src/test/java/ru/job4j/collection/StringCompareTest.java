package ru.job4j.collection;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;

public class StringCompareTest {
    @Test
    public void whenStringsAreEqualThenZero() {
        StringCompare comp = new StringCompare();
        int rst = comp.compare(
                "Ivanov",
                "Ivanov"
        );
        MatcherAssert.assertThat(rst, is(0));
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        StringCompare comp = new StringCompare();
        int rst = comp.compare(
                "Ivanov",
                "Ivanova"
        );
        MatcherAssert.assertThat(rst, lessThan(0));
    }

    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        StringCompare comp = new StringCompare();
        int rst = comp.compare(
                "Petrov",
                "Ivanova"
        );
        MatcherAssert.assertThat(rst, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive() {
        StringCompare comp = new StringCompare();
        int rst = comp.compare(
                "Petrov",
                "Patrov"
        );
        MatcherAssert.assertThat(rst, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative() {
        StringCompare comp = new StringCompare();
        int rst = comp.compare(
                "Patrova",
                "Petrov"
        );
        MatcherAssert.assertThat(rst, lessThan(0));
    }
}