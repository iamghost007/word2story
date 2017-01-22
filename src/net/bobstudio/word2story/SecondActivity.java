package net.bobstudio.word2story;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SecondActivity extends Activity {
	private static final String TAG = "Index2Activity";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.v(TAG, "protected void onCreate()");
		
		setContentView(R.layout.activity_second);

		Button but2 = (Button) this.findViewById(R.id.button2);
		but2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				SecondActivity.this.finish();

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
