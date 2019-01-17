package test;

import org.junit.Assert;
import org.junit.Test;

import main.VirtualPet;

public class VirtualPetTest {

	@Test
	public void shouldReturnLassieAsLassie() {
		VirtualPet dog = new VirtualPet("Lassie");

		Assert.assertEquals(dog.getName(), "Lassie");

	}

	@Test
	public void shouldReturnIntialHungerAsOneHundred() {
		VirtualPet dog = new VirtualPet("Lassie");
		int hungerValue = dog.getHunger();
		Assert.assertEquals(hungerValue, 100);	
	}
	@Test
	public void shouldReturnHungerAfterFeedingAsOneHundredFifty() {
		
		VirtualPet dog = new VirtualPet("Lassie");
		dog.feed();
		int hungerValue = dog.getHunger();
		Assert.assertEquals(hungerValue, 150);
	}
	@Test
	public void shouldReturnHungerAfterTenTicksAsNinety() {
		
		VirtualPet dog = new VirtualPet("Lassie");
		dog.tick(10);
		int hungerValue = dog.getHunger();
		Assert.assertEquals(hungerValue, 90);
	}
	@Test
	public void shouldReturnIntialBoredomAsOneHundred() {
		VirtualPet dog = new VirtualPet("Lassie");
		int boredomValue = dog.getBoredom();
		Assert.assertEquals(boredomValue, 100);	
	}
	@Test
	public void shouldReturnBoredomAfterIntialPlayAsOneHundredFifty() {
		
		VirtualPet dog = new VirtualPet("Lassie");
		dog.play();
		int boredomValue = dog.getBoredom();
		Assert.assertEquals(boredomValue, 150);
	}
	@Test
	public void shouldReturnBoredomAfterTenTicksAsNinety() {
		
		VirtualPet dog = new VirtualPet("Lassie");
		dog.tick(10);
		int boredomValue = dog.getBoredom();
		Assert.assertEquals(boredomValue, 90);
	}
}
