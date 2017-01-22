package net.bobstudio.word2story;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import android.util.Log;

import static net.bobstudio.word2story.IData.*;

public class Utils {

	public static int getRandom(int max) {
		return new Random().nextInt(max);
	}

	public static List<String> getTenLetters(String word) {
		int max = 26; // LETTERS.length
		List<String> list = Arrays.asList(word.split(""));
		List<String> allLetters = new ArrayList<String>();
		for (int j = word.length(); j < 10; j++) {
			allLetters.add(String.valueOf(LETTERS[getRandom(max)]));
		}
		allLetters.addAll(list);
		allLetters.remove("");
		Log.v("UTILS", "word::" + word+", letters::"+allLetters);
		Collections.shuffle(allLetters);

		return allLetters;
	}

	public static int getAllWordsNum() {
		int num = 0;
		for (String[] s : WORDS) {
			num += s.length;
		}

		return num;
	}

	public static String getOneWord() {
		int num = getAllWordsNum();
		int index = getRandom(num);

		return matchWord(0, index);
	}

	private static String matchWord(int serial, int index) {
		if (WORDS[serial].length > index) {
			return WORDS[serial][index].toUpperCase();
		} else {
			return matchWord(serial + 1, index - WORDS[serial].length);
		}
	}

}
