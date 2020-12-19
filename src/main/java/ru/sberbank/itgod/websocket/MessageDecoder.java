package ru.sberbank.itgod.websocket;

import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;

import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.GZIPInputStream;

public class MessageDecoder implements Decoder.Text<String> {
	private static final Base64.Decoder DECODER = Base64.getDecoder();

	@SneakyThrows
	public String decode(final String message) {
		final byte[] base64DecodedBytes = DECODER.decode(message);

		final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(base64DecodedBytes);
		final GZIPInputStream gzipInputStream = new GZIPInputStream(byteArrayInputStream);
		final byte[] decompressedBytes = IOUtils.toByteArray(gzipInputStream);

		gzipInputStream.close();
		byteArrayInputStream.close();
		return new String(decompressedBytes, StandardCharsets.UTF_8);
	}

	public boolean willDecode(final String s) {
		return false;
	}

	public void init(final EndpointConfig endpointConfig) {
	}

	public void destroy() {
	}
}


