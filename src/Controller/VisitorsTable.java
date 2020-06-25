package Controller;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class VisitorsTable {
    private final IntegerProperty id;
    private final StringProperty fullname;
    private final StringProperty email;
    private final StringProperty phone;
    private final StringProperty room;
    private final StringProperty createdat;

    public VisitorsTable(IntegerProperty id, StringProperty fullname, StringProperty email, StringProperty phone, StringProperty room, StringProperty createdat) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.room = room;
        this.createdat = createdat;
    }

    public VisitorsTable(Integer id, String fullname, String email, String phone, String room, String createdat) {
        this.id = new SimpleIntegerProperty(id);
        this.fullname = new SimpleStringProperty(fullname);
        this.email = new SimpleStringProperty(email);
        this.phone = new SimpleStringProperty(phone);
        this.room = new SimpleStringProperty(room);
        this.createdat = new SimpleStringProperty(createdat);
    }

    public Integer getId(){
        return id.get();
    }
    public String getFullname(){
        return fullname.get();
    }
    public String getEmail(){
        return email.get();
    }
    public String getPhone(){
        return phone.get();
    }
    public String getRoom(){ return room.get(); }
    public String getCreatedat(){
        return createdat.get();
    }

    public void setId(Integer value){
        id.setValue(value);
    }
    public void setFullname(String value){
        fullname.setValue(value);
    }
    public void setEmail(String value){
        email.setValue(value);
    }
    public void setPhone(String value){
        phone.setValue(value);
    }
    public void setRoom(String value){
        room.setValue(value);
    }
    public void setCreatedat(String value){
        createdat.setValue(value);
    }

    public IntegerProperty idProperty(){ return id; }
    public StringProperty fullnameProperty(){ return fullname; }
    public StringProperty emailProperty(){
        return email;
    }
    public StringProperty phoneProperty(){
        return phone;
    }
    public StringProperty roomProperty(){
        return room;
    }
    public StringProperty createdatProperty(){
        return createdat;
    }

}