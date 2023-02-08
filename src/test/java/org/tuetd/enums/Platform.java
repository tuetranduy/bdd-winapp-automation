package org.tuetd.enums;

import java.util.Arrays;

public enum Platform {
    WINDOWS("windows");

    public final String name;

    Platform(String name) {
        this.name = name;
    }

    public static Platform getPlatform(String value) {
        return Arrays.stream(Platform.values())
                .filter(platform -> platform.name.equalsIgnoreCase(value))
                .findFirst()
                .orElse(Platform.WINDOWS);
    }
}
