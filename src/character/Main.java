package character;

public class Main {
	//mainメソッドは常にstatic（mainメソッド呼び出し時にはインスタンスは存在していないから）
	public static void main(String[] args){

		//勇者を生成
		//Hero型のh1には、生み出されたHeroインスタンスの番地が入っているだけ（実体はない）
		Hero h1 = new Hero("ミナト",500);		//コンストラクタ1
		//フィールドに初期値をセット
		System.out.println("勇者" + h1.name + "を生み出しました。彼のHPは" + h1.hp + "です");

		//勇者を生成
		Hero h2 = new Hero();		//コンストラクタ2（引数がないとき）
		System.out.println("勇者" + h2.name + "を生み出しました。彼のHPは" + h2.hp + "です");

		//ランダムな金額を設定（しなければ初期値の¥1000）
		Hero.setRandomMoney();

		//moneyはHeroクラスの静的フィールド（クラス変数）
		System.out.println("勇者らの共通貯金は¥" + Hero.money + "です");

		//静的フィールドにはたとえインスタンスが生成されていない状態でもアクセスできる

		//h1.moneyの値を変えると、h2.moneyの値も変化する（どうせならHero.moneyを使った方が良い）
		//h1.money += 500;
		//System.out.println("勇者らの共通貯金は¥" + h2.money + "です");

		//きのこを生成
		Matango m1 = new Matango();
		m1.hp = 50;
		m1.suffix = 'A';

		Matango m2 = new Matango();
		m2.hp = 48;
		m2.suffix = 'B';

		//冒険の始まり

	}

}
