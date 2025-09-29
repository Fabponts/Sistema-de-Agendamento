package com.example.springboot.exeception;

public class ItemNotFound extends RuntimeException{

    public ItemNotFound(String message){
        super(message);
    }
}
