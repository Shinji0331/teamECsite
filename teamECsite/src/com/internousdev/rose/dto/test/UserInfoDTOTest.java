package com.internousdev.rose.dto.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.internousdev.rose.dto.UserInfoDTO;

public class UserInfoDTOTest {

	// get Id test
	@Test
	public void testGetId1() {
		UserInfoDTO dto = new UserInfoDTO();
		int expected = 0;

		dto.setId(expected);
		int actual = dto.getId();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetId2() {
		UserInfoDTO dto = new UserInfoDTO();
		int expected = 9999999;

		dto.setId(expected);
		int actual = dto.getId();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetId3() {
		UserInfoDTO dto = new UserInfoDTO();
		int expected = -9999999;

		dto.setId(expected);
		int actual = dto.getId();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetId4() throws Exception{
		UserInfoDTO dto = new UserInfoDTO();
		try {
			int postalMax = 10000000;
			dto.setId(postalMax);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(),"For input string: \"10000000.00\"");
		}
	}
	@Test
	public void testGetId5() throws Exception{
		UserInfoDTO dto = new UserInfoDTO();
		try {
			int postalMax = -10000000;
			dto.setId(postalMax);
		}catch(RuntimeException e) {
			assertEquals(e.getMessage(),"For input string: \"-10000000.00\"");
		}
	}

	// set Id test
	@Test
	public void testSetId() {
		UserInfoDTO dto = new UserInfoDTO();
		int expected = 0;

		dto.setId(expected);
		int actual = dto.getId();
		assertEquals(expected,actual);
	}

	@Test
	public void testSetId2() {
		UserInfoDTO dto = new UserInfoDTO();
		int expected = 9999999;

		dto.setId(expected);
		int actual = dto.getId();
		assertEquals(expected,actual);
	}

	@Test
	public void testSetId3() {
		UserInfoDTO dto = new UserInfoDTO();
		int expected = -9999999;

		dto.setId(expected);
		int actual = dto.getId();
		assertEquals(expected,actual);
	}

	@Test
	public void testSetId4() throws Exception{
		UserInfoDTO dto = new UserInfoDTO();
		try {
			int postalMax = -10000000;
			dto.setId(postalMax);
		}catch(RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"10000000.00\"");
		}
	}

	@Test
	public void testSetId5() throws Exception{
		UserInfoDTO dto = new UserInfoDTO();
		try {
			int postalMax = -10000000;
			dto.setId(postalMax);
		}catch(RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"-10000000.00\"");
		}
	}

	// get LoginId test
	@Test
	public void testGetLoginId1() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "0";

		dto.setLoginId(expected);
		String actual = dto.getLoginId();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetLoginId2() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "2147483647";

		dto.setLoginId(expected);
		String actual = dto.getLoginId();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetLoginId3() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "-2147483647";

		dto.setLoginId(expected);
		String actual = dto.getLoginId();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetLoginId4() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "null";

		dto.setLoginId(expected);
		String actual = dto.getLoginId();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetLoginId5() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "";

		dto.setLoginId(expected);
		String actual = dto.getLoginId();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetLoginId6() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = " ";

		dto.setLoginId(expected);
		String actual = dto.getLoginId();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetLoginId7() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "　";

		dto.setLoginId(expected);
		String actual = dto.getLoginId();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetLoginId8() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123";

		dto.setLoginId(expected);
		String actual = dto.getLoginId();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetLoginId9() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "あいう１２３";

		dto.setLoginId(expected);
		String actual = dto.getLoginId();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetLoginId10() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setLoginId(expected);
		String actual = dto.getLoginId();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetLoginId11() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setLoginId(expected);
		String actual = dto.getLoginId();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetLoginId12() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "ａｂｃあいう１２３漢字";

