package net.bobstudio.word2story;

import android.os.Handler;
import android.os.Message;

public class OneThread implements Runnable {
	Object lock = new Object();
	private volatile boolean exit = false;
	Handler handler;
	String word;

	public OneThread(Handler handler, String word) {
		exit = false;
		this.handler = handler;
		this.word = word;
	}

	@Override
	public void run() {
		int i = 8;
		while (!exit && i >= 0) {
			synchronized (lock) {
				try {
					lock.wait(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			setCurrentSeconds(i--);
		}

		if (i < 0 && !exit) {
			//handler.sendEmptyMessage(0);
			Message msg = new Message();
			msg.what = 0;
			msg.obj = word;
			handler.sendMessage(msg);
		}
	}

	public void exit() {
		exit = true;
	}

	private void setCurrentSeconds(int i) {
		Message msg = new Message();
		msg.what = 1;
		msg.arg1 = i / 10;
		msg.arg2 = i % 10;
		handler.sendMessage(msg);
	}
}
