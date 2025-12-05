/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.Serializable; //is the class and that can take an object and serialize into byte stream and send to the network
/**
 *
 * @author vuong
 */

public class Envelope implements Serializable{
    private String id;
    private String arg;
    private Object contents;
    
    public Envelope(){
        //must have for serializatble to use
    }

    public Envelope(String id, String arg, Object contents) {
        this.id = id;
        this.arg = arg;
        this.contents = contents;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArg() {
        return arg;
    }

    public void setArg(String arg) {
        this.arg = arg;
    }

    public Object getContents() {
        return contents;
    }

    public void setContents(Object contents) {
        this.contents = contents;
    }
    
}
