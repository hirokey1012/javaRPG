package character;

public class Hero {

	//フィールド名は最初以外の単語の頭が大文字であると良い
	String name;	//名前の宣言

	int hp;	//HPの宣言

	void attack(){
	}

	//メソッド名は最初以外の単語の頭が大文字であると良い
	void sleep(){
		this.hp = 100;	//thisは特別な変数で「自分自身のインスタンス」を意味する
		System.out.println(this.name + "は、眠って回復した");
	}


	void sit(int sec){
		this.hp += sec;
		System.out.println(this.name +"は" +sec+"秒すわった");
		System.out.println("HPが" +sec+"ポイント回復した");

	}

	void slip(){
		this.hp -= 5;
		System.out.println(this.name + "は転んだ");
		System.out.println("5のダメージ");

	}

	void run(){
		System.out.println(this.name+"は逃げ出した！");
		System.out.println("game over");
		System.out.println("最終HPは"+this.hp+"でした");
	}

}


