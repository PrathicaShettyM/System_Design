package Example_2.BetterCode;

public class UserManager {
    // some basic CRUD operations

    // 1. C: CREATE 
    public void add(User user){
        if(user.getAge() < 18){
            throw new IllegalArgumentException("User is not adult");
        }
        System.out.println("User added");
    }

    // 2. R: READ
    public void get(User user){
        System.out.println("User read / returned");
    }

    // 3. U: UPDATE
    public void update(User user){
        if(user.getAge() < 18){
            throw new IllegalArgumentException("User is not adult");
        }
        System.out.println("User is updated");
    }

    // 4. D: DELETE
    public void delete(User user){
        System.out.println("User deleted");
    }

    public void logUserActivity(User user){
        System.out.println("User activity logged");
    }
}
