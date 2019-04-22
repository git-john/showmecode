package com.john.designpattern.filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaFemale implements Criteria {

    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> malePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if(person.getGender().equalsIgnoreCase("FEMALE")){
                malePersons.add(person);
            }
        }
        return malePersons;
    }
}
