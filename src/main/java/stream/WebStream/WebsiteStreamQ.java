package stream.WebStream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WebsiteStreamQ {
    public static void main(String[] args) {
        List<Integer>listOfIntegers= Arrays.asList(12,1,2,12,2,1,34,12,3,5,64,7,89,9);
        int[]arrayOfInt={2,8,9,10,72,3};
        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
        List<String> listOfStrings = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");

        List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");
        String  inputString = "Java Concept Of The Day";
        List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);

        List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);


        System.out.println("1.Given a list of integers, separate odd and even numbers");
        List<Integer>listOfEvenInt=listOfIntegers.stream().filter(i->i%2==0).collect(Collectors.toList());
        System.out.println("List of Even no:- "+listOfEvenInt);
        List<Integer>listOfOddInt=listOfIntegers.stream().filter(i->i%2!=0).collect(Collectors.toList());
        System.out.println("List of Odd no:- "+listOfOddInt);

        System.out.println("3. frequency of each character");
        Map<Character,Long>charFreq=inputString.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(i->i,Collectors.counting()));
        System.out.println(charFreq);

        System.out.println("4. frequency of each element in an array ");
        Map<String,Long>eachElementCount=stationeryList.stream().collect(Collectors.groupingBy(i->i,Collectors.counting()));
        System.out.println(eachElementCount);

        System.out.println("5. sort the given list of decimals in reverse order");
        List<Double>sorteDecimal=decimalList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sorteDecimal);

        System.out.println("6.a list of strings, join the strings with ‘[‘ as prefix, ‘]’ as suffix and ‘,’ as delimiter");
        String joinedString=listOfStrings.stream().collect(Collectors.joining(",","[","]"));
        System.out.println(joinedString);

        System.out.println("8. maximum and minimum ");
        int maxi=listOfIntegers.stream().max(Comparator.naturalOrder()).get();
        System.out.println(maxi);
        int mini=listOfIntegers.stream().max(Comparator.reverseOrder()).get();
        System.out.println(mini);

        System.out.println("15. sort them according to increasing order of their length");
        listOfStrings.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);

        System.out.println("17. find common elements between two arrays");
        list1.stream().filter(list2::contains).forEach(System.out::println);

        System.out.println("18.Reverse each word of a string using Java 8 streams");
        String revEachWord=Arrays.stream(inputString.split(" ")).map(i->new StringBuffer(i).reverse()).collect(Collectors.joining(" "));
        System.out.println(revEachWord);

        System.out.println("19. find sum of first 10 natural numbers");
        int sumofNaturalNo=IntStream.range(1,11).sum();
        System.out.println(sumofNaturalNo);
        System.out.println("20.Reverse Integer Array ");
        int[]revArray= IntStream.rangeClosed(1,arrayOfInt.length).map(i->arrayOfInt[arrayOfInt.length-i]).toArray();
        System.out.println(Arrays.toString(revArray));



    }
}
