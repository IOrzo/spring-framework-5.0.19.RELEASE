/**
 * Common annotations with language-level semantics: nullability as well as JDK API indications.
 * These annotations sit at the lowest level of Spring's package dependency arrangement, even
 * lower than {@code org.springframework.util}, with no Spring-specific concepts implied.
 *
 * <p>Used descriptively within the framework codebase. Can be validated by build-time tools
 * (e.g. FindBugs or Animal Sniffer), alternative JVM languages (e.g. Kotlin), as well as IDEs
 * (e.g. IntelliJ IDEA or Eclipse with corresponding project setup).
 *
 * 具有语言级语义的常见注释：可空性以及JDK API指示
 * 这些批注位于Spring包依赖关系安排的最低级别，甚至比{@code org.springframework.util}低，并且没有暗示特定于Spring的概念。
 * 描述性地在框架代码库中使用。可以通过构建时工具进行验证
 */
package org.springframework.lang;
