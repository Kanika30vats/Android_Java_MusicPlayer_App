package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.song_bandeya);

        Button playButton = (Button) findViewById(R.id.play_button);
        playButton.setOnClickListener(new View.OnClickListener()
        {
             public void onClick(View v)
             {
                 mediaPlayer.start();
                 /**
                  * Using asyn callback to be notified when song finishes.
                  * In the meantime, we can do other things like respond to buttons from user.
                  */
                 mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                     @Override
                     public void onCompletion(MediaPlayer mediaPlayer) {
                         Toast.makeText(MainActivity.this, "I'm done", Toast.LENGTH_SHORT).show();
                     }
                 });
                 mediaPlayer.setLooping(true);
                 /**
                  * This message was written to test the working of the Play Button.
                  * Toast.makeText(MainActivity.this, "Play", Toast.LENGTH_SHORT).show();
                  */
             }
        });

        Button pauseButton = (Button) findViewById(R.id.pause_button);
        pauseButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                mediaPlayer.pause();
                /**
                 *
                 * This message was written to test the working of the Pause Button.
                 * Toast.makeText(MainActivity.this, "Pause", Toast.LENGTH_SHORT).show();
                 */
            }
        });

        Button seekButton = (Button) findViewById(R.id.seek_button);
        seekButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                mediaPlayer.seekTo(170000);
                /**
                 *
                 * This message was written to test the working of the Pause Button.
                 * Toast.makeText(MainActivity.this, "Pause", Toast.LENGTH_SHORT).show();
                 */
            }
        });
    }
}