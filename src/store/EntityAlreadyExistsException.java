package store;

public class EntityAlreadyExistsException extends RuntimeException {

  public EntityAlreadyExistsException(String msg) {
    super(msg);
  }

}
