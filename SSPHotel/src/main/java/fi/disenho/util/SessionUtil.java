/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.disenho.util;

import jakarta.faces.context.FacesContext;
import jakarta.servlet.http.HttpSession;

/**
 * Clase tipo util para manejo de sesión
 */
public class SessionUtil {
    
    public static final String LOGIN_PAGE = "login.xthml";
    public static final String USU_KEY = "usuKey";
    
    private SessionUtil(){}
    
    /**
     * Método para obtener instancia de HttpSession mediante FacesContext
     * @param val Tipo booleano para recuerar session
     * @return Instancia HttpSession
     */
    public static HttpSession getFacesSession(boolean val){
        return (HttpSession)FacesContext
                .getCurrentInstance()
                .getExternalContext().
                getSession(val);
    }
    
    public static int suma(int a, int b){
        return a+b;
    }
    
}
