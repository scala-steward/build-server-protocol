package ch.epfl.scala.bsp4j;

import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.lsp4j.jsonrpc.util.Preconditions;
import org.eclipse.lsp4j.jsonrpc.util.ToStringBuilder;
import org.eclipse.lsp4j.jsonrpc.validation.NonNull;

@SuppressWarnings("all")
public class CancelRequestParams {
  @NonNull private Either<String, Integer> id;

  public CancelRequestParams(@NonNull final Either<String, Integer> id) {
    this.id = id;
  }

  @NonNull
  public Either<String, Integer> getId() {
    return this.id;
  }

  public void setId(@NonNull final Either<String, Integer> id) {
    this.id = Preconditions.checkNotNull(id, "id");
  }

  public void setId(final String id) {
    if (id == null) {
      Preconditions.checkNotNull(id, "id");
      this.id = null;
      return;
    }
    this.id = Either.forLeft(id);
  }

  public void setId(final Integer id) {
    if (id == null) {
      Preconditions.checkNotNull(id, "id");
      this.id = null;
      return;
    }
    this.id = Either.forRight(id);
  }

  @Override
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("id", this.id);
    return b.toString();
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    CancelRequestParams other = (CancelRequestParams) obj;
    if (this.id == null) {
      if (other.id != null) return false;
    } else if (!this.id.equals(other.id)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    return 31 * 1 + ((this.id == null) ? 0 : this.id.hashCode());
  }
}
