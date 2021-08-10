package(
    default_visibility = ["//src:__subpackages__"],
)

android_library(
    name = "greeter_activity",
    srcs = [
        "Greeter.java",
        "MainActivity.java",
    ],
    deps = [
        "//src/main/java/com/example/bazel/lib",
    ],
    javacopts = [
        "-source 8",
        "-target 8",
    ],
    manifest = "AndroidManifest.xml",
    resource_files = glob(["res/**"]),
)