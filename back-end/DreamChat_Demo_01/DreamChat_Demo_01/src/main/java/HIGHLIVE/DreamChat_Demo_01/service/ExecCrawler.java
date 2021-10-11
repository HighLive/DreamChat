package HIGHLIVE.DreamChat_Demo_01.service;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

import java.io.IOException;

public class ExecCrawler implements ExecPython{
    private String path;

    // Json 파일 만들고 저장할 절대경로 지정
    public ExecCrawler(String path){
        this.path = path;
    }

    @Override
    public int execPythonProgram(String arg) {
        String[] commands = new String[3];
        commands[0] = "python3";
        commands[1] = path + "crawler.py"; // 파이썬 실행 프로그램 경로
        commands[2] = arg;      // vedio_id
        int result = -1;

        // 커멘드라인으로 파이썬 프로그램 실행
        try{
            result = execByCommandLine(commands);
        } catch (Exception e){
            e.printStackTrace();
            return 1;
        }

        return result;
    }

    @Override
    public int execByCommandLine(String[] command) throws IOException {
        CommandLine commandLine = CommandLine.parse(command[0]);
        for (int i = 1, n = command.length; i < n; i++) {
            commandLine.addArgument(command[i]);
        }

        DefaultExecutor executor = new DefaultExecutor();

        executor.execute(commandLine);
        //System.out.println("finished!");


        return 0;   // 정상 수행
    }
}
