package practice;

public class Student {
    //class attributes
    int id;
    String name;

    //constructor - used to create new instances of student
    public Student(String name){
        name = this.name;
    }

    //class specific method - returns the instance's name attribute
    public String getName() {
        return name;
    }
}

