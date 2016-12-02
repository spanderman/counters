package name.spanderman.counters.service.controller;

import static com.github.jsonj.tools.JsonBuilder.array;
import static com.github.jsonj.tools.JsonBuilder.field;
import static com.github.jsonj.tools.JsonBuilder.object;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountersController {

	private static final ConcurrentMap<String, AtomicLong> counters = new ConcurrentHashMap<>();

	@RequestMapping(path = "/counter/{counter}/increment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String increment(@PathVariable("counter") String counter) {
		// incrementing and returning
		return object(field(counter, counters.computeIfAbsent(counter, key -> new AtomicLong()).incrementAndGet()))
				.toString();
	}

	@RequestMapping(path = "/counter/{counter}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String get(@PathVariable("counter") String counter) {
		// creating and returning
		return object(field(counter, counters.computeIfAbsent(counter, key -> new AtomicLong()))).toString();
	}

	@RequestMapping(path = "/counter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getAll() {
		return array(counters).toString();
	}
}