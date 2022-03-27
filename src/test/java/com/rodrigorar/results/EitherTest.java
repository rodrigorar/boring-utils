package com.rodrigorar.results;

import com.rodrigorar.helpers.NotImplementedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EitherTest {
    private static final String VALID_RIGHT = "Test object created";
    private static final String NULL_RIGHT = null;

    private static final TestError VALID_LEFT = TestError.Creation("Failed to create");
    private static final TestError NULL_LEFT = null;

    // left & isLeft & getLeft

    @Test
    public void left_validInput_success() {
        final Either <TestError, String> underTest = Either.left(VALID_LEFT);

        Assertions.assertNotNull(underTest);
        Assertions.assertTrue(underTest.isLeft());
        Assertions.assertEquals(VALID_LEFT, underTest.getLeft());
    }

    @Test
    public void left_invalidInput_Failure() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Either.left(NULL_LEFT));
    }

    // mapLeft

    @Test
    public void mapLeft_validFunction_success() {
        // TODO: Not implemented
        throw new NotImplementedException("EitherTest#mapLeft_validFunction_success");
    }

    @Test
    public void mapLeft_validFunction_failure() {
        // TODO: Not implemented
        throw new NotImplementedException("EitherTest#mapLeft_validFunction_failure");
    }

    @Test
    public void mapLeft_invalidFunction_failure() {
        // TODO: Not implemented
        throw new NotImplementedException("EitherTest#mapLeft_invalidFunction_failure");
    }

    // flatMapLeft

    @Test
    public void flatMapLeft_validFunction_success() {
        // TODO: Not implemented
        throw new NotImplementedException("EitherTest#mapRight_validFunction_success");
    }

    @Test
    public void flatMapLeft_validFunction_error() {
        // TODO: Not implemented
        throw new NotImplementedException("EitherTest#mapRight_validFunction_error");
    }

    @Test
    public void flatMapLeft_invalidFunction_error() {
        // TODO: Not implemented
        throw new NotImplementedException("EitherTest#mapRight_invalidFunction_error");
    }

    // right & isRight & getRight

    @Test
    public void right_validInput_success() {
        final Either <TestError, String> underTest = Either.right(VALID_RIGHT);

        Assertions.assertNotNull(underTest);
        Assertions.assertTrue(underTest.isRight());
        Assertions.assertEquals(VALID_RIGHT, underTest.getRight());
    }

    @Test
    public void right_invalidInput_Failure() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Either.right(NULL_RIGHT));
    }

    // mapRight

    @Test
    public void mapRight_validFunction_success() {
        // TODO: Not implemented
        throw new NotImplementedException("EitherTest#mapLeft_validFunction_success");
    }

    @Test
    public void mapRight_validFunction_failure() {
        // TODO: Not implemented
        throw new NotImplementedException("EitherTest#mapLeft_validFunction_failure");
    }

    @Test
    public void mapRight_invalidFunction_failure() {
        // TODO: Not implemented
        throw new NotImplementedException("EitherTest#mapLeft_invalidFunction_failure");
    }

    // flatMapLeft

    @Test
    public void flatMapRight_validFunction_success() {
        // TODO: Not implemented
        throw new NotImplementedException("EitherTest#mapRight_validFunction_success");
    }

    @Test
    public void flatMapRight_validFunction_error() {
        // TODO: Not implemented
        throw new NotImplementedException("EitherTest#mapRight_validFunction_error");
    }

    @Test
    public void flatMapRight_invalidFunction_error() {
        // TODO: Not implemented
        throw new NotImplementedException("EitherTest#mapRight_invalidFunction_error");
    }

    // fold

    @Test
    public void fold_rightValue_success() {
        // TODO: Not implemented
        throw new NotImplementedException("EitherTest#fold_rightValue_success");
    }

    @Test
    public void fold_leftValue_success() {
        // TODO: Not implemented
        throw new NotImplementedException("EitherTest#fold_leftValue_success");
    }

    // swap

    @Test
    public void swap_rightValue_success() {
        Either<TestError, String> underTest = Either.right(VALID_RIGHT);
        Either<String, TestError> swappedValue = underTest.swap();

        Assertions.assertTrue(swappedValue.isLeft());
        Assertions.assertNotNull(swappedValue.getLeft());
        Assertions.assertEquals(VALID_RIGHT, swappedValue.getLeft());
    }

    @Test
    public void swap_leftValue_success() {
        Either<TestError, String> underTest = Either.left(VALID_LEFT);
        Either<String, TestError> swappedValue = underTest.swap();

        Assertions.assertTrue(swappedValue.isRight());
        Assertions.assertNotNull(swappedValue.getRight());
        Assertions.assertEquals(VALID_LEFT, swappedValue.getRight());
    }
}
