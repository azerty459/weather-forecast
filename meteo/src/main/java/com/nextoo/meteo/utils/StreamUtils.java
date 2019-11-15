package com.nextoo.meteo.utils;

import java.util.Map;
import java.util.stream.Stream;

public class StreamUtils {

	public static <K, V> Stream<KeyPair<K, V>> stream(Map<K, V> map) {
		return map.keySet().stream().map(k -> new KeyPair<>(k, map.get(k)));
	}

}
