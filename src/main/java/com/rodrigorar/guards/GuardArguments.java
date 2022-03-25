package com.rodrigorar.guards;

import java.util.function.Supplier;

public class GuardArguments {

    public static <T extends RuntimeException> void NotNullOrThrow(
            Object obj,
            Supplier<T> exceptionSupplier) {

        if (obj == null) {
            throw exceptionSupplier.get();
        }
    }

    public static void NotNullOrThrow(Object obj) {
        NotNullOrThrow(obj, IllegalArgumentException::new);
    }

    public static void NotNullOrThrow(Object obj, String message) {
        NotNullOrThrow(obj, () -> new IllegalArgumentException(message));
    }

    public static <T extends RuntimeException> void ValidStateOrThrow(
            boolean condition,
            Supplier<T> exceptionSupplier) {

        if (! condition) {
            throw exceptionSupplier.get();
        }
    }

    public static void ValidStateOrThrow(boolean condition) {
        ValidStateOrThrow(condition, IllegalStateException::new);
    }

    public static void ValidStateOrThrow(boolean condition, String message) {
        ValidStateOrThrow(condition, () -> new IllegalStateException(message));
    }
}
