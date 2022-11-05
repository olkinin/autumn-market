package ru.geekbrains.autumnmarket.exeption;

public class ResourseNotFoundExeption extends RuntimeException {
    public ResourseNotFoundExeption(String message){
        super (message);
    }
}
