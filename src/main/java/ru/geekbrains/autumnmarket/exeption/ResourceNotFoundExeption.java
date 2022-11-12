package ru.geekbrains.autumnmarket.exeption;

public class ResourceNotFoundExeption extends RuntimeException {
    public ResourceNotFoundExeption(String message){
        super (message);
    }
}
