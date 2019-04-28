/**
 * The tester class can be run in the following two ways:
 * 	Solution 01:
 * 		Right click the class and choose 'Run As' -> 'Junit Test'
 * 	Solution 02:
 *  	Run the test case by writing a new test runner class, which contain the a static main function
 *  	Please check on the demo class 'TestRunner.java'.
 */
package tk.mybatis.simple.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import tk.mybatis.simple.model.Country;

public class CountryMapperTest extends BaseMapperTest {
	
	@Test
	public void testSelectAll() {
		// Open the session
		SqlSession sqlSession = getSqlSession();
		
		try {
			// Here you must provide the Full Qualified Name of the mapper class
			List<Country> countryList = sqlSession.selectList("tk.mybatis.simple.mapper.CountryMapper.selectAll");
			printCountryList(countryList);
		} finally {
			// make sure the sql session is closed
			sqlSession.close();
		}
	}
	
	private void printCountryList(List<Country> countryList) {
		for(Country country: countryList) {
			System.out.printf("%-4d%4s%4s\n",
					country.getId(), country.getCountryname(), country.getCountrycode());
		}
	}
}
