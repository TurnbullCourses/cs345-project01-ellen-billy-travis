package edu.ithaca.dturnbull.bank;

public abstract class Teller {
    
    /**
     * The login check for the user
     * @param user - the user account to login to
     * @param email - the entered email string
     * @param password - the entered password string
     * @return true if the correct email and password for the given user
     */
    public boolean userLogin(User user, String email, String password){
        return user.confirmCredentials(email, password);
    }
}
