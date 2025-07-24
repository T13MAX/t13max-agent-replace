package com.t13max.agent.config;

import java.util.List;

/**
 * 匹配器配置
 *
 * @author t13max
 * @since 18:30 2025/7/23
 */
public class TransformerMatcher {

    private String name;

    private List<String> args;

    public TransformerMatcher() {
        // YAML用
    }

    public void setName(String name) {
        if (this.name != null) throw new IllegalStateException("name 已设置");
        this.name = name;
    }

    public void setArgs(List<String> args) {
        if (this.args != null) throw new IllegalStateException("args 已设置");
        this.args = args;
    }

    public String getName() {
        return name;
    }

    public List<String> getArgs() {
        return args;
    }
}