---
id: jvm
title: JVM Extension
sidebar_label: JVM
---

The following section contains JVM-specific extensions to the build server
protocol.

## BSP version

`2.2.0`

## BSP Server remote interface

### BuildTargetJvmTestEnvironment: request

The JVM test environment request is sent from the client to the server in order to
gather information required to launch a Java process. This is useful when the
client wants to control the Java process execution, for example to enable custom
Java agents or launch a custom main class during unit testing or debugging

The data provided by this endpoint may change between compilations, so it should
not be cached in any form. The client should ask for it right before test execution,
after all the targets are compiled.

- method: `buildTarget/jvmTestEnvironment`
- params: `JvmTestEnvironmentParams`
- result: `JvmTestEnvironmentResult`

#### JvmTestEnvironmentParams

```ts
export interface JvmTestEnvironmentParams {
  targets: BuildTargetIdentifier[];

  originId?: Identifier;
}
```

#### JvmTestEnvironmentResult

```ts
export interface JvmTestEnvironmentResult {
  items: JvmEnvironmentItem[];
}
```

#### JvmEnvironmentItem

```ts
export interface JvmEnvironmentItem {
  target: BuildTargetIdentifier;

  classpath: string[];

  jvmOptions: string[];

  workingDirectory: string;

  environmentVariables: EnvironmentVariables;

  mainClasses?: JvmMainClass[];
}
```

#### JvmMainClass

```ts
export interface JvmMainClass {
  className: string;

  arguments: string[];
}
```

### BuildTargetJvmRunEnvironment: request

Similar to `buildTarget/jvmTestEnvironment`, but returns environment
that should be used for regular exection of main classes, not for testing

- method: `buildTarget/jvmRunEnvironment`
- params: `JvmRunEnvironmentParams`
- result: `JvmRunEnvironmentResult`

#### JvmRunEnvironmentParams

```ts
export interface JvmRunEnvironmentParams {
  targets: BuildTargetIdentifier[];

  originId?: Identifier;
}
```

#### JvmRunEnvironmentResult

```ts
export interface JvmRunEnvironmentResult {
  items: JvmEnvironmentItem[];
}
```

### BuildTargetJvmCompileClasspath: request

The build target classpath request is sent from the client to the server to
query the target for its compile classpath.

- method: `buildTarget/jvmCompileClasspath`
- params: `JvmCompileClasspathParams`
- result: `JvmCompileClasspathResult`

#### JvmCompileClasspathParams

```ts
export interface JvmCompileClasspathParams {
  targets: BuildTargetIdentifier[];
}
```

#### JvmCompileClasspathResult

```ts
export interface JvmCompileClasspathResult {
  items: JvmCompileClasspathItem[];
}
```

#### JvmCompileClasspathItem

```ts
export interface JvmCompileClasspathItem {
  target: BuildTargetIdentifier;

  /** The dependency classpath for this target, must be
   * identical to what is passed as arguments to
   * the -classpath flag in the command line interface
   * of scalac. */
  classpath: string[];
}
```

## BuildTargetData kinds

### JvmBuildTarget

This structure is embedded in
the `data?: BuildTargetData` field, when
the `dataKind` field contains `"jvm"`.

#### JvmBuildTarget

`JvmBuildTarget` is a basic data structure that contains jvm-specific
metadata, specifically JDK reference.

```ts
export interface JvmBuildTarget {
  /** Uri representing absolute path to jdk
   * For example: file:///usr/lib/jvm/java-8-openjdk-amd64 */
  javaHome?: URI;

  /** The java version this target is supposed to use (can be set using javac `-target` flag).
   * For example: 1.8 */
  javaVersion?: string;
}
```

## SourceItemData kinds

### JvmSourceItemData

This structure is embedded in
the `data?: SourceItemData` field, when
the `dataKind` field contains `"jvm"`.

#### JvmSourceItemData

`JvmSourceItemData` contains JVM-specific metadata for a source item.

```ts
export interface JvmSourceItemData {
  /** The package name associated with the source item.
   *
   * If the source item is a file, this value must match the package declaration within the file.
   *
   * If the source item is a directory, the package name can be empty if the directory is at the package root,
   * such as in a Maven structure (e.g., source directories like `src/main/java` and `src/test/java`).
   * In non-conventional directory structures, the package name for the directory should be set to the package prefix
   * that will be applied to all source files within the directory.
   * For example, if a source directory is `a`, containing a source file `a/b/Lib.java`
   * where the package name for `Lib` is `my.example.b`,
   * then the package prefix for the directory `a` should be set to `my.example`.
   * If a consistent package name cannot be applied to the source directory,
   * such as when each source file within the source directory has an arbitrary package name,
   * the package name for the source directory should be set to null. */
  packageName?: string;
}
```
