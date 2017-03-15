package com.example.android.musicapp;



        import android.media.MediaPlayer;
        import android.os.Bundle;

        import android.support.v7.app.AppCompatActivity;

        import android.support.v7.widget.Toolbar;
        import android.view.View;

        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer Song;
    int pause;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void Play(View view){

        if(Song == null){
            Song = MediaPlayer.create(this , R.raw.song);
            Song = MediaPlayer.create(this , R.raw.songs);
            Song.start();


            Toast.makeText(MainActivity.this, "Song Play", Toast.LENGTH_SHORT).show();    }

        else if(!Song.isPlaying()){
            Song.seekTo(pause);
            Song.start();
            Toast.makeText(MainActivity.this, "Song Play", Toast.LENGTH_SHORT).show();     }
    }
    public void Pause(View view){
        if(Song!= null){
            Song.pause();
            pause = Song.getCurrentPosition();
            Toast.makeText(MainActivity.this, "Song Pause", Toast.LENGTH_SHORT).show();
        }
    }
    public void Stop(View view){

        Song.stop();
        Song = null;
        Toast.makeText(MainActivity.this, "Song Stop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Song.pause();
    }

}