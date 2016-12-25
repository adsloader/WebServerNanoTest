package com.example.snake.webservernanotest;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

// Activity로 상속받아야 "Them 에디터로 만든 스타일"이 먹힌다.
// 안드로이드의 흑역사가 만든 애매한 상황의 애매한 설정...ㅠㅠ
public class MainActivity extends Activity {
    private simpleWebSvr server;
    private static final int PORT = 8080;
    private String sIP;
    private TextView txtIPInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setIpUI();
        startWebServer();

    }

    // 웹서버 생성 및 시작
    private void startWebServer() {
        server = new simpleWebSvr(PORT);
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 화면설정
    private void setIpUI() {
        txtIPInfo = (TextView) findViewById(R.id.txtAddr);
        sIP = Util.getLocalIpAddress();

        if (sIP != null) {
            txtIPInfo.setText("http://" + sIP + ":" + PORT);
        } else {
            txtIPInfo.setText("WiFi 연결이 되어있지 않습니다.");
        }

    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        if (server != null)
            server.stop();
    }

}
