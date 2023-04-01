package com.example.auditingquizapp1;

public class QuizTest {

    public static String[] mLabels = {
            "Question 1",
            "Question 2",
            "Question 3",
            "Question 4",
            "Question 5"
    };

    public static String mQuestions[] = {
            "Which of the following statements explains a detection risk?",
            "Choose a self-interest threat below.",
            "Which of these is a weakness?",
            "What further work is applicable to unadjusted audit differences below performance materiality?",
            "What does the job of an auditor entails?"
    };

    public static String[][] mAnswers = {
            {"The risk that an auditor's conclusion based on a sample may be different from the conclusion that could have been reached if the entire population was subjected to the same audit procedure", "The risk that the auditor expressesn inappropriate audit opinion when the financial statements are materially mistated.", "The risk that the procedures performed by the auditor to reduce the audit risk to an acceptable low level will not a material misstatement that exists."},
            {"sa", "zw", "lb"},
            {"1", "2", "3"},
            {"bird", "apple", "mark"},
            {"Americanos", "Pacifica", "Arabic"},
    };

    public static String mCorrectAnswers[] = {
            "The risk that the procedures performed by the auditor to reduce the audit risk to an acceptable low level will not a material misstatement that exists.",
            "sa",
            "3",
            "mark",
            "Americanos"
    };
}
