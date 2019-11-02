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

    /**
     * Method to insert new record.
     *
     * @param name
     * @param description
     * @param color_id
     * @return
     */
    Integer insertNewRecord(String name, String description, Integer color_id);

    /**
     * Method to get info.
     * @param name
     * @param description
     * @return
     */
    Integer getInfo(String name, String description);
}
