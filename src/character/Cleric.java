package character;

import java.util.*;


public class Cleric {

	String name;
	int hp;
	int mp;
	static final int max_hp = 50;
	static final int max_mp = 10;

	public void selfAid(){
		System.out.println(this.name + "はセリフエイドを唱えた");
		this.hp = Cleric.max_hp;
		this.mp -= 5;
		System.out.println("HPが最大まで回復した");
	}

	public int pray(int sec){

		System.out.println(this.name + "は" + sec + "秒間天に祈りを捧げた");

		// Random().nextInt(3)で0〜2の乱数
		int recover = new Random().nextInt(3) + sec;

		//実際の回復量を計算する
		//上限MP - 現在MP　と　回復量を比較して　小さい方がrecoverActualに入る（現在MP＋回復量が上限MPを突破してしまう恐れ）
		int recoverActual = Math.min(Cleric.max_mp - this.mp, recover);
		this.mp += recoverActual;
		System.out.println("MPが"+recoverActual + "回復した");

		return recoverActual;
	}

	//コンストラクタはクラス名(引数){ 初期化の処理 }
	Cleric(String name, int hp, int mp){
		this.name = name;
		this.hp = hp;
		this.mp = mp;
	}

	Cleric(String name, int hp){
		this(name, hp, Cleric.max_mp);
	}

	Cleric(String name){
		this(name , Cleric.max_hp);
	}


}
