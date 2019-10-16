package org.healthdemo.model;

public interface SQLRequest {

    /**
     * Method required for adding table into DB.
     *
     * @return status
     */
    String getTableCreationStatus();

    /**
     * Method to get quantity of records with same name.
     *
     * @param name specific name
     * @return count of dog's specific name
     */
    Integer getCountByName(String name);


    Integer insertNewRecord(String name, String description, Integer color_id);
}
