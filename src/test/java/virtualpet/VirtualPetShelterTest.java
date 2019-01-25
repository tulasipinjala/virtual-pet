package virtualpet;

import org.junit.Assert;
import org.junit.Test;

public class VirtualPetShelterTest {

	@Test
	public void shouldReturnCageCleanlinessAsOneHundred() {
		VirtualPetShelter clean = new VirtualPetShelter();
		Assert.assertEquals(clean.getCageCleanliness(), 100);
	}
	
}
