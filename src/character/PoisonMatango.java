package character;

/*
 * お化けきのこMatangoクラスを継承し、毒攻撃が可能になったPoisonMatangoクラス
 */
public final class PoisonMatango extends Matango {

	private int poisonCount = 5;	//毒の使用回数の初期値

	public void attack(Hero h) {

		super.attack(h);

		if(this.poisonCount>0){
			int poisonDmg = h.getHp()/5;
			System.out.println("さらに毒の胞子をばらまいた");
			h.setHp(h.getHp() - poisonDmg);
			System.out.println("勇者に"+poisonDmg+"の毒ダメージ");
			this.poisonCount--;	//毒の使用回数をデクリメント
		}

	}
}
