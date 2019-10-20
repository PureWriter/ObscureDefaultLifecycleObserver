# ObscureDefaultLifecycleObserver

In the Android official [Lifecycle](https://developer.android.com/jetpack/androidx/releases/lifecycle) library, a consumerProguardRule is included. It tells Proguard to keep all subclass class names that implement or inherit `LifecycleObserver` or `DefaultLifecycleObserver`:

For details, see https://github.com/aosp-mirror/platform_frameworks_support/blob/a9ac247af2afd4115c3eb6d16c05bc92737d6305/lifecycle/runtime/proguard-rules.pro

This leads our projects to unnecessarily expose a lot of code names that use `DefaultLifecycleObserver`. But in fact, for the subclasses of `DefaultLifecycleObserver` or `FullLifecycleObserver`, they don't need to be kept at all, and they can be completely obfuscated, because the Lifecycle framework doesn't reflect `FullLifecycleObserver` at all. Unfortunately, the Android official kept them all. Once we introduce the Lifecycle library, its consumerProguardRule content will inevitably be automatically merged into our project Proguard configuration and take effect.

---

在 Android 官方提供的 Lifecycle 库中，包含了一个 consumerProguardRule，它告诉 Proguard 需要 keep 住所有实现或继承 `LifecycleObserver` 或 `DefaultLifecycleObserver` 的子类类名:

详情可见: https://github.com/aosp-mirror/platform_frameworks_support/blob/a9ac247af2afd4115c3eb6d16c05bc92737d6305/lifecycle/runtime/proguard-rules.pro

这导致了我们不必要地暴露了很多使用到 `DefaultLifecycleObserver` 的代码命名，但实际上，对于 `DefaultLifecycleObserver` 或 `FullLifecycleObserver` 的子类，它们根本不需要被 keep 任何内容，它们都是可以完全混淆的，因为 Lifecycle 框架并不会对 `FullLifecycleObserver` 进行任何反射，可惜 Android 官方一股脑全给 keep 住了。一旦我们引入 Lifecycle 库，其 consumerProguardRule 内容将不可避免地自动合并到我们的工程 Proguard 配置中并生效。

**这篇文章提供了一个简单快速的解决办法：https://t.zsxq.com/VzNfmyb**
