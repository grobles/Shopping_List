package com.Utilities;

import com.DataContainers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Class: WriteToFile
 * Description: This class helps write the DataContainers class to a serialize file and read from it
 * Author: Brian Arnold & Guadalupe Robles Gil Date:
 * 27/09/12 Time: 04:44 PM *
 */
public class WriteToFile {

    /**
     * method: writeSerializeFile  It writes to a file the DataConatiner
     *
     * @param object
     */
    public static void writeSerializeFile(Object object) {
        try {
            if (object instanceof DataContainers) {
                DataContainers container = (DataContainers) object;
                String fileName = "DataContainers.ser";
                FileOutputStream file = new FileOutputStream(fileName);
                ObjectOutputStream stream = new ObjectOutputStream(file);
                stream.writeObject(container);
                stream.flush();
            }
        } catch (Exception e) {
            // Problem writing file!
            System.out.println(e.getMessage());
        }
    }

    /**
     * method: readSerializeFile  It from the file the DataContainer object
     *
     * @return
     */
    public static DataContainers readSerializeFile() {

        DataContainers object = null;

        try {

            ObjectInputStream input1 = new ObjectInputStream(new FileInputStream("DataContainers.ser"));

            object = (DataContainers) input1.readObject();


            input1.close();
            return object;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }

    }
}
