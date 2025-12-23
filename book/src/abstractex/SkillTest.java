package abstractex;

public class SkillTest {
    public static void main(String[] args) {

        Skill2 outer = new Skill2();

        Skill s1 = outer.new WaterSkill();
        Skill s2 = outer.new FireSkill();
        Skill s3 = outer.new EarthSkill();

        s1.attack();
        s2.attack();
        s3.attack();
    }
}