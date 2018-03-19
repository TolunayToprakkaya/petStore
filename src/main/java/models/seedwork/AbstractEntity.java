package models.seedwork;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@MappedSuperclass
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@ToString(of = {"id"})
@EqualsAndHashCode(of = {"id"})
public class AbstractEntity implements Serializable {

    private static final long serialVersionUID = -6728904055822363204L;

    public static String DEFAULT_DELETED_VALUE = "0";

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "com.example.demo.domain.entities.util.UpperCaseUUIDGenerator")
    @Access(AccessType.PROPERTY)
    @Column(name = "ID")
    @Getter
    private String id;

    public void setId(String id)
    {
        this.id = id;
    }

}
