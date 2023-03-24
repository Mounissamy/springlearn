package com.learn.filtering.controller;


import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.learn.controller.model.FilterBean;

@RestController
public class FilteringController {

	public FilteringController() {
		// TODO Auto-generated constructor stub
	}
	/* Static filter example
	 */
	@GetMapping(path ="/filter")
	public FilterBean dofilter()
	{ 
		return new FilterBean("field1","field2","fiedl3");
	}
	@GetMapping(path ="/filter-list")
	public List<FilterBean> dofilterList()
	{ 
		return  Arrays.asList( new FilterBean("field11","field12","fiedl13"),
				new FilterBean("field21","field22","fied23"),
				new FilterBean("field31","field32","fied33"));
	}
	
	/* Dynamic filter example
	 */
	@GetMapping(path ="/dynafilter")
	public MappingJacksonValue dynafilter()
	{ 
		FilterBean filterBean = new FilterBean("field1","field2","fiedl3");
		MappingJacksonValue mjv = new MappingJacksonValue(filterBean);
		SimpleBeanPropertyFilter sbpf =  SimpleBeanPropertyFilter.filterOutAllExcept("field1");
		FilterProvider fp = new SimpleFilterProvider().addFilter("myDynamicFilter", sbpf);  
		// this myDynamicFilter should match in the FilterBean annotation
		mjv.setFilters(fp);
		return mjv ;
	}
	
	@GetMapping(path ="/dynafilter-list")
	public MappingJacksonValue dynamicFilterList()
	{ 
		List<FilterBean> filterBeans =  Arrays.asList( new FilterBean("field11","field12","fiedl13"),new FilterBean("field21","field22","fied23"),
				new FilterBean("field31","field32","fied33"));
		MappingJacksonValue mjv = new MappingJacksonValue(filterBeans);
		SimpleBeanPropertyFilter sbpf =  SimpleBeanPropertyFilter.filterOutAllExcept("field2");
		FilterProvider fp = new SimpleFilterProvider().addFilter("myDynamicFilter", sbpf);  
		// this myDynamicFilter should match in the FilterBean annotation
		mjv.setFilters(fp);
		return mjv ;
	}
	
}
