package ubu.gii.dass.c01; 

  

import static org.junit.jupiter.api.Assertions.*; 

  

import org.junit.jupiter.api.AfterAll; 

import org.junit.jupiter.api.BeforeAll; 

import org.junit.jupiter.api.Test; 

import org.junit.jupiter.api.DisplayName; 

  

public class ReusablePoolTest { 

  

 

@BeforeAll 

public static void setUp(){ 

} 

  

 

@AfterAll 

public static void tearDown() throws Exception { 

} 

 

 

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

                if (r != null) pool.releaseReusable(r); 

            } catch (Exception e) {} 

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

                if (r1 != null) pool.releaseReusable(r1); 

                if (r2 != null) pool.releaseReusable(r2); 

            } catch (Exception e) {} 

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

                if (r1 != null) pool.releaseReusable(r1); 

                if (r2 != null) pool.releaseReusable(r2); 

            } catch (Exception e) {} 

        } 

    } 

     

    @Test 

    @DisplayName("testReleaseReusable") 

    public void testReleaseReusable() { 

  

        ReusablePool pool = ReusablePool.getInstance(); 

        Reusable r = null; 

  

        try { 

            // adquirir 

            r = pool.acquireReusable(); 

  

            // liberar 

            pool.releaseReusable(r); 

  

            assertTrue(true); 

  

        } catch (Exception e) { 

            fail("No debería lanzar excepción al liberar instancia"); 

        } 

    } 

     

    @Test 

    @DisplayName("testReleaseDuplicated") 

    public void testReleaseDuplicated() { 

  

        ReusablePool pool = ReusablePool.getInstance(); 

        Reusable r = null; 

  

        try { 

            // acquire 

            r = pool.acquireReusable(); 

  

            // release normal 

            pool.releaseReusable(r); 

  

            // release duplicado → excepción 

            pool.releaseReusable(r); 

            fail("Debería lanzar DuplicatedInstanceException"); 

  

        } catch (DuplicatedInstanceException e) { 

            assertTrue(true); // esperado 

        } catch (NotFreeInstanceException e) { 

            fail("No debería lanzar NotFreeInstanceException"); 

        } 

    } 

     

    @Test 

    @DisplayName("testReusableUtil") 

    public void testReusableUtil() { 

  

        Reusable nuevo = new Reusable(); 

        String resultado = nuevo.util(); 

  

        assertNotNull(resultado); 

    } 

} 