package pl.other;

import java.util.List;

public class ListHolder<Student, String> {
    private List<Student> listOfCorrectEntries;
    private List<String> listOfIncorrectEntries;

    public ListHolder(List<Student> correctStudentsEntries, List<String> incorrectStudentsEntries) {
        this.listOfCorrectEntries = correctStudentsEntries;
        this.listOfIncorrectEntries = incorrectStudentsEntries;
    }

    public List<Student> getListOfCorrectEntries() {
        return listOfCorrectEntries;
    }

    public List<String> getListOfIncorrectEntries() {
        return listOfIncorrectEntries;
    }
}
