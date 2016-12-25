package com.example.snake.webservernanotest;

import java.util.Map;
import fi.iki.elonen.NanoHTTPD;

// Nano에서 상속받은 초간단 웹서버 
public class simpleWebSvr extends NanoHTTPD {

    public simpleWebSvr(int port){
        super(port);
    }

    @Override
    public Response serve(String uri, Method method,
                          Map<String, String> header,
                          Map<String, String> parameters,
                          Map<String, String> files) {
        String strResponse = "요청주소:" +  uri + "<br>" +"연결방식:" +  method.name() + "<br>" ;
        strResponse       += "Header:"   + header.toString() + "<br>";
        strResponse       += "param:"    + parameters.toString();

        return new NanoHTTPD.Response(strResponse);
    }

}
