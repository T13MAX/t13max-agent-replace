package com.t13max.agent.match;

import javassist.expr.MethodCall;

/**
 * 行号匹配器
 *
 * @author t13max
 * @since 18:15 2025/7/23
 */
public class LineNumberMatcher implements IMethodCallMatcher {

    private final int lineNumber;

    public LineNumberMatcher(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public boolean match(MethodCall methodCall) {
        return lineNumber==methodCall.getLineNumber();
    }
}
