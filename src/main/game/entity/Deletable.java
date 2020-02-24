package main.game.entity;

/**
 * Interface that allows Entities to be deleted.
 * @author Jeff
 */
public interface Deletable {
    /**
     * Checks if the Entity can be deleted.
     * @return if it can be deleted
     */
    boolean isDelete();
}
