package com.drakeet.purewriter

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

/**
 * https://github.com/aosp-mirror/platform_frameworks_support/blob/a9ac247af2afd4115c3eb6d16c05bc92737d6305/lifecycle/runtime/proguard-rules.pro
 *
 * @author Drakeet Xu
 */
fun Lifecycle.addObserver(observer: ObscureDefaultLifecycleObserver) {
  addObserver(ObscureDefaultLifecycleObserverWrapper(observer))
}

fun Lifecycle.removeObscureObserver(observer: ObscureDefaultLifecycleObserver) {
  removeObserver(ObscureDefaultLifecycleObserverWrapper(observer))
}

interface ObscureDefaultLifecycleObserver {

  fun onCreate(owner: LifecycleOwner) {}

  fun onResume(owner: LifecycleOwner) {}

  fun onStart(owner: LifecycleOwner) {}

  fun onPause(owner: LifecycleOwner) {}

  fun onStop(owner: LifecycleOwner) {}

  fun onDestroy(owner: LifecycleOwner) {}
}

data class ObscureDefaultLifecycleObserverWrapper(val base: ObscureDefaultLifecycleObserver) : DefaultLifecycleObserver {

  override fun onCreate(owner: LifecycleOwner) = base.onCreate(owner)

  override fun onResume(owner: LifecycleOwner) = base.onResume(owner)

  override fun onStart(owner: LifecycleOwner) = base.onStart(owner)

  override fun onPause(owner: LifecycleOwner) = base.onPause(owner)

  override fun onStop(owner: LifecycleOwner) = base.onStop(owner)

  override fun onDestroy(owner: LifecycleOwner) = base.onDestroy(owner)
}
