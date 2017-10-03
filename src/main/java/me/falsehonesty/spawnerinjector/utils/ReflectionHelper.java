package me.falsehonesty.spawnerinjector.utils;

import java.lang.reflect.Field;

/**
 * Copyright 2017 (c) FalseHonesty
 */

public class ReflectionHelper {
    public static void setPrivateValue(Field field, Object instance, Object newVal) {
        field.setAccessible(true);

        try {
            field.set(instance, newVal);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
