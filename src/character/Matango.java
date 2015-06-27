package character;

import java.util.Random;

public class Matango {

	protected char suffix;	//きのこの識別名 charは一文字の文字リテラル　シングルクォーテーションで囲う

	protected int level;	//レベル　経験値・HP・攻撃力に影響
	protected final int max_level = 10;	//finalを変数の前に付けると定数として宣言　フィールドLEVELは10で固定

	protected int hp;	//きのこの体力　レベル依存でランダム
	protected int power;	//きのこの攻撃力　レベル依存でランダム


	//マタンゴの被ダメージ
	public void damage(int damage){
		this.hp -= damage;
		System.out.println("マタンゴ"+ this.suffix + "は" + damage +"のダメージを受けた");
	}

	public void run(){
		System.out.println("おばけキノコ" + this.suffix + "は逃げ出した");
	}

	//マタンゴの情報表示
	public void show(){
		System.out.println("マタンゴ" + this.suffix + "のレベルは"+ this.level + "体力は" + this.hp + "攻撃力は" + this.power);
	}


	//マタンゴの攻撃
	public void attack(Hero h) {
		System.out.println("キノコ" + this.suffix + "の攻撃");
		System.out.println("10のダメージ");
		h.setHp(h.getHp()-10);	//変更するときはsetメソッドを使うようにする
	}

	//コンストラクタ
	Matango(char suffix){
		this.suffix = suffix;
		this.level = new Random().nextInt(5) + 1;	//レベル1〜5のランダム
		this.hp = this.level * 10;
		this.power = this.level * 2;	//SysoでSystem.out.println("")が出る
	}

	Matango(){
		this('A');
	}

}
