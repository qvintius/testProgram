package classes;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VoprosRealisation {
    private static int ID_COUNT;
    /*private List<Vopros> voprosy;
    {
        voprosy = new ArrayList<>();
        voprosy.add(new Vopros(++ID_COUNT, "theme1"));
        voprosy.add(new Vopros(++ID_COUNT, "theme2"));
        voprosy.add(new Vopros(++ID_COUNT, "theme3"));
    }*/
    private List<String> otvety;
    {
        otvety = new ArrayList<>();
        otvety.add("otvet1");
        otvety.add("otvet2");
        otvety.add("otvet3");
        otvety.add("otvet4");
    }

    private List<Vopros> voprosy;
    {
        voprosy = new ArrayList<>();
        voprosy.add(new Vopros(++ID_COUNT, "theme1", 4,  otvety));
        voprosy.add(new Vopros(++ID_COUNT, "theme2", 4, otvety));
        voprosy.add(new Vopros(++ID_COUNT, "theme3", 4, otvety));
    }
    public List<Vopros> outputAll(){return voprosy;}
    public Vopros outputById(int id){
        return voprosy.stream().filter(vopros -> vopros.getId() == id).findAny().orElse(null);
    }
    public void update(int id, Vopros updatedVopros){
        Vopros voprosToBeUpdated = outputById(id);
        voprosToBeUpdated.setTheme(updatedVopros.getTheme());
        voprosToBeUpdated.setCount(updatedVopros.getCount());
        voprosToBeUpdated.setOtvety(updatedVopros.getOtvety());
    }
    public void save(Vopros vopros){
        vopros.setId(++ID_COUNT);
        voprosy.add(vopros);
    }
    public void delete(int id){ voprosy.removeIf(v -> v.getId() == id); }
}
