package ph.mramos.ocjsfd.component;

import java.time.Month;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class Dates {

	private Map<String, Integer> months;
	private Integer[] days;
	private Integer[] years;

	public Dates() {
		months = Stream.of(Month.values()).collect(Collectors.toMap(Month::toString, Month::getValue, (x, y) -> x, LinkedHashMap::new));
		days = IntStream.rangeClosed(1, 31).boxed().collect(Collectors.toList()).toArray(new Integer[31]);
		years = IntStream.rangeClosed(2017, 2026).boxed().collect(Collectors.toList()).toArray(new Integer[10]);
	}

	public Map<String, Integer> getMonths() {
		return months;
	}

	public Integer[] getDays() {
		return days;
	}

	public Integer[] getYears() {
		return years;
	}

}
