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