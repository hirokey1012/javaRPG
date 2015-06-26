package character;

public class King {

	//勇者とお話
	public void talk(Hero h){
		System.out.println("ようこそ我が国へ" + h.getName() + "よ");
	}

	public void setName(Hero h,String name){
		System.out.println("勇者" + h.getName() + "はださい");
		h.setName(name);
		System.out.println("お前の戸籍情報を変えたから、これからお前の名前は勇者" + h.getName() + "だよ");
	}

}
