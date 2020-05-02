# Java中比较实用实体工具介绍

[源码地址](https://github.com/Nullrable/beancopy
)
大家一般编码过程中，经常会遇到DO对象转化为DTO对象，对象和对象之间转换一般需要用到转换工具，毕竟使用getter/setter太过麻烦

```
DO： Domain Object，领域对象，一般从现实世界或业务逻辑中抽离出的业务实体，对内使用

DTO：Data Transfer Object，数据传输对象，用于展示层与服务层之间的数据传输对象，对外使用
```

## MapStruct介绍
官方介绍：
```
MapStruct is a Java annotation processor for the generation of type-safe bean mapping classes.
```
大意为MapStruct是一个以**注解**的方式，生成**类型安全**的一个实体映射类。

其中关键字是：注解和类型安全，注解好理解，怎么理解类型安全呢？

可以这么理解：类型转化中必须指定具体的类型（不能使用范性，因为MapStruct是在编译期生成实现，类似lombok），Java编译器会针对任何表达式推断出一个明显类型（Apparent Type），Java编译器可以基于明显类型进行类型检查

[相关资料](https://mapstruct.org/documentation/stable/reference/html/)
## cglib介绍
是一个强大的，高性能，高质量的Code生成类库，它可以在运行期扩展Java类与实现Java接口。Hibernate支持它来实现PO(Persistent Object 持久化对象)**字节码**的动态生成。
在实现内部，CGLIB库使用了ASM这一个轻量但高性能的字节码操作框架来转化字节码，产生新类。

[相关资料](https://github.com/cglib/cglib/wiki)
## Spring BeanUtils介绍
Spring BeanUtils提供对Java反射和自省API的包装。其主要目的是利用反射机制对JavaBean的属性进行处理

[相关资料
](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/BeanUtils.html)
## 性能对比

|  | 100 | 1000 | 10000 | 100000 |
| --- | --- | --- | --- | --- |
| MapStruct | 8 | 16 | 40 | 107 |
| cglib | 254 | 365 | 773 | 3391 |
| BeanUtils | 176 | 500 | 1450 | 6339 |
单位：ms

可以看到，上面当复制对象大于10000时，各个性能表现MapStruct > cglib > BeanUtils，而且MapStruct表现情况最为稳定；本文中只测试了转换java bean的个数，严谨上存在欠缺。

从上面介绍中可以知道，cglib和Spring BeanUtils是在运行时进行转换，而MapStruct是在编译时进行转换。

## 编译时和运行时
编译时

```
就是编译器将源代码翻译成机器能识别的代码，比如Java只有JVM识别的字节码，,C#中只有CLR能识别的MSIL。
编译器就像老师一样，会帮学生进行词法分析，愈发语法分析，有没有错别字和病句，如果有错误就会显示的知名error或warnning。这个就是Java中编译时检查或者静态检查
```
运行时

```
将代码装载到内存中，先运行起来，然后再去类型检查或者错误（比如1/0）
```
