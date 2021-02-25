package drinks;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@AllArgsConstructor
public class Alcohol
{
    private Long Id;
    private String name;
    private String land;
    private Integer strenght;
}
