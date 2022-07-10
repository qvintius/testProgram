package classes;

import java.util.ArrayList;
import java.util.List;

public class Vopros {
    private int id;
    private String theme;

    private int count;

    private List<String> otvety;

    public Vopros() {
    }

    /*public Vopros(int id, String theme) {
        this.id = id;
        this.theme = theme;
    }*/

    public Vopros(int id, String theme, int count, List<String> otvety) {
        this.id = id;
        this.theme = theme;
        this.count = count;
        this.otvety = otvety;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<String> getOtvety() {
        return otvety;
    }

    public void setOtvety(List<String> otvety) {
        this.otvety = otvety;
    }

    @Override
    public String toString() {
        return "id: " + id +
                "\n theme: " + theme  +
                "\n count: " + count +
                "\n otvety: " + otvety +
                "\n";
    }
}
