package com.t13max.agent;

import com.t13max.agent.config.TransformerConfig;
import com.t13max.agent.config.TransformerEntry;
import com.t13max.agent.match.MatcherFactory;
import com.t13max.agent.transformer.CommonTransformer;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.instrument.Instrumentation;

/**
 * @author t13max
 * @since 15:15 2025/7/23
 */
public class AgentMain {

    private final static String PROPERTY_NAME = "transformer.yml.path";

    private static TransformerConfig TRANSFORMER_CONFIG;

    public static void premain(String agentArgs, Instrumentation inst){

        System.out.println("------------------------------------------------");
        System.out.println("AgentMain.permain begin!!");

        try {
            System.out.println("AgentMain.permain loadConfig!!");
            loadConfig();
        }catch (Exception exception){
            System.err.println("AgentMain.permain loadConfig error!!");
            exception.printStackTrace();
        }

        System.out.println("AgentMain.permain loadConfig success!!");

        System.out.println("AgentMain.permain addTransformers!!");
        addTransformers(inst);
    }

    private static void addTransformers(Instrumentation inst) {
        for (TransformerEntry transformerEntry : TRANSFORMER_CONFIG.getEntries()) {
            addTransformer(inst, new CommonTransformer(transformerEntry.getClassName(), transformerEntry.getMethodName(), MatcherFactory.createMatcher(transformerEntry.getMatcher().getName(), transformerEntry.getMatcher().getArgs()), transformerEntry.getReplace()));
        }
    }

    private static void addTransformer(Instrumentation inst, CommonTransformer commonTransformer) {
        inst.addTransformer(commonTransformer);
    }

    private static void loadConfig() throws Exception {

        String confName = System.getProperty(PROPERTY_NAME);
        InputStream inputStream;

        if (confName != null && new File(confName).exists()) {
            inputStream = new FileInputStream(confName);
        } else {
            inputStream = AgentMain.class.getClassLoader().getResourceAsStream("transformer.yml");
        }

        Yaml yaml = new Yaml();

        TRANSFORMER_CONFIG = yaml.loadAs(inputStream, TransformerConfig.class);

    }
}
