package persistentie;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObjectStreamManipulaties {
	
	//Maak de methode generiek
	//remove comment
    public  <E>    leesObject(File naamBestand) {
    	
    	try (ObjectInputStream ois = 
    			new ObjectInputStream(Files.newInputStream(naamBestand.toPath()))){
            return ois.readObject();
            
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ObjectStreamManipulaties.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }     
    */ remove comment
    
    //Maak de methode generiek
    /*//remove comment
    public List< > leesObjecten(File naamBestand) {
    	
        List<    > li = new ArrayList<>();
        
        try (ObjectInputStream ois = 
        		new ObjectInputStream(Files.newInputStream(naamBestand.toPath()))){
            while (true) {
                li.add(ois.readObject());
                
            }
        } catch (EOFException e) {
            //EOF bereikt, continue
            return li;
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ObjectStreamManipulaties.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    */ //remove comment
}
