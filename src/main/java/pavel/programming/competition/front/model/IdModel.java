package pavel.programming.competition.front.model;

import java.util.Objects;
import java.util.UUID;

public abstract class IdModel {
    private final UUID id;

    public IdModel(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdModel idModel = (IdModel) o;
        return Objects.equals(id, idModel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
