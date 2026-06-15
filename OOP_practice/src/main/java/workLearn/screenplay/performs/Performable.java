package workLearn.screenplay.performs;

import workLearn.screenplay.Actor;

import javax.annotation.Nonnull;

@FunctionalInterface
public interface Performable {

    void performAs(@Nonnull Actor actor);
}
