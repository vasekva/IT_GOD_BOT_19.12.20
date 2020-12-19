package ru.sberbank.itgod.engine;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

@Slf4j
@Getter
@ToString
public final class Options {


    @Option(name = "-i", aliases = {"--ip"}, usage = "Set ip address of web socket server")
    private String ip;

    @Option(name = "-u", aliases = {"--user"}, usage = "Set user identifier")
    private String user;

    @Option(name = "-b", aliases = {"--bot"}, usage = "Set bot identifier")
    private String bot;

    @Option(name = "-g", aliases = {"--game"}, usage = "Set game identifier")
    private String game;

    @Option(name = "-s", aliases = {"--system"}, usage = "Set system mode")
    private boolean system;


    public void parseCommandLine(final String[] args) {
        final CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (final CmdLineException e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }
}