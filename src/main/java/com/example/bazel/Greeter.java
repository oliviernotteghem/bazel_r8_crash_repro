package com.example.bazel;

import com.example.bazel.lib.InterfaceWithDefault.BoolParameter;

public class Greeter {
  public String sayHello() {
  	return "hello";
  }

  public class MyBooleanParameter implements BoolParameter {
  }
}

