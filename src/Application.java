
public class Application {
    public static void main(String[] args) {
        Profile profile = new Profile("Damir Lapeiko");
        System.out.println(profile.fullName);
        System.out.println(profile.getFirstName());
        System.out.println(profile.getLastName());
    }
}
