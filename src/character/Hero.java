package character;

public class Hero {

	//フィールド名は最初以外の単語の頭が大文字であると良い
	private String name;	//名前の宣言
	private int hp;	//HPの宣言	private指定すると、自分自身のクラスからしか呼び出すことができない

	public int getHp(){
		return this.hp;
	}
	public void setHp(int hp){
		this.hp = hp;
	}

	//***アクセス修飾子の定石***
	//フィールドはすべてprivate　メソッドはすべてpublic
	//とりあえずはこのパターンでアクセス修飾を行ってから、クラス内部だけで使用するメソッドのみをprivateに指定しなおすような微調整を行う

	//所持金の宣言　staticは静的フィールド（クラス変数）　クラスに対して一つだけ用意される
	//インスタンス未生成の状態でも呼び出せる
	static int money;

	public void attack(Matango m){
		//this.hp -= m.attack;

	}

	//静的メソッド（クラス・メソッド）は静的フィールドと合わせて静的メンバと総称される
	//静的フィールドと同様に、クラス名.メソッド名();で呼び出しできる　もちろん　インスタンス名.メソッド名();　も可
	//インスタンス未生成の状態でも呼び出せる
	static void setRandomMoney(){
		//注意：静的メソッドの中で利用できるのは、同じくstaticが付いている静的フィールドや静的メソッドだけ！
		Hero.money = (int)(Math.random()*1000);
	}

	//メソッド名は最初以外の単語の頭が大文字であると良い

	//睡眠（hp全回復）
	public void sleep(){
		this.hp = 100;	//thisは特別な変数で「自分自身のインスタンス」を意味する
		System.out.println(this.name + "は、眠って回復した");
	}

	//座る（時間経過回復）
	public void sit(int sec){
		this.hp += sec;
		System.out.println(this.name +"は" +sec+"秒すわった");
		System.out.println("HPが" +sec+"ポイント回復した");
	}

	//逃走
	public void run(){
		System.out.println(this.name+"は逃げ出した！");
	}
	//転倒
	public void slip(int damage){
		this.hp -= damage;
		System.out.println(this.name + "は転んだ");
		System.out.println(damage + "のダメージ");
	}

	//死亡
	public void die(){
		System.out.println(this.name + "は死んでしまった");
		System.out.println("Game Over");
	}

	//勇者への攻撃		attackメソッドを通さなければ勇者のHPフィールドにはアクセスできない
	//つまり勇者のHPに異常が起きたときはHPを変動させるメソッド（例：attack）にバグがあると分かる
	public void attack(int damage){
		this.hp -= damage;
		System.out.println("勇者" + this.name + "は" + damage + "のダメージを受けた");
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
		this("見習い",100);	//コンストラクタ1の呼び出し　特殊な文法 this（引数); は同一クラスの別コンストラクタを呼び出す
	}

	//getterメソッド　ある特定のフィールド値を単に取り出すだけ
	//定石は　public 値を取り出すフィールドの型　getフィールド名(){ return this.フィールド; }
	public String getName() {
		return this.name;
	}

	//setterメソッド　ある特定のフィールドに指定された値（引数）を単に代入するだけのメソッド
	//定石は pulbic void setフィールド名（フィールドの型　任意の変数名）{　this.フィールド = 任意の変数名 }
	public void setName(String name){

		//setterで設定されようとしている値の検査
		if(name == null){
			//throw new IllegalArgumentExceptionはエラーを吐いてプログラムを強制停止させる
			throw new IllegalArgumentException("名前がnullなので処理を中断");
		}

		if (name.length() <= 1) {
			throw new IllegalArgumentException("名前が短すぎるので処理を中断");
		}

		if (name.length() >= 8) {
			throw new IllegalArgumentException("名前が長すぎるので処理を中断");
		}

		this.name = name;

	}

	//***カプセル化の利点***
	//setNameメソッドを削除すれば、nameフィールドを外部から読めるが書き換えられない(Read Only)フィールドにできる
	//nameフィールドをname2フィールドに変更したいとき、getterやsetterメソッドがあれば
	//他のクラスの全ての開発者にアクセスするフィールド名を変更するようにお願いせずに済む
	//setterメソッドの中で引数の値の妥当性をチェックできる
}


