package HIGHLIVE.DreamChat_Demo_01.service;


import org.junit.jupiter.api.Test;

class InputModuleTest {

    InputModule inputModule = new InputModule();
    String tempUrl = "https://www.twitch.tv/videos/724229279";


    @Test
    public void getURL(){
        inputModule.getURL(tempUrl);
    }
}
