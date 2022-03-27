package com.rodrigorar.results;

public class TestError {
    private final Type _type;
    private final String _reason;

    private TestError(Type type, String reason) {
        _type = type;
        _reason = reason;
    }

    public Type getType() {
        return _type;
    }

    public String getReason() {
        return _reason;
    }

    public static TestError Creation(String reason) {
        return new TestError(Type.Creation, reason);
    }

    public static TestError Update(String reason) {
        return new TestError(Type.Update, reason);
    }

    public static TestError Delete(String reason) {
        return new TestError(Type.Delete, reason);
    }

    public static TestError Get(String reason) {
        return new TestError(Type.Get, reason);
    }

    public enum Type {
        Creation,
        Update,
        Delete,
        Get
    }
}