		dto.setLoginId(expected);
		String actual = dto.getLoginId();
		assertEquals(expected,actual);
	}

	// set LoginId test
	@Test
	public void testSetLoginId1() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "0";

		dto.setLoginId(expected);
		String actual = dto.getLoginId();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetLoginId2() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "2147483647";

		dto.setLoginId(expected);
		String actual = dto.getLoginId();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetLoginId3() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "-2147483647";

		dto.setLoginId(expected);
		String actual = dto.getLoginId();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetLoginId4() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "null";

		dto.setLoginId(expected);
		String actual = dto.getLoginId();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetLoginId5() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "";

		dto.setLoginId(expected);
		String actual = dto.getLoginId();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetLoginId6() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = " ";

		dto.setLoginId(expected);
		String actual = dto.getLoginId();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetLoginId7() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "　";

		dto.setLoginId(expected);
		String actual = dto.getLoginId();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetLoginId8() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123";

		dto.setLoginId(expected);
		String actual = dto.getLoginId();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetLoginId9() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "あいう１２３";

		dto.setLoginId(expected);
		String actual = dto.getLoginId();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetLoginId10() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setLoginId(expected);
		String actual = dto.getLoginId();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetLoginId11() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setLoginId(expected);
		String actual = dto.getLoginId();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetLoginId12() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "ａｂｃあいう１２３漢字";

		dto.setLoginId(expected);
		String actual = dto.getLoginId();
		assertEquals(expected,actual);
	}

	// get Password test
	@Test
	public void testGetPassword1() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "0";

		dto.setPassword(expected);
		String actual = dto.getPassword();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetPassword2() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "2147483647";

		dto.setPassword(expected);
		String actual = dto.getPassword();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetPassword3() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "-2147483647";

		dto.setPassword(expected);
		String actual = dto.getPassword();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetPassword4() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "null";

		dto.setPassword(expected);
		String actual = dto.getPassword();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetPassword5() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "";

		dto.setPassword(expected);
		String actual = dto.getPassword();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetPassword6() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = " ";

		dto.setPassword(expected);
		String actual = dto.getPassword();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetPassword7() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "　";

		dto.setPassword(expected);
		String actual = dto.getPassword();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetPassword8() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123";

		dto.setPassword(expected);
		String actual = dto.getPassword();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetPassword9() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "あいう１２３";

		dto.setPassword(expected);
		String actual = dto.getPassword();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetPassword10() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setPassword(expected);
		String actual = dto.getPassword();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetPassword11() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setPassword(expected);
		String actual = dto.getPassword();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetPassword12() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "ａｂｃあいう１２３漢字";

		dto.setPassword(expected);
		String actual = dto.getPassword();
		assertEquals(expected,actual);
	}

	// set Password test
	@Test
	public void testSetPassword1() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "0";

		dto.setPassword(expected);
		String actual = dto.getPassword();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetPassword2() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "2147483647";

		dto.setPassword(expected);
		String actual = dto.getPassword();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetPassword3() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "-2147483647";

		dto.setPassword(expected);
		String actual = dto.getPassword();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetPassword4() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "null";

		dto.setPassword(expected);
		String actual = dto.getPassword();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetPassword5() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "";

		dto.setPassword(expected);
		String actual = dto.getPassword();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetPassword6() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = " ";

		dto.setPassword(expected);
		String actual = dto.getPassword();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetPassword7() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "　";

		dto.setPassword(expected);
		String actual = dto.getPassword();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetPassword8() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123";

		dto.setPassword(expected);
		String actual = dto.getPassword();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetPassword9() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "あいう１２３";

		dto.setPassword(expected);
		String actual = dto.getPassword();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetPassword10() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setPassword(expected);
		String actual = dto.getPassword();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetPassword11() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setPassword(expected);
		String actual = dto.getPassword();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetPassword12() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "ａｂｃあいう１２３漢字";

		dto.setPassword(expected);
		String actual = dto.getPassword();
		assertEquals(expected,actual);
	}

	// get FamilyName test
	@Test
	public void testGetFamilyName1() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "0";

		dto.setFamilyName(expected);
		String actual = dto.getFamilyName();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFamilyName2() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "2147483647";

		dto.setFamilyName(expected);
		String actual = dto.getFamilyName();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFamilyName3() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "-2147483647";

		dto.setFamilyName(expected);
		String actual = dto.getFamilyName();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFamilyName4() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "null";

		dto.setFamilyName(expected);
		String actual = dto.getFamilyName();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFamilyName5() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "";

		dto.setFamilyName(expected);
		String actual = dto.getFamilyName();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFamilyName6() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = " ";

		dto.setFamilyName(expected);
		String actual = dto.getFamilyName();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFamilyName7() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "　";

		dto.setFamilyName(expected);
		String actual = dto.getFamilyName();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFamilyName8() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123";

		dto.setFamilyName(expected);
		String actual = dto.getFamilyName();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFamilyName9() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "あいう１２３";

		dto.setFamilyName(expected);
		String actual = dto.getFamilyName();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFamilyName10() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setFamilyName(expected);
		String actual = dto.getFamilyName();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFamilyName11() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setFamilyName(expected);
		String actual = dto.getFamilyName();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFamilyName12() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "ａｂｃあいう１２３漢字";

		dto.setFamilyName(expected);
		String actual = dto.getFamilyName();
		assertEquals(expected,actual);
	}

	// set FamilyName test
	@Test
	public void testSetFamilyName1() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "0";

		dto.setFamilyName(expected);
		String actual = dto.getFamilyName();
		assertEquals(expected,actual);
	}
	public void testSetFamilyName2() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "2147483647";

		dto.setFamilyName(expected);
		String actual = dto.getFamilyName();
		assertEquals(expected,actual);
	}
	public void testSetFamilyName3() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "-2147483647";

		dto.setFamilyName(expected);
		String actual = dto.getFamilyName();
		assertEquals(expected,actual);
	}
	public void testSetFamilyName4() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "null";

		dto.setFamilyName(expected);
		String actual = dto.getFamilyName();
		assertEquals(expected,actual);
	}
	public void testSetFamilyName5() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "";

		dto.setFamilyName(expected);
		String actual = dto.getFamilyName();
		assertEquals(expected,actual);
	}
	public void testSetFamilyName6() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = " ";

		dto.setFamilyName(expected);
		String actual = dto.getFamilyName();
		assertEquals(expected,actual);
	}
	public void testSetFamilyName7() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "　";

		dto.setFamilyName(expected);
		String actual = dto.getFamilyName();
		assertEquals(expected,actual);
	}
	public void testSetFamilyName8() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123";

		dto.setFamilyName(expected);
		String actual = dto.getFamilyName();
		assertEquals(expected,actual);
	}
	public void testSetFamilyName9() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "";

		dto.setFamilyName(expected);
		String actual = dto.getFamilyName();
		assertEquals(expected,actual);
	}
	public void testSetFamilyName10() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "あいう１２３";

		dto.setFamilyName(expected);
		String actual = dto.getFamilyName();
		assertEquals(expected,actual);
	}
	public void testSetFamilyName11() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setFamilyName(expected);
		String actual = dto.getFamilyName();
		assertEquals(expected,actual);
	}
	public void testSetFamilyName12() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setFamilyName(expected);
		String actual = dto.getFamilyName();
		assertEquals(expected,actual);
	}

	// get FirstName test
	@Test
	public void testGetFirstName1() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "0";

		dto.setFirstName(expected);
		String actual = dto.getFirstName();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFirstName2() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "2147483647";

		dto.setFirstName(expected);
		String actual = dto.getFirstName();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFirstName3() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "-2147483647";

		dto.setFirstName(expected);
		String actual = dto.getFirstName();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFirstName4() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "null";

		dto.setFirstName(expected);
		String actual = dto.getFirstName();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFirstName5() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "";

		dto.setFirstName(expected);
		String actual = dto.getFirstName();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFirstName6() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = " ";

		dto.setFirstName(expected);
		String actual = dto.getFirstName();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFirstName7() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "　";

		dto.setFirstName(expected);
		String actual = dto.getFirstName();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFirstName8() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123";

		dto.setFirstName(expected);
		String actual = dto.getFirstName();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFirstName9() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "あいう１２３";

		dto.setFirstName(expected);
		String actual = dto.getFirstName();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFirstName10() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setFirstName(expected);
		String actual = dto.getFirstName();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFirstName11() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setFirstName(expected);
		String actual = dto.getFirstName();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFirstName12() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "ａｂｃ１２３漢字";

		dto.setFirstName(expected);
		String actual = dto.getFirstName();
		assertEquals(expected,actual);
	}

	// set FirstName test
	@Test
	public void testSetFirstName1() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "0";

		dto.setFirstName(expected);
		String actual = dto.getFirstName();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetFirstName2() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "2147483647";

		dto.setFirstName(expected);
		String actual = dto.getFirstName();
		assertEquals(expected,actual);
	}
	public void testSetFirstName3() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "-2147483647";

		dto.setFirstName(expected);
		String actual = dto.getFirstName();
		assertEquals(expected,actual);
	}
	public void testSetFirstName4() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "null";

		dto.setFirstName(expected);
		String actual = dto.getFirstName();
		assertEquals(expected,actual);
	}
	public void testSetFirstName5() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "";

		dto.setFirstName(expected);
		String actual = dto.getFirstName();
		assertEquals(expected,actual);
	}
	public void testSetFirstName6() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = " ";

		dto.setFirstName(expected);
		String actual = dto.getFirstName();
		assertEquals(expected,actual);
	}
	public void testSetFirstName7() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "　";

		dto.setFirstName(expected);
		String actual = dto.getFirstName();
		assertEquals(expected,actual);
	}
	public void testSetFirstName8() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123";

		dto.setFirstName(expected);
		String actual = dto.getFirstName();
		assertEquals(expected,actual);
	}
	public void testSetFirstName9() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "あいう１２３";

		dto.setFirstName(expected);
		String actual = dto.getFirstName();
		assertEquals(expected,actual);
	}
	public void testSetFirstName10() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setFirstName(expected);
		String actual = dto.getFirstName();
		assertEquals(expected,actual);
	}
	public void testSetFirstName11() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setFirstName(expected);
		String actual = dto.getFirstName();
		assertEquals(expected,actual);
	}
	public void testSetFirstName12() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "ａｂｃあいう１２３漢字";

		dto.setFirstName(expected);
		String actual = dto.getFirstName();
		assertEquals(expected,actual);
	}

	// get FamilyNameKana test
	@Test
	public void testGetFamilyNameKana1() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "0";

		dto.setFamilyNameKana(expected);
		String actual = dto.getFamilyNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFamilyNameKana2() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "2147483647";

		dto.setFamilyNameKana(expected);
		String actual = dto.getFamilyNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFamilyNameKana3() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "-2147483647";

		dto.setFamilyNameKana(expected);
		String actual = dto.getFamilyNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFamilyNameKana4() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "null";

		dto.setFamilyNameKana(expected);
		String actual = dto.getFamilyNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFamilyNameKana5() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "";

		dto.setFamilyNameKana(expected);
		String actual = dto.getFamilyNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFamilyNameKana6() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = " ";

		dto.setFamilyNameKana(expected);
		String actual = dto.getFamilyNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFamilyNameKana7() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "　";

		dto.setFamilyNameKana(expected);
		String actual = dto.getFamilyNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFamilyNameKana8() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123";

		dto.setFamilyNameKana(expected);
		String actual = dto.getFamilyNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFamilyNameKana9() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "あいう１２３";

		dto.setFamilyNameKana(expected);
		String actual = dto.getFamilyNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFamilyNameKana10() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setFamilyNameKana(expected);
		String actual = dto.getFamilyNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFamilyNameKana11() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setFamilyNameKana(expected);
		String actual = dto.getFamilyNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFamilyNameKana12() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "ａｂｃあいう１２３漢字";

		dto.setFamilyNameKana(expected);
		String actual = dto.getFamilyNameKana();
		assertEquals(expected,actual);
	}

	// set FamilyNameKana test
	@Test
	public void testSetFamilyNameKana1() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "0";

		dto.setFamilyNameKana(expected);
		String actual = dto.getFamilyNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetFamilyNameKana2() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "2147483647";

		dto.setFamilyNameKana(expected);
		String actual = dto.getFamilyNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetFamilyNameKana3() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "-2147483647";

		dto.setFamilyNameKana(expected);
		String actual = dto.getFamilyNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetFamilyNameKana4() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "null";

		dto.setFamilyNameKana(expected);
		String actual = dto.getFamilyNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetFamilyNameKana5() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "";

		dto.setFamilyNameKana(expected);
		String actual = dto.getFamilyNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetFamilyNameKana6() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = " ";

		dto.setFamilyNameKana(expected);
		String actual = dto.getFamilyNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetFamilyNameKana7() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "　";

		dto.setFamilyNameKana(expected);
		String actual = dto.getFamilyNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetFamilyNameKana8() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123";

		dto.setFamilyNameKana(expected);
		String actual = dto.getFamilyNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetFamilyNameKana9() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "あいう１２３";

		dto.setFamilyNameKana(expected);
		String actual = dto.getFamilyNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetFamilyNameKana10() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setFamilyNameKana(expected);
		String actual = dto.getFamilyNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetFamilyNameKana11() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setFamilyNameKana(expected);
		String actual = dto.getFamilyNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetFamilyNameKana12() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "ａｂｃあいう１２３漢字";

		dto.setFamilyNameKana(expected);
		String actual = dto.getFamilyNameKana();
		assertEquals(expected,actual);
	}

	// get FirstNameKana test
	@Test
	public void testGetFirstNameKana1() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "0";

		dto.setFirstNameKana(expected);
		String actual = dto.getFirstNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFirstNameKana2() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "2147483647";

		dto.setFirstNameKana(expected);
		String actual = dto.getFirstNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFirstNameKana3() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "-2147483647";

		dto.setFirstNameKana(expected);
		String actual = dto.getFirstNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFirstNameKana4() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "null";

		dto.setFirstNameKana(expected);
		String actual = dto.getFirstNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFirstNameKana5() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "";

		dto.setFirstNameKana(expected);
		String actual = dto.getFirstNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFirstNameKana6() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = " ";

		dto.setFirstNameKana(expected);
		String actual = dto.getFirstNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFirstNameKana7() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "　";

		dto.setFirstNameKana(expected);
		String actual = dto.getFirstNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFirstNameKana8() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123";

		dto.setFirstNameKana(expected);
		String actual = dto.getFirstNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFirstNameKana9() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "あいう１２３";

		dto.setFirstNameKana(expected);
		String actual = dto.getFirstNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFirstNameKana10() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setFirstNameKana(expected);
		String actual = dto.getFirstNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFirstNameKana11() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setFirstNameKana(expected);
		String actual = dto.getFirstNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetFirstNameKana12() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "ａｂｃあいう１２３漢字";

		dto.setFirstNameKana(expected);
		String actual = dto.getFirstNameKana();
		assertEquals(expected,actual);
	}

	// set FirstNameKana test
	@Test
	public void testSetFirstNameKana1() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "0";

		dto.setFirstNameKana(expected);
		String actual = dto.getFirstNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetFirstNameKana2() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "2147483647";

		dto.setFirstNameKana(expected);
		String actual = dto.getFirstNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetFirstNameKana3() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "-2147483647";

		dto.setFirstNameKana(expected);
		String actual = dto.getFirstNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetFirstNameKana4() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "null";

		dto.setFirstNameKana(expected);
		String actual = dto.getFirstNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetFirstNameKana5() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "";

		dto.setFirstNameKana(expected);
		String actual = dto.getFirstNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetFirstNameKana6() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = " ";

		dto.setFirstNameKana(expected);
		String actual = dto.getFirstNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetFirstNameKana7() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "　";

		dto.setFirstNameKana(expected);
		String actual = dto.getFirstNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetFirstNameKana8() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123";

		dto.setFirstNameKana(expected);
		String actual = dto.getFirstNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetFirstNameKana9() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "あいう１２３";

		dto.setFirstNameKana(expected);
		String actual = dto.getFirstNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetFirstNameKana10() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setFirstNameKana(expected);
		String actual = dto.getFirstNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetFirstNameKana11() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setFirstNameKana(expected);
		String actual = dto.getFirstNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetFirstNameKana12() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "ａｂｃあいう１２３漢字";

		dto.setFirstNameKana(expected);
		String actual = dto.getFirstNameKana();
		assertEquals(expected,actual);
	}


	// get Sex test
	@Test
	public void testGetSex1() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "0";

		dto.setSex(expected);
		String actual = dto.getSex();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetSex2() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "2147483647";

		dto.setSex(expected);
		String actual = dto.getSex();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetSex3() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "-2147483647";

		dto.setSex(expected);
		String actual = dto.getSex();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetSex4() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "null";

		dto.setSex(expected);
		String actual = dto.getSex();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetSex5() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "";

		dto.setSex(expected);
		String actual = dto.getSex();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetSex6() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = " ";

		dto.setSex(expected);
		String actual = dto.getSex();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetSex7() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "　";

		dto.setSex(expected);
		String actual = dto.getSex();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetSex8() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123";

		dto.setSex(expected);
		String actual = dto.getSex();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetSex9() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "あいう１２３";

		dto.setSex(expected);
		String actual = dto.getSex();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetSex10() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setSex(expected);
		String actual = dto.getSex();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetSex11() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setSex(expected);
		String actual = dto.getSex();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetSex12() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "ａｂｃ１２３あいう漢字";

		dto.setSex(expected);
		String actual = dto.getSex();
		assertEquals(expected,actual);
	}

	// get Sex test
	@Test
	public void testSetSex1() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "0";

		dto.setSex(expected);
		String actual = dto.getSex();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetSex2() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "2147483647";

		dto.setSex(expected);
		String actual = dto.getSex();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetSex3() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "-2147483647";

		dto.setSex(expected);
		String actual = dto.getSex();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetSex4() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "null";

		dto.setSex(expected);
		String actual = dto.getSex();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetSex5() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "";

		dto.setSex(expected);
		String actual = dto.getSex();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetSex6() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = " ";

		dto.setSex(expected);
		String actual = dto.getSex();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetSex7() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "　";

		dto.setSex(expected);
		String actual = dto.getSex();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetSex8() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123";

		dto.setSex(expected);
		String actual = dto.getSex();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetSex9() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "あいう１２３";

		dto.setSex(expected);
		String actual = dto.getSex();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetSex10() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setSex(expected);
		String actual = dto.getSex();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetSex11() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setSex(expected);
		String actual = dto.getSex();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetSex12() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "ａｂｃ１２３あいう漢字";

		dto.setSex(expected);
		String actual = dto.getSex();
		assertEquals(expected,actual);
	}

	// get Email test
	@Test
	public void testGetEmail1() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "0";

		dto.setEmail(expected);
		String actual = dto.getEmail();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetEmail2() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "2147483647";

		dto.setEmail(expected);
		String actual = dto.getEmail();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetEmail3() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "-2147483647";

		dto.setEmail(expected);
		String actual = dto.getEmail();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetEmail4() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "null";

		dto.setEmail(expected);
		String actual = dto.getEmail();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetEmail5() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "";

		dto.setEmail(expected);
		String actual = dto.getEmail();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetEmail6() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = " ";

		dto.setEmail(expected);
		String actual = dto.getEmail();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetEmail7() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "　";

		dto.setEmail(expected);
		String actual = dto.getEmail();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetEmail8() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123";

		dto.setEmail(expected);
		String actual = dto.getEmail();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetEmail9() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "あいう１２３";

		dto.setEmail(expected);
		String actual = dto.getEmail();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetEmail10() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setEmail(expected);
		String actual = dto.getEmail();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetEmail11() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setEmail(expected);
		String actual = dto.getEmail();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetEmail12() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "ａｂｃ１２３あいう漢字";

		dto.setEmail(expected);
		String actual = dto.getEmail();
		assertEquals(expected,actual);
	}

	// set Email test
	@Test
	public void testSetEmail1() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "0";

		dto.setEmail(expected);
		String actual = dto.getEmail();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetEmail2() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "2147483647";

		dto.setEmail(expected);
		String actual = dto.getEmail();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetEmail3() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "-2147483647";

		dto.setEmail(expected);
		String actual = dto.getEmail();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetEmail4() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "null";

		dto.setEmail(expected);
		String actual = dto.getEmail();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetEmail5() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "";

		dto.setEmail(expected);
		String actual = dto.getEmail();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetEmail6() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = " ";

		dto.setEmail(expected);
		String actual = dto.getEmail();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetEmail7() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "　";

		dto.setEmail(expected);
		String actual = dto.getEmail();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetEmail8() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123";

		dto.setEmail(expected);
		String actual = dto.getEmail();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetEmail9() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "あいう１２３";

		dto.setEmail(expected);
		String actual = dto.getEmail();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetEmail10() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setEmail(expected);
		String actual = dto.getEmail();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetEmail11() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setEmail(expected);
		String actual = dto.getEmail();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetEmail12() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "ａｂｃ１２３あいう漢字";

		dto.setEmail(expected);
		String actual = dto.getEmail();
		assertEquals(expected,actual);
	}

	// get Status test
	@Test
	public void testGetStatus1() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "0";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetStatus2() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "2147483647";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetStatus3() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "-2147483647";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetStatus4() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "null";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetStatus5() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetStatus6() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = " ";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetStatus7() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "　";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetStatus8() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetStatus9() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "あいう１２３";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetStatus10() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetStatus11() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetStatus12() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "ａｂｃ１２３あいう漢字";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected,actual);
	}

	// set Status test
	@Test
	public void testSetStatus1() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "0";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetStatus2() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "2147483647";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetStatus3() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "-2147483647";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetStatus4() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "null";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetStatus5() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetStatus6() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = " ";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetStatus7() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "　";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetStatus8() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetStatus9() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "あいう１２３";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetStatus10() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetStatus11() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetStatus12() {
		UserInfoDTO dto = new UserInfoDTO();
		String expected = "ａｂｃ１２３あいう漢字";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected,actual);
	}

	// get Logined test
	@Test
	public void testGetLogined1() {
		UserInfoDTO dto = new UserInfoDTO();
		int expected = 0;

		dto.setLogined(expected);
		int actual = dto.getLogined();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetLogined2() {
		UserInfoDTO dto = new UserInfoDTO();
		int expected = 9999999;

		dto.setLogined(expected);
		int actual = dto.getLogined();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetLogined3() {
		UserInfoDTO dto = new UserInfoDTO();
		int expected = -9999999;

		dto.setLogined(expected);
		int actual = dto.getLogined();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetLogined4() {
		UserInfoDTO dto = new UserInfoDTO();
		try {
			int postalMax = 10000000;
			dto.setLogined(postalMax);
		}catch(RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"10000000.00\"");
		}
	}
	@Test
	public void testGetLogined5() {
		UserInfoDTO dto = new UserInfoDTO();
		try {
			int postalMax = -10000000;
			dto.setLogined(postalMax);
		}catch(RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"-10000000.00\"");
		}
	}

	//set Logined test
	@Test
	public void testSetLogined1() {
		UserInfoDTO dto = new UserInfoDTO();
		int expected = 0;

		dto.setLogined(expected);
		int actual = dto.getLogined();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetLogined2() {
		UserInfoDTO dto = new UserInfoDTO();
		int expected = 9999999;

		dto.setLogined(expected);
		int actual = dto.getLogined();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetLogined3() {
		UserInfoDTO dto = new UserInfoDTO();
		int expected = -9999999;

		dto.setLogined(expected);
		int actual = dto.getLogined();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetLogined4() {
		UserInfoDTO dto = new UserInfoDTO();
		try {
			int postalMax = 10000000;
			dto.setLogined(postalMax);
		}catch(RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"10000000.00\"");
		}
	}
	@Test
	public void testSetLogined5() {
		UserInfoDTO dto = new UserInfoDTO();
		try {
			int postalMax = -10000000;
			dto.setLogined(postalMax);
		}catch(RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"-10000000.00\"");
		}
	}

	// get RegistDate test
	@Test
	public void testGetRegistDate1() {
		UserInfoDTO dto = new UserInfoDTO();
		Date expected = null;

		dto.setRegistDate(expected);
		Date actual = dto.getRegistDate();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetRegistDate2() throws ParseException{
		UserInfoDTO dto = new UserInfoDTO();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Date expected = sdf.parse("20180420 12:00:00");
		dto.setRegistDate(expected);
		assertEquals(expected,dto.getRegistDate());

	}

	// set RegistDate test
	@Test
	public void testSetRegistDate1() {
		UserInfoDTO dto = new UserInfoDTO();
		Date expected = null;

		dto.setRegistDate(expected);
		Date actual = dto.getRegistDate();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetRegistDate2() throws ParseException{
		UserInfoDTO dto = new UserInfoDTO();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Date expected = sdf.parse("20180420 12:00:00");
		dto.setRegistDate(expected);
		assertEquals(expected,dto.getRegistDate());
	}

	// get UpdateDate test
	@Test
	public void testGetUpdateDate1() {
		UserInfoDTO dto = new UserInfoDTO();
		Date expected = null;

		dto.setUpdateDate(expected);
		Date actual = dto.getUpdateDate();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetUpdateDate2() throws ParseException{
		UserInfoDTO dto = new UserInfoDTO();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Date expected = sdf.parse("20180420 12:00:00");
		dto.setUpdateDate(expected);
		assertEquals(expected,dto.getUpdateDate());
	}

	@Test
	public void testSetUpdateDate1() {
		UserInfoDTO dto = new UserInfoDTO();
		Date expected = null;

		dto.setUpdateDate(expected);
		Date actual = dto.getUpdateDate();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetUpdateDate2() throws ParseException{
		UserInfoDTO dto = new UserInfoDTO();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Date expected = sdf.parse("20180420 12:00:00");
		dto.setUpdateDate(expected);
		assertEquals(expected,dto.getUpdateDate());
	}

}
