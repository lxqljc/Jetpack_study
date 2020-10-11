### 使用LifeCycle解耦页面与组件

* 通过观察者模式，是组件感知生命周期回调。
* 组件代码与页面生命周期回调解耦。



### 案例分析

需求：在用户打开某个页面时，获取用户当前的地理位置。

步骤：

1. 编写一个MyLocationListener的类，该类就是我们自定义的组件，使其实现LifecycleObserver.
2. 编写获取地理位置方法步骤，在对应的方法上加上生命周期注解@OnLifecycleEvent(Lifecycle.Event.xxx)，当页面执行对应的生命周期时，会自动调用该方法。
3. 将页面生命周期对象绑定组件观察者MyLocationListener。

