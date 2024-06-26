package ch.epfl.scala.bsp4j;

import org.eclipse.lsp4j.jsonrpc.util.Preconditions;
import org.eclipse.lsp4j.jsonrpc.util.ToStringBuilder;
import org.eclipse.lsp4j.jsonrpc.validation.NonNull;

@SuppressWarnings("all")
public class RunResult {
  private String originId;

  @NonNull private StatusCode statusCode;

  public RunResult(@NonNull final StatusCode statusCode) {
    this.statusCode = statusCode;
  }

  public String getOriginId() {
    return this.originId;
  }

  public void setOriginId(final String originId) {
    this.originId = originId;
  }

  @NonNull
  public StatusCode getStatusCode() {
    return this.statusCode;
  }

  public void setStatusCode(@NonNull final StatusCode statusCode) {
    this.statusCode = Preconditions.checkNotNull(statusCode, "statusCode");
  }

  @Override
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("originId", this.originId);
    b.add("statusCode", this.statusCode);
    return b.toString();
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    RunResult other = (RunResult) obj;
    if (this.originId == null) {
      if (other.originId != null) return false;
    } else if (!this.originId.equals(other.originId)) return false;
    if (this.statusCode == null) {
      if (other.statusCode != null) return false;
    } else if (!this.statusCode.equals(other.statusCode)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.originId == null) ? 0 : this.originId.hashCode());
    return prime * result + ((this.statusCode == null) ? 0 : this.statusCode.hashCode());
  }
}
