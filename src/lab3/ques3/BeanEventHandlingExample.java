package lab3.ques3;

import java.util.EventListener;

//3.	Write a program to use eventDescriptor in javabeans.


interface StudentListener extends EventListener {
    void studentAdded(StudentEvent event);
}

public class BeanEventHandlingExample {
    public static void main(String[] args) {
        StudentBean student = new StudentBean();
        MyStudentListener listener = new MyStudentListener();
        student.addStudentListener(listener);

        student.setName("John Doe");
    }
}

class StudentEvent {
    private StudentBean source;

    public StudentEvent(StudentBean source) {
        this.source = source;
    }

    public StudentBean getSource() {
        return source;
    }
}

class MyStudentListener implements StudentListener {
    @Override
    public void studentAdded(StudentEvent event) {
        StudentBean student = event.getSource();
        System.out.println("Student added: " + student.getName());
    }
}

class StudentBean {
    private String name;
    private StudentListener listener;

    public void addStudentListener(StudentListener listener) {
        this.listener = listener;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
        if (listener != null) {
            StudentEvent event = new StudentEvent(this);
            listener.studentAdded(event);
        }
    }
}



