package hellojpa;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "MBR", uniqueConstraints = {
    @UniqueConstraint(name = "unique_key_name", columnNames = {"name"})
})
public class Member {
    @Id
    private long id;

    private int age;

    @Enumerated(EnumType.STRING) //Enum Type 사용할 때, EnumType은 문제 사항 회피를 위해 String 사용
    private RoleType roleType;

    private String name;

    @Temporal(TemporalType.TIMESTAMP) // Date, Calendar 객체 매핑하기 위해 사용하며, LocalDate 등 사용 시에는 생략 가능
    private Date createdDate;

    private LocalDate localDate;
    private LocalDateTime localDateTime;
    private Timestamp timestamp;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    @Transient // DB 저장 X
    private int temp;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}