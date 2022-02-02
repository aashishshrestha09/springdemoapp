package com.shrestha.demoapp.error;

public class DepartmentNotFoundException extends Exception {

    public DepartmentNotFoundException() {
    }

    public DepartmentNotFoundException(String arg0) {
        super(arg0);
    }

    public DepartmentNotFoundException(Throwable arg0) {
        super(arg0);
    }

    public DepartmentNotFoundException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public DepartmentNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }
    
}
