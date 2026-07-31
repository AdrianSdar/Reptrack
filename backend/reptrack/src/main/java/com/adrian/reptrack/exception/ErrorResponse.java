package com.adrian.reptrack.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
    
    private String message;
    private int status;
    private LocalDateTime localDateTime;

    public ErrorResponse(int status, String message, LocalDateTime localDateTime){
        this.status = status;
        this.message = message;
        this.localDateTime = localDateTime;
    }

    public int getStatus(){
        return status;
    }
    
    public String getMessage(){
        return message;
    }


    public LocalDateTime getLocalDateTime(){
        return localDateTime;
    }
}
