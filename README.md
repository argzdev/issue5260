# issue 5260
### Github link:
- https://github.com/firebase/firebase-android-sdk/issues/5260
### Summary
- mockk okhttp3.Call.Factory in Robolectric test when firebase-perf is enabled
### Steps to reproduce
- Go to the test scripts (issue5260/app/src/test[unitTest]/java/com.argz.issue5620/ExampleUnitTest)
- Run the unit test
- Test will fail with the following stacktrace:
```
java.lang.ExceptionInInitializerError
	at com.google.firebase.perf.config.ConfigResolver.<init>(ConfigResolver.java:78)
	at com.google.firebase.perf.config.ConfigResolver.getInstance(ConfigResolver.java:86)
	at com.google.firebase.perf.application.AppStateMonitor.<init>(AppStateMonitor.java:98)
	at com.google.firebase.perf.application.AppStateMonitor.getInstance(AppStateMonitor.java:87)
	at com.google.firebase.perf.metrics.NetworkRequestMetricBuilder.<init>(NetworkRequestMetricBuilder.java:92)
	at com.google.firebase.perf.metrics.NetworkRequestMetricBuilder.builder(NetworkRequestMetricBuilder.java:84)
	at com.google.firebase.perf.network.InstrumentOkHttpEnqueueCallback.<init>(InstrumentOkHttpEnqueueCallback.java:42)
	at com.google.firebase.perf.network.FirebasePerfOkHttpClient.enqueue(FirebasePerfOkHttpClient.java:73)
	at com.threekk.firebaseperf.issue.Requester.doRequest(Requester.kt:13)
	at com.threekk.firebaseperf.issue.ExampleUnitTest.exampleUntTest(ExampleUnitTest.kt:21)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)
	at java.base/java.lang.reflect.Method.invoke(Unknown Source)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:59)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:56)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)
	at org.robolectric.RobolectricTestRunner$HelperTestRunner$1.evaluate(RobolectricTestRunner.java:589)
	at org.robolectric.internal.SandboxTestRunner$2.lambda$evaluate$2(SandboxTestRunner.java:290)
	at org.robolectric.internal.bytecode.Sandbox.lambda$runOnMainThread$0(Sandbox.java:99)
	at java.base/java.util.concurrent.FutureTask.run(Unknown Source)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
	at java.base/java.lang.Thread.run(Unknown Source)
Caused by: java.lang.IllegalStateException: Default FirebaseApp is not initialized in this process null. Make sure to call FirebaseApp.initializeApp(Context) first.
	at com.google.firebase.FirebaseApp.getInstance(FirebaseApp.java:179)
	at com.google.firebase.perf.config.RemoteConfigManager.getInitialStartupMillis(RemoteConfigManager.java:91)
	at com.google.firebase.perf.config.RemoteConfigManager.<init>(RemoteConfigManager.java:85)
	at com.google.firebase.perf.config.RemoteConfigManager.<clinit>(RemoteConfigManager.java:52)
	... 26 more
```
