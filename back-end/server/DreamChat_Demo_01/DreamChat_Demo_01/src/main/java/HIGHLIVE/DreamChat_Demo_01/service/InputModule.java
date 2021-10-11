package HIGHLIVE.DreamChat_Demo_01.service;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

@Service
public class InputModule {
    private String url;
    private String video_id;

    // 프로그램 경로
    //private static String pathOfCrawler = "C:\\Users\\jinh2\\Desktop\\2021-2\\capstone\\pythonProgram\\";
    //private static String pathOfFindHighlight = "C:\\Users\\jinh2\\Desktop\\2021-2\\capstone\\pythonProgram\\";
    private static String pathOfCrawler = "/home/ubuntu/highlive/pythonProgram/";
    private static String pathOfFindHighlight = "/home/ubuntu/highlive/pythonProgram/";

    private static ExecCrawler execCrawler = new ExecCrawler(pathOfCrawler);
    private static  ExecFindHighlight execFH = new ExecFindHighlight(pathOfFindHighlight);


    public String getURL(String url){
        this.url = url;

        // 올바른 url인지 check
        // IF 올바른 URL
            // 파이썬 실행
            // execPythonProgram

        // (1) URL 파싱 -> video_id 추출
        // https://www.twitch.tv/videos/1167834289

        String token = "/";
        StringTokenizer strTk = new StringTokenizer(url, token);

        ArrayList<String> pstr = new ArrayList<>();
        while(strTk.hasMoreTokens()){
            pstr.add(strTk.nextToken());
        }

        boolean find_Video_id = false;
        for(int i=0; i<pstr.size(); i++){
            //System.out.println(pstr.get(i));
            if(pstr.get(i).equals("videos")) {
                find_Video_id = true;
                video_id = pstr.get(i+1);
                break;
            }
        }
        if(!find_Video_id){
            System.out.println("can't find video_id");
        }

        // polling
        int flagCrawler = execCrawler.execPythonProgram(video_id);
        int flagFH = -1;
        if(flagCrawler == -1) {

        }else if(flagCrawler == 1){

        }
        else if(flagCrawler == 0){
            // 정상 수행
            flagFH = execFH.execPythonProgram(video_id);
        }

        if(flagFH == 0){
            // 그래프 출력

        }


        return video_id;
    }



}
