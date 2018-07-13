import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class Starship {

    private String name;
    private String model;
    private String manufacturer;
    private int cost_in_credits;
    private double length;
    private int max_atmosphering_speed;
    private int crew;
    private int passengers;
    private int cargo_capacity;
    private String consumables;
    private double hyperdrive_rating;
    private int MGLT;
    private String starship_class;
    private List<String> pilots;
    private List<String> films;
    private String created;
    private String edited;
    private String url;

    public Starship() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Starship Starship = (Starship) o;
        return Starship.getName().equals(this.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}


