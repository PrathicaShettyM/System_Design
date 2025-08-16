package Example_2.ProblematicCode;

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

    // 5. Log user activity
    // Now this function violates the single responsibility principle, tht is till now CRUD operations were going on
    // now we are doing log monitoring
    // coz a lot many things can be changed: log the mouse, hover, browsing data etc
    
    public void logUserActivity(User user){
        System.out.println("User activity logged");
    }
}
