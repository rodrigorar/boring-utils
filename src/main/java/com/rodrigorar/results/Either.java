package com.rodrigorar.results;

import com.rodrigorar.helpers.NotImplementedException;

import java.util.function.Function;

public class Either<L, R> {
    private final L _leftValue;
    private final R _rightValue;

    private Either(L leftValue, R rightValue) {
        _leftValue = leftValue;
        _rightValue = rightValue;
    }

    public static <L, R> Either<L, R> left(L leftValue) {
        // TODO: Add some sort of null guard for left value

        return new Either<L, R>(leftValue, null);
    }

    public static <L, R> Either<L, R> right(R rightValue) {
        // TODO: Add some sort of null guard for left value

        return new Either<L, R>(null, rightValue);
    }

    public boolean isLeft() {
        return _leftValue != null && _rightValue == null;
    }

    public <T> Either<T, R> mapLeft(Function<L, T> mappingFunction) {
        T leftResult = mappingFunction.apply(_leftValue);
        return new Either<>(leftResult, null);
    }

    public <T> Either<T, R> flatMapLeft(Function<L, Either<T, R>> mappingFunction) {
        // TODO: Not implemented
        throw new NotImplementedException("Either#flatMapLeft");
    }

    public <T> T foldLeft(Function<L, R> foldingFunction) {
        // TODO: Not implemented
        throw new NotImplementedException("Either#foldLeft");
    }

    public boolean isRight() {
        return _rightValue != null && _leftValue == null;
    }

    public <T> Either<L, T> mapRight(Function<R, T> mappingFunction) {
        T rightResult = mappingFunction.apply(_rightValue);
        return new Either<>(null, rightResult);
    }

    public <T> Either<L, T> flatMapRight(Function<Either<L, T>, R> mappingFunction) {
        // TODO: Not implemented
        throw new NotImplementedException("Either#flatMapRight");
    }

    public <T> T foldRight(Function<R, T> foldingFunction) {
        // TODO: Not implemented
        throw new NotImplementedException("Either#foldRight");
    }

    public <T> T fold(Function<L, T> leftFunction, Function<R, T> rightFunction) {
        // TODO: Not implemented
        throw new NotImplementedException("Either#fold");
    }

    public Either<R, L> swap() {
        // TODO: Not implemented
        throw new NotImplementedException("Either#swap");
    }
}
