package com.lmy.jvmPerson;


/**
 *
 * 命令行解析工具单元测试
 */
public class CommandUtilTest {

    /**
     * 1.查看版本
     * @param args -version
     *   sout java version "1.8.0"
     *
     *
     * 2.查看帮助
     * @param args -h | -help
     *   sout 用法: <main class> [-options] class [args...]
     *
     *
     * 3.查看类路径及参数
     * @param args -cp | -classpath com.lmy.jvmPerson.CommandUtilTest.main com.lmy.jvmPerson.CommandUtilTest.main
     *   sout classpath:com.lmy.jvmPerson.CommandUtilTest.main class:com.lmy.jvmPerson.CommandUtilTest.main args:null
     */
    public static void main(String[] args) {
        CommandUtil commandUtil = CommandUtil.parse(args);
        if (!commandUtil.success || commandUtil.helpFlag) {
            System.out.println("用法: <main class> [-options] class [args...]");
            return;
        }
        if (commandUtil.versionFlag) {
            System.out.println("java version \"1.8.0\"");
            return;
        }
        startJvm(commandUtil);
    }

    private static void startJvm(CommandUtil commandUtil) {
        System.out.printf("classpath:%s class:%s args:%s\n", commandUtil.classpath, commandUtil.getMainClass(), commandUtil.getArgs());
    }
}
