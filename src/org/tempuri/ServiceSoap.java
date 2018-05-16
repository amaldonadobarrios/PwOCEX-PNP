/**
 * ServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface ServiceSoap extends java.rmi.Remote {
    public boolean validateUser(java.lang.String user, java.lang.String pass) throws java.rmi.RemoteException;
    public org.tempuri.ClsDatos recuperaUsuarioExisteAD(java.lang.String l_cuenta_usuario, java.lang.String password) throws java.rmi.RemoteException;
    public boolean existeUsuarioLDAP(java.lang.String l_cuenta_usuario) throws java.rmi.RemoteException;
    public boolean usuarioHabilitadoLDAP(java.lang.String v_cuenta_usuario) throws java.rmi.RemoteException;
    public org.tempuri.ClsDatos recuperaDatosUsuarioExisteLDAP(java.lang.String v_cuenta_usuario) throws java.rmi.RemoteException;
}
