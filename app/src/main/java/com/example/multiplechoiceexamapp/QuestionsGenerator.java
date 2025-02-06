package com.example.multiplechoiceexamapp;

public class QuestionsGenerator {

    //Data members
    private int index =0;
    private int correct;
    private int total;
    private int size;

    //5 Questions
    private String[] questions = {
    "What does the acronym \"CPU\" stand for in computer science?"
    ,"What is the primary function of an operating system?"
    ,"Which data structure uses LIFO (Last In, First Out) order?"
    ,"Which programming language is commonly used for web development on the client-side?"
    ,"What is the purpose of an IP address in networking?"};

    //5 Answers
    private String[][] answers ={
        {"Central Processing Unit", "Central Power Unit", "Central Program Unit", "Computer Processing Unit"},
        {"Store data permanently", "Manage hardware and software resources", "Compile programs", "Execute machine code"},
        {"Queue", "Array", "Stack", "Linked List"},
        {"Python", "JavaScript", "C++", "Java"},
        {"To assign a name to a device", "To encrypt data", "To uniquely identify devices on a network", "To store website data"}
    };

    //Keys for correct answers
    private int[] keys = {1,2,3,2,3};

    //public constructor
    public QuestionsGenerator()
    {
        //The size of the questions array
        size = questions.length;

        //index is where the pointer at for each question
        index = 0;

        //number of correct answers answered
        correct = 0;

        //number of total questions been displayed
        total = 0;
    }

    //for every generate , the pointer moves to the next question
    public void generate()
    {
        index +=1;
    }


    //getters
    public int getIndex()
    {
        return index;
    }

    public int getCorrect()
    {
        return correct;
    }

    public int getTotal()
    {
        return total;
    }

    public int getSize()
    {
        return size;
    }


    public String getQuestions() {
        return questions[index];
    }

    public int getKey()
    {
        return keys[index];
    }

    public String getAnswer1()
    {
        return answers[index][0];
    }

    public String getAnswer2()
    {
        return answers[index][1];
    }

    public String getAnswer3()
    {
        return answers[index][2];
    }

    public String getAnswer4()
    {
        return answers[index][3];
    }

    //Increment the number of correct answers
    public void increaseCorrect()
    {
        correct +=1;
    }

    //Increase the number of questions asked
    public void increaseTotal()
    {
        total +=1;
    }
}