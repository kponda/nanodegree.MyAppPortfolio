package jp.qox.myappportfolio;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    String willLaunchMessageTemplate = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.spotify).setOnClickListener(this);
        findViewById(R.id.score).setOnClickListener(this);
        findViewById(R.id.library).setOnClickListener(this);
        findViewById(R.id.build).setOnClickListener(this);
        findViewById(R.id.xyz).setOnClickListener(this);
        findViewById(R.id.capstone).setOnClickListener(this);
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
    public void onClick(View v) {
        if (v instanceof Button) {
            showWillLaunchToast(((Button) v).getText().toString());
        }
    }

    private void showWillLaunchToast(String appName) {
        if (willLaunchMessageTemplate == null) {
            final Resources resources = getResources();
            willLaunchMessageTemplate = resources.getString(R.string.will_launch_message);
        }
        Toast.makeText(this, String.format(willLaunchMessageTemplate, appName), Toast.LENGTH_SHORT)
                .show();
    }
}
