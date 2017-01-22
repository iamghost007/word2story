package net.bobstudio.word2story;

public interface IData {
	int[] BACKLOG_IDS = new int[] { R.id.backlog_1, R.id.backlog_2,
			R.id.backlog_3, R.id.backlog_4, R.id.backlog_5, R.id.backlog_6,
			R.id.backlog_7, R.id.backlog_8, R.id.backlog_9, R.id.backlog_10 };
	
	char[] LETTERS = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
			'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
			'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
			'y', 'z' };
	
	String [] GREETINGS = {"Hellomyboy","Higoodluck","Howareyou!","HiAuready?","Nicetomeet"};

	String[][] WORDS = {
			{ "animal", "lion", "panda", "tiger", "camel", "goat", "sheep",
					"zebra", "cow", "bull", "bear", "wolf", "cow", "deer",
					"fox", "horse", "pig", "dog", "monkey", "bat", "cat",
					"rabbit", "whale", "fish", "frog", "hen", "cock", "duck",
					"goose", "bee", "mouse", "bird", "giraffe" },

			{ "weather", "hot", "cold", "storm", "windy", "cloudy", "sunny",
					"snowy", "foggy", "ice", "sandy" },

			{ "family", "home", "child", "parent", "single", "man", "women",
					"female", "mother", "father", "brother", "sister", "wife",
					"ancestor" },

			{ "friend", "brave", "capable", "careful", "clever", "cheer",
					"depend" },

			{ "plant", "rose", "tree", "trunk", "root", "leaf", "fruit",
					"apple", "orange", "pear", "mango", "cherry", "peach",
					"grape", "banana", "lemon", "peanut" },

			{ "run", "swim", "fly", "come", "turn", "shut", "sing", "dance",
					"put", "walk", "ride", "take", "bring", "have", "leave",
					"move", "borrow", "lend", "keep", "grow", "wake", "sleep",
					"speak", "say", "talk", "watch", "see", "buy", "tell",
					"teach", "beat", "hit", "think", "sink", "discuss",
					"observe", "celebrate", "hold", "carry", "break", "cut",
					"grow", "water", "wash", "sell", "smell" } };
}
