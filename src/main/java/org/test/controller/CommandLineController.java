package org.test.controller;

import java.io.PrintStream;
import java.util.List;
import org.test.service.DummyService;

public class CommandLineController {
  private DummyService dummyService;

  private PrintStream out;

  public void setDummyService(DummyService dummyService) {
    this.dummyService = dummyService;
  }

  public void setOut(PrintStream out) {
    this.out = out;
  }

  public List<String> run() {
    out.println("Executing dummy service");
    return dummyService.doSomething();
  }
}
