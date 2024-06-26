package ch.epfl.scala.bsp4j;

import java.util.List;
import org.eclipse.lsp4j.jsonrpc.util.Preconditions;
import org.eclipse.lsp4j.jsonrpc.util.ToStringBuilder;
import org.eclipse.lsp4j.jsonrpc.validation.NonNull;

@SuppressWarnings("all")
public class ScalaTestSuiteSelection {
  @NonNull private String className;

  @NonNull private List<String> tests;

  public ScalaTestSuiteSelection(
      @NonNull final String className, @NonNull final List<String> tests) {
    this.className = className;
    this.tests = tests;
  }

  @NonNull
  public String getClassName() {
    return this.className;
  }

  public void setClassName(@NonNull final String className) {
    this.className = Preconditions.checkNotNull(className, "className");
  }

  @NonNull
  public List<String> getTests() {
    return this.tests;
  }

  public void setTests(@NonNull final List<String> tests) {
    this.tests = Preconditions.checkNotNull(tests, "tests");
  }

  @Override
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("className", this.className);
    b.add("tests", this.tests);
    return b.toString();
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    ScalaTestSuiteSelection other = (ScalaTestSuiteSelection) obj;
    if (this.className == null) {
      if (other.className != null) return false;
    } else if (!this.className.equals(other.className)) return false;
    if (this.tests == null) {
      if (other.tests != null) return false;
    } else if (!this.tests.equals(other.tests)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.className == null) ? 0 : this.className.hashCode());
    return prime * result + ((this.tests == null) ? 0 : this.tests.hashCode());
  }
}
