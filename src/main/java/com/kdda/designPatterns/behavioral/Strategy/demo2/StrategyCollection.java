package com.kdda.designPatterns.behavioral.Strategy.demo2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tiyong
 * @date 24/09/2024 10:49
 */
public class StrategyCollection {
    public static final Map<String, StrategyEnum> map = new HashMap<>();

    static {
        map.put("A", StrategyEnum.A);
        map.put("B", StrategyEnum.B);
    }
}
