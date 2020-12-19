package ru.sberbank.itgod;

import lombok.extern.slf4j.Slf4j;
import ru.sberbank.itgod.bot.Bot;
import ru.sberbank.itgod.engine.GameEngine;
import ru.sberbank.itgod.websocket.WebSocket;
import ru.sberbank.itgod.engine.Options;

import java.net.URI;

@Slf4j
public class Program {
	public static void main(final String[] args) {
		
		String ip = "wss://gameapi.it-god.ru";
		String user = "adba7760-d300-4a6f-b01e-4a46e8057927";
		String bot = "6dea5ea6-2752-4abe-8da8-97dc3bf0b5f7";

		final Options options = new Options();
		options.parseCommandLine(args);
		log.info("Options received: ip: {}, user: {}, bot: {}, game: {}, system: {}",
				options.getIp(), options.getUser(), options.getBot(), options.getGame(), options.isSystem());

		if (options.isSystem())
		{
			ip = options.getIp();
			user = options.getUser();
			bot = options.getBot();
		}

		final String userId = user;
		final String botId = bot;

		final String wsServer = ip + "/game";
		final WebSocket webSocket = new WebSocket(URI.create(wsServer));

		final Thread thread = new Thread(() -> {
			try {
				GameEngine.start(new Bot(), userId, botId, options.getGame(), webSocket);
			} catch (final Exception e) {
				log.error(e.getMessage(), e);
			}
		});
		thread.start();
	}
}