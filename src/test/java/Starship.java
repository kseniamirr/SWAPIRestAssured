
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Starship {

    @Setter
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

    public Starship(String name, String model, String manufacturer, int cost_in_credits, double length, int max_atmosphering_speed, int crew,
                    int passengers, int cargo_capacity, String consumables, double hyperdrive_rating, int MGLT, String starship_class, List<String> pilots,
                    List<String> films, String created, String edited, String url) {
        this.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
        this.cost_in_credits = cost_in_credits;
        this.length = length;
        this.max_atmosphering_speed = max_atmosphering_speed;
        this.crew = crew;
        this.passengers = passengers;
        this.cargo_capacity = cargo_capacity;
        this.consumables = consumables;
        this.hyperdrive_rating = hyperdrive_rating;
        this.MGLT = MGLT;
        this.starship_class = starship_class;
        this.pilots = pilots;
        this.films = films;
        this.created = created;
        this.edited = edited;
        this.url = url;
    }
}
