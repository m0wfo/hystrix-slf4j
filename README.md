# hystrix-slf4j

tl;dr- it's a Hystrix reporter for SLF4J loggers

## Logentries &#9829; Hystrix :)

Skim through [this post](https://blog.logentries.com/2015/12/analysing-hystrix-metrics-with-logentries/) if you're curious.

## Quick start

You'll need Maven and JDK 7+. `mvn clean package` will download everything and build a JAR for you. Assuming you're using a [dropwizard](http://www.dropwizard.io/0.9.1/docs/) app, dropping in the reporter is as simple as adding the dependency and this line to your `run()` method:

    environment.lifecycle().manage(new LogentriesReporter());

Actually, there's not much more to it than that!
