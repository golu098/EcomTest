package CoreJava.Activities;

import java.util.*;

public class Employee implements Comparable<Employee> {
    int age;
    String name;

    public Employee(int age,String name){
        this.age=age;
        this.name=name;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
////        if(!(o instanceof Employee))return false;// optional
//        Employee employee = (Employee) o;
////        return age==employee.age && name.equals(employee.name);
//        return age == employee.age && Objects.equals(name, employee.name);
//    }
    @Override
    public boolean equals(Object o){
        if(this==o)return true;
        if(o==null || getClass()!=o.getClass())return false;
        if(!(o instanceof Employee))return false;
        Employee obj=(Employee) o;
//        return age==obj.age && name.equals(obj.name);
        return age==obj.age && Objects.equals(name,obj.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    @Override
    public String toString(){
        return "My age is "+age+" and my name is "+name;
    }
    public int compareTo(Employee that){
        return Integer.compare(this.age,that.age);
    }


    public static void main(String[] args) {
        Comparator<Employee>nameComparator=new Comparator<Employee>(){
            public int compare(Employee name1,Employee name2){
                return name1.name.compareTo(name2.name);

            }
        };
        Comparator<Employee>ageComparator=new Comparator<Employee>(){
            public int compare(Employee age1,Employee age2){
                return Integer.compare(age1.age,age2.age);
            }
        };
        Employee obj=new Employee(1,"shiv");
        Employee obj1=new Employee(2,"kant");
//        Employee obj1=new Employee(1,"Shiv");
        HashSet<Employee>hashSet=new HashSet<>();
        hashSet.add(obj);
        hashSet.add(obj1);
        System.out.println(hashSet);
        TreeSet<Employee>treeSet=new TreeSet<>(nameComparator);
        treeSet.add(obj);
        treeSet.add(obj1);
        System.out.println("sorted by name:- ");
        System.out.println(treeSet);

        TreeSet<Employee>treeSet1=new TreeSet<>(ageComparator);
        treeSet1.add(obj);
        treeSet1.add(obj1);
        System.out.println("sorted by age:- ");
        System.out.println(treeSet1);


    }
}
