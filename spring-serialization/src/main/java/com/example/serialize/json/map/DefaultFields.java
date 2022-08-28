package com.example.serialize.json.map;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@ToString
@RequiredArgsConstructor
final class DefaultFields<T> {
    private final List<T> fields;

    boolean is(T... args) {
        return fields.equals(List.of(args));
    }

    static <T> DefaultFields<T> defaultFields(T... fields) {
        return new DefaultFields<>(List.of(fields));
    }
}
