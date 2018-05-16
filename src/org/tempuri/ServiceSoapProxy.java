package org.tempuri;

public class ServiceSoapProxy implements org.tempuri.ServiceSoap {
  private String _endpoint = null;
  private org.tempuri.ServiceSoap serviceSoap = null;
  
  public ServiceSoapProxy() {
    _initServiceSoapProxy();
  }
  
  public ServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiceSoapProxy();
  }
  
  private void _initServiceSoapProxy() {
    try {
      serviceSoap = (new org.tempuri.ServiceLocator()).getServiceSoap();
      if (serviceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)serviceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)serviceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (serviceSoap != null)
      ((javax.xml.rpc.Stub)serviceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.ServiceSoap getServiceSoap() {
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap;
  }
  
  public boolean validateUser(java.lang.String user, java.lang.String pass) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.validateUser(user, pass);
  }
  
  public org.tempuri.ClsDatos recuperaUsuarioExisteAD(java.lang.String l_cuenta_usuario, java.lang.String password) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.recuperaUsuarioExisteAD(l_cuenta_usuario, password);
  }
  
  public boolean existeUsuarioLDAP(java.lang.String l_cuenta_usuario) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.existeUsuarioLDAP(l_cuenta_usuario);
  }
  
  public boolean usuarioHabilitadoLDAP(java.lang.String v_cuenta_usuario) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.usuarioHabilitadoLDAP(v_cuenta_usuario);
  }
  
  public org.tempuri.ClsDatos recuperaDatosUsuarioExisteLDAP(java.lang.String v_cuenta_usuario) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.recuperaDatosUsuarioExisteLDAP(v_cuenta_usuario);
  }
  
  
}