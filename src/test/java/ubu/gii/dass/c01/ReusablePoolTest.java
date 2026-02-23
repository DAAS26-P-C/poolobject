package ubu.gii.dass.c01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class ReusablePoolTest {

	@Test
	@DisplayName("testGetInstance")
	public void testGetInstance() {
		ReusablePool p1 = ReusablePool.getInstance();
		ReusablePool p2 = ReusablePool.getInstance();
		assertTrue(p1 == p2);
	}

	@Test
	@DisplayName("testAcquireReusable")
	public void testAcquireReusable() {

		ReusablePool pool = ReusablePool.getInstance();
		Reusable r = null;

		try {
			r = pool.acquireReusable();
			assertNotNull(r);
		} catch (NotFreeInstanceException e) {
			fail("No debería lanzar excepción en el primer acquire");
		} finally {
			try {
				if (r != null)
					pool.releaseReusable(r);
			} catch (Exception e) {
			}
		}
	}

	@Test
	@DisplayName("testAcquireMultipleInstances")
	public void testAcquireMultipleInstances() {

		ReusablePool pool = ReusablePool.getInstance();
		Reusable r1 = null;
		Reusable r2 = null;

		try {
			r1 = pool.acquireReusable();
			r2 = pool.acquireReusable();

			assertNotNull(r1);
			assertNotNull(r2);
			assertTrue(r1 != r2);

		} catch (NotFreeInstanceException e) {
			fail("No debería lanzar excepción al adquirir dos instancias");
		} finally {
			try {
				if (r1 != null)
					pool.releaseReusable(r1);
				if (r2 != null)
					pool.releaseReusable(r2);
			} catch (Exception e) {
			}
		}
	}

	@Test
	@DisplayName("testAcquireException")
	public void testAcquireException() {

		ReusablePool pool = ReusablePool.getInstance();
		Reusable r1 = null;
		Reusable r2 = null;

		try {
			// llenar pool
			r1 = pool.acquireReusable();
			r2 = pool.acquireReusable();

			// tercer acquire → debe lanzar excepción
			pool.acquireReusable();
			fail("Debería lanzar NotFreeInstanceException");

		} catch (NotFreeInstanceException e) {
			assertTrue(true); // esperado
		} finally {
			// limpieza pool
			try {
				if (r1 != null)
					pool.releaseReusable(r1);
				if (r2 != null)
					pool.releaseReusable(r2);
			} catch (Exception e) {
			}
		}
	}
}
