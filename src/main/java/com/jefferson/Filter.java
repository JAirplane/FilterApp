package com.jefferson;

@FunctionalInterface
public interface Filter<T> {
    T apply(T o);
}
