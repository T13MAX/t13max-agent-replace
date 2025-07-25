# 运行时修改字节码

## 快速开始

1. 添加JVM参数 指定javaagent -javaagent:/xxx/yyy/zzz/t13max-cx-agent-1.0-SNAPSHOT.jar
2. (可选) 添加JVM参数 指定transformer.yml文件 -Dtransformer.yml.path=/xxx/yyy/zzz/transformer.yml  (如果不指定
   则默认读取jar包内的配置)
3. 出现CommonTransformer.transform replace success等字样代表替换成功

## 配置transformer.yml

1. entries 顶级节点 下面是一个数组
2. 数组内有className, methodName, replace, matcher节点 分别代表类名, 方法名, 替换内容和匹配器
3. matcher器内有name和args两个节点 分别为匹配器名和参数列表

### 匹配器

- 用于匹配指定的代码 进行替换

#### LineNumberMatcher 行号匹配器

- 指定行号 进行替换 参数就是行号

#### ClassMethodMatcher 类名方法名匹配器

- 第一个参数为类名 第二个为方法名

#### 其他 待补充...

### yml示例

```yaml
entries:
  - className: "xxx.yyy.Zzz"
    methodName: "www"
    replace: ""
    matcher:
      name: "LineNumberMatcher"
      args:
        - "321"
  - className: "xxx.yyy.Zzz"
    methodName: "www"
    replace: ""
    matcher:
      name: "LineNumberMatcher"
      args:
        - "53"
```

## 成功日志示例

```
------------------------------------------------
AgentMain.permain begin!!
AgentMain.permain loadConfig!!
AgentMain.permain loadConfig success!!
AgentMain.permain addTransformers!!
CommonTransformer.transform replace success, className=xxx/yyy/Zzz1 methodName=www1
CommonTransformer.transform replace success, className=xxx/yyy/Zzz2 methodName=www2
CommonTransformer.transform replace success, className=xxx/yyy/Zzz3 methodName=www3
```