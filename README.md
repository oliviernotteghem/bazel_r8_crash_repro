# Android Error Demo

A small project to reproduce corner case R8 issue. 

# Conditions

The conditions where issue occurs:

- android app is built with `--nojava_header_compilation` option
- a **separate** module defines a **generic** interface
- a child subclass of this interface defines a **default** for one of the **generics** interface method
- another module defines a subclass of child interface

# Repro

`bazel build //src/main:app --nojava_header_compilation`

# Error

`````ERROR: /Users/oliviern/Uber/bazel_r8_issue_repro/src/main/java/com/example/bazel/BUILD:5:16: Dexing src/main/java/com/example/bazel/_dx/greeter_activity/libgreeter_activity.jar_desugared.jar with applicable dexopts [] failed (Exit 1): d8_dexbuilder failed: error executing command bazel-out/darwin-opt-exec-2B5CBBC6/bin/external/bazel_tools/tools/android/d8_dexbuilder ... (remaining 1 argument(s) skipped)
Error in bazel-out/android-armeabi-v7a-fastbuild/bin/src/main/java/com/example/bazel/_dx/greeter_activity/libgreeter_activity.jar_desugared.jar:com/example/bazel/Greeter$MyBooleanParameter.class at java.lang.Object com.example.bazel.Greeter$MyBooleanParameter.getDefaultValue():
NullPointerException during IR Conversion
Exception in thread "main" java.util.concurrent.ExecutionException: java.lang.RuntimeException: java.lang.RuntimeException: com.android.tools.r8.CompilationFailedException: Compilation failed to complete
	at java.base/java.util.concurrent.ForkJoinTask.get(ForkJoinTask.java:1006)
	at com.android.tools.r8.compatdexbuilder.CompatDexBuilder.a(:115)
	at com.android.tools.r8.compatdexbuilder.CompatDexBuilder.main(:1)
Caused by: java.lang.RuntimeException: java.lang.RuntimeException: com.android.tools.r8.CompilationFailedException: Compilation failed to complete
	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:490)
	at java.base/java.util.concurrent.ForkJoinTask.getThrowableException(ForkJoinTask.java:600)
	... 3 more
Caused by: java.lang.RuntimeException: com.android.tools.r8.CompilationFailedException: Compilation failed to complete
	at java.base/java.util.concurrent.ForkJoinTask$AdaptedCallable.exec(ForkJoinTask.java:1453)
	at java.base/java.util.concurrent.ForkJoinTask.doExec(ForkJoinTask.java:290)
	at java.base/java.util.concurrent.ForkJoinPool$WorkQueue.topLevelExec(ForkJoinPool.java:1020)
	at java.base/java.util.concurrent.ForkJoinPool.scan(ForkJoinPool.java:1656)
	at java.base/java.util.concurrent.ForkJoinPool.runWorker(ForkJoinPool.java:1594)
	at java.base/java.util.concurrent.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:177)
Caused by: com.android.tools.r8.CompilationFailedException: Compilation failed to complete
	at com.android.tools.r8.utils.W.a(:87)
	at com.android.tools.r8.D8.run(:11)
	at com.android.tools.r8.compatdexbuilder.CompatDexBuilder.a(:199)
	at java.base/java.util.concurrent.ForkJoinTask$AdaptedCallable.exec(ForkJoinTask.java:1448)
	... 5 more
Caused by: com.android.tools.r8.utils.b: Error: bazel-out/android-armeabi-v7a-fastbuild/bin/src/main/java/com/example/bazel/_dx/greeter_activity/libgreeter_activity.jar_desugared.jar:com/example/bazel/Greeter$MyBooleanParameter.class, java.lang.Object com.example.bazel.Greeter$MyBooleanParameter.getDefaultValue(), NullPointerException during IR Conversion
	at com.android.tools.r8.utils.P0.a(:21)
	at com.android.tools.r8.utils.W.a(:73)
	... 8 more```