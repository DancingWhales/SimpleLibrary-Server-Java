package com.whale.library.basic.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.whale.library.forms.CustomerForm;


/**
 * TestBasicController.java
 *  기초 습득을 위한 컨트롤러
 * 
 * @version 1.0 / 2018. 7. 9.
 * @author miseong
 *
 */
@Controller
@RequestMapping(value = "/test")
public class TestBasicController {

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(TestBasicController.class);

	private static final String TEST_PAGE = "test/dataChange";
	
	private static final String PAGE_TYPE = "pageType";
	
	private static final String TEST_DATA_CHANGE_PATTERN = "/{dataType:.*}";

	private enum TestType {
	
		INSERT, LIST, UPDATE, DELETE;

		private static TestType getType(final String testType) {
			try {

				return TestType.valueOf(testType.toUpperCase());

			} catch (final Exception e) {
				return null;
			}

		}
	}



	/**
	 * dataChange
	 * -test 페이지 메인
	 *
	 * @param model
	 * @return TEST_PAGE
	 * @author miseong
	 */
	@RequestMapping (method = RequestMethod.GET)
	public String dataChange(final Model model) {

		model.addAttribute(PAGE_TYPE, TestType.LIST.name());
		model.addAttribute(new CustomerForm());
		return TEST_PAGE;
	}

	/**
	 * dataChange
	 * -데이터 조회, 등록, 수정, 삭제를 위한 페이지
	 *
	 * @param model
	 * @param dataType
	 * @return TEST_PAGE
	 * @author miseong
	 */
	@RequestMapping(value = TEST_DATA_CHANGE_PATTERN, method = RequestMethod.GET)
	public String dataChange(final Model model, @PathVariable("dataType") final String dataType) {

		TestType testType = TestType.getType(dataType);

		if (testType == null)
			testType = TestType.LIST;

		model.addAttribute(PAGE_TYPE, testType.name());
		model.addAttribute(new CustomerForm());

		return TEST_PAGE;
	}

	/**
	 * dataChange
	 * -데이터 조회, 등록, 수정, 삭제 페이지
	 *
	 * @param model
	 * @param pageType
	 * @param dataChangeForm
	 * @return TEST_PAGE
	 * @author miseong
	 */
	@RequestMapping(value = TEST_DATA_CHANGE_PATTERN, method = RequestMethod.POST)
	public String dataChange(final Model model, @PathVariable("dataType") final String pageType,
			final CustomerForm dataChangeForm) {

		TestType testType = TestType.getType(pageType);

		if (testType == null)
			testType = TestType.LIST;

		switch (testType) {
		case INSERT:
			model.addAttribute(PAGE_TYPE, TestType.UPDATE.name());
			break;
		case UPDATE:
			model.addAttribute(PAGE_TYPE, TestType.UPDATE.name());
			break;
		case DELETE:
			model.addAttribute(PAGE_TYPE, TestType.DELETE.name());
			break;
		case LIST:
			model.addAttribute(PAGE_TYPE, TestType.DELETE.name());
			break;
		}

		model.addAttribute(PAGE_TYPE, testType.name());

		return TEST_PAGE;
	}

}