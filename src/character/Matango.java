package character;

public class Matango {

	int hp;		//HPは可変
	final int level = 10;	//finalを変数の前に付けると定数として宣言　フィールドLEVELは10で固定

	char suffix;
	void run(){
		System.out.println("おばけキノコ" + this.suffix + "は逃げ出した");
	}

}
