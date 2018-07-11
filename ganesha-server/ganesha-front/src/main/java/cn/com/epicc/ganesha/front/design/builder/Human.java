package cn.com.epicc.ganesha.front.design.builder;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-07-09 17:24
 */
public class Human {

    private String name;

    private String age;

    private String gender;

    private String birth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public Human() {
    }

    public Human(String name, String age, String gender, String birth) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.birth = birth;
    }

    public static Human.HumanBuilder builder(){
        return new HumanBuilder();
    }

    public static class HumanBuilder {

        private String name;

        private String age;

        private String gender;

        private String birth;

        public HumanBuilder name(String name){
            this.name = name;
            return this;
        }

        public HumanBuilder age(String age){
            this.age = age;
            return this;
        }

        public HumanBuilder gender(String gender){
            this.gender = gender;
            return this;
        }

        public HumanBuilder birth(String birth){
            this.birth = birth;
            return this;
        }

        public Human build(){
            return new Human(this.name,this.age,this.gender,this.birth);
        }

    }
}
