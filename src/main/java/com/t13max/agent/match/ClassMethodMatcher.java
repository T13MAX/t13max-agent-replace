package com.t13max.agent.match;

import javassist.expr.MethodCall;

import java.util.List;

/**
 * 类名+方法名匹配器
 *
 * @author t13max
 * @since 10:40 2025/7/25
 */
public class ClassMethodMatcher implements IMethodCallMatcher {

    private final String className;

    private final String methodName;

    public ClassMethodMatcher(List<String> args) {
        this.className = args.get(0);
        this.methodName = args.get(1);
    }

    @Override
    public boolean match(MethodCall methodCall) {
        String className = methodCall.getClassName();
        String methodName = methodCall.getMethodName();
        return this.className.equals(className) && this.methodName.equals(methodName);
    }
}
