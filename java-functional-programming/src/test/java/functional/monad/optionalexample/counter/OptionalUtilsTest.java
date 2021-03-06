package functional.monad.optionalexample.counter;

import functional.monad.optionalexample.utils.OptionalUtils;
import org.junit.Test;

import java.util.Optional;
import java.util.function.BiFunction;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class OptionalUtilsTest {

    @Test
    public void testFlatMap2ComposeOptional() {


        Optional<Integer> val1 = Optional.of(5);
        Optional<Integer> val2 = Optional.of(7);

        Optional<Integer> result = addOptionals(val1, val2);
        assertTrue(result.isPresent());

        assertThat(result.get(), is(12));
    }

    @Test
    public void testFlatMap2ReturnsEmptyIfAnyEmpty() {
        Optional<Integer> val1 = Optional.of(5);
        Optional<Integer> val2 = Optional.empty();

        Optional<Integer> result = addOptionals(val1, val2);
        assertFalse(result.isPresent());
    }

    @Test
    public void testFlatMap2EmptyIfResultEmpty() {
        Optional<Integer> val1 = Optional.of(5);
        Optional<Integer> val2 = Optional.of(7);

        Optional<Integer> result = addOptionalReturnsEmtpy(val1, val2);
        assertFalse(result.isPresent());
    }

    private Optional<Integer> addOptionals(Optional<Integer> val1, Optional<Integer> val2) {
        BiFunction<Integer, Integer, Optional<Integer>> mapper = (a, b) -> Optional.of(a + b);
        return OptionalUtils.flatMap2(val1, val2, mapper);
    }

    private Optional<Integer> addOptionalReturnsEmtpy(Optional<Integer> val1, Optional<Integer> val2) {
        BiFunction<Integer, Integer, Optional<Integer>> mapper = (a, b) -> Optional.empty();
        return OptionalUtils.flatMap2(val1, val2, mapper);
    }

}

