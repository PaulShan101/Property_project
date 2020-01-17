package PropertyAgents;

import Home.MyList;
import Properties.Property;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PropertyAgentModel {

    private MyList propAgents;

    private static int PropertyId=0;

    public PropertyAgentModel()

    {

        propAgents = new MyList();

    }

    public MyList getPropAgents() {
        return propAgents;
    }

    public void addProp(String name, int phoneNumber) {

        PropertyAgent propAgent = new PropertyAgent(name,phoneNumber);
          propAgents.add(propAgent);

    }

    public boolean removeProperty(int id) {
        for (int i = 0; i < propAgents.size(); i++) {
            if (((PropertyAgent) propAgents.get(i)).getId() == id) {
                propAgents.remove(i);
                return true;
            }
        }
        // prop.remove(id);
        return false;

    }

    public PropertyAgent getPropDetails(String id){
        int id1;
        try {
            id1 = (Integer.parseInt(id));  //Test only
        }
        catch (Exception e)
        {
            return null;
        }


        for (int i = 0; i < propAgents.size(); i++){

            if (((PropertyAgent)propAgents.get(i)).getId()  ==id1){

                return ((PropertyAgent)propAgents.get(i));

            }

        }

        return null;

    }
    public void deletePropAgent(int index)

    {
        propAgents.remove(index);
    }

    public MyList  getProp() {
        return propAgents;
    }


    public int getSize()
    {
        return propAgents.size();
    }



    public void saveProperties() throws Exception

    {

        XStream xstream = new XStream(new DomDriver());

        ObjectOutputStream out = xstream.createObjectOutputStream

                (new FileWriter("propertyAgents.xml"));

        out.writeObject(propAgents);

        out.close();

    }

    public void loadProperties() throws Exception

    {

        XStream xstream = new XStream(new DomDriver());

        ObjectInputStream is = xstream.createObjectInputStream

                (new FileReader("propertyAgents.xml"));

        propAgents = (MyList) is.readObject();
        Property.productId=((PropertyAgent)propAgents.get(propAgents.size()-1)).getId()+1;

        is.close();

    }



}
