package com.quiz.onlinequizplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class QuizController {

    private final List<Map<String, Object>> questions =
            new ArrayList<>();

    public QuizController() {
        add("Which language is used in this project?",
                new String[]{"Java", "Python", "C++", "JavaScript"}, 0);

        add("Which keyword is used to inherit a class?",
                new String[]{"implements", "extends", "inherits", "super"}, 1);

        add("What is the entry point of a Java program?",
                new String[]{"start()", "run()", "main()", "init()"}, 2);

        add("Which type stores true or false?",
                new String[]{"int", "char", "boolean", "String"}, 2);

        add("Which keyword creates an object?",
                new String[]{"new", "class", "this", "void"}, 0);

        add("Which symbol ends a Java statement?",
                new String[]{":", ";", ".", ","}, 1);

        add("Which collection stores unique elements?",
                new String[]{"ArrayList", "HashSet", "LinkedList", "Vector"}, 1);

        add("Which keyword defines a class?",
                new String[]{"object", "define", "class", "struct"}, 2);

        add("Which package contains Scanner?",
                new String[]{"java.io", "java.util", "java.lang", "java.net"}, 1);

        add("Which keyword prevents inheritance?",
                new String[]{"static", "final", "private", "abstract"}, 1);

        add("Which is not a primitive type?",
                new String[]{"int", "char", "String", "double"}, 2);

        add("Which keyword refers to the current object?",
                new String[]{"super", "this", "self", "current"}, 1);

        add("Which operator checks equality?",
                new String[]{"=", "==", "!=", "==="}, 1);

        add("Which loop executes at least once?",
                new String[]{"for", "while", "do-while", "foreach"}, 2);

        add("Which keyword exits a loop?",
                new String[]{"stop", "exit", "break", "return"}, 2);

        add("Which keyword skips the current iteration?",
                new String[]{"skip", "continue", "break", "pass"}, 1);

        add("Which access modifier is most restrictive?",
                new String[]{"public", "protected", "private", "default"}, 2);

        add("Which keyword is used to implement an interface?",
                new String[]{"extends", "implements", "interface", "instanceof"}, 1);

        add("Which concept hides internal implementation details?",
                new String[]{"Inheritance", "Encapsulation", "Compilation", "Iteration"}, 1);

        add("Which concept allows multiple forms?",
                new String[]{"Polymorphism", "Inheritance", "Iteration", "Casting"}, 0);

        add("Which keyword handles exceptions?",
                new String[]{"catch", "throws", "throw", "All of these"}, 3);

        add("Which block usually executes after try/catch?",
                new String[]{"final", "finally", "finish", "last"}, 1);

        add("Which keyword explicitly throws an exception?",
                new String[]{"throws", "throw", "catch", "try"}, 1);

        add("Which class is the parent of all Java classes?",
                new String[]{"Class", "Main", "Object", "System"}, 2);

        add("Which method compares String contents?",
                new String[]{"==", "equals()", "compare()", "same()"}, 1);

        add("Which keyword declares a constant-like variable?",
                new String[]{"const", "final", "static", "fixed"}, 1);

        add("Which keyword belongs to a class rather than an object?",
                new String[]{"public", "static", "this", "super"}, 1);

        add("Which method returns a String's length?",
                new String[]{"size()", "count()", "length()", "length"}, 2);

        add("Which index starts an array in Java?",
                new String[]{"0", "1", "-1", "Depends on array"}, 0);

        add("Which array property gives its size?",
                new String[]{"size()", "length()", "length", "count"}, 2);

        add("Which class reads keyboard input commonly?",
                new String[]{"Scanner", "ReaderInput", "Keyboard", "Input"}, 0);

        add("Which method prints and adds a new line?",
                new String[]{"print()", "println()", "write()", "display()"}, 1);

        add("Which package is imported automatically?",
                new String[]{"java.util", "java.io", "java.lang", "java.sql"}, 2);

        add("Which keyword creates a subclass relationship?",
                new String[]{"extends", "implements", "imports", "package"}, 0);

        add("Can Java support multiple inheritance through classes?",
                new String[]{"Yes", "No", "Only with final", "Only with static"}, 1);

        add("Which interface represents a resizable list?",
                new String[]{"List", "Runnable", "Comparable", "Cloneable"}, 0);

        add("Which collection stores key-value pairs?",
                new String[]{"ArrayList", "HashMap", "HashSet", "Stack"}, 1);

        add("Which collection follows LIFO?",
                new String[]{"Queue", "Stack", "TreeSet", "ArrayList"}, 1);

        add("Which collection follows FIFO behavior?",
                new String[]{"Stack", "Queue", "HashSet", "Map"}, 1);

        add("Which keyword starts exception-handling code?",
                new String[]{"try", "catch", "final", "error"}, 0);

        add("Which keyword declares an abstract class or method?",
                new String[]{"virtual", "abstract", "interface", "native"}, 1);

        add("Which method converts a string to an integer?",
                new String[]{"Integer.valueOfInt()", "Integer.parseInt()", "String.toInt()", "parse.Integer()"}, 1);

        add("Which keyword is used to create a package declaration?",
                new String[]{"import", "package", "include", "using"}, 1);

        add("Which keyword imports another package's classes?",
                new String[]{"include", "using", "import", "require"}, 2);

        add("Which method starts a new Thread?",
                new String[]{"run()", "start()", "begin()", "execute()"}, 1);

        add("Which interface can be used to define a thread task?",
                new String[]{"Runnable", "Serializable", "Readable", "Iterable"}, 0);

        add("Which keyword is used to access a parent class member?",
                new String[]{"this", "parent", "super", "base"}, 2);

        add("Which exception can occur when dividing an integer by zero?",
                new String[]{"IOException", "ArithmeticException", "NullPointerException", "ClassNotFoundException"}, 1);

        add("Which feature automatically reclaims unused memory?",
                new String[]{"Destructor", "Garbage collection", "Manual deletion", "Pointer arithmetic"}, 1);

        add("Which tool compiles Java source code?",
                new String[]{"java", "javac", "javadoc", "jdb"}, 1);
    }

    private void add(String question, String[] options, int answer) {
        Map<String, Object> q = new HashMap<>();
        q.put("question", question);
        q.put("options", options);
        q.put("answer", answer);
        questions.add(q);
    }

    @GetMapping("/quiz")
    public String quiz(Model model) {
        model.addAttribute("questions", questions);
        return "quiz";
    }

    @PostMapping("/result")
    public String result(
            @RequestParam Map<String, String> answers,
            Model model) {

        int score = 0;

        for (int i = 0; i < questions.size(); i++) {
            String selected = answers.get("q" + i);

            if (selected != null &&
                    selected.equals(String.valueOf(
                            questions.get(i).get("answer")))) {
                score++;
            }
        }

        model.addAttribute("score", score);
        model.addAttribute("total", questions.size());
        model.addAttribute("percentage",
                score * 100.0 / questions.size());

        return "result";
    }
}