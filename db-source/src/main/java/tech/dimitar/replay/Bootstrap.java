package tech.dimitar.replay;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {
    private final Replayer replayer;

    @Override
    public void run(String... args) throws Exception {
        log.info("***************************************************************");
        log.info("Replaying the axon store events...");
        replayer.replay("tech.dimitar.other.services");
    }
}
