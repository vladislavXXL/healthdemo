package org.healthdemo.model;

public interface SQLRequest {

    /**
     * Method required for adding table into DB.
     *
     * @return status
     */
    String getTableCreationStatus();

    /**
     * @param name specific name of dog
     * @return count of dog's specific name
     */
    Integer getCountByName(String name);
}
