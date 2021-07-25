package kin.carta.demoCheckout.services.api;

import kin.carta.demoCheckout.models.Items;
import kin.carta.demoCheckout.services.CheckoutServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CheckoutServiceImplTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	CheckoutServiceImpl checkoutService;

	@Test
	void testCase1WaterBottleDiscount(){
		Items list = new Items();
		String[] items = {"0001", "0001", "0002", "0003"};
		list.items = items;

		String response = checkoutService.checkoutBasket(list);
		assert(response.equals("£103.47"));
	}


	@Test
	void testCase2NoMinimumSpend(){
		Items list = new Items();
		String[] items = {"0001", "0001", "0001"};
		list.items = items;

		String response = checkoutService.checkoutBasket(list);
		assert(response.equals("£68.97"));
	}

	@Test
	void testCase3NoWaterBottle(){
		Items list = new Items();
		String[] items = {"0002", "0002", "0003"};
		list.items = items;

		String response = checkoutService.checkoutBasket(list);
		assert(response.equals("£120.59"));
	}

	@Test
	void testCaseReturnErrorMessageWhenItemIncorrect(){
		Items list = new Items();
		String[] items = {"0002", "0002", "0005"};
		list.items = items;

		String response = checkoutService.checkoutBasket(list);
		assert(response.equals("Item code 0005 does not match specifications"));
	}

	@Test
	void testCaseReturnErrorMessageWhenItemsMissing(){
		Items list = new Items();

		String response = checkoutService.checkoutBasket(list);
		assert(response.equals("Item list must not be empty"));
	}


}
