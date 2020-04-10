# geekbang-lessons
### 1.极客课程学习--lessons-in-spring  
#### 1.1. 面向对象编程
```Aware接口回调
契约接口 : ApplicationContextAware.class , BeanNameAware.class , BeanPostProcessor.class
   只要自定义类实现了*Aware接口,并复写了其方法, spring就会把ApplicationContext或BeanName这个参数回传到自定义类中复写的方法参数上,
   以供使用者调用

```
```设计模式
设计模式:观察者
    Spring基于Java8的EventObject进行实现,也就是ApplicationEvent.spring对其的一个简单实现SimpleApplicationEventMulticaster(广播器)

```
#### 1.2.面向切面编程
```动态代理:AopProxy接口
    CglibAopProxy(内联,asm是cglib的基础,对java汇编的操作),JdkDynamicAopProxy
```
#### 1.3.面向元编程
```注解:
@Component:有三个派生,@Service,@Repository,@Controller

```
```配置:
Environment抽象类:Profile(区分线上和线下等),Property(PropertyResolver父接口,数据源通过注解@PropertySource或者PropertySource<T>)

```

```泛型:
GenericTypeResolver泛型抽象类:
ResolvableType:
```

#### 1.4.函数驱动
```
```

#### 1.5.模块驱动
```Enable*
   eg.    EnableWebMvc
```