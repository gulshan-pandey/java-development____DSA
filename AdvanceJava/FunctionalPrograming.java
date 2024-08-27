package AdvanceJava;
import java.lang.reflect.Array;
import java.time.format.SignStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionalPrograming {
      
// functional interface:- is an interface that contains exactly one abstract method. These interfaces are used to represent functional concepts, similar to what lambda expressions can express.

// Consumer only consumes, it doesnot returns anything
    public static void main(String[] args) {
        
    List <String> fruits = List.of("apple","banana","grapes","peach","orange","date");   // this list.of() method makes the immutable list!!!

    // for(String fruit: fruits){                   //traditional way
    //     System.out.println(fruit);
    // }


System.out.println("printing using the Streams,and redefining accept method:--");

    fruits.stream().forEach(new Consumer<String>(){    //forEach is a Terminal operation it includes consumer ...here we defined the anonymous inner class of Consumer interface and overriding the accept method
        @Override
        public void accept(String fruit){       // accept method is used to perform any operation on the given input
            System.out.println(fruit);
        }
    });           // forEach expects the object of the consumer interface which has method called {accept()} which is a generic method



    //ALTERNATIVELY----------------------------------------------------- using lambda expression
   
    //the above accept() method can be used as lambda expression for simplicity
    
    System.out.println("\n printing using lambda expression :");

    fruits.stream().forEach(fruit->System.out.println(fruit));     // here forEach is a terminal operation,Without a terminal operation, intermediate operations will not be executed, and the stream will not perform any processing. 
    
    
    System.out.println("\n printing uppercase using lambda expression :");

    fruits.stream().forEach(fruit->System.out.println(fruit.toUpperCase()));


    System.out.println("\n filtering the fruits:");
    fruits.stream().filter(fruit->fruit.endsWith("a")).forEach(fruit->System.out.println(fruit));







    List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 8,4,2,1 ,5, 6));      // this list.of() method under the ArrayList() makes the list mutable because ArrayList() produces mutable list

    
    List<Integer> sqNumbers = numbers.stream()
                                       .map(num -> num * num)
                                       .collect(Collectors.toList());   //collect is terminal method,Accumulates the elements of this stream into a List
    
    // for (Integer num : evenNumbers) {   
    //     System.out.println(num);
    // }

    System.out.println(sqNumbers);

    // -----------------------------OR-----------------------

    System.out.println( numbers.stream()
                                    .map(num -> num * num).collect(Collectors.toList()));  

    System.out.println("\n using only forEach:");
    numbers.stream().forEach(number->System.out.print(number*2));

    
    ////////////////////////Sorting the list///////////////////
    var numberList = List.of(21,35,466,353,65,23,7,9,21,35,5336);
    List<Integer> sortedNumlist = numberList.stream().sorted().distinct().collect(Collectors.toList());
    System.out.println(sortedNumlist);

    ///////////Distinct-ensures that no duplicates available //////
    List <Integer> DistinctList = numberList.stream().distinct().collect(Collectors.toList());
    System.out.println(DistinctList);





    // using Stream 
    // while Stream.generate() is used to create an infinite stream where elements are generated by a Supplier. The infinite stream can also be generate by Stream.iterate...  ex Stream.iterate(1, n-> n+1)


    System.out.println("printing random numbers using stream: ");
    var stream = Stream.generate(()->Math.random());       // var was introduced in java 10    also ,here Stream.generate generates the infinite data items but we have to limit it!

    stream.limit(5).forEach((n)-> System.out.println(n));           //forEach takes a consumer for which(leta h but deta kuch nhi)
    

    //Alternatively
    
    // Random random = new Random();
    // Stream<Double> stream2 = Stream.generate(random::nextDouble);
    // stream2.limit(5).forEach(System.out::println);
    
    
    
    
    // demonstrating Stream.of 
    // Stream.of() is used to create a stream from a fixed set of elements
   
            Stream<String> stream3 = Stream.of("Geeks", "for", "Geeks");     // it takes varargs
            stream3.forEach(System.out::println);               //forEach takes a consumer which(leta h but deta kuch nhi)
            
            




    // flatMap-- used to return combine the colletion of objects( flaten the stream)

    var lis = Stream.of(List.of(1,2,3),List.of(4,5,6),List.of(7,8,9));
    // lis.peek(m -> System.out.println("using peek:" +m)).forEach(System.out::print);  // peek method is used to peek at the element of what operation is going on 

    lis.flatMap(l -> l.stream()).forEach(System.out::print);    


    System.out.println("\n\n");




    // ways to create a streams of array

    //1
    // List<String> list = Arrays.asList("apple", "banana", "grapes", "peach", "orange", "date");

    // Stream<String> listOfFruits= list.stream();

    //2
    // String[] list ={"apple", "banana", "grapes", "peach", "orange", "date"};
    // Stream<String> arrayOfFruits = Arrays.stream(list);
    // arrayOfFruits.forEach((a) -> {System.out.println(a);});

    //3
    // Stream<Integer> streama = Stream.of(1,2,3,4,5);
    // streama.forEach(System.out::println);
    

    //4
    Stream<Integer> streamb = Stream.iterate(0, n -> n + 1).limit(10).skip(3);      // the iterate function takes one input and one function to generate next values and the skip operation will skip the first 3 values
    streamb.forEach(System.out::print);


    //5
    // Stream<Integer> streamc = Stream.generate( () -> (int)(Math.random()*100)).limit(10);
    // streamc.forEach(System.out::println);


    int[] numberss = {1, 2, 3, 4, 5};
    int[] evenNumbers = Arrays.stream(numberss)
        .filter(n -> n % 2 == 0)
        .toArray();

    int[] numbersss = {1, 2, 3, 4, 5};
    int firstEvenNumber = Arrays.stream(numbersss)
            .filter(n -> n % 2 == 0)
            .findFirst()
            .orElse(-1);



    System.out.println("\n\n");


    Integer integer = Stream.iterate(0, x -> x + 1)
    .limit(101)
    .map(x -> x / 10)
    .distinct()
    .peek(System.out::println)
    .max((a,b) -> a - b)            // max() returns the Optional 
    .get();

    System.out.println(integer);

    
    
    }}
    