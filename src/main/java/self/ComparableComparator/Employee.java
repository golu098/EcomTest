package self.ComparableComparator;

import java.util.Comparator;
import java.util.TreeSet;

public class Employee implements Comparable<Employee>
{
    int age;
    String name;

    public Employee(int age,String name){
        this.age=age;
        this.name=name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String toString(){
        return " Name is "+name+ " and age is "+age;
    }
    public int compareTo(Employee that){
//        return Integer.compare(this.age,that.age);
        return this.name.compareTo(that.name);
    }

    public static void main(String[] args) {
        Employee obj=new Employee(1,"asli");
        Employee obj1=new Employee(2,"ad");

        System.out.println("Comparing by age ");
        Comparator<Employee>compByAge=new Comparator<Employee>(){
            public int compare(Employee age1,Employee age2){
                return Integer.compare(age1.age,age2.age);
            }
        };
        TreeSet<Employee>treeSet=new TreeSet<>(compByAge);
        treeSet.add(obj);
        treeSet.add(obj1);
        System.out.println(treeSet);

        Comparator <Employee>compByName=new Comparator<Employee>(){
            public int compare(Employee name1,Employee name2){
//                return name.compareTo(name1,name2.name);
                return name1.name.compareTo(name2.name);
            }
        };
        System.out.println("Comparing by name ");
//        TreeSet<Employee>treeSet1=new TreeSet<>(Comparator.comparing(Employee::getName));
        TreeSet<Employee>treeSet1=new TreeSet<>(Comparator.comparing(i->i.getName().length()));
        treeSet1.add(obj);
        treeSet1.add(obj1);
        System.out.println(treeSet1);

    }
}

