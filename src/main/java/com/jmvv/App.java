package com.jmvv;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Person> peaple= getPersons();
        System.out.println("Full List");
        peaple.stream().forEach(System.out::println);
        System.out.println("-------------------");

        // Filter
        System.out.println("Filtered List equal to Male genere");
        peaple.stream()
              .filter(p->p.genere().equals(Genere.male)) 
              .sorted(Comparator.comparing(Person::age).reversed())          
              .forEach(p->System.out.println(p));
        System.out.println("-------------------");

        // Sorted
        System.out.println("Sorted List for age");
        peaple.stream()
              .sorted(Comparator.comparing(Person::age))
              .forEach(p->System.out.println(p));
        System.out.println("-------------------");

        // all Match
        System.out.println("All in the list are bigger to 5 year");
        System.out.println(
            peaple.stream()
                .allMatch(p->p.age()>5)
        );
        System.out.println("-------------------");
        // any Match
        System.out.println("Any in the list are bigger to 7 year");
        System.out.println(
            peaple.stream()
                .anyMatch(p->p.age()>7)
        );
        System.out.println("-------------------");
        // none match
        System.out.println("Isn't present Daniel in the list?");
        System.out.println(
            peaple.stream()
                .noneMatch(p->p.name().equals("Daniel"))
        );
        System.out.println("-------------------");
        // max
        System.out.println("How is the older in the list?");
        System.out.println(
            peaple.stream() //Optional data
               .max(Comparator.comparing(Person::age))
               .get()
        );
        System.out.println("-------------------");
        // Min
        System.out.println("How is the younger in the list?");
        System.out.println(
            peaple.stream() //Optional data
               .min(Comparator.comparing(Person::age))
               .get()
        );
        System.out.println("-------------------");
        // Group
        System.out.println("Group peaple for genere");
        Map <Genere, List<Person>> groupByGenere = peaple.stream()
            .collect(Collectors.groupingBy(Person::genere));
        groupByGenere.forEach((gen,peaples)->{
            System.out.println(gen);
            peaples.forEach(System.out::println);
        }
        );
        System.out.println("-------------------");
        // 
        System.out.println("How is the man more younger in the list?");
        System.out.println(
            peaple.stream() //Optional data
                .filter(p->p.genere().equals(Genere.male))
                .min(Comparator.comparing(Person::age))
                .get().name()
        );
    }
    public static List<Person> getPersons() {
        return List.of(
            new Person("jhon", 6, Genere.male),
            new Person("kevin", 56, Genere.male),
            new Person("Lisa", 98, Genere.female),
            new Person("Maria", 55, Genere.female),
            new Person("Rose",18,Genere.female),
            new Person("Peter",29,Genere.male)
        );
    }
}

