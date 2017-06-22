package org.jbehave.core.junit.guice;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;

import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.configuration.guice.GuiceAnnotationBuilder;
import org.jbehave.core.junit.AnnotatedEmbedderRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.model.InitializationError;

public class GuiceAnnotatedEmbedderRunnerBehaviour {

    @Test
    public void shouldCreateWithGuiceAnnotatedBuilder() throws InitializationError{
        AnnotatedEmbedderRunner runner = new GuiceAnnotatedEmbedderRunner(RunningWithAnnotatedEmbedderRunner.class);
        assertThat(runner.annotationBuilder(), instanceOf(GuiceAnnotationBuilder.class));
    }

    @RunWith(GuiceAnnotatedEmbedderRunner.class)
    @Configure()
    @UsingEmbedder()
    public static class RunningWithAnnotatedEmbedderRunner extends InjectableEmbedder {

        static boolean hasRun;

        @Override
        @Test
        public void run() {
            hasRun = true;
        }
    }
}
