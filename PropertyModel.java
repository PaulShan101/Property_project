package Properties;

import Home.MyList;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.scene.control.ListView;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


class PropertyModel {

    private MyList prop;

    private static int PropertyId=0;





    public PropertyModel()

    {

        prop = new MyList();

    }



    public void addProduct(  String description, String address, String ber,

                             String eircode,String areaId, double price, double bedroomId, String typeId)

    {

        Property proper = new Property(description, address, ber, eircode, areaId,price, bedroomId, typeId );

        prop.add(proper);

    }

    public boolean removePropertyByPosition(int posId){


            prop.remove(posId);
            return false;
        }

    public boolean removeProperty(int id) {
                 for (int i = 0; i < prop.size(); i++) {
                     if (((Property) prop.get(i)).getId() == id)  {
                         prop.remove(i);
                         return true;
                     }
                 }
                     // prop.remove(id);
                     return false;

             }

public void filterPrice(ListView lv, double housePrice){
    lv.getItems().clear();
    for (Object item : prop){
        if(((Property)item).getPrice()>=housePrice){
            lv.getItems().add(item.toString());
        }
    }
}

    public void filterRoom(ListView lv, double bedroom){
        lv.getItems().clear();
        for (Object item : prop){
            if(((Property)item).getBedroomId()>=bedroom){
                lv.getItems().add(item.toString());

            }
        }
    }

    public void filterLocation(ListView lv, String location) {
        lv.getItems().clear();
        for (Object item : prop) {
            if (((Property)item).getAreaId().contains(location) ) {
                lv.getItems().add(item.toString());
            }
        }
    }

    public void filterType(ListView lv, String type) {
        lv.getItems().clear();
        for (Object item : prop) {
            if (((Property)item).getTypeId().contains(type)) {
                lv.getItems().add(item.toString());
            }
        }
    }

    public String listProperties()

    {

        int i=0;

        String displayProperties = "All Properties";

        for (Object item:prop){

            displayProperties += "\n"+ (i++) + ": " + item;

        }

        return displayProperties;

    }




    public Property getPropDetails(String id) {
        int id1;
        try {
            id1 = (Integer.parseInt(id));  //Test only
        } catch (Exception e) {
            return null;
        }



     for (Object item:prop){

            if (((Property)item).getId()==id1){

                //return ;

            }

        }

        return null;

    }




    public void saveProperties() throws Exception

    {

        XStream xstream = new XStream(new DomDriver());

        ObjectOutputStream out = xstream.createObjectOutputStream

                (new FileWriter("properties.xml"));

        out.writeObject(prop);

        out.close();

    }


    public MyList getProp()
    {
        return prop;
    }
    public int getSize()
    {
        return prop.size();
    }



    public void loadProperties() throws Exception

    {

        XStream xstream = new XStream(new DomDriver());

        ObjectInputStream is = xstream.createObjectInputStream

                (new FileReader("properties.xml"));

        prop = (MyList) is.readObject();
        Property.productId=((Property) prop.get(prop.size()-1)).getId()+1;

        is.close();

    }

    public String getTitle()

    {

        return("Property Site");

    }

}




