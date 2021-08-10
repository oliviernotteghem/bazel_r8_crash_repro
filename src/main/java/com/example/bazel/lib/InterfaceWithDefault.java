package com.example.bazel.lib;

public class InterfaceWithDefault {

  public interface AccessibleParameter<T>  {
     T getDefaultValue();
  }

  public interface BoolParameter extends AccessibleParameter<Boolean> {
    @Override
    default Boolean getDefaultValue() {
      return false;
    }
  }
}