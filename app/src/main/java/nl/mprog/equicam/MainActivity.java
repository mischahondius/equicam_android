package nl.mprog.equicam;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity implements MediaPlayer.MediaPlayerCallback {

    // callback handler
    @Override
    public int Status(int arg) {return 0;}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create Playr instance
        MediaPlayer player = new MediaPlayer();
        player = (MediaPlayer)findViewById(R.id.playerView);
// Get player instance
//        ...
// Connect or start playback
        player.Open(ConnectionUrl or File name,
                decoderType,
                rendererType,
                synchroEnable,
                synchroNeedDropVideoFrames,
                rendererEnableColorVideo,
                rendererEnableAspectRatio,
                DataReceiveTimeout,
                decoderNumberOfCpuCores,
                this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy()
    {
        // Destroy and close player
        if (player != null)
        {
        // Close connection to server
                    player.close ();
        // Desroy player
                    player.onDestroy();
                }
                super.onDestroy();
    }
}
