package ch.epfl.scala.bsp4j;

import org.eclipse.lsp4j.jsonrpc.util.Preconditions;
import org.eclipse.lsp4j.jsonrpc.util.ToStringBuilder;
import org.eclipse.lsp4j.jsonrpc.validation.NonNull;

@SuppressWarnings("all")
public class Position {
  @NonNull private Integer line;

  @NonNull private Integer character;

  public Position(@NonNull final Integer line, @NonNull final Integer character) {
    this.line = line;
    this.character = character;
  }

  @NonNull
  public Integer getLine() {
    return this.line;
  }

  public void setLine(@NonNull final Integer line) {
    this.line = Preconditions.checkNotNull(line, "line");
  }

  @NonNull
  public Integer getCharacter() {
    return this.character;
  }

  public void setCharacter(@NonNull final Integer character) {
    this.character = Preconditions.checkNotNull(character, "character");
  }

  @Override
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("line", this.line);
    b.add("character", this.character);
    return b.toString();
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Position other = (Position) obj;
    if (this.line == null) {
      if (other.line != null) return false;
    } else if (!this.line.equals(other.line)) return false;
    if (this.character == null) {
      if (other.character != null) return false;
    } else if (!this.character.equals(other.character)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.line == null) ? 0 : this.line.hashCode());
    return prime * result + ((this.character == null) ? 0 : this.character.hashCode());
  }
}
