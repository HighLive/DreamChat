package HIGHLIVE.DreamChat_Demo_01.controller;

import HIGHLIVE.DreamChat_Demo_01.service.InputModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.lang.reflect.Member;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class DomainController {

    private final InputModule inputModule;

    @Autowired
    public DomainController(InputModule inputModule){
        this.inputModule = inputModule;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }


    // send URL => Post 메서드 호출
    @PostMapping("/")
    public ResponseEntity<Resource> create(URLform request, Model model){

        // 입력 모듈 클래스에 입력받은 URL 전달
        String video_id = inputModule.getURL(request.getUrl());

        // 그래프 이미지 확장자
        //String extension = ".png";
        //model.addAttribute("video_id", video_id + extension);


        // URL 경로로 전달한다.
        //String path = "C:\\Users\\jinh2\\Desktop\\2021-2\\capstone\\DreamChat_Demo_01\\DreamChat_Demo_01\\src\\main\\resources\\static\\graph\\";

        // for ubuntu
        String path = "/home/ubuntu/highlive/DreamChat_Demo_01/DreamChat_Demo_01/src/main/resources/static/graph/";
        String total = path + video_id + ".png";

        Resource resource = new FileSystemResource(total);

        if(!resource.exists()){
            return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
        }

        HttpHeaders header = new HttpHeaders();
        Path filepath = null;

        try{
            filepath = Paths.get(total);
            header.add("Content-Type", Files.probeContentType(filepath));
        } catch (IOException e){
            e.printStackTrace();
        }

        return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);

    }

}
