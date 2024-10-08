package ch.epfl.scala.bsp4j;

import com.google.gson.annotations.JsonAdapter;
import org.eclipse.lsp4j.jsonrpc.json.adapters.JsonElementTypeAdapter;
import org.eclipse.lsp4j.jsonrpc.util.Preconditions;
import org.eclipse.lsp4j.jsonrpc.util.ToStringBuilder;
import org.eclipse.lsp4j.jsonrpc.validation.NonNull;

@SuppressWarnings("all")
public class SourceItem {
  @NonNull private String uri;

  @NonNull private SourceItemKind kind;

  @NonNull private Boolean generated;

  private String dataKind;

  @JsonAdapter(JsonElementTypeAdapter.Factory.class)
  private Object data;

  public SourceItem(
      @NonNull final String uri,
      @NonNull final SourceItemKind kind,
      @NonNull final Boolean generated) {
    this.uri = uri;
    this.kind = kind;
    this.generated = generated;
  }

  @NonNull
  public String getUri() {
    return this.uri;
  }

  public void setUri(@NonNull final String uri) {
    this.uri = Preconditions.checkNotNull(uri, "uri");
  }

  @NonNull
  public SourceItemKind getKind() {
    return this.kind;
  }

  public void setKind(@NonNull final SourceItemKind kind) {
    this.kind = Preconditions.checkNotNull(kind, "kind");
  }

  @NonNull
  public Boolean getGenerated() {
    return this.generated;
  }

  public void setGenerated(@NonNull final Boolean generated) {
    this.generated = Preconditions.checkNotNull(generated, "generated");
  }

  public String getDataKind() {
    return this.dataKind;
  }

  public void setDataKind(final String dataKind) {
    this.dataKind = dataKind;
  }

  public Object getData() {
    return this.data;
  }

  public void setData(final Object data) {
    this.data = data;
  }

  @Override
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("uri", this.uri);
    b.add("kind", this.kind);
    b.add("generated", this.generated);
    b.add("dataKind", this.dataKind);
    b.add("data", this.data);
    return b.toString();
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    SourceItem other = (SourceItem) obj;
    if (this.uri == null) {
      if (other.uri != null) return false;
    } else if (!this.uri.equals(other.uri)) return false;
    if (this.kind == null) {
      if (other.kind != null) return false;
    } else if (!this.kind.equals(other.kind)) return false;
    if (this.generated == null) {
      if (other.generated != null) return false;
    } else if (!this.generated.equals(other.generated)) return false;
    if (this.dataKind == null) {
      if (other.dataKind != null) return false;
    } else if (!this.dataKind.equals(other.dataKind)) return false;
    if (this.data == null) {
      if (other.data != null) return false;
    } else if (!this.data.equals(other.data)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.uri == null) ? 0 : this.uri.hashCode());
    result = prime * result + ((this.kind == null) ? 0 : this.kind.hashCode());
    result = prime * result + ((this.generated == null) ? 0 : this.generated.hashCode());
    result = prime * result + ((this.dataKind == null) ? 0 : this.dataKind.hashCode());
    return prime * result + ((this.data == null) ? 0 : this.data.hashCode());
  }
}
