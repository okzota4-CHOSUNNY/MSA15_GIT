package dto;

import java.util.List;

public class Users {

    // 기본 생성자 (JSON 매핑에 필수)
    public Users() {}

    private String name;
    private int age;
    private List<String> roles;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getRoles() {
        return roles;
    }
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
