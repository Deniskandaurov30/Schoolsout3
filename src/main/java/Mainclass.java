import model.Person;
import model.User;
import repository.EMFactory;
import repository.PersonRepository;
import repository.UserRepository;
import services.UserService;

public class Mainclass {

    public static void main(String[] args) {

        Person person = new Person();
        User user = new User("rerger","lolcats",true, person);
        UserRepository userRepository= new UserRepository() ;
        userRepository.createUser(user);
        System.out.println("check");
    }


}
