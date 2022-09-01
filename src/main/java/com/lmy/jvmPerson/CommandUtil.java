package com.lmy.jvmPerson;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.util.List;

/**
 *
 * 命令行工具
 * @desc
 */
public class CommandUtil {

    @Parameter(description = "入口方法及参数")
    List<String> mainClassAndArgs;

    @Parameter(names = {"-cp", "-classpath"}, description = "class文件路径", order = 1)
    String classpath;

    @Parameter(names = {"-version"}, description = "输出版本信息", order = 2)
    boolean versionFlag;

    @Parameter(names = {"-?", "-help"}, description = "输出帮助信息", order = 3,  help = true)
    boolean helpFlag = false;

    boolean success;

    String getMainClass() {
        return mainClassAndArgs != null && !mainClassAndArgs.isEmpty()
                ? mainClassAndArgs.get(0)
                : null;
    }

    List<String> getArgs() {
        return mainClassAndArgs != null && mainClassAndArgs.size() > 1
                ? mainClassAndArgs.subList(1, mainClassAndArgs.size())
                : null;
    }

    static CommandUtil parse(String[] argv) {
        CommandUtil args = new CommandUtil();
        JCommander cmd = JCommander.newBuilder().addObject(args).build();
        cmd.parse(argv);
        args.success = true;
        return  args;
    }
}
