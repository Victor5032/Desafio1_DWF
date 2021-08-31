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
}
