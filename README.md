# AndroidJetpack
#### Android Jetpack组件库学习

##### LifeCycle(组件)

生命周期感知型组件可执行操作来响应另一个组件（如 Activity 和 Fragment）的生命周期状态的变化。这些组件有助于您写出更有条理且往往更精简的代码，这样的代码更易于维护。

##### ViewModel

用于存放页面所需要的各种数据，对页面来说，它并不关心ViewModel中的业务逻辑，它只关心需要展示的数据是什么，并且希望在数据发送变化时，能及时得到通知并做出更新。

##### LiveData

在ViewModel中的数据发生变化时通知页面，用于包装ViewModel中那些需要被外界观察的数据。
LiveData 是一种可观察的数据存储器类。与常规的可观察类不同，LiveData 具有生命周期感知能力，意指它遵循其他应用组件（如 Activity、Fragment 或 Service）的生命周期。这种感知能力可确保 LiveData 仅更新处于活跃生命周期状态的应用组件观察者。

#### Navigation

Navigation 是一个框架，用于在 Android 应用中的“目标”之间导航，该框架提供一致的 API，无论目标是作为 Fragment、Activity 还是其他组件实现。

