package dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;

import org.apache.commons.io.IOUtils;

import dao.UsuarioDAO;
import entity.UsuarioAguila6;
import util.BatEncriptador;
import util.ConectaDB;
import util.ConstantSIGEDO;

public class UsuarioDAOImpl  implements UsuarioDAO {

	@Override
	public String img(String cip) throws IOException {
		int tamaño_cip = cip.length();
		String sSubCadena = cip.substring(tamaño_cip - 1, tamaño_cip);
		String rutaimagen = BatEncriptador.getInstance().Desencripta(ConstantSIGEDO.codigo) + sSubCadena + "/" + cip
				+ ".jpg";
		String encod = null;
		byte[] bytes;
		try {
			URL url = new URL(rutaimagen);
			URLConnection urlCon = url.openConnection();
			System.out.println(urlCon.getContentType());
			InputStream is = urlCon.getInputStream();
			bytes = IOUtils.toByteArray(is);
			Base64.Encoder code = Base64.getEncoder();
			encod = code.encodeToString(bytes);
		} catch (Exception e) {
			URL fileLocation = this.getClass().getResource("policia.jpg");
			bytes = IOUtils.toByteArray(fileLocation);
			Base64.Encoder code = Base64.getEncoder();
			encod = code.encodeToString(bytes);
		}
		return encod;
	}

	@Override
	public UsuarioAguila6 getEfectivoAguila6(String cip) throws Exception {
		ConectaDB db = null;
		db = new ConectaDB();
		Connection conn;
		conn = null;
		UsuarioAguila6 maspe = null;
		String sqlResult = null;
		sqlResult = " SELECT DISTINCT \r\n" + "	   mp.MASPE_CODPER,\r\n" + "	   mp.MASPE_CARNE,\r\n"
				+ "	   mp.MASPE_DNI,\r\n" + "	   mp.MASPE_NOMB,\r\n" + "	   mp.MASPE_PATER,\r\n"
				+ "	   mp.MASPE_MATER,\r\n" + "	   gr.TGRAD_DES,\r\n" + "	   tu.UNIDAD,\r\n"
				+ "	   car.TCARGO_DES,\r\n" + "	   mo.TMODA_DES,\r\n" + "	   si.TSITE_DES,\r\n"
				+ "	   situa.TSITUA_DES,\r\n" + "	   es.tespe_des,\r\n" + "	   ec.TECIV_DES,\r\n"
				+ "	   mp.MASPE_NHIJOS,\r\n" + "	   sa.TSANGRE_DES,\r\n" + "	   sex.TSEXO_DES,\r\n"
				+ "	  FORMAT (mp.MASPE_FNACIM, 'dd-MM-yyyy') as MASPE_FNACIM,\r\n" + "	   mp.MASPE_FIESCU,\r\n"
				+ "	   mp.MASPE_FEGRES,\r\n" + "	   mp.MASPE_FASCEN\r\n" + "FROM \r\n" + "	MASPE  mp, \r\n"
				+ "	TCARGO car,\r\n" + "	TGRAD gr,\r\n" + "	TMODA mo,\r\n" + "	TSANGRE sa,\r\n"
				+ "	tabuni tu,\r\n" + "	TSITE si,\r\n" + "	TSITUA situa,\r\n" + "	tespe es,\r\n" + "	TECIV ec,\r\n"
				+ "	TSEXO sex\r\n" + "WHERE \r\n" + " 	mp.MASPE_CARNE=?	\r\n"
				+ " 	and mp.TCARGO_COD=car.TCARGO_COD\r\n" + "	and mp.TGRAD_COD=gr.TGRAD_COD\r\n"
				+ "	and mp.TMODA_COD=mo.TMODA_COD\r\n" + " 	and mp.TSANGRE_COD=sa.TSANGRE_COD\r\n"
				+ " 	and mp.MASPE_CODUNILR collate Modern_Spanish_CI_AS = tu.coduni\r\n"
				+ " 	and mp.TSITE_COD=si.TSITE_COD\r\n" + " 	and mp.TSITUA_COD=situa.TSITUA_COD\r\n"
				+ " 	and mp.tespe_cod =es.tespe_cod\r\n" + " 	and mp.TECIV_COD=ec.TECIV_COD\r\n"
				+ " 	and mp.MASPE_SEXO=sex.TSEXO_COD ";
		try {

			conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement(sqlResult);
			ps.setString(1, cip);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				maspe = new UsuarioAguila6();
				maspe.setCodofin(rs.getString("MASPE_CODPER"));
				maspe.setCip(rs.getString("MASPE_CARNE"));
				maspe.setDni(rs.getString("MASPE_DNI"));
				maspe.setNombre(rs.getString("MASPE_NOMB"));
				maspe.setApellidopat(rs.getString("MASPE_PATER"));
				maspe.setApellidomat(rs.getString("MASPE_MATER"));
				maspe.setGrado(rs.getString("TGRAD_DES"));
				maspe.setUnidad(rs.getString("UNIDAD"));
				maspe.setCargo(rs.getString("TCARGO_DES"));
				maspe.setSituacion(rs.getString("TSITE_DES"));
				maspe.setEspecialidad(rs.getString("tespe_des"));
				maspe.setEstadocivil(rs.getString("TECIV_DES"));
				maspe.setSexo(rs.getString("TSEXO_DES"));
				maspe.setTipoSangre(rs.getString("TSANGRE_DES"));
				maspe.setFechanac(rs.getString("MASPE_FNACIM"));
			}
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception("Error Interno.");
		} finally {
			conn.close();
		}

		return maspe;
	}

}
