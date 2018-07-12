package enigma;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestEnigmaMachine {

   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(RotorTest.class);
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
      if (result.wasSuccessful()) {
          System.out.println("WOOO YOU FUCKING DID IT THE TESTS PASSED!");
      } else {
          System.out.println("Aww they didn't pass :(");
      }
   }


} 