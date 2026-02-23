package ubu.gii.dass.c01;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

//import org.junit.jupiter.api.Disabled;

public class ReusablePoolTest {
	@BeforeAll
	public static void setUp() {
	}

	@AfterAll
	public static void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#getInstance()}.
	 */
	@Test
	@DisplayName("testGetInstance")
	public void testGetInstance() {
		ReusablePool p1 = ReusablePool.getInstance();
		ReusablePool p2 = ReusablePool.getInstance();

		assertTrue(p1 == p2);
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 */
	@Test
	@DisplayName("testAcquireReusable")
	public void testAcquireReusable() {

		ReusablePool pool = ReusablePool.getInstance();

		try {
			// Caso normal
			Reusable r1 = pool.acquireReusable();
			Reusable r2 = pool.acquireReusable();
			assertTrue(r1 != null);
			assertTrue(r2 != null);

			// Caso excepción
			pool.acquireReusable();
			assertTrue(false); // si llega aquí falla

		} catch (NotFreeInstanceException e) {
			assertTrue(true); // excepción esperada
		}
	}

	/**
	 * Test method for
	 * {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 */
	@Test
	@DisplayName("testReleaseReusable")
	public void testReleaseReusable() {

		ReusablePool pool = ReusablePool.getInstance();

		try {
			// Adquirimos uno para poder liberarlo
			Reusable r = pool.acquireReusable();

			// Caso normal
			pool.releaseReusable(r);

			// Caso excepción (liberarlo otra vez)
			pool.releaseReusable(r);
			fail("Debería lanzar DuplicatedInstanceException");

		} catch (DuplicatedInstanceException e) {
			assertTrue(true); // excepción esperada
		} catch (NotFreeInstanceException e) {
			fail("No debería lanzar NotFreeInstanceException aquí");
		}

		// ---- Cubrir Reusable.util() ----
		Reusable nuevo = new Reusable();
		String resultado = nuevo.util();
		assertNotNull(resultado);

		// ---- Cubrir Client.main() ----
		try {
			Client.main(new String[] {});
		} catch (Exception e) {
			fail("Client.main no debería lanzar excepción");
		}
	}

}
