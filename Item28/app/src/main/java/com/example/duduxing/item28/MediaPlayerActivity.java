package com.example.duduxing.item28;
//使用MediaPalyer实现音乐播放器，包括播放、暂停、停止等功能
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MediaPlayerActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button1, button2, button3;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        mediaPlayer = MediaPlayer.create(this, R.raw.music);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.button1:
                mediaPlayer.start();
                Toast.makeText(MediaPlayerActivity.this, "播放", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                mediaPlayer.pause();
                Toast.makeText(MediaPlayerActivity.this, "暂停", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button3:
                mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(this, R.raw.music);
                Toast.makeText(MediaPlayerActivity.this, "停止", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
