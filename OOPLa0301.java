// Use a custom exception. 
 
// Create an exception. 
class NonIntResultException extends Exception { 
  int n; 
  int d; 
 
  NonIntResultException(int i, int j) { 
    n = i; 
    d = j; 
  } 
 
  public String toString() { 
    return "Result of " + n + " / " + d + " is non-integer."; 
  } 
} 
 
class NotInRangeException extends Exception {
  int numer, denom;

  NotInRangeException(int numer, int denom) {
    this.numer = numer;
    this.denom = denom;
  }

  public String toString() {
    return "Result of " + numer + " / " + denom + " is not in the [LOWERBOUND, UPPERBOUND] interval.";
  }
}

class ArrayUtils {
  protected static int getBound(int[] arr, boolean isMax) {
    int box = arr[0];

    for (int i = 1; i < arr.length; i++) {
      if ((isMax && arr[i] > box) || (!isMax && arr[i] < box)) {
        box = arr[i];
      }
    }

    return box;
  }
}

class CustomExceptDemo { 
  public static void main(String args[]) { 
 
    // Here, numer contains some odd values. 
    int numer[] = { 4, 8, 15, 32, 64, 127, 256, 512 }; 
    int denom[] = { 2, 0, 4, 4, 0, 8 };

    // Lower and upper bounds are not described in the task description
    // Assuming them to be min and max elements of the numer array
    // Due to google search on Java upper and lower bounds to produce this
    // https://en.wikipedia.org/wiki/Upper_and_lower_bounds 
    final int lowerBound = ArrayUtils.getBound(numer, true);
    final int upperBound = ArrayUtils.getBound(numer, false);

    for (int i=0; i<numer.length; i++) { 
      try { 
        if ((numer[i] % 2) != 0) {
          throw new NonIntResultException(numer[i], denom[i]); 
        }

        final int divisionResult = numer[i] / denom[i];

        if (divisionResult < upperBound || divisionResult > lowerBound) {
          throw new NotInRangeException(numer[i], denom[i]);
        }
 
        System.out.println(
          numer[i] + " / " + 
          denom[i] + " is " + 
          divisionResult
        ); 
      } 
      catch (ArithmeticException exc) { 
        // catch the exception 
        System.out.println("Can't divide by Zero!"); 
      } 
      catch (ArrayIndexOutOfBoundsException exc) { 
        // catch the exception 
        System.out.println("No matching element found."); 
      } 
      catch (NonIntResultException exc) { 
        System.out.println(exc); 
      }
      catch (NotInRangeException exc) {
        System.out.println(exc);
      }
    } 
  } 
}