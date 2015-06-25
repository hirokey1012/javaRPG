package character;

public class Hero {

	//フィールド名は最初以外の単語の頭が大文字であると良い
	String name;	//名前の宣言
	int hp;	//HPの宣言

	//所持金の宣言　staticは静的フィールド（クラス変数）　クラスに対して一つだけ用意される
	//インスタンス未生成の状態でも呼び出せる
	static int money;

	void attack(){
	}

	//静的メソッド（クラス・メソッド）は静的フィールドと合わせて静的メンバと総称される
	//静的フィールドと同様に、クラス名.メソッド名();で呼び出しできる　もちろん　インスタンス名.メソッド名();　も可
	//インスタンス未生成の状態でも呼び出せる
	static void setRandomMoney(){
		//注意：静的メソッドの中で利用できるのは、同じくstaticが付いている静的フィールドや静的メソッドだけ！
		Hero.money = (int)(Math.random()*1000);
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

	//コンストラクタは基本的に必要不可欠　newによるインスタンス化の直後に自動実行
	//ただし、1つもコンストラクタがユーザによって定義されていなければ、
	//コンパイル時に引数なし・処理内容なしのデフォルトコンストラクタが自動で追加される
	//コンストラクタは直接呼び出せないが、コンストラクタの先頭で別コンストラクタを特別に呼び出せる this(引数）;

	//コンストラクタ1（newと同時にメソッド内部で定義しておいた処理が自動的に行われる
	//hpの初期値は固定で良いが、名前は別々なので、引数で追加情報（名前）を受け取れるようにする
	Hero(String name , int hp){
		this.hp = hp;
		this.name = name;
		Hero.money = 1000;
	}

	//コンストラクタ1の引数がない場合はこちらのコンストラクタ2が使用される
	//仮引数の個数や型が異なれば、同名のメソッドを多重に定義できる（オーバーロード）
	Hero(){
		//this.hpは不要、さらに多数のコンストラクタが存在する場合、this.hpの値書き換えが一箇所で済む
		this("凡人",100);	//コンストラクタ1の呼び出し　特殊な文法 this（引数); は同一クラスの別コンストラクタを呼び出す
	}

}


