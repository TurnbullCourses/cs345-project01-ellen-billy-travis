package edu.ithaca.dturnbull.bank;
public class User {
    private BankAccount userAccounts[];
    private String email;
    private String password;

    public User(BankAccount[] accounts, String userEmail, String userPassword){

    }

    public boolean confirmCredentials(){
        return true;
    }



    public static boolean isPasswordValid(String userPassword){
        return true;
    }

    public static boolean isEmailValid(String userEmail){
        
        if(userEmail.length() <= 0)
            return false;

        //If first character is not a letter or number
        if(userEmail.charAt(0) < 'A' || userEmail.charAt(0) > 'z'){
            return false;
        }
        else if(userEmail.charAt(0) > 'Z' && userEmail.charAt(0) < 'a'){
            return false;
        }
        else if(userEmail.charAt(0) > '9' && userEmail.charAt(0) < '0'){
            return false;
        }
        
        
        //if it does not contain an @ or has no prefix
        if (userEmail.indexOf('@') == -1 || userEmail.indexOf('@') == 0){
            return false;
        }
        else {
            //if there is more than 1 @
            int count = 0;
            for(int i = 0; i<userEmail.length(); i++){
                if(userEmail.charAt(i) == '@'){
                    count++;
                }
            }

            if(count > 1)
                return false;
        }

        int lastPeriodIndex = userEmail.lastIndexOf('.');
        //if the @ is after the period
        if(userEmail.lastIndexOf('@') > lastPeriodIndex){
            return false;
        }
        else{
            //if suffix has less than 2 characters after the period  g@f.om
            if(lastPeriodIndex > userEmail.length() - 3){
                return false;
            }


            //if a period isn't followed by a letter or number
            for(int i = 0; i < userEmail.length(); i++){
                if(userEmail.charAt(i) == '.'){
                    //period not followed by letter
                    if(userEmail.charAt(i+1) > 122 || userEmail.charAt(i+1) < 65){
                        return false;
                    }
                    else if(userEmail.charAt(i+1) > 90 && userEmail.charAt(i+1) < 97){
                            return false;
                    }
                    else if(userEmail.charAt(i+1) > '9' && userEmail.charAt(i+1) < '0'){
                        return false;
                    }
                }
            }

            //if a underscore isn't followed by a letter or number
            for(int i = 0; i < userEmail.length(); i++){
                if(userEmail.charAt(i) == '_'){
                    //period not followed by letter
                    if(userEmail.charAt(i+1) > 122 || userEmail.charAt(i+1) < 65){
                        return false;
                    }
                    else if(userEmail.charAt(i+1) > 90 && userEmail.charAt(i+1) < 97){
                            return false;
                    }
                    else if(userEmail.charAt(i+1) > '9' && userEmail.charAt(i+1) < '0'){
                        return false;
                    }
                }
            }

            //if a dash isn't followed by a letter or number
            for(int i = 0; i < userEmail.length(); i++){
                if(userEmail.charAt(i) == '-'){
                    //period not followed by letter
                    if(userEmail.charAt(i+1) > 122 || userEmail.charAt(i+1) < 65){
                        return false;
                    }
                    else if(userEmail.charAt(i+1) > 90 && userEmail.charAt(i+1) < 97){
                            return false;
                    }
                    else if(userEmail.charAt(i+1) > '9' && userEmail.charAt(i+1) < '0'){
                        return false;
                    }
                }
            }
        }

        //if any domain character isn't a lower case letter or period
        for(int i = userEmail.indexOf('@') + 1; i < userEmail.length(); i++){
            if(userEmail.charAt(i) < 97 || userEmail.charAt(i) > 122){
                if(userEmail.charAt(i) != '.'){
                    return false;
                }             
            }
        }

        return true;

        
    }

}
