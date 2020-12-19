package ru.sberbank.itgod.websocket;

import lombok.SneakyThrows;

import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.GZIPOutputStream;

public class MessageEncoder implements Encoder.Text<String> {
	private static final Base64.Encoder ENCODER = Base64.getEncoder();

	@SneakyThrows
	public String encode(final String message) {
		final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(message.length());
		final GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream);
		gzipOutputStream.write(message.getBytes());
		gzipOutputStream.close();
		final byte[] compressedMessage = byteArrayOutputStream.toByteArray();
		byteArrayOutputStream.close();

		final byte[] base64Bytes = ENCODER.encode(compressedMessage);
		return new String(base64Bytes, StandardCharsets.UTF_8);
	}

	public void init(final EndpointConfig endpointConfig) {
	}

	public void destroy() {
	}
}