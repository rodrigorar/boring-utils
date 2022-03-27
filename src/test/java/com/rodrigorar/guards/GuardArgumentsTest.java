package com.rodrigorar.guards;

import com.rodrigorar.TestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GuardArgumentsTest {
    private final String NOT_NULL_INPUT_VALUE = "test-string-value";

    private final String CONTROL_INPUT = "control-input";
    private final String VALID_INPUT = CONTROL_INPUT;
    private final String INVALID_INPUT = "invalid-input-value";

    private final String NULL_ERROR_MESSAGE = "The input field cannot be null";
    private final String INVALID_STATE_ERROR_MESSAGE = "The condition provided is not valid";

    // NotNullOrThrow

    @Test
    public void NotNullOrThrow_GenericException_NotNullInput() {
        GuardArguments.NotNullOrThrow(NOT_NULL_INPUT_VALUE);
    }

    @Test
    public void NotNullOrThrow_GenericException_NullInput() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> GuardArguments.NotNullOrThrow(null));
    }

    @Test
    public void NotNullOrThrow_GenericExceptionWithMessage_NotNullInput() {
        GuardArguments.NotNullOrThrow(NOT_NULL_INPUT_VALUE, NULL_ERROR_MESSAGE);
    }

    @Test
    public void NotNullOrThrow_GenericExceptionWithMessage_NullInput() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> GuardArguments.NotNullOrThrow(null, NULL_ERROR_MESSAGE));
    }

    @Test
    public void NotNullOrThrow_CustomException_NotNullInput() {
        GuardArguments.NotNullOrThrow(NOT_NULL_INPUT_VALUE, () -> new TestException());
    }

    @Test
    public void NotNullOrThrow_CustomException_NullInput() {
        Assertions.assertThrows(
            TestException.class,
                () -> GuardArguments.NotNullOrThrow(null, () -> new TestException(NULL_ERROR_MESSAGE)));
    }

    // ValidStateOrThrow

    @Test
    public void ValidStateOrThrow_GenericException_ValidInput() {
        GuardArguments.ValidStateOrThrow(CONTROL_INPUT.equals(VALID_INPUT));
    }

    @Test
    public void ValidStateOrThrow_GenericException_InvalidInput() {
        Assertions.assertThrows(
                IllegalStateException.class,
                () -> GuardArguments.ValidStateOrThrow(CONTROL_INPUT.equals(INVALID_INPUT)));
    }

    @Test
    public void ValidStateOrThrow_GenericExceptionWithMessage_ValidInput() {
        GuardArguments.ValidStateOrThrow(CONTROL_INPUT.equals(VALID_INPUT), INVALID_STATE_ERROR_MESSAGE);
    }

    @Test
    public void ValidStateOrThrow_GenericExceptionWithMessage_InvalidInput() {
        Assertions.assertThrows(
                IllegalStateException.class,
                () -> GuardArguments.ValidStateOrThrow(CONTROL_INPUT.equals(INVALID_INPUT), INVALID_STATE_ERROR_MESSAGE));
    }

    @Test
    public void ValidStateOrThrow_CustomException_ValidInput() {
        GuardArguments.ValidStateOrThrow(CONTROL_INPUT.equals(VALID_INPUT), TestException::new);
    }

    @Test
    public void ValidStateOrThrow_CustomException_InvalidInput() {
        Assertions.assertThrows(
                TestException.class,
                () -> GuardArguments.ValidStateOrThrow(
                        CONTROL_INPUT.equals(INVALID_INPUT),
                        () -> new TestException(INVALID_STATE_ERROR_MESSAGE)));
    }
}
