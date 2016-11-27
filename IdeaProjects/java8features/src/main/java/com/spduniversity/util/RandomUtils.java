package com.spduniversity.util;

import java.util.Random;

public class RandomUtils {

    public static String oneOf(String... variations) {
        return variations[new Random().nextInt(variations.length)];
    }

}
