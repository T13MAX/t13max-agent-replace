package com.t13max.agent.match;

import javassist.expr.MethodCall;

/**
 * MethodCall匹配器
 *
 * @author t13max
 * @since 18:14 2025/7/23
 */
public interface IMethodCallMatcher {

    boolean match(MethodCall methodCall);
}
