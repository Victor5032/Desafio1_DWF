package sv.edu.udb.www.services;

import sv.edu.udb.www.beans.*;

public interface ClienteCuponService {
	public ClienteCupon comprobarCupon(String codigo);
	public String canjearCupon(String codigo, String dui);
}
