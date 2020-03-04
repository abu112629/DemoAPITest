package com.sams.promotions.emulation.test.helper;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import org.assertj.core.api.SoftAssertions;
import org.springframework.stereotype.Component;

import com.sams.promotions.emulation.test.base.BaseStep;

import groovy.util.logging.Slf4j;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

@Slf4j
@Component

public class AssertHelper extends BaseStep{

	public AssertHelper() throws IOException {
		super();
	}

	/*
	 * Author : Abu Description : Helper Method Date : 2/13/2019
	 * 
	 */
	private SoftAssertions softAssertions = new SoftAssertions();
	
	

	public SoftAssertions BusinessBaseValidation(ValidatableResponse response, ValidatableResponse response2,
			String packagecode, String OfferId, String expected) throws Exception {
		
		helper = new Helper();
		Response res = response.assertThat().statusCode(200).and().extract().response();
		Response res2 = response2.assertThat().statusCode(200).and().extract().response();

		String[] actual = helper.ActualMigratedValidations(res.prettyPrint().toString());
		String[] actual2 = helper.ActualMigratedValidations(res2.prettyPrint().toString());
		
		Map<String, String> dataPowerValues=helper.getAssertValues(res.asString());
		Map<String, String> emulatorValues=helper.getAssertValues(res2.asString());

		if (packagecode.contentEquals("91") || packagecode.contentEquals("99") || packagecode.contentEquals("90")
				|| packagecode.contentEquals("98") || packagecode.contentEquals("94")
				|| packagecode.contentEquals("95")) {

			System.out.println("DataPower Actual : " + Arrays.toString(actual));
			System.out.println("Emulator Actual : " + Arrays.toString(actual2));

			String[] invalidexpected = new String[] { "NO VALID OFFER PRESENT" };
			System.out.println("Expected :" + Arrays.toString(invalidexpected));
			
			
			softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

			//softAssertions.assertThat(actual).isEqualTo(invalidexpected);
			//softAssertions.assertThat(actual2).isEqualTo(invalidexpected);

			//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :" + OfferId);
		}

		else {

			System.out.println("DataPower Actual : " + Arrays.toString(actual));
			System.out.println("Emulator Actual : " + Arrays.toString(actual2));

			System.out.println("Expected : " + expected);

			//softAssertions.assertThat(Arrays.toString(actual)).isEqualTo(expected);
			//softAssertions.assertThat(Arrays.toString(actual2)).isEqualTo(expected);

			softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

			//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :" + OfferId);
		}
		return softAssertions;

	}
	
	public SoftAssertions BusinessBaseDoubleLinesValidation(ValidatableResponse response, ValidatableResponse response2,
			String packagecode, String packagecode2, String OfferId, String OfferId2,String expected) throws Exception {
		
		helper = new Helper();
		Response res = response.assertThat().statusCode(200).and().extract().response();
		Response res2 = response2.assertThat().statusCode(200).and().extract().response();

		String[] actual = helper.ActualMigratedValidations(res.prettyPrint().toString());
		String[] actual2 = helper.ActualMigratedValidations(res2.prettyPrint().toString());
		
		Map<String, String> dataPowerValues=helper.getAssertValues(res.asString());
		Map<String, String> emulatorValues=helper.getAssertValues(res2.asString());

		if (packagecode.contentEquals("91") || packagecode.contentEquals("99") || packagecode.contentEquals("90")
				|| packagecode.contentEquals("98") || packagecode.contentEquals("94")
				|| packagecode.contentEquals("95")) {

			if (packagecode2.contentEquals("91") || packagecode2.contentEquals("99") || packagecode2.contentEquals("90")
					|| packagecode2.contentEquals("98") || packagecode2.contentEquals("94")
					|| packagecode2.contentEquals("95")) {

				System.out.println("DataPower Actual : " + Arrays.toString(actual));
				System.out.println("Emulator Actual : " + Arrays.toString(actual2));

				String []invalidexpected =new String [] {"NO VALID OFFER PRESENT"};
				System.out.println("Expected :" + Arrays.toString(invalidexpected));

				softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);
				//softAssertions.assertThat(actual).isEqualTo(invalidexpected);
				//softAssertions.assertThat(actual2).isEqualTo(invalidexpected);

				//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :" + OfferId);

			}

			else {

				System.out.println("DataPower Actual : " + Arrays.toString(actual));

				System.out.println("Emulator Actual : " + Arrays.toString(actual2));

				System.out.println("Expected : " + expected);
				

				//softAssertions.assertThat(Arrays.toString(actual)).isEqualTo(expected);
				//softAssertions.assertThat(Arrays.toString(actual2)).isEqualTo(expected);

				softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

				//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :"+ OfferId2);

			}

		}

