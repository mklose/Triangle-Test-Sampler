package org.jnario.triangletests;

import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.hamcrest.StringDescription;
import org.jnario.lib.JnarioIterableExtensions;
import org.jnario.lib.Should;
import org.jnario.lib.StepArguments;
import org.jnario.runner.FeatureRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.jnario.triangletests.TriangleTestsRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(FeatureRunner.class)
@Named("Scenario: Draws scalene triangle")
@SuppressWarnings("all")
public class TrainglePageFeatureDrawsScaleneTriangle {
  @Test
  @Order(0)
  @Named("When  I enter \"4\", \"5\", \"6\" as side lengths")
  public void whenIEnter456AsSideLengths() {
    try {
        StepArguments _stepArguments = new StepArguments("4", "5", "6");
        final StepArguments args = _stepArguments;
        StepArguments _args = args;
        String _first = JnarioIterableExtensions.<String>first(_args);
        StepArguments _args_1 = args;
        String _second = JnarioIterableExtensions.<String>second(_args_1);
        StepArguments _args_2 = args;
        String _third = JnarioIterableExtensions.<String>third(_args_2);
        context.trianglePage.enterSideLengths(_first, _second, _third);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Order(1)
  @Named("Then triangle displays \"Scalene\" as the triangle type")
  public void thenTriangleDisplaysScaleneAsTheTriangleType() {
      StepArguments _stepArguments = new StepArguments("Scalene");
      final StepArguments args = _stepArguments;
      String _triangleType = context.trianglePage.triangleType();
      StepArguments _args = args;
      String _first = JnarioIterableExtensions.<String>first(_args);
      boolean _doubleArrow = Should.operator_doubleArrow(_triangleType, _first);
      Assert.assertTrue("\nExpected  but"
       + "\n      is " + new StringDescription().appendValue(_triangleType).toString() + "\n", _doubleArrow);
      
  }
  
  @Test
  @Order(2)
  @Named("And draws the triangle inside the canvas")
  public void andDrawsTheTriangleInsideTheCanvas() {
    boolean _coordinatesAreValid = context.trianglePage.coordinatesAreValid();
    boolean _doubleArrow = Should.operator_doubleArrow(Boolean.valueOf(_coordinatesAreValid), Boolean.valueOf(true));
    Assert.assertTrue("\nExpected  but"
     + "\n      is " + new StringDescription().appendValue(Boolean.valueOf(_coordinatesAreValid)).toString() + "\n", _doubleArrow);
    
  }
  
  @Rule
  public TriangleTestsRule context = new Function0<TriangleTestsRule>() {
    public TriangleTestsRule apply() {
      TriangleTestsRule _triangleTestsRule = new TriangleTestsRule();
      return _triangleTestsRule;
    }
  }.apply();
}
