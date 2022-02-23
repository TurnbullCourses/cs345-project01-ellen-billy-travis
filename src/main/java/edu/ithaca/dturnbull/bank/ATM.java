package edu.ithaca.dturnbull.bank;

public class ATM extends Teller{
    
    private String location;

    /**
     * The constructor function for the ATM object
     * @param atmLocation - the location of the ATM object
     */
    public ATM(String atmLocation){
        location = atmLocation;
    }

    /**
     * Returns the location of the ATM
     * @return the location of the ATM
     */
    public String getLocation(){
        return location;
    }
}
