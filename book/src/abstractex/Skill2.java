package abstractex;

public class Skill2 {

	class WaterSkill extends Skill {
	    void attack() {
	        System.out.println("물 공격! 50 데미지!");
	    }
	}

	class FireSkill extends Skill {
	    void attack() {
	        System.out.println("불 공격! 80 데미지!");
	    }
	}

	class EarthSkill extends Skill {
	    void attack() {
	        System.out.println("대지 공격! 70 데미지!");
	    }
	}
}
