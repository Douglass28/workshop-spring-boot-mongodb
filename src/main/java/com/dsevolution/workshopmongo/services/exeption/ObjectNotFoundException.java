package com.dsevolution.workshopmongo.services.exeption;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String msg){
        super(msg);
    }
}
