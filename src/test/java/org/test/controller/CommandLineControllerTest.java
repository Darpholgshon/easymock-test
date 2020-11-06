package org.test.controller;

import static org.easymock.EasyMock.anyString;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import com.google.common.collect.ImmutableList;
import java.io.PrintStream;
import java.util.List;
import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.test.service.DummyService;

@RunWith(EasyMockRunner.class)
public class CommandLineControllerTest {

  @TestSubject
  private final CommandLineController controller = new CommandLineController();

  @Mock
  private PrintStream out;

  @Mock
  private DummyService service;

  @Test
  public void testInvocation() {
    // Setup expectations on void print stream.
    out.println(anyString());
    EasyMock.expectLastCall().andVoid();

    // Setup expectations on service.
    expect(service.doSomething()).andReturn(ImmutableList.of("Hello", "Java"));

    // Switch the mocks into replay mode.
    replay(service, out);

    // Execute the method on the TestSubject
    List<String> result = controller.run();

    // Regular assertion that the correct response is made.
    Assert.assertThat(result, CoreMatchers.is(ImmutableList.of("Hello", "Java")));

    // Verify all the expectations on the various mocks were met.
    verify(service, out);
  }
}
