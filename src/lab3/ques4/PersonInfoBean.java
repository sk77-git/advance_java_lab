package lab3.ques4;

//4.	Write a program to use InfoBean in javabeans.
public class PersonInfoBean {
    private String name;
    private int age;

    public String getInfo() {
        return "Name: " + name + "\nAge: " + age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class InfoBeanExample {
    public static void main(String[] args) {
        PersonInfoBean person = new PersonInfoBean();
        person.setName("John Doe");
        person.setAge(25);

        String info = person.getInfo();
        System.out.println(info);
    }
}


