package Controller;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Rees {
    private final IntegerProperty id;
    private final StringProperty fullname;
    private final StringProperty room;
    private final StringProperty checkin;
    private final StringProperty checkout;
    private final StringProperty createdat;

    public Rees(IntegerProperty id, StringProperty fullname, StringProperty room, StringProperty checkin, StringProperty checkout, StringProperty createdat) {
        this.id = id;
        this.fullname = fullname;
        this.room = room;
        this.checkin = checkin;
        this.checkout = checkout;
        this.createdat = createdat;
    }

    public Rees(Integer id, String fullname, String room, String checkin, String checkout, String createdat) {
        this.id = new SimpleIntegerProperty(id);
        this.fullname = new SimpleStringProperty(fullname);
        this.room = new SimpleStringProperty(room);
        this.checkin = new SimpleStringProperty(checkin);
        this.checkout = new SimpleStringProperty(checkout);
        this.createdat = new SimpleStringProperty(createdat);
    }

    public Integer getId(){
        return id.get();
    }
    public String getFullname(){
        return fullname.get();
    }
    public String getRoom(){
        return room.get();
    }
    public String getCheckin(){
        return checkin.get();
    }
    public String getCheckout(){ return checkout.get(); }
    public String getCreatedat(){
        return createdat.get();
    }

    public void setId(Integer value){
        id.setValue(value);
    }
    public void setFullname(String value){
        fullname.setValue(value);
    }
    public void setRoom(String value){
        room.setValue(value);
    }
    public void setCheckin(String value){
        checkin.setValue(value);
    }
    public void setCheckout(String value){
        checkout.setValue(value);
    }
    public void setCreatedat(String value){
        createdat.setValue(value);
    }

    public IntegerProperty idProperty(){ return id; }
    public StringProperty fullnameProperty(){ return fullname; }
    public StringProperty roomProperty(){
        return room;
    }
    public StringProperty checkinProperty(){
        return checkin;
    }
    public StringProperty checkoutProperty(){
        return checkout;
    }
    public StringProperty createdatProperty(){
        return createdat;
    }

}