package ch.epfl.scala.bsp4j;

import java.util.List;
import org.eclipse.lsp4j.jsonrpc.util.Preconditions;
import org.eclipse.lsp4j.jsonrpc.util.ToStringBuilder;
import org.eclipse.lsp4j.jsonrpc.validation.NonNull;

@SuppressWarnings("all")
public class ScalacOptionsResult {
  @NonNull private List<ScalacOptionsItem> items;

  public ScalacOptionsResult(@NonNull final List<ScalacOptionsItem> items) {
    this.items = items;
  }

  @NonNull
  public List<ScalacOptionsItem> getItems() {
    return this.items;
  }

  public void setItems(@NonNull final List<ScalacOptionsItem> items) {
    this.items = Preconditions.checkNotNull(items, "items");
  }

  @Override
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("items", this.items);
    return b.toString();
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    ScalacOptionsResult other = (ScalacOptionsResult) obj;
    if (this.items == null) {
      if (other.items != null) return false;
    } else if (!this.items.equals(other.items)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    return 31 * 1 + ((this.items == null) ? 0 : this.items.hashCode());
  }
}
