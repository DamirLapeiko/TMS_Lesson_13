public class Profile {
    public String fullName;

    public Profile(String fullName){
        this.fullName = fullName;
    }
    public String getFirstName(){
        String[] parts = fullName.split(" ");
        return parts[0];
    }

    public String getLastName(){
        String[] parts = fullName.split(" ");
        return parts[1];
    }
}