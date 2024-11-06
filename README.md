# jx3api-java

The Java SDK to the JX3API.

使用说明

0、喜报，终于搞明白怎么推送到中央仓库，现在可以选择直接引用中央仓库配置来引用了

```
        <dependency>
            <groupId>io.github.jx3api</groupId>
            <artifactId>jx3-api-autoconfigure</artifactId>
            <version>1.1</version>
        </dependency>         
```

1、也可以本地安装一下，再引入

```
mvn clean install -DskipTests
```

2、在pom.xml中引入

```
        <dependency>
            <groupId>io.github.jx3api</groupId>
            <artifactId>jx3-api-autoconfigure</artifactId>
            <version>1.1</version>
        </dependency>         
```

3、实现`jx3api.api.ws.IWsDataPushService`该接口，由于sdk无法判断使用者到底要做什么，所以你必须要自己实现一个

4、在启动类添加相关注解

```
// 其中 jx3api.api 是配置扫描路径
@ComponentScan(basePackages = {"jx3api.api","com.example.demo"})

// 下列三个Enable注解，可以按需使用，EnableJX3Api包含后续两个
@EnableJX3Api
@EnableJX3ApiWS
@EnableJX3ApiHttp

```

**其他说明**

- 1、v1.1版本已经完成 FREE API、 V1 API、 V2 API的接口测试。
- VRF接口中`语音合成`接口设计到第三方标识，因此未进行测试，其他接口均可以在`jx3api.api.test.normal.NormalTest`中找到测试方法

**更新记录**

- V1.2
    - 增加`挂件效果`、qq秀相关接口
    - 删除 `资历榜单, /data/school/rank/statistical`接口
- V1.2.1
  - bugfix 修复了错误使用内部类，导致类无法外部使用的问题。
- V1.2.2
  - bugfix 增加objectmapper配置类，修复引字段缺失导致的整体序列化失败的问题，后果遇到字段缺失，可以提issues来添加
- V1.2.3
  - bugfix 修复了 因为内置objectmapper，并且外部也有objectmapper时，导致的问题。现在sdk通过spring获取托管的objectmapper。
  - 所以现在需要什么样的序列化方式，都由使用方决定了。测试请参考test模块下的测试类，和autoconfigure下的测试类
  - 所以一定要自行选择序列化的objectmapper。当然也可以使用`JacksonConfig.java`提供的示例代码，但是一定要托管给spring才生效