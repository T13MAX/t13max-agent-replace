package com.t13max.agent.match;

import lombok.experimental.UtilityClass;

import java.util.List;

/**
 * @author t13max
 * @since 18:37 2025/7/23
 */
@UtilityClass
public class MatcherFactory {

    public IMethodCallMatcher createMatcher(String name, List<String> args) {
        switch (name) {

            case "LineNumberMatcher" -> {
                if (args.isEmpty()) {
                    throw new IllegalArgumentException("MatcherFactory.createMatcher, name=" + name + " args=" + args);
                }
                int lineNumber = Integer.parseInt(args.getFirst());
                return new LineNumberMatcher(lineNumber);
            }
            default -> {
                throw new IllegalArgumentException("MatcherFactory.createMatcher, name=" + name);
            }
        }
    }
}
