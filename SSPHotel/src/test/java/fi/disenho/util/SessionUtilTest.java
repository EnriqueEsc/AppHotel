/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package fi.disenho.util;

import fi.disenho.util.SessionUtil;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.ArgumentMatchers;
import static org.mockito.ArgumentMatchers.anyBoolean;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

/**
 *
 * @author jcs
 */
public class SessionUtilTest {
    
    public SessionUtilTest() {
    }

    /**
     * Test of getFacesSession method, of class SessionUtil.
     */
    @Test
    public void testGetFacesSession() {
        System.out.println("getFacesSession");
        boolean val = false;
        HttpSession expResult = Mockito.mock(HttpSession.class);
        FacesContext fctx = Mockito.mock(FacesContext.class);
        ExternalContext ctx = Mockito.mock(ExternalContext.class);
        
        Mockito.when(fctx.getExternalContext()).thenReturn(ctx);
        Mockito.when(ctx.getSession(anyBoolean())).thenReturn(expResult);
        
        try(MockedStatic<FacesContext> stFctx = Mockito.mockStatic(FacesContext.class)){
            stFctx.when(FacesContext::getCurrentInstance).thenReturn(fctx);
            
            HttpSession result = SessionUtil.getFacesSession(val);
        
            assertEquals(expResult, result);
            
        }
        
        
        
        
        //fail("The test case is a prototype.");
    }
    
    
    @Test
    public void testSuma(){
        int a = 5;
        int b= 10;
        
        int expResult = 15;
        
        int res = SessionUtil.suma(a, b);
        
        assertEquals(expResult, res);
        
    }
    
}