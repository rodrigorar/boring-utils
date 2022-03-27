package com.rodrigorar.results;

import com.rodrigorar.guards.GuardArguments;

import java.util.function.Function;

public class Either<L, R> {
    private final L _leftValue;
    private final R _rightValue;

    private Either(L leftValue, R rightValue) {
        _leftValue = leftValue;
        _rightValue = rightValue;
    }

    public static <L, R> Either<L, R> left(L leftValue) {
        GuardArguments.NotNullOrThrow(leftValue);
        return new Either<L, R>(leftValue, null);
    }

    public L getLeft() {
        return _leftValue;
    }

    public boolean isLeft() {
        return _leftValue != null && _rightValue == null;
    }

    public <T> Either<T, R> mapLeft(Function<L, T> mappingFunction) {
        final T leftResult = mappingFunction.apply(_leftValue);
        return Either.left(leftResult);
    }

    public <T> Either<T, R> flatMapLeft(Function<L, Either<T, R>> mappingFunction) {
        return mappingFunction.apply(_leftValue);
    }

    public static <L, R> Either<L, R> right(R rightValue) {
        GuardArguments.NotNullOrThrow(rightValue);
        return new Either<L, R>(null, rightValue);
    }

    public R getRight() {
        return _rightValue;
    }

    public boolean isRight() {
        return _rightValue != null && _leftValue == null;
    }

    public <T> Either<L, T> mapRight(Function<R, T> mappingFunction) {
        final T rightResult = mappingFunction.apply(_rightValue);
        return Either.right(rightResult);
    }

    public <T> Either<L, T> flatMapRight(Function<R, Either<L, T>> mappingFunction) {
        return mappingFunction.apply(_rightValue);
    }

    public <T> T fold(Function<L, T> leftFunction, Function<R, T> rightFunction) {
        final T result;
        if (isRight()) {
            result = rightFunction.apply(_rightValue);
        } else {
            result = leftFunction.apply(_leftValue);
        }
        return result;
    }

    public Either<R, L> swap() {
        final Either<R, L> result;
        if (isRight()) {
            result = Either.left(_rightValue);
        } else {
            result = Either.right(_leftValue);
        }
        return result;
    }
}