		else {

			System.out.println("DataPower Actual : " + Arrays.toString(actual));

			System.out.println("Emulator Actual : " + Arrays.toString(actual2));

			System.out.println("Expected : " + expected);

			//softAssertions.assertThat(Arrays.toString(actual)).isEqualTo(expected);
			//softAssertions.assertThat(Arrays.toString(actual2)).isEqualTo(expected);

			softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

			//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :" + OfferId);

		}

		return softAssertions;

	}

	public SoftAssertions BusinessPlusValidation(ValidatableResponse response, ValidatableResponse response2,
			String packagecode, String OfferId, String expected) throws Exception {

		
		helper = new Helper();
		Response res = response.assertThat().statusCode(200).and().extract().response();
		Response res2 = response2.assertThat().statusCode(200).and().extract().response();

		String[] actual = helper.ActualMigratedValidations(res.prettyPrint().toString());
		String[] actual2 = helper.ActualMigratedValidations(res2.prettyPrint().toString());
		
		Map<String, String> dataPowerValues=helper.getAssertValues(res.asString());
		Map<String, String> emulatorValues=helper.getAssertValues(res2.asString());

		if (packagecode.contentEquals("97") || packagecode.contentEquals("91")
				|| packagecode.contentEquals("99") || packagecode.contentEquals("90")
				|| packagecode.contentEquals("98")) {

			System.out.println("DataPower Actual : " + Arrays.toString(actual));
			System.out.println("Emulator Actual : " + Arrays.toString(actual2));

			String[] invalidexpected = new String[] { "NO VALID OFFER PRESENT" };
			System.out.println("Expected :" + Arrays.toString(invalidexpected));
			softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

			//softAssertions.assertThat(actual).isEqualTo(invalidexpected);
			//softAssertions.assertThat(actual2).isEqualTo(invalidexpected);

			//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :" + OfferId);
		}

		else {

			System.out.println("DataPower Actual : " + Arrays.toString(actual));
			System.out.println("Emulator Actual : " + Arrays.toString(actual2));

			System.out.println("Expected : " + expected);

			//softAssertions.assertThat(Arrays.toString(actual)).isEqualTo(expected);
			//softAssertions.assertThat(Arrays.toString(actual2)).isEqualTo(expected);

			softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

			//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :" + OfferId);

		}

		return softAssertions;

	}
	
	public SoftAssertions BusinessPlusDoubleLinesValidation(ValidatableResponse response, ValidatableResponse response2,
			String packagecode, String packagecode2, String OfferId, String OfferId2,String expected) throws Exception {
		
		
		helper = new Helper();
		Response res = response.assertThat().statusCode(200).and().extract().response();
		Response res2 = response2.assertThat().statusCode(200).and().extract().response();

		String[] actual = helper.ActualMigratedValidations(res.prettyPrint().toString());
		String[] actual2 = helper.ActualMigratedValidations(res2.prettyPrint().toString());
		
		Map<String, String> dataPowerValues=helper.getAssertValues(res.asString());
		Map<String, String> emulatorValues=helper.getAssertValues(res2.asString());

		if (packagecode.contentEquals("97") || packagecode.contentEquals("91")
				|| packagecode.contentEquals("99") || packagecode.contentEquals("90")
				|| packagecode.contentEquals("98")) {

			if (packagecode2.contentEquals("97") || packagecode2.contentEquals("91")
					|| packagecode2.contentEquals("99") || packagecode2.contentEquals("90")
					|| packagecode2.contentEquals("98")) {

				System.out.println("DataPower Actual : " + Arrays.toString(actual));
				System.out.println("Emulator Actual : " + Arrays.toString(actual2));

				String []invalidexpected =new String [] {"NO VALID OFFER PRESENT"};
				System.out.println("Expected :" + Arrays.toString(invalidexpected));
				
				softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);
				//softAssertions.assertThat(actual).isEqualTo(invalidexpected);
				//softAssertions.assertThat(actual2).isEqualTo(invalidexpected);

				//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :" + OfferId);

			}

			else {

				System.out.println("DataPower Actual : " + Arrays.toString(actual));

				System.out.println("Emulator Actual : " + Arrays.toString(actual2));

				System.out.println("Expected : " + expected);

				//softAssertions.assertThat(Arrays.toString(actual)).isEqualTo(expected);
				//softAssertions.assertThat(Arrays.toString(actual2)).isEqualTo(expected);

				softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

				//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :"+ OfferId2);

			}

		}

		else {

			System.out.println("DataPower Actual : " + Arrays.toString(actual));

			System.out.println("Emulator Actual : " + Arrays.toString(actual2));

			System.out.println("Expected : " + expected);

			//softAssertions.assertThat(Arrays.toString(actual)).isEqualTo(expected);
			//softAssertions.assertThat(Arrays.toString(actual2)).isEqualTo(expected);

			softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

			//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :" +OfferId);

		}

		return softAssertions;

	}
	
	public SoftAssertions SavingsBaseValidation(ValidatableResponse response, ValidatableResponse response2,
			String packagecode, String OfferId, String expected) throws Exception {

		
		helper = new Helper();
		Response res = response.assertThat().statusCode(200).and().extract().response();
		Response res2 = response2.assertThat().statusCode(200).and().extract().response();

		String[] actual = helper.ActualMigratedValidations(res.prettyPrint().toString());
		String[] actual2 = helper.ActualMigratedValidations(res2.prettyPrint().toString());
		
		Map<String, String> dataPowerValues=helper.getAssertValues(res.asString());
		Map<String, String> emulatorValues=helper.getAssertValues(res2.asString());

		if (packagecode.contentEquals("91") || packagecode.contentEquals("99")
				|| packagecode.contentEquals("94") || packagecode.contentEquals("95")
				|| packagecode.contentEquals("92") || packagecode.contentEquals("93")) {

			System.out.println("DataPower Actual : " + Arrays.toString(actual));
			System.out.println("Emulator Actual : " + Arrays.toString(actual2));

			String[] invalidexpected = new String[] { "NO VALID OFFER PRESENT" };
			System.out.println("Expected :" + Arrays.toString(invalidexpected));
			softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

			//softAssertions.assertThat(actual).isEqualTo(invalidexpected);
			//softAssertions.assertThat(actual2).isEqualTo(invalidexpected);

			//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :" + OfferId);
		}

		else {

			System.out.println("DataPower Actual : " + Arrays.toString(actual));
			System.out.println("Emulator Actual : " + Arrays.toString(actual2));

			System.out.println("Expected : " + expected);

			//softAssertions.assertThat(Arrays.toString(actual)).isEqualTo(expected);
			//softAssertions.assertThat(Arrays.toString(actual2)).isEqualTo(expected);

			softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

			//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :" + OfferId);

		}

		return softAssertions;

	}
	public SoftAssertions SavingsBaseDoubleLinesValidation(ValidatableResponse response, ValidatableResponse response2,
			String packagecode, String packagecode2, String OfferId, String OfferId2,String expected) throws Exception {
		
		helper = new Helper();
		Response res = response.assertThat().statusCode(200).and().extract().response();
		Response res2 = response2.assertThat().statusCode(200).and().extract().response();

		String[] actual = helper.ActualMigratedValidations(res.prettyPrint().toString());
		String[] actual2 = helper.ActualMigratedValidations(res2.prettyPrint().toString());
		
		Map<String, String> dataPowerValues=helper.getAssertValues(res.asString());
		Map<String, String> emulatorValues=helper.getAssertValues(res2.asString());


		if (packagecode.contentEquals("91") || packagecode.contentEquals("99") || packagecode.contentEquals("94")
				|| packagecode.contentEquals("95") || packagecode.contentEquals("92")
				|| packagecode.contentEquals("93")) {

			if (packagecode2.contentEquals("91") || packagecode2.contentEquals("99") || packagecode2.contentEquals("94")
					|| packagecode2.contentEquals("95") || packagecode2.contentEquals("92")
					|| packagecode2.contentEquals("93")) {

				System.out.println("DataPower Actual : " + Arrays.toString(actual));
				System.out.println("Emulator Actual : " + Arrays.toString(actual2));

				String []invalidexpected =new String [] {"NO VALID OFFER PRESENT"};
				System.out.println("Expected :" + Arrays.toString(invalidexpected));
				softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

				//softAssertions.assertThat(actual).isEqualTo(invalidexpected);
				//softAssertions.assertThat(actual2).isEqualTo(invalidexpected);

				//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :" + OfferId);

			}

			else {

				System.out.println("DataPower Actual : " + Arrays.toString(actual));

				System.out.println("Emulator Actual : " + Arrays.toString(actual2));

				System.out.println("Expected : " + expected);

				//softAssertions.assertThat(Arrays.toString(actual)).isEqualTo(expected);
				//softAssertions.assertThat(Arrays.toString(actual2)).isEqualTo(expected);

				softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

				//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :"+ OfferId2);

			}

		}

		else {

			System.out.println("DataPower Actual : " + Arrays.toString(actual));

			System.out.println("Emulator Actual : " + Arrays.toString(actual2));

			System.out.println("Expected : " + expected);

			//softAssertions.assertThat(Arrays.toString(actual)).isEqualTo(expected);
			//softAssertions.assertThat(Arrays.toString(actual2)).isEqualTo(expected);

			softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

			//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :" + OfferId);

		}

		return softAssertions;

	}

	public SoftAssertions SavingsPlusValidation(ValidatableResponse response, ValidatableResponse response2,
			String packagecode, String OfferId, String expected) throws Exception {

		helper = new Helper();
		Response res = response.assertThat().statusCode(200).and().extract().response();
		Response res2 = response2.assertThat().statusCode(200).and().extract().response();

		String[] actual = helper.ActualMigratedValidations(res.prettyPrint().toString());
		String[] actual2 = helper.ActualMigratedValidations(res2.prettyPrint().toString());
		
		Map<String, String> dataPowerValues=helper.getAssertValues(res.asString());
		Map<String, String> emulatorValues=helper.getAssertValues(res2.asString());

		if (packagecode.contentEquals("97") || packagecode.contentEquals("94")
				|| packagecode.contentEquals("95") || packagecode.contentEquals("92")
				|| packagecode.contentEquals("93")) {

			System.out.println("DataPower Actual : " + Arrays.toString(actual));
			System.out.println("Emulator Actual : " + Arrays.toString(actual2));

			String[] invalidexpected = new String[] { "NO VALID OFFER PRESENT" };
			System.out.println("Expected :" + Arrays.toString(invalidexpected));
			softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

			//softAssertions.assertThat(actual).isEqualTo(invalidexpected);
			//softAssertions.assertThat(actual2).isEqualTo(invalidexpected);

			//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :" + OfferId);
		}

		else {

			System.out.println("DataPower Actual : " + Arrays.toString(actual));
			System.out.println("Emulator Actual : " + Arrays.toString(actual2));

			System.out.println("Expected : " + expected);

			//softAssertions.assertThat(Arrays.toString(actual)).isEqualTo(expected);
			//softAssertions.assertThat(Arrays.toString(actual2)).isEqualTo(expected);

			softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

			//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :" + OfferId);

		}

		return softAssertions;

	}
	
	public SoftAssertions SavingsPlusDoubleLinesValidation(ValidatableResponse response, ValidatableResponse response2,
			String packagecode, String packagecode2, String OfferId, String OfferId2,String expected) throws Exception {
		
		helper = new Helper();
		Response res = response.assertThat().statusCode(200).and().extract().response();
		Response res2 = response2.assertThat().statusCode(200).and().extract().response();

		String[] actual = helper.ActualMigratedValidations(res.prettyPrint().toString());
		String[] actual2 = helper.ActualMigratedValidations(res2.prettyPrint().toString());
		
		Map<String, String> dataPowerValues=helper.getAssertValues(res.asString());
		Map<String, String> emulatorValues=helper.getAssertValues(res2.asString());


		if (packagecode.contentEquals("97") || packagecode.contentEquals("94")
				|| packagecode.contentEquals("95") || packagecode.contentEquals("92")
				|| packagecode.contentEquals("93")) {

			if (packagecode2.contentEquals("97") || packagecode2.contentEquals("94")
					|| packagecode2.contentEquals("95") || packagecode2.contentEquals("92")
					|| packagecode2.contentEquals("93")) {

				System.out.println("DataPower Actual : " + Arrays.toString(actual));
				System.out.println("Emulator Actual : " + Arrays.toString(actual2));

				String []invalidexpected =new String [] {"NO VALID OFFER PRESENT"};
				System.out.println("Expected :" + Arrays.toString(invalidexpected));

				softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

				//softAssertions.assertThat(actual).isEqualTo(invalidexpected);
				//softAssertions.assertThat(actual2).isEqualTo(invalidexpected);

				//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :" + OfferId);

			}

			else {

				System.out.println("DataPower Actual : " + Arrays.toString(actual));

				System.out.println("Emulator Actual : " + Arrays.toString(actual2));

				System.out.println("Expected : " + expected);

				//softAssertions.assertThat(Arrays.toString(actual)).isEqualTo(expected);
				//softAssertions.assertThat(Arrays.toString(actual2)).isEqualTo(expected);
				
				softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

				//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :"+ OfferId2);

			}

		}

		else {

			System.out.println("DataPower Actual : " + Arrays.toString(actual));

			System.out.println("Emulator Actual : " + Arrays.toString(actual2));

			System.out.println("Expected : " + expected);

			//softAssertions.assertThat(Arrays.toString(actual)).isEqualTo(expected);
			//softAssertions.assertThat(Arrays.toString(actual2)).isEqualTo(expected);

			softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

			//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :" + OfferId);

		}

		return softAssertions;

	}
	
	public SoftAssertions BusinessBaseAddOnValidation(ValidatableResponse response, ValidatableResponse response2,
			String packagecode, String OfferId, String expected) throws Exception {
		
		helper = new Helper();
		Response res = response.assertThat().statusCode(200).and().extract().response();
		Response res2 = response2.assertThat().statusCode(200).and().extract().response();

		String[] actual = helper.ActualMigratedValidations(res.prettyPrint().toString());
		String[] actual2 = helper.ActualMigratedValidations(res2.prettyPrint().toString());
		
		Map<String, String> dataPowerValues=helper.getAssertValues(res.asString());
		Map<String, String> emulatorValues=helper.getAssertValues(res2.asString());
		
		if (packagecode.contentEquals("91") || packagecode.contentEquals("99")
				|| packagecode.contentEquals("90") || packagecode.contentEquals("98")
				|| packagecode.contentEquals("94") || packagecode.contentEquals("95")||packagecode.contentEquals("97")||packagecode.contentEquals("93")) {

			System.out.println("DataPower Actual : " + Arrays.toString(actual));
			System.out.println("Emulator Actual : " + Arrays.toString(actual2));
			
			String []invalidexpected =new String [] {"NO VALID OFFER PRESENT"};
			System.out.println("Expected :" + Arrays.toString(invalidexpected));
			softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);
			
			//softAssertions.assertThat(actual).isEqualTo(invalidexpected);
			//softAssertions.assertThat(actual2).isEqualTo(invalidexpected);
			
			//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :"+OfferId);
		}

		else {
			
			System.out.println("DataPower Actual : " + Arrays.toString(actual));
			System.out.println("Emulator Actual : " + Arrays.toString(actual2));
			
			System.out.println("Expected : " + expected);

			//softAssertions.assertThat(Arrays.toString(actual)).isEqualTo(expected);
			//softAssertions.assertThat(Arrays.toString(actual2)).isEqualTo(expected);

			softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

			//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :"+OfferId);
		}
		return softAssertions;

	}
	
	
	public SoftAssertions BusinessBaseAddOnDoubleLinesValidation(ValidatableResponse response, ValidatableResponse response2,
			String packagecode, String packagecode2, String OfferId, String OfferId2,String expected) throws Exception {
		
		helper = new Helper();
		Response res = response.assertThat().statusCode(200).and().extract().response();
		Response res2 = response2.assertThat().statusCode(200).and().extract().response();

		String[] actual = helper.ActualMigratedValidations(res.prettyPrint().toString());
		String[] actual2 = helper.ActualMigratedValidations(res2.prettyPrint().toString());

		Map<String, String> dataPowerValues=helper.getAssertValues(res.asString());
		Map<String, String> emulatorValues=helper.getAssertValues(res2.asString());

		if (packagecode.contentEquals("91") || packagecode.contentEquals("99")
				|| packagecode.contentEquals("90") || packagecode.contentEquals("98")
				|| packagecode.contentEquals("94") || packagecode.contentEquals("95")||packagecode.contentEquals("97")||packagecode.contentEquals("93")) {

			if (packagecode2.contentEquals("91") || packagecode2.contentEquals("99")
					|| packagecode2.contentEquals("90") || packagecode2.contentEquals("98")
					|| packagecode2.contentEquals("94") || packagecode2.contentEquals("95")||packagecode2.contentEquals("97")||packagecode2.contentEquals("93")) {

				System.out.println("DataPower Actual : " + Arrays.toString(actual));
				System.out.println("Emulator Actual : " + Arrays.toString(actual2));

				String []invalidexpected =new String [] {"NO VALID OFFER PRESENT"};
				System.out.println("Expected :" + Arrays.toString(invalidexpected));
				softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

				//softAssertions.assertThat(actual).isEqualTo(invalidexpected);
				//softAssertions.assertThat(actual2).isEqualTo(invalidexpected);

				//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :" + OfferId);

			}

			else {

				System.out.println("DataPower Actual : " + Arrays.toString(actual));

				System.out.println("Emulator Actual : " + Arrays.toString(actual2));

				System.out.println("Expected : " + expected);

				//softAssertions.assertThat(Arrays.toString(actual)).isEqualTo(expected);
				//softAssertions.assertThat(Arrays.toString(actual2)).isEqualTo(expected);

				softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

				//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :"+ OfferId2);

			}

		}

		else {

			System.out.println("DataPower Actual : " + Arrays.toString(actual));

			System.out.println("Emulator Actual : " + Arrays.toString(actual2));

			System.out.println("Expected : " + expected);

			//softAssertions.assertThat(Arrays.toString(actual)).isEqualTo(expected);
			//softAssertions.assertThat(Arrays.toString(actual2)).isEqualTo(expected);

			softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

			//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :" + OfferId);

		}


		return softAssertions;

	}

	public SoftAssertions BusinessPlusAddOnValidation(ValidatableResponse response, ValidatableResponse response2,
			String packagecode, String OfferId, String expected) throws Exception {
		
		helper = new Helper();
		Response res = response.assertThat().statusCode(200).and().extract().response();
		Response res2 = response2.assertThat().statusCode(200).and().extract().response();

		String[] actual = helper.ActualMigratedValidations(res.prettyPrint().toString());
		String[] actual2 = helper.ActualMigratedValidations(res2.prettyPrint().toString());
		
		Map<String, String> dataPowerValues=helper.getAssertValues(res.asString());
		Map<String, String> emulatorValues=helper.getAssertValues(res2.asString());

		if (packagecode.contentEquals("97")
				|| packagecode.contentEquals("91") || packagecode.contentEquals("99")
				|| packagecode.contentEquals("90") || packagecode.contentEquals("98")||packagecode.contentEquals("95")||packagecode.contentEquals("93")) {

			System.out.println("DataPower Actual : " + Arrays.toString(actual));
			System.out.println("Emulator Actual : " + Arrays.toString(actual2));

			String []invalidexpected =new String [] {"NO VALID OFFER PRESENT"};
			System.out.println("Expected :" + Arrays.toString(invalidexpected));
			softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

			//softAssertions.assertThat(actual).isEqualTo(invalidexpected);
			//softAssertions.assertThat(actual2).isEqualTo(invalidexpected);

			//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :" + OfferId);
		}

		else {

			System.out.println("DataPower Actual : " + Arrays.toString(actual));
			System.out.println("Emulator Actual : " + Arrays.toString(actual2));

			System.out.println("Expected : " + expected);

			//softAssertions.assertThat(Arrays.toString(actual)).isEqualTo(expected);
			//softAssertions.assertThat(Arrays.toString(actual2)).isEqualTo(expected);
			
			softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

			//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :" + OfferId);

		}

		return softAssertions;

	}
	
	
	public SoftAssertions BusinessPlusAddOnDoubleLinesValidation(ValidatableResponse response, ValidatableResponse response2,
			String packagecode, String packagecode2, String OfferId, String OfferId2,String expected) throws Exception {
		
		helper = new Helper();
		Response res = response.assertThat().statusCode(200).and().extract().response();
		Response res2 = response2.assertThat().statusCode(200).and().extract().response();

		String[] actual = helper.ActualMigratedValidations(res.prettyPrint().toString());
		String[] actual2 = helper.ActualMigratedValidations(res2.prettyPrint().toString());
		
		Map<String, String> dataPowerValues=helper.getAssertValues(res.asString());
		Map<String, String> emulatorValues=helper.getAssertValues(res2.asString());


		if (packagecode.contentEquals("97")
				|| packagecode.contentEquals("91") || packagecode.contentEquals("99")
				|| packagecode.contentEquals("90") || packagecode.contentEquals("98")||packagecode.contentEquals("95")||packagecode.contentEquals("93")) {

			if (packagecode2.contentEquals("97")
					|| packagecode2.contentEquals("91") || packagecode2.contentEquals("99")
					|| packagecode2.contentEquals("90") || packagecode2.contentEquals("98")||packagecode2.contentEquals("95")||packagecode2.contentEquals("93")) {


				System.out.println("DataPower Actual : " + Arrays.toString(actual));
				System.out.println("Emulator Actual : " + Arrays.toString(actual2));

				String []invalidexpected =new String [] {"NO VALID OFFER PRESENT"};
				System.out.println("Expected :" + Arrays.toString(invalidexpected));
				softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

				//softAssertions.assertThat(actual).isEqualTo(invalidexpected);
				//softAssertions.assertThat(actual2).isEqualTo(invalidexpected);

				//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :" + OfferId);

			}

			else {

				System.out.println("DataPower Actual : " + Arrays.toString(actual));

				System.out.println("Emulator Actual : " + Arrays.toString(actual2));

				System.out.println("Expected : " + expected);

				//softAssertions.assertThat(Arrays.toString(actual)).isEqualTo(expected);
				//softAssertions.assertThat(Arrays.toString(actual2)).isEqualTo(expected);

				softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

				//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :"+ OfferId2);

			}

		}

		else {

			System.out.println("DataPower Actual : " + Arrays.toString(actual));

			System.out.println("Emulator Actual : " + Arrays.toString(actual2));

			System.out.println("Expected : " + expected);

			//softAssertions.assertThat(Arrays.toString(actual)).isEqualTo(expected);
			//softAssertions.assertThat(Arrays.toString(actual2)).isEqualTo(expected);

			softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);
			
			//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :" + OfferId);

		}


		return softAssertions;

	}
	
	public SoftAssertions SavingsBaseAddOnValidation(ValidatableResponse response, ValidatableResponse response2,
			String packagecode, String OfferId, String expected) throws Exception {
		
		helper = new Helper();
		Response res = response.assertThat().statusCode(200).and().extract().response();
		Response res2 = response2.assertThat().statusCode(200).and().extract().response();

		String[] actual = helper.ActualMigratedValidations(res.prettyPrint().toString());
		String[] actual2 = helper.ActualMigratedValidations(res2.prettyPrint().toString());

		Map<String, String> dataPowerValues=helper.getAssertValues(res.asString());
		Map<String, String> emulatorValues=helper.getAssertValues(res2.asString());

		if (packagecode.contentEquals("97") || packagecode.contentEquals("91")
				|| packagecode.contentEquals("99") || packagecode.contentEquals("98")
				|| packagecode.contentEquals("94") || packagecode.contentEquals("95")||packagecode.contentEquals("92")||packagecode.contentEquals("93")) {

			System.out.println("DataPower Actual : " + Arrays.toString(actual));
			System.out.println("Emulator Actual : " + Arrays.toString(actual2));

			String []invalidexpected =new String [] {"NO VALID OFFER PRESENT"};
			System.out.println("Expected :" + Arrays.toString(invalidexpected));
			softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

			//softAssertions.assertThat(actual).isEqualTo(invalidexpected);
			//softAssertions.assertThat(actual2).isEqualTo(invalidexpected);

			//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :" + OfferId);
		}

		else {

			System.out.println("DataPower Actual : " + Arrays.toString(actual));
			System.out.println("Emulator Actual : " + Arrays.toString(actual2));

			System.out.println("Expected : " + expected);

			//softAssertions.assertThat(Arrays.toString(actual)).isEqualTo(expected);
			//softAssertions.assertThat(Arrays.toString(actual2)).isEqualTo(expected);

			softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

			//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :" + OfferId);

		}

		return softAssertions;

	}
	
	public SoftAssertions SavingsBaseAddOnDoubleLinesValidation(ValidatableResponse response, ValidatableResponse response2,
			String packagecode, String packagecode2, String OfferId, String OfferId2,String expected) throws Exception {
		
		helper = new Helper();
		Response res = response.assertThat().statusCode(200).and().extract().response();
		Response res2 = response2.assertThat().statusCode(200).and().extract().response();

		String[] actual = helper.ActualMigratedValidations(res.prettyPrint().toString());
		String[] actual2 = helper.ActualMigratedValidations(res2.prettyPrint().toString());

		Map<String, String> dataPowerValues=helper.getAssertValues(res.asString());
		Map<String, String> emulatorValues=helper.getAssertValues(res2.asString());

		if (packagecode.contentEquals("97") || packagecode.contentEquals("91")
				|| packagecode.contentEquals("99") || packagecode.contentEquals("98")
				|| packagecode.contentEquals("94") || packagecode.contentEquals("95")||packagecode.contentEquals("92")||packagecode.contentEquals("93")) {

			if (packagecode2.contentEquals("97") || packagecode2.contentEquals("91")
					|| packagecode2.contentEquals("99") || packagecode2.contentEquals("98")
					|| packagecode2.contentEquals("94") || packagecode2.contentEquals("95")||packagecode2.contentEquals("92")||packagecode2.contentEquals("93")) {

				System.out.println("DataPower Actual : " + Arrays.toString(actual));
				System.out.println("Emulator Actual : " + Arrays.toString(actual2));

				String []invalidexpected =new String [] {"NO VALID OFFER PRESENT"};
				System.out.println("Expected :" + Arrays.toString(invalidexpected));
				softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

				//softAssertions.assertThat(actual).isEqualTo(invalidexpected);
				//softAssertions.assertThat(actual2).isEqualTo(invalidexpected);

				//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :" + OfferId);

			}

			else {

				System.out.println("DataPower Actual : " + Arrays.toString(actual));

				System.out.println("Emulator Actual : " + Arrays.toString(actual2));

				System.out.println("Expected : " + expected);

				//softAssertions.assertThat(Arrays.toString(actual)).isEqualTo(expected);
				//softAssertions.assertThat(Arrays.toString(actual2)).isEqualTo(expected);

				softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

				//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :"+ OfferId2);

			}

		}

		else {

			System.out.println("DataPower Actual : " + Arrays.toString(actual));

			System.out.println("Emulator Actual : " + Arrays.toString(actual2));

			System.out.println("Expected : " + expected);

			//softAssertions.assertThat(Arrays.toString(actual)).isEqualTo(expected);
			//softAssertions.assertThat(Arrays.toString(actual2)).isEqualTo(expected);
			softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

			//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :" + OfferId);

		}


		return softAssertions;

	}
	
	public SoftAssertions SavingsPlusAddOnValidation(ValidatableResponse response, ValidatableResponse response2,
			String packagecode, String OfferId, String expected) throws Exception {
		
		helper = new Helper();
		Response res = response.assertThat().statusCode(200).and().extract().response();
		Response res2 = response2.assertThat().statusCode(200).and().extract().response();

		String[] actual = helper.ActualMigratedValidations(res.prettyPrint().toString());
		String[] actual2 = helper.ActualMigratedValidations(res2.prettyPrint().toString());

		Map<String, String> dataPowerValues=helper.getAssertValues(res.asString());
		Map<String, String> emulatorValues=helper.getAssertValues(res2.asString());

		if (packagecode.contentEquals("97")
				|| packagecode.contentEquals("99") || packagecode.contentEquals("98")
				|| packagecode.contentEquals("94") || packagecode.contentEquals("95")||packagecode.contentEquals("92")||packagecode.contentEquals("93")) {

			System.out.println("DataPower Actual : " + Arrays.toString(actual));
			System.out.println("Emulator Actual : " + Arrays.toString(actual2));

			String []invalidexpected =new String [] {"NO VALID OFFER PRESENT"};
			System.out.println("Expected :" + Arrays.toString(invalidexpected));
			softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

			//softAssertions.assertThat(actual).isEqualTo(invalidexpected);
			//softAssertions.assertThat(actual2).isEqualTo(invalidexpected);

			//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :" + OfferId);
		}

		else {

			System.out.println("DataPower Actual : " + Arrays.toString(actual));
			System.out.println("Emulator Actual : " + Arrays.toString(actual2));

			System.out.println("Expected : " + expected);

			//softAssertions.assertThat(Arrays.toString(actual)).isEqualTo(expected);
			//softAssertions.assertThat(Arrays.toString(actual2)).isEqualTo(expected);

			softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

			//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :" + OfferId);

		}


		return softAssertions;

	}
	
	public SoftAssertions SavingsPlusAddOnDoubleLinesValidation(ValidatableResponse response, ValidatableResponse response2,
			String packagecode, String packagecode2, String OfferId, String OfferId2,String expected) throws Exception {

		helper = new Helper();
		Response res = response.assertThat().statusCode(200).and().extract().response();
		Response res2 = response2.assertThat().statusCode(200).and().extract().response();

		String[] actual = helper.ActualMigratedValidations(res.prettyPrint().toString());
		String[] actual2 = helper.ActualMigratedValidations(res2.prettyPrint().toString());
		
		Map<String, String> dataPowerValues=helper.getAssertValues(res.asString());
		Map<String, String> emulatorValues=helper.getAssertValues(res2.asString());


		if (packagecode.contentEquals("97")
				|| packagecode.contentEquals("99") || packagecode.contentEquals("98")
				|| packagecode.contentEquals("94") || packagecode.contentEquals("95")||packagecode.contentEquals("92")||packagecode.contentEquals("93")) {

			if (packagecode2.contentEquals("97")
					|| packagecode2.contentEquals("99") || packagecode2.contentEquals("98")
					|| packagecode2.contentEquals("94") || packagecode2.contentEquals("95")||packagecode2.contentEquals("92")||packagecode2.contentEquals("93")) {

				System.out.println("DataPower Actual : " + Arrays.toString(actual));
				System.out.println("Emulator Actual : " + Arrays.toString(actual2));

				String []invalidexpected =new String [] {"NO VALID OFFER PRESENT"};
				System.out.println("Expected :" + Arrays.toString(invalidexpected));
				softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

				//softAssertions.assertThat(actual).isEqualTo(invalidexpected);
				//softAssertions.assertThat(actual2).isEqualTo(invalidexpected);

				//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :" + OfferId);

			}

			else {

				System.out.println("DataPower Actual : " + Arrays.toString(actual));

				System.out.println("Emulator Actual : " + Arrays.toString(actual2));

				System.out.println("Expected : " + expected);

				//softAssertions.assertThat(Arrays.toString(actual)).isEqualTo(expected);
				//softAssertions.assertThat(Arrays.toString(actual2)).isEqualTo(expected);

				softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

				//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :"+ OfferId2);

			}

		}

		else {

			System.out.println("DataPower Actual : " + Arrays.toString(actual));

			System.out.println("Emulator Actual : " + Arrays.toString(actual2));

			System.out.println("Expected : " + expected);

			//softAssertions.assertThat(Arrays.toString(actual)).isEqualTo(expected);
			//softAssertions.assertThat(Arrays.toString(actual2)).isEqualTo(expected);

			softAssertions.assertThat(dataPowerValues).isEqualTo(emulatorValues);

			//softAssertions.fail("Expected Promotion Discount not equal to Actual Promo Discount.Failed Promotion :" + OfferId);

		}


		return softAssertions;

	}


}
