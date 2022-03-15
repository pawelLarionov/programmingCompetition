package pavel.programming.competition.front.model;

import java.util.Objects;
import java.util.UUID;

public abstract class GlobalIdModel {
    private final UUID globalId;

    public GlobalIdModel(UUID globalId) {
        this.globalId = globalId;
    }

    public UUID getGlobalId() {
        return globalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GlobalIdModel that = (GlobalIdModel) o;
        return Objects.equals(globalId, that.globalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(globalId);
    }
}
