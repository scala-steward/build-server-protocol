package ch.epfl.scala.bsp4j;

import org.eclipse.lsp4j.jsonrpc.util.Preconditions;
import org.eclipse.lsp4j.jsonrpc.util.ToStringBuilder;
import org.eclipse.lsp4j.jsonrpc.validation.NonNull;

/**
 * The completion of a compilation task should be signalled with a `build/taskFinish` notification.
 * When the compilation unit is a build target, the notification's `dataKind` field must be
 * `compile-report` and the `data` field must include a `CompileReport` object:
 */
@SuppressWarnings("all")
public class CompileReport {
  @NonNull private BuildTargetIdentifier target;

  private String originId;

  @NonNull private Integer errors;

  @NonNull private Integer warnings;

  private Long time;

  private Boolean noOp;

  public CompileReport(
      @NonNull final BuildTargetIdentifier target,
      @NonNull final Integer errors,
      @NonNull final Integer warnings) {
    this.target = target;
    this.errors = errors;
    this.warnings = warnings;
  }

  @NonNull
  public BuildTargetIdentifier getTarget() {
    return this.target;
  }

  public void setTarget(@NonNull final BuildTargetIdentifier target) {
    this.target = Preconditions.checkNotNull(target, "target");
  }

  public String getOriginId() {
    return this.originId;
  }

  public void setOriginId(final String originId) {
    this.originId = originId;
  }

  @NonNull
  public Integer getErrors() {
    return this.errors;
  }

  public void setErrors(@NonNull final Integer errors) {
    this.errors = Preconditions.checkNotNull(errors, "errors");
  }

  @NonNull
  public Integer getWarnings() {
    return this.warnings;
  }

  public void setWarnings(@NonNull final Integer warnings) {
    this.warnings = Preconditions.checkNotNull(warnings, "warnings");
  }

  public Long getTime() {
    return this.time;
  }

  public void setTime(final Long time) {
    this.time = time;
  }

  public Boolean getNoOp() {
    return this.noOp;
  }

  public void setNoOp(final Boolean noOp) {
    this.noOp = noOp;
  }

  @Override
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("target", this.target);
    b.add("originId", this.originId);
    b.add("errors", this.errors);
    b.add("warnings", this.warnings);
    b.add("time", this.time);
    b.add("noOp", this.noOp);
    return b.toString();
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    CompileReport other = (CompileReport) obj;
    if (this.target == null) {
      if (other.target != null) return false;
    } else if (!this.target.equals(other.target)) return false;
    if (this.originId == null) {
      if (other.originId != null) return false;
    } else if (!this.originId.equals(other.originId)) return false;
    if (this.errors == null) {
      if (other.errors != null) return false;
    } else if (!this.errors.equals(other.errors)) return false;
    if (this.warnings == null) {
      if (other.warnings != null) return false;
    } else if (!this.warnings.equals(other.warnings)) return false;
    if (this.time == null) {
      if (other.time != null) return false;
    } else if (!this.time.equals(other.time)) return false;
    if (this.noOp == null) {
      if (other.noOp != null) return false;
    } else if (!this.noOp.equals(other.noOp)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.target == null) ? 0 : this.target.hashCode());
    result = prime * result + ((this.originId == null) ? 0 : this.originId.hashCode());
    result = prime * result + ((this.errors == null) ? 0 : this.errors.hashCode());
    result = prime * result + ((this.warnings == null) ? 0 : this.warnings.hashCode());
    result = prime * result + ((this.time == null) ? 0 : this.time.hashCode());
    return prime * result + ((this.noOp == null) ? 0 : this.noOp.hashCode());
  }
}
