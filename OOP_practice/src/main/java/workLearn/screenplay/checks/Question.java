package workLearn.screenplay.checks;

import workLearn.screenplay.Actor;

import javax.annotation.Nonnull;

@FunctionalInterface
public interface Question<T> {

    T answeredBy(@Nonnull Actor actor);
}
