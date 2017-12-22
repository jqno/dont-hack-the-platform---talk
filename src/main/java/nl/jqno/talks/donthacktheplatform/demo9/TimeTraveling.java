package nl.jqno.talks.donthacktheplatform.demo9;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;

import static net.bytebuddy.implementation.FixedValue.value;
import static net.bytebuddy.matcher.ElementMatchers.named;

public class TimeTraveling {
    public static void main(String... args) throws Exception {
        int i = 0;
        while (true) {
            System.out.println(System.currentTimeMillis());
            Thread.sleep(1000);

            if (i == 2) {
                travelThroughTime();
            }
            i++;
        }
    }

    private static void travelThroughTime() {
        ByteBuddyAgent.install();
        new ByteBuddy()
                .redefine(System.class)
                .method(named("currentTimeMillis"))
                .intercept(value(-1))
                .make()
                .load(TimeTraveling.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());
    }
}
