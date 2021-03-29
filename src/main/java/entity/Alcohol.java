package entity;

import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Cache;

import javax.persistence.*;

@Entity
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@DynamicUpdate
@DynamicInsert
@ToString(of = {"name", "land", "strenght"})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "entity.Alcohol")
public class Alcohol
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NonNull
    private String name;

    @NonNull
    private String land;

    @NonNull
    private Integer strenght;

    public Alcohol(String name)
    {
        this.name = name;
    }
}
