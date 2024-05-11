package com.example.offlinequiz;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QuestionsBank {

    private static List<QuestionsList> javaQuestions() {

        final List<QuestionsList> questionsLists = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("what is the size of in variable?", "16bit", "8bit", "32bit", "64bit", "32bit", "");
        final QuestionsList question2 = new QuestionsList("what is the default value of Bolean variable?", "true", "false", "null", "not defined", "false", "");
        final QuestionsList question3 = new QuestionsList("What of the following is the default value of an instance variable?", "Depends upon the types of the variable", "null", "0", "not assigned", "Depends upon the types of the variable", "");
        final QuestionsList question4 = new QuestionsList("Which is a reserved word in the java programming language", "method", "native", "reference", "array", "native", "");
        final QuestionsList question5 = new QuestionsList("Which of the following in NOT a keywords or reserved words in java?", "if", "then", "goto", "while", "then", "");
        final QuestionsList question6 = new QuestionsList("which is the valid declarations within an interface definition?", "public double methods();", "public final double methods()", "static void methods(double d1);", "protected void methods(double d1);", "public double methods();", "");


        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);

        return questionsLists;
    }

    private static List<QuestionsList> phpQuestions() {

        final List<QuestionsList> questionsLists = new ArrayList<>();


        final QuestionsList question1 = new QuestionsList("PHP is an acronym for ____.", "Prefix Hypertext Preprocessor", "Prototype Hypertext Preprocesso", "Hypertext Preprocessor", "PHP: Hypertext Preprocessor", "PHP: Hypertext Preprocessor", "");
        final QuestionsList question2 = new QuestionsList("Which is/are statement(s) true about PHP?", "It is an open-source scripting language", "PHP scripts execute on the server", "It is used for developing dynamic & interactive websites", "All of the above", "All of the above", "");
        final QuestionsList question3 = new QuestionsList(" What is the extension of a PHP file?", ".php", ".ph", ".phpfile", "All Of Above", ".php", "");
        final QuestionsList question4 = new QuestionsList("Who developed PHP?", "Guido van Rossum", "Rasmus Lerdorf", "Jesse James Garrett", "Douglas Crockford", "Rasmus Lerdorf", "");
        final QuestionsList question5 = new QuestionsList("A PHP script starts with ____ and ends with ___.", "<?php and ?>", "<php> and </php>", "<?php and /?php>", "</php and />", "<?php and ?>", "");
        final QuestionsList question6 = new QuestionsList("Single line comments can be placed in PHP script by using which symbol?", "//", "#", "$", "Both a and b", "Both a and b", "");


        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);

        return questionsLists;
    }

    private static List<QuestionsList> htmlQuestions() {

        final List<QuestionsList> questionsLists = new ArrayList<>();


        final QuestionsList question1 = new QuestionsList("What does the abbreviation HTML stand for?", "HyperText Markup Language", "HighText Markup Language", "HyperText Markdown Language", "None of the above", "HyperText Markup Language", "");
        final QuestionsList question2 = new QuestionsList("How many size of headers are available in HTML by default?", "5", "1", "3", "6", "6", "");
        final QuestionsList question3 = new QuestionsList("What is the smallest header in HTML by default?", "h1", "h3", "h5", "h6", "h6", "");
        final QuestionsList question4 = new QuestionsList("What are the types of lists available in HTML?", "Ordered, Unordered Lists.", "Bulleted, Numbered Lists.", "Named,Unnamed Lists", "None of the above", "Ordered, Unordered Lists.", "");
        final QuestionsList question5 = new QuestionsList("How to create an ordered list in HTML?", "<ul>", "<ol>", "<href>", "<b>", "<ol>", "");
        final QuestionsList question6 = new QuestionsList("HTML files are saved by default with the extension?", ".html", ".h", ".ht", "None of the above", ".html", "");


        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);

        return questionsLists;
    }

    private static List<QuestionsList> androidQuestions() {

        final List<QuestionsList> questionsLists = new ArrayList<>();


        final QuestionsList question1 = new QuestionsList("Android is?", "an operating system", "a web browser", "a web server", "none of the above", "an operating system", "");
        final QuestionsList question2 = new QuestionsList(" Under which of the following Android is licensed?", "OSS", "SourceForge", "Apache/MIT", "None of the above", "Apache/MIT", "");
        final QuestionsList question3 = new QuestionsList(" For which of the following Android is mainly developed?", "Servers", "Desktops", "Laptops", "Mobile devices", "Mobile devices", "");
        final QuestionsList question4 = new QuestionsList("Which of the following is the first mobile phone released that ran the Android OS?", "HTC Hero", "Google gphone", "T - mobile G1", "None of the above", "T - mobile G1", "");
        final QuestionsList question5 = new QuestionsList("Which of the following virtual machine is used by the Android operating system?", "JVM", "Dalvik virtual machine", "Simple Virtual machine", "None of the above", "Dalvik virtual machine", "");
        final QuestionsList question6 = new QuestionsList("Android is based on which of the following language?", "Java", "C", "C++", "None of the above", "Java", "");


        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);

        return questionsLists;
    }

    public static List<QuestionsList> getQuestions(String selectedTopicName) {
        switch (selectedTopicName) {
            case "java":
                return javaQuestions();
            case "php":
                return phpQuestions();
            case "android":
                return androidQuestions();
            default:
                return htmlQuestions();
        }
    }
}