package character;

//extends　でHeroクラスを継承する
//継承を禁止したいときは

public class SuperHero extends Hero{

	//***理由***
	//Heroクラスとフィールドやメソッドはほとんど同じだが部分的に違う
	//Heroクラスの中身をコピペすると管理が難しくなるしコピー元を変更したときのSuperHeroクラスの修正が手間

	private boolean flying;

	public void fly(){
		this.flying = true;
		System.out.println("飛び上がった");
	}

	public void land(){
		this.flying = false;
		System.out.println("着地した");
	}

	public void flyingOn(){
		this.flying = true;
	}

	public void flyingOff(){
		this.flying = false;
	}

	//たったこれだけの追加で済む
	//もちろんHeroクラスのメンバも使用可能

	//***用語***
	//Heroのような継承元のクラスをスーパークラス
	//SuperHeroのようなスーパークラスから生まれた派生クラスをサブクラスという

	//***禁止事項***
	//子クラス、孫クラスと作ることができるが
	//複数の親クラスを持つ多重継承は認められていない


	//逃走
	//親クラスのHeroクラスにもrun()メソッドは存在するが、内容を変更したい場合は
	//子クラスでも同じメソッド名で再定義することができる　これをオーバーライドと呼ぶ

	//Heroクラスのrun()メソッドをオーバーライド
	public void run(){
		System.out.println(getName() +"は撤退した！");
	}

	//Heroクラスのattack()メソッドをオーバーライド
	public void attack(Matango m){
		super.attack(m);
		if (this.flying) {
			super.attack(m);
		}
	}



	//コンストラクタ1　Heroクラスから継承 super
	SuperHero(String name , int hp){
		super(name,hp);
	}
	//生成時に引数がない場合はこちらのコンストラクタ2が使用される
	SuperHero(){
		super();
	}

}

//継承のルール
/*
 * スーパークラスと子クラスの関係は is-a　子クラスはスーパークラスの一種である
 * たとえばItemクラスを継承してHouseクラスを作ることはできない
 * 子クラスになればなるほど特殊で具体的なものに特化していく
 * 親クラスになればなるほど一般的で抽象的なものに汎化（一般化）していく
*/
