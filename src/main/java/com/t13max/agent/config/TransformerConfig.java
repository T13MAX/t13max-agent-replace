package com.t13max.agent.config;

import java.util.List;

/**
 * 修改配置类
 *
 * @author t13max
 * @since 18:23 2025/7/23
 */
public class TransformerConfig {

    public List<TransformerEntry> entries;

    public TransformerConfig() {
    }

    public List<TransformerEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<TransformerEntry> entries) {
        if (this.entries != null) {
            throw new IllegalStateException("entryList 已设置 不能重复设置");
        }
        this.entries = entries;
    }
}
