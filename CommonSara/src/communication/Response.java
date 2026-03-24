/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import java.io.Serializable;

/**
 *
 * @author Korisnik
 */
public class Response implements Serializable {
    
    private Operation operation;
    private Object result;
    private Exception exception;
    private boolean uspesno;
    private String poruka;

    public Response() {
    }

    public Response(Operation operation, Object result, Exception exception, boolean uspesno, String poruka) {
        this.operation = operation;
        this.result = result;
        this.exception = exception;
        this.uspesno = uspesno;
        this.poruka = poruka;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public boolean isUspesno() {
        return uspesno;
    }

    public void setUspesno(boolean uspesno) {
        this.uspesno = uspesno;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }
}
