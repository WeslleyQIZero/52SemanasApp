package br.com.clubeapp.a52semanas.Activitys.Daos;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import br.com.clubeapp.a52semanas.Activitys.Banco.SQLiteBD;
import br.com.clubeapp.a52semanas.Activitys.Models.Desafio;

public class DesafioDaos {
	private SQLiteBD vrBanco = null;
	private SQLiteDatabase vrRefEscrita;

	private String nome = "nome";
	private String tabela = "objetivo";
	private String valor = "valor";
	private String datainicio = "dataInicial";
	private String dataVencimento = "dataVencimento";
	private String visualizacao="visualizacao";
	private String porcentagem="pocentagem";
	private  String semana="semana";


	public DesafioDaos(Context context) {
		vrBanco = new SQLiteBD(context, "app", 1);
		vrRefEscrita = vrBanco.getWritableDatabase();

	}

	public void deleta(int deletar) {
		try {
			String tabela = this.tabela;
			String where = "_id=?";
			String[] whereArgs = new String[] { deletar + "" };
			vrRefEscrita.delete(tabela, where, whereArgs);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// (_id integer primary key autoincrement,integer idOjetivo not null,nome
	// text not null,valor bigint not null,dataInicial text not
	// null,dataVenciemnto text not null,status text not null)


	public void inserir(Desafio modelo) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String datainico = df.format(modelo.getDataInicio());
		try {
			vrRefEscrita.execSQL("insert into " + tabela + " (" + nome + ","
					+ valor + "," + datainicio + "," + dataVencimento+"," + visualizacao+"," + porcentagem+"," + semana
					+ ")values('" + modelo.getObjetivo() + "','" + modelo.getValorInicial()
					+ "','" + datainico + "','"+ modelo.getDataFim() + "','"
					+ modelo.getVisualizacao() + "','"+ modelo.getPorcentagem()+ "','"+modelo.getSemana()+"')");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update(Desafio modelo) {
		try {
			ContentValues values = new ContentValues();
			values.put(nome, modelo.getObjetivo());
			values.put(valor, modelo.getValorInicial());
			values.put(datainicio, modelo.getDataInicio().toString());
			values.put(dataVencimento, modelo.getDataFim().toString());
			String tabela = this.tabela;
			String where = "_id =?";
			String[] whereArgs = new String[] { String.valueOf(values
					.get("_id")) };
			vrRefEscrita.update(tabela, values, where, whereArgs);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Desafio> listar() {

		ArrayList<Desafio> list = new ArrayList<Desafio>();
		String[] cadastro = new String[] { "_id," + nome + "," + datainicio
				+ "," + dataVencimento + "," + valor+ "," +visualizacao+ "," +porcentagem+ "," +semana };
		Cursor vrConsulta = vrRefEscrita.query(tabela, cadastro, "", null,
				null, null, "nome");

		int cont = 0;
		while (vrConsulta.getCount() > cont) {
			if (vrConsulta.getCount() > 0) {
				vrConsulta.moveToNext();
				Desafio desafio =new Desafio();
				desafio.setId(Long.parseLong(vrConsulta.getString(0)));
				desafio.setValorInicial(Double.parseDouble(vrConsulta.getString(4)));
				desafio.setObjetivo(vrConsulta.getString(1));
				desafio.setDataInicio(Desafio.stringToDate(vrConsulta.getString(2)));
				desafio.setDataFim(Desafio.stringToDate(vrConsulta.getString(3)));
				desafio.setVisualizacao((vrConsulta.getString(5)));
				desafio.setPorcentagem(Integer.parseInt(vrConsulta.getString(6)));
				desafio.setSemana(Integer.parseInt(vrConsulta.getString(7)));

				list.add(desafio);

			}

			cont++;
		}
		return list;

	}

	public Desafio Buscar(String buscar) {

		Desafio list = null;
		String[] cadastro = new String[] { "_id," + nome + "," + datainicio
				+ "," + dataVencimento + "," + valor+ "," +visualizacao+ "," +porcentagem+ "," +semana };

		Cursor vrConsulta = vrRefEscrita.query(tabela, cadastro, "_id =?",
				new String[] { buscar }, null, null, "nome");
		int cont = 0;
		while (vrConsulta.getCount() > cont) {
			if (vrConsulta.getCount() > 0) {
				vrConsulta.moveToNext();

				Desafio desafio =new Desafio();
				desafio.setId(Long.parseLong(vrConsulta.getString(0)));
				desafio.setValorInicial(Double.parseDouble(vrConsulta.getString(4)));
				desafio.setObjetivo(vrConsulta.getString(1));
				desafio.setDataInicio(Desafio.stringToDate(vrConsulta.getString(2)));
				desafio.setDataFim(Desafio.stringToDate(vrConsulta.getString(3)));
				desafio.setVisualizacao((vrConsulta.getString(5)));
				desafio.setPorcentagem(Integer.parseInt(vrConsulta.getString(6)));
				desafio.setSemana(Integer.parseInt(vrConsulta.getString(7)));
				list = (desafio);

			}

			cont++;
		}
		return list;

	}

}