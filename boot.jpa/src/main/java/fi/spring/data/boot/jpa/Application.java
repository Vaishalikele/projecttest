package fi.spring.data.boot.jpa;

import java.util.Optional;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	UsersRepository userRepo;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		try (Scanner scanner = new Scanner(System.in)) {
			boolean running = true;
			while (running) {
				System.out.println("Enter the name to search");
				String name = scanner.next();
				Optional<Users> tmpUser = userRepo.findByName(name);
				if (name.equals("exit")) {
					running = false;
					return;
				}

				if (!tmpUser.isEmpty()) {
					Users objUser = tmpUser.get();
					System.out.println(objUser.getUserName());
					System.out.println(objUser.getPassword());

					System.out.println(objUser.getName());
					System.out.println(objUser.getEmail());
				} else
					System.out.println("NO SUCH USER FOUNDER");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

//void listAllUsers() {
//// TODO Auto-generated method stub
//
//}
//
//void getByEmail() {
//try (Scanner scanner = new Scanner(System.in)) {
//	boolean running = true;
//	while (running) {
//		System.out.println("Enter the email to search");
//		String email = scanner.next();
//		if (email.equals("exit")) {
//			running = false;
//			return;
//		}
//		Optional<Users> tmpUser = userRepo.findByEmail(email);
//		if (!tmpUser.isEmpty()) {
//			Users objUser = tmpUser.get();
//			System.out.println(objUser.getUserName());
//			System.out.println(objUser.getPassword());
//			System.out.println(objUser.getName());
//			System.out.println(objUser.getEmail());
//		} else
//			System.out.println("NO SUCH USER FOUND");
//	}
//} catch (Exception e) {
//	e.printStackTrace();
//}
//
//}
