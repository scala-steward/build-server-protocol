load("@aspect_rules_lint//format:defs.bzl", "format_multirun")
load("@npm//website:prettier/package_json.bzl", prettier = "bin")
load("@rules_java//java:defs.bzl", "java_binary")

package(default_visibility = ["//:__subpackages__"])

prettier.prettier_binary(
    name = "prettier",
    # Allow the binary to be run outside bazel
    env = {"BAZEL_BINDIR": "."},
)

java_binary(
    name = "java-format",
    jvm_flags = [
        "--add-exports jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED",
        "--add-exports jdk.compiler/com.sun.tools.javac.file=ALL-UNNAMED",
        "--add-exports jdk.compiler/com.sun.tools.javac.parser=ALL-UNNAMED",
        "--add-exports jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED",
        "--add-exports jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED",
    ],
    main_class = "com.google.googlejavaformat.java.Main",
    runtime_deps = ["@google-java-format//jar"],
)

java_binary(
    name = "scalafmt",
    data = ["//:.scalafmt.conf"],
    main_class = "org.scalafmt.cli.Cli",
    runtime_deps = ["@maven//:org_scalameta_scalafmt_cli_2_13"],
)

java_binary(
    name = "ktfmt",
    main_class = "com.facebook.ktfmt.cli.Main",
    runtime_deps = ["@ktfmt//jar"],
)

format_multirun(
    name = "format",
    java = ":java-format",
    javascript = ":prettier",
    kotlin = ":ktfmt",
    markdown = ":prettier",
    scala = ":scalafmt",
    starlark = "@buildifier_prebuilt//:buildifier",
)
