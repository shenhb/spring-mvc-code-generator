# spring-mvc-code-generator
spring-mvc-code-generator

# 简介
为方便生成springmvc框架中，controller、service、dao、entity等基础代码，基于Mybatis-Plus代码生成器以基础，扩展了yml配置方式

# 配置
详见项目文件resources/generator.yml

##如何使用
###下载release
可以前往[release页面](https://github.com/shenhb/spring-mvc-code-generator/releases/tag/1.0.0)下载window版程序，配置resources/generator/generator.yml文件，可根据自己的需要修改模板文件，运行spring-mvc-code-generator.exe

###下载代码
如果现有功能无法实现你的要求，可以通过下载项目代码进行修改，后运行com.muggle.generator.MpGenerator，运行前需先进入项目根目录执行命令编译工厂注解处理器模块
```
cd fatory
mvn clean install
```

# 参考

https://github.com/baomidou/mybatis-plus

https://github.com/sockeqwe/annotationprocessing101

