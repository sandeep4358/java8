package com.stingray.desinePattern;

public class ChainOfResponsibility {
    public static void main(String[] args) {
        LoggerHandler logger = new LoggerHandler(new InfoLoggerHandler(new DebugLoggerHandler(new ErrorLoggerHandler(null))));
        logger.log(1,"Hello this is Sandeep");
    }
}


 class LoggerHandler{
    public final int  INFO_LOGGER = 1;
    public final int DEBUG_LOGGER = 2;
    public   final int ERROR_LOGGER = 3;

    private LoggerHandler nextLogger;

    LoggerHandler(LoggerHandler nextLogger){
        this.nextLogger = nextLogger;
    }


    public void log(int i, String message){
        if(this.nextLogger !=null){
            nextLogger.log(i,message);
        }
    }
}


class InfoLoggerHandler extends LoggerHandler{

    InfoLoggerHandler(LoggerHandler nextLogger) {
        super(nextLogger);
    }

    public void log(int i , String message){
        if(i == INFO_LOGGER){
            System.out.println("INFO :: "+message);
        }else {
            super.log(i,message);
        }
    }
}

class ErrorLoggerHandler extends LoggerHandler{
    ErrorLoggerHandler(LoggerHandler nextLogger) {
        super(nextLogger);
    }

    public void log(int i , String message){
        if(i == ERROR_LOGGER){
            System.out.println("ERROR :: "+message);
        }else {
            super.log(i,message);
        }
    }
}class DebugLoggerHandler extends LoggerHandler{
    DebugLoggerHandler(LoggerHandler nextLogger) {
        super(nextLogger);
    }

    public void log(int i , String message){
        if(i == DEBUG_LOGGER){
            System.out.println("DEBUG :: "+message);
        }else {
            super.log(i,message);
        }
    }
}