package character;

import java.util.*;


public class Cleric {

	String name;
	int hp = 50;
	final int max_hp = 50;
	int mp = 10;
	final int max_mp = 10;

	public void selfAid(){
		System.out.println(this.name + "はセリフエイドを唱えた");
		this.hp = this.max_hp;
		this.mp -= 5;
		System.out.println("HPが最大まで回復した");
	}

	public int pray(int sec){

		System.out.println(this.name + "は" + sec + "秒間天に祈りを捧げた");

		// Random().nextInt(3)で0〜2の乱数
		int recover = new Random().nextInt(3) + sec;

		//実際の回復量を計算する
		//上限MP - 現在MP　と　回復量を比較して　小さい方がrecoverActualに入る（上限MPを超える回復量はありえない）
		int recoverActual = Math.min(this.max_mp -this.mp, recover);
		this.mp += recoverActual;
		System.out.println("MPが"+recoverActual + "回復した");

		return recoverActual;
	}

}
