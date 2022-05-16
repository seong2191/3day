package ch10_extends_interface.starcraft;

import java.util.ArrayList;

public class StarCraftMain {

	public static void main(String[] args) {

		Marine marine = new Marine();

		System.out.println(marine.getName());

		marine.stimpack();
		marine.move(10, 20);

		Zealot zealot = new Zealot();

		System.out.println(zealot.getName());
		zealot.move(10, 20);
		
		// 질럿뽑기
		Zealot zealot2 = new Zealot();
		Zealot zealot3 = new Zealot();
		Zealot zealot4 = new Zealot();
		Zealot zealot5 = new Zealot();
		Zealot zealot6 = new Zealot();
		
		// 질럿들을 드래그로 선택
		ArrayList<Zealot> zealotList = new ArrayList<>();
		zealotList.add(zealot);
		zealotList.add(zealot2);
		zealotList.add(zealot3);
		zealotList.add(zealot4);
		zealotList.add(zealot5);
		zealotList.add(zealot6);
		
		// 선택한 질럿들에게 이동 명령
		for(int i = 0; i < zealotList.size(); i++) {
			zealotList.get(i).move(10, 30);
		}
		
		HighTemplar highTemplar = new HighTemplar();
		// 스톰 한방으로 시작
		highTemplar.skillStorm();
		
		// 하이템플러도 질럿과 함께 같이 선택하기
//		zealotList.add(highTemplar);
		
		// 다형성(Polymorphism)
		// 하나의 객체가 여러 가지 타입을 가질 수 있는 것
		// 부모 클래스 타입의 참조 변수로(ProtossUnit, StarUnit)
		// 자식 클래스 타입의 인스턴스(zealot 객체)를 참조할 수 있는 것
		
		// 자식 객체에서 부모 객체로 자동 형변환이 가능하다.
		ProtossUnit protoss = zealot;	 // 자동 형변환의 모습
		ProtossUnit protoss2 = (ProtossUnit) zealot2; // 강제 형변환
		
		// 자식 객체에서 조부모 객체로도 형변환이 가능하다.
		StarUnit star = zealot; 	// 자동형변환(증조부, 고조부 당연히 가능)
		
		// 드래그 선택
		ArrayList<StarUnit> starList = new ArrayList<>();
		
		starList.add(zealot);
		starList.add(zealot2);
		starList.add(zealot3);
		starList.add(zealot4);
		starList.add(zealot5);
		starList.add(zealot6);
		
		starList.add(highTemplar);
		
		starList.add(marine);
		
		for(int i = 0; i < starList.size(); i++) {
			starList.get(i).move(10, 45);
		}
		
		// StarUnit을 담는 ArrayList인 starList에
		// Zealot, Marine, HighTemplar가 담기는 순간
		// 자동 형변환이 되어 담기고 있는 것이다.
		
		// .get으로 꺼낼때는 형변환이 된 상태이므로 (Marine -> StarUnit)
		// 자식이 가진 메소드를 바로 사용할 수 없다.
		
		System.out.println(starList.get(7).getName());
		
		// 스팀팩은 Marine이 가진 메소드이기 때문에 사용할 수 없다.
//		starList.get(7).stimpack();
		
		// 다시 형변환(강제 형변환)을 통해 되돌려 준 이후에 사용이 가능하다. (StarUnit -> Marine)
		((Marine)starList.get(7)).stimpack();
		
		((HighTemplar)starList.get(6)).skillStorm();
		
		// 배열 내 객체가 무슨 클래스인지 알아야 거기에 맞게 형변환이 가능
		// 콘솔에 에러가 나는 이유는 스킬스톰 메소드는 하이템플러 하위인데, 인덱스 0은 질럿이라서
//		((HighTemplar)starList.get(0)).skillStorm();
		
		for(int i = 0; i < starList.size(); i++) {
//			if(starList.get(i).getName().equals("하이템플러")){
//				((HighTemplar)starList.get(i)).skillStorm();
//			}
			
			// 순서
			// 객체 instanceof 클래스
			// 좌측의 객체가 우측의 클래스로 형변환이 가능하다면 true를 리턴
			// 불가능하다면 false 리턴
			
			// 102행의 강제형변환을 instanceof를 이용하여 한다면,
			if(starList.get(i) instanceof HighTemplar) {
				((HighTemplar)starList.get(i)).skillStorm();
			}
			
			if(starList.get(i) instanceof Marine) {
				((Marine)starList.get(i)).stimpack();
			}
		}
		
		// 조부모 객체 생성
		StarUnit puma = new StarUnit("푸마", 0, 0, 0, 0, 0, 0, 0, 0);
		
		// 일반적으로 부모 객체는 자식 객체로 형변환 할 수 없다.
		System.out.println(puma instanceof ProtossUnit);	// false
		System.out.println(puma instanceof Marine);			// false
		
		// 자식 객체는 부모 객체로 형변환이 가능하다.
		System.out.println(zealot instanceof ProtossUnit);	// true
		System.out.println(zealot instanceof StarUnit);		// true
		
		// 부모 객체로 형변환 되었던 자식 객체는
		// 다시 자식 객체로 형변환이 가능하다.
		
		ProtossUnit pro = zealot;
		System.out.println(pro instanceof Zealot);		//true
		StarUnit su = highTemplar;
		System.out.println(su instanceof HighTemplar);		//true
		System.out.println(pro instanceof HighTemplar);		//false
		
		
		
		

	}

}
