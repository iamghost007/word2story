package net.bobstudio.word2story;

import static net.bobstudio.word2story.IData.*;

import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
//import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initData();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void initData() {
		unshowRedunantBtn();

		showGreetings();

		handleStart();

		handleExit();

		makeupWord();

	}

	private void showGreetings() {
		String word = GREETINGS[Utils.getRandom(GREETINGS.length)];

		int i = 0;
		for (int id : BACKLOG_IDS) {
			setTextValueById(id, String.valueOf(word.charAt(i++)));
		}

	}

	private void handleStart() {
		View start = (ImageView) this.findViewById(R.id.btnStart);
		start.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (oneThread != null) {
					oneThread.exit();
				}

				String word = Utils.getOneWord();
				List<String> allLetters = Utils.getTenLetters(word);
				int i = 0;
				for (String s : allLetters) {
					if (i < BACKLOG_IDS.length) {
						setTextValueById(BACKLOG_IDS[i++], s);
					}
				}

				EditText text = (EditText) findViewById(R.id.editText1);
				text.setText("");

				oneThread = new OneThread(handler,word);
				new Thread(oneThread).start();

			}
		});

	}

	private void makeupWord() {
		for (int i = 0; i < BACKLOG_IDS.length; i++) {

			TextView one = (TextView) this.findViewById(BACKLOG_IDS[i]);
			// final String letter = String.valueOf(one.getText());
			one.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View view) {
					String letter = String.valueOf(((TextView) view).getText());
					EditText text = (EditText) findViewById(R.id.editText1);
					text.setText(text.getText() + letter);
				}

			});
		}
	}

	private void handleExit() {
		final Activity ac = this;
		View exit = (ImageView) this.findViewById(R.id.btnExit);
		exit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				ac.finish();
			}
		});

	}

	private void setTextValueById(int id, String value) {
		TextView one = (TextView) findViewById(id);
		one.setText(value);
	}

	@SuppressWarnings("deprecation")
	private void unshowRedunantBtn() {

		ImageView one = (ImageView) this.findViewById(R.id.redundant_1);
		one.setAlpha(0);
	}

	Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);

			switch (msg.what) {
			case 1:
				// Log.v("num::"+String.valueOf(msg.arg1)+",num2::"+String.valueOf(msg.arg2));
				setTextValueById(R.id.num_1, String.valueOf(msg.arg1));
				setTextValueById(R.id.num_2, String.valueOf(msg.arg2));
				break;
			case 0:
				Intent intentRef = new Intent();
				intentRef.setClass(MainActivity.this, SecondActivity.class);
				startActivity(intentRef);

				EditText text = (EditText) findViewById(R.id.editText1);
				text.setText((String)msg.obj);
				
				break;
			}

		}

	};

	OneThread oneThread;

}
