package sv.edu.udb.www.services;

import java.util.*;
import java.sql.*;
import java.util.logging.*;

import sv.edu.udb.www.beans.*;
import sv.edu.udb.www.models.*;

public class ClienteCuponImpl implements ClienteCuponService {
	@Override
	public ClienteCupon comprobarCupon(String codigo) {
		ClienteCupon datos = new ClienteCupon();
		CuponModel cupon = new CuponModel();
		
		datos = cupon.comprobarCupon(codigo);
		
		return datos;
	}
	
	@Override
	public String canjearCupon(String codigo, String dui) {
		CuponModel cupon = new CuponModel();
		String mensaje = "Error interno del sistema";
		
		if (codigo.equals("?")) {
			mensaje = "El código del cupón es requerido";
		}
		
		if (dui.equals("?")) {
			mensaje = "El DUI del cliente es requerido";
		}
		
		if (dui.equals("?") && codigo.equals("?")) {
			mensaje = "El DUI del cliente y el código del cupón es requerido";
		}
		
		int response = cupon.canjearCupon(dui, codigo);
		
		if (response == 1) {
			mensaje = "Cupón canjeado!! Disfrute de su oferta.";
		}
		
		if (response == 0) {
			mensaje = "Error al intentar canjear cupón";
		}

		return mensaje;
	}
}
