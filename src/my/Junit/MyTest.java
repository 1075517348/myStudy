package my.Junit;

import org.junit.jupiter.api.*;

@DisplayName("JUNIT测试用类")
public class MyTest {
    // 定义待测试类的实例
    private TestSample testSample;

    // 定义在整个测试类开始执行前的操作
    // 通常包括全局和外部资源的创建和初始化
    @BeforeAll
    public static void init() {
    }

    // 定义在整个测试类完成后执行的操作
    // 通常包括全局和外部资源的释放销毁
    @AfterAll
    public static void cleanup() {

    }

    // 定义在每个测试用例开始前执行的操作
    // 通常包括基础数据和运行环境的准备
    @BeforeEach
    public void create() {
    }

    // 定义在每个测试用例完成后执行的操作
    // 通常包括运行环境的清理
    @AfterEach
    public void destroy() {
    }

    // 测试用例，某些操作
    @Test
    @DisplayName("测试用例A")
    public void someTestA() {
    }

    // 测试用例，某些操作
    @Test
    @DisplayName("测试用例B")
    public void someTestB() {

    }

    // Disabled将禁用测试用例
    // 该测试用例会出现在最终的报告中，但是不会被执行
    @Disabled
    @Test
    @DisplayName("不执行的测试用例C")
    public void someTestC() {

    }
}
