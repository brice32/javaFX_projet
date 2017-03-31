package contacts.emb.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import contacts.emb.dao.IDaoAnnonceur;
import contacts.emb.dom.Annonceur;
import contacts.emb.dom.Personne;

public class DaoAnnonceur implements IDaoAnnonceur {

	// Champs

	private DataSource dataSource;

	// Injecteurs
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	// Action

	@Override
	public List<Annonceur> listerTout() {
		Connection cn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT * FROM Annonceur ORDER BY nom";
			stmt = cn.prepareStatement(sql);
			rs = stmt.executeQuery();

			List<Annonceur> annonceur = new ArrayList<>();
			while (rs.next()) {
				annonceur.add(construireAnnonceur(rs));
			}
			return annonceur;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
			}
			try {
				if (cn != null)
					cn.close();
			} catch (SQLException e) {
			}
		}
	}

	@Override
	public int inserer(Annonceur annonceur) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void modifier(Annonceur annonceur) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimer(int idAnnonceur) {
		// TODO Auto-generated method stub

	}

	@Override
	public Annonceur retrouver(int idAnnonceur) {
		Connection cn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT * FROM annonceur WHERE idAnnonceur = ?";
			stmt = cn.prepareStatement(sql);
			stmt.setInt(1, idAnnonceur);
			rs = stmt.executeQuery();

			if (rs.next()) {
				return construireAnnonceur(rs);
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
			}
			try {
				if (cn != null)
					cn.close();
			} catch (SQLException e) {
			}
		}
	}

	// Mé thodes auxiliaires

	private Annonceur construireAnnonceur(ResultSet rs) throws SQLException {
		Annonceur annonceur = new Annonceur();
		annonceur.setId(rs.getInt("idAnnonceur"));
		annonceur.setNom(rs.getString("nom"));
		annonceur.setTelephone(rs.getString("telephone"));
		annonceur.setEmail(rs.getString("email"));
		annonceur.setLieuNom(rs.getString("lieuNom"));
		annonceur.setLieuAdresse(rs.getString("lieuAdresse"));
		annonceur.setLieuCp(rs.getString("lieuCp"));
		annonceur.setLieuVille(rs.getString("lieuVille"));
		annonceur.setSiteWeb(rs.getString("siteWeb"));
		return annonceur;
	}

}
