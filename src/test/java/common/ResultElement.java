package common;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResultElement {
    public String name;

    @Getter
    @Setter(AccessLevel.PUBLIC)
    public int height;

    public int miss;

    public List<String> films;
}
