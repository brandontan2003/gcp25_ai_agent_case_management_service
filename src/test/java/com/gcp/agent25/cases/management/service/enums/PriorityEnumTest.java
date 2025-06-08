package com.gcp.agent25.cases.management.service.enums;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.gcp.agent25.cases.management.service.enums.PriorityEnum.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PriorityEnumTest {
    static Stream<Arguments> test_priorityEnum() {
        return Stream.of(
                Arguments.of(OPEN, OPEN.toString()),
                Arguments.of(IN_PROGRESS, IN_PROGRESS.toString()),
                Arguments.of(RESOLVED, RESOLVED.toString())
        );
    }

    @ParameterizedTest
    @MethodSource("test_priorityEnum")
    void test_priorityEnum(PriorityEnum expectedValue, String actualValue) {
        assertEquals(expectedValue.getValue(), actualValue);
    }
}
