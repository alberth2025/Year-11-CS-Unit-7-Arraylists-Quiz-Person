import java.util.ArrayList;
import java.util.Collections;

public class PersonFactory {

    private ArrayList<Person> allPersons;

    public PersonFactory() {
        allPersons = new ArrayList<>();
    }

    public void addPerson(Person person) {
        Collections.sort(allPersons); //sort list in alphabetical order first

        int original_size = allPersons.size(); //note original size for line 23.

        for(int i = 0; i < allPersons.size(); i++){ // compares last name of person object to each person object in arralyist.
            String str1 = person.getLastName();
            String str2 = allPersons.get(i).getLastName();
            if(str2.compareTo(str1) >= 0) //if person object lastname is lexicographically less or equal than the person object from arraylist, insert person object there
                allPersons.add(i, person);
        }
        if(original_size == allPersons.size()) // this means that the person object had not been added through the for loop above, and thus belongs at the end of the list.
            allPersons.add(person);
    }

    public ArrayList<Person> under18() {
        ArrayList<Person> under18List = new ArrayList<>();
        for (Person person: allPersons){
            if(person.getAge() < 18)
                under18List.add(person);
        }
        return under18List;
    }

    public boolean checkLastName(String lastName) {
        for(Person person: allPersons){
            if (person.getLastName().equals(lastName))
                return true;
        }
        return false;
    }
}