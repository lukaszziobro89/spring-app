package pl.other;

import java.util.List;

public class ListHolder<Student, String> {
    private List<Student> listOfCorrectStudentsEntries;
    private List<String> listOfIncorrectStudentsEntries;

    public ListHolder(List<Student> correctStudentsEntries, List<String> incorrectStudentsEntries) {
        this.listOfCorrectStudentsEntries = correctStudentsEntries;
        this.listOfIncorrectStudentsEntries = incorrectStudentsEntries;
    }

    public List<Student> getListOfCorrectStudentsEntries() {
        return listOfCorrectStudentsEntries;
    }

    public List<String> getListOfIncorrectStudentsEntries() {
        return listOfIncorrectStudentsEntries;
    }
}
