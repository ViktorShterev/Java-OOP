package ReflectionAndAnnotation.Lab.annotation;


import ReflectionAndAnnotation.Lab.Reflection;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;

        Method[] declaredMethods = clazz.getDeclaredMethods();

        List<Author> annotated = Arrays.stream(declaredMethods)
                .filter(m -> m.getAnnotation(Author.class) != null)
                .map(m -> m.getAnnotation(Author.class))
                .collect(Collectors.toList());

        annotated.forEach(a -> System.out.println("Method author is " + a.name()));
    }
}
