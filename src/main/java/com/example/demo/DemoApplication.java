package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oracle.truffle.js.runtime.JSContextOptions;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.HostAccess;

public class DemoApplication {

	public static void main(String... args) throws Exception {
		var context = Context.newBuilder("js")
				.allowHostAccess(HostAccess.ALL)
				.allowHostClassLookup(s -> true)
				.option(JSContextOptions.ECMASCRIPT_VERSION_NAME, "2022")
				.build();

		var bindings = context.getBindings("js");
		bindings.putMember("randomService", new RandomService());

		context.eval("js", Files.readString(Paths.get(System.getenv("PATH_TO_SCRIPT")), StandardCharsets.UTF_8));
		var scriptInstance = context.eval("js", "new Script()");
		var processMethod = scriptInstance.getMember("process");
		var payload = new ObjectMapper().writeValueAsString(new TestEvent("hello"));
		processMethod.execute(payload);
		System.exit(0);
	}

	static class TestEvent {
		String name;
		private List<String> randomUuids;

		public TestEvent(String name) {
			this.name = name;
			this.randomUuids = IntStream.range(0, 10).mapToObj(_i -> UUID.randomUUID().toString()).toList();
		}

		public TestEvent() {
		}

		public List<String> getRandomUuids() {
			return randomUuids;
		}

		public void setRandomUuids(List<String> randomUuids) {
			this.randomUuids = randomUuids;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

}
