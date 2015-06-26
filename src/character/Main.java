package character;

public class Main {
	//mainメソッドは常にstatic（mainメソッド呼び出し時にはインスタンスは存在していないから）
	public static void main(String[] args){

		//勇者を生成
		//Hero型のh1には、生み出されたHeroインスタンスの番地が入っているだけ（実体はない）
		Hero h1 = new Hero("ミナト",500);		//コンストラクタ1
		Hero h2 = new Hero();		//コンストラクタ2（引数がないとき）

		//ランダムな金額を設定（しなければ初期値の¥1000）
		Hero.setRandomMoney();

		//moneyはHeroクラスの静的フィールド（クラス変数）
		System.out.println("勇者らの共通貯金は¥" + Hero.money + "です");

		//静的フィールドにはたとえインスタンスが生成されていない状態でもアクセスできる

		//h1.moneyの値を変えると、h2.moneyの値も変化する（どうせならHero.moneyを使った方が良い）
		//h1.money += 500;
		//System.out.println("勇者らの共通貯金は¥" + h2.money + "です");

		//きのこを生成
		Matango m1 = new Matango('Z');
		Matango m2 = new Matango();

		King k = new King();

		//冒険の始まり
		k.talk(h1);

		k.setName(h1,"ミナットン");

	}

}
