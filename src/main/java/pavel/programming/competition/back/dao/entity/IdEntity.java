package pavel.programming.competition.back.dao.entity;

import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public abstract class IdEntity {
    public abstract Long getId();

    public abstract void setId(Long id);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdEntity idEntity = (IdEntity) o;
        return Objects.equals(getId(), idEntity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
