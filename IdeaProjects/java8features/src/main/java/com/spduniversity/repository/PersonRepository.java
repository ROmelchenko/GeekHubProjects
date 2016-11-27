package com.spduniversity.repository;

import com.spduniversity.entity.Person;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.spduniversity.util.RandomUtils.oneOf;

@Repository
public class PersonRepository {

    private static final String[] FIRST_NAME_VARIATIONS = new String[]{"Sophia", "Emma", "Olivia", "Isabella", "Mia", "Ava", "Lily", "Zoe", "Emily", "Chloe", "Layla", "Madison", "Madelyn", "Abigail", "Aubrey", "Charlotte", "Amelia", "Ella", "Kaylee", "Avery", "Aaliyah", "Hailey", "Hannah", "Addison", "Riley", "Harper", "Aria", "Arianna", "Mackenzie", "Lila", "Evelyn", "Adalyn", "Grace", "Brooklyn", "Ellie", "Anna", "Kaitlyn", "Isabelle", "Sophie", "Scarlett", "Natalie", "Leah", "Sarah", "Nora", "Mila", "Elizabeth", "Lillian", "Kylie", "Audrey", "Lucy", "Maya", "Annabelle", "Makayla", "Gabriella", "Elena", "Victoria", "Claire", "Savannah", "Peyton", "Maria", "Alaina", "Kennedy", "Stella", "Liliana", "Allison", "Samantha", "Keira", "Alyssa", "Reagan", "Molly", "Alexandra", "Violet", "Charlie", "Julia", "Sadie", "Ruby", "Eva", "Alice", "Eliana", "Taylor", "Callie", "Penelope", "Camilla", "Bailey", "Kaelyn", "Alexis", "Kayla", "Katherine", "Sydney", "Lauren", "Jasmine", "London", "Bella", "Adeline", "Caroline", "Vivian", "Juliana", "Gianna", "Skyler", "Jordyn", "Jackson", "Aiden", "Liam", "Lucas", "Noah", "Mason", "Jayden", "Ethan", "Jacob", "Jack", "Caden", "Logan", "Benjamin", "Michael", "Caleb", "Ryan", "Alexander", "Elijah", "James", "William", "Oliver", "Connor", "Matthew", "Daniel", "Luke", "Brayden", "Jayce", "Henry", "Carter", "Dylan", "Gabriel", "Joshua", "Nicholas", "Isaac", "Owen", "Nathan", "Grayson", "Eli", "Landon", "Andrew", "Max", "Samuel", "Gavin", "Wyatt", "Christian", "Hunter", "Cameron", "Evan", "Charlie", "David", "Sebastian", "Joseph", "Dominic", "Anthony", "Colton", "John", "Tyler", "Zachary", "Thomas", "Julian", "Levi", "Adam", "Isaiah", "Alex", "Aaron", "Parker", "Cooper", "Miles", "Chase", "Muhammad", "Christopher", "Blake", "Austin", "Jordan", "Leo", "Jonathan", "Adrian", "Colin", "Hudson", "Ian", "Xavier", "Camden", "Tristan", "Carson", "Jason", "Nolan", "Riley", "Lincoln", "Brody", "Bentley", "Nathaniel", "Josiah", "Declan", "Jake", "Asher", "Jeremiah", "Cole", "Mateo", "Micah", "Elliot"};
    private static final String[] LAST_NAME_VARIATIONS = new String[]{"Smith", "Murphy", "Lam", "Martin", "Brown", "Roy", "Tremblay", "Lee", "Gagnon", "Wilson"};
    private static final String[] JOB_TITLE_VARIATIONS = new String[]{"Chief diversity officer", "Chief content officer", "Chief executive officer", "Chief experience officer", "Chief financial officer", "Chief gaming officer", "Chief genealogical officer", "Chief human resources officer", "Chief information officer", "Chief information officer (higher education)", "Chief information security officer", "Chief innovation officer", "Chief investment officer", "Chief knowledge officer", "Chief learning officer", "Chief marketing officer", "Chief operating officer", "Chief privacy officer", "Chief process officer", "Chief product officer", "Chief reputation officer", "Chief research officer", "Chief restructuring officer", "Chief risk officer", "Chief science officer", "Chief Scientific Officer", "Chief security officer", "Chief services officer", "Chief strategy officer", "Chief sustainability officer", "Chief technology officer", "Chief visibility officer", "Chief visionary officer", "Chief web officer"};

    private List<Person> persons = new ArrayList<>();

    @PostConstruct
    public void init() {

        for (int i = 0; i < 10_000_000; i++) {
            Person person = new Person();
            person.setFirstName(oneOf(FIRST_NAME_VARIATIONS));
            person.setLastName(oneOf(LAST_NAME_VARIATIONS));
            person.setJobTitle(oneOf(JOB_TITLE_VARIATIONS));
            person.setAge(new Random().nextInt(30) + 20);
            persons.add(person);
        }
    }

    public List<Person> list() {
        return new ArrayList<>(persons);
    }

}
