package virtualpet;

import org.junit.Assert;
import org.junit.Test;

public class VirtualPetShelterTest {

	@Test
	public void shouldReturnCageCleanlinessAsOneHundred() {
		VirtualPetShelter clean = new VirtualPetShelter();
		clean.addVirtualPet(new VirtualPet("abc"));
		Assert.assertEquals(clean.getCageCleanliness(), 100);
	}
	@Test
	public void shouldReturnFeed() {
		VirtualPetShelter feed = new VirtualPetShelter();
		feed.addVirtualPet(new VirtualPet("abc"));
		Assert.assertEquals(feed.getCageCleanliness(), 100);
	}
	@Test
	public void shouldReturnWater() {
		VirtualPetShelter water = new VirtualPetShelter();
		water.addVirtualPet(new VirtualPet("abc"));
		Assert.assertEquals(water.getCageCleanliness(), 100);
	}
	@Test
	public void shouldReturnCheckup() {
		VirtualPetShelter checkup = new VirtualPetShelter();
		checkup.addVirtualPet(new VirtualPet("abc"));
		Assert.assertEquals(checkup.getCageCleanliness(), 100);
	}
	@Test
	public void shouldReturnPlay() {
		VirtualPetShelter play = new VirtualPetShelter();
		play.addVirtualPet(new VirtualPet("abc"));
		Assert.assertEquals(play.getCageCleanliness(), 100);
	}
	
}
