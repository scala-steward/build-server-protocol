package ch.epfl.scala.bsp4j;

import org.eclipse.lsp4j.jsonrpc.util.Preconditions;
import org.eclipse.lsp4j.jsonrpc.util.ToStringBuilder;
import org.eclipse.lsp4j.jsonrpc.validation.NonNull;

/**
 * A Scala action represents a change that can be performed in code. See also [LSP: Code Action
 * Request](https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#textDocument_codeAction).
 *
 * <p>**Note**: In LSP, `CodeAction` appears only as a response to a `textDocument/codeAction`
 * request, whereas ScalaAction is intended to be returned as `Diagnostics.data.actions`.
 */
@SuppressWarnings("all")
public class ScalaAction {
  @NonNull private String title;

  private String description;

  private ScalaWorkspaceEdit edit;

  public ScalaAction(@NonNull final String title) {
    this.title = title;
  }

  @NonNull
  public String getTitle() {
    return this.title;
  }

  public void setTitle(@NonNull final String title) {
    this.title = Preconditions.checkNotNull(title, "title");
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  public ScalaWorkspaceEdit getEdit() {
    return this.edit;
  }

  public void setEdit(final ScalaWorkspaceEdit edit) {
    this.edit = edit;
  }

  @Override
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("title", this.title);
    b.add("description", this.description);
    b.add("edit", this.edit);
    return b.toString();
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    ScalaAction other = (ScalaAction) obj;
    if (this.title == null) {
      if (other.title != null) return false;
    } else if (!this.title.equals(other.title)) return false;
    if (this.description == null) {
      if (other.description != null) return false;
    } else if (!this.description.equals(other.description)) return false;
    if (this.edit == null) {
      if (other.edit != null) return false;
    } else if (!this.edit.equals(other.edit)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.title == null) ? 0 : this.title.hashCode());
    result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
    return prime * result + ((this.edit == null) ? 0 : this.edit.hashCode());
  }
}
