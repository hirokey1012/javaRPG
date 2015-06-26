package character;

import java.util.Random;

public class Matango {

	private char suffix;	//きのこの識別名 charは一文字の文字リテラル　シングルクォーテーションで囲う

	private int level;	//レベル　経験値・HP・攻撃力に影響
	private final int max_level = 10;	//finalを変数の前に付けると定数として宣言　フィールドLEVELは10で固定

	private int hp;	//きのこの体力　レベル依存でランダム
	private int attack;	//きのこの攻撃力　レベル依存でランダム

	public void run(){
		System.out.println("おばけキノコ" + this.suffix + "は逃げ出した");
	}

	//マタンゴの情報表示
	public void show(){
		System.out.println("マタンゴ" + this.suffix + "のレベルは"+ this.level + "体力は" + this.hp + "攻撃力は" + this.attack);
	}

	//コンストラクタ
	Matango(char suffix){
		this.suffix = suffix;
		this.level = new Random().nextInt(4) + 1;	//レベル1〜5のランダム
		this.hp = this.level * 10;
		this.attack = this.level * 2;
	}

	Matango(){
		this('A');
	}

}
