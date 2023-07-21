package lab3.ques2;

import lab3.ques1.Student;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

//2.	Write a program to use propertyDescriptor in javabeans.
public class BeanPropertyDescriptorExample {
    public static void main(String[] args) {
        // Create an instance of Student bean
        Student student = new Student();

        // Get the property descriptors for the Student class
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(Student.class);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            // Set property values using PropertyDescriptor
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                if ("id".equals(propertyDescriptor.getName())) {
                    propertyDescriptor.getWriteMethod().invoke(student, 1);
                } else if ("name".equals(propertyDescriptor.getName())) {
                    propertyDescriptor.getWriteMethod().invoke(student, "John Doe");
                } else if ("age".equals(propertyDescriptor.getName())) {
                    propertyDescriptor.getWriteMethod().invoke(student, 18);
                } else if ("grade".equals(propertyDescriptor.getName())) {
                    propertyDescriptor.getWriteMethod().invoke(student, "A");
                }
            }

            // Get property values using PropertyDescriptor
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                Object value = propertyDescriptor.getReadMethod().invoke(student);
                System.out.println(propertyDescriptor.getName() + ": " + value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



