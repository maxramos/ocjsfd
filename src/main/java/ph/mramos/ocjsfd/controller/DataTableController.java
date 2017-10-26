package ph.mramos.ocjsfd.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ph.mramos.ocjsfd.model.Name;

@Named
@ViewScoped
public class DataTableController implements Serializable {

	private static final long serialVersionUID = -1613970290401486906L;
	private static final Logger log = LoggerFactory.getLogger(DataTableController.class);

	private DataModel<Name> names;
	private Name name;
//	private DataSource ds;

	@PostConstruct
	void init() {
		List<Name> data = new ArrayList<>();
		data.add(new Name("1st", "1st"));
		data.add(new Name("2nd", "2nd"));
		data.add(new Name("3rd", "3rd"));
		data.add(new Name("4th", "4th"));
		data.add(new Name("5th", "5th"));
		names = new ListDataModel<>(data);
		name = new Name();
	}

	public String delete(Name name) {
		log.info("Selected Index: " + names.getRowIndex());
		@SuppressWarnings("unchecked")
		List<Name> data = (List<Name>) names.getWrappedData();
		data.remove(name);
		return null;
	}

	public String add() {
		log.info("Selected Index: " + names.getRowIndex());
		@SuppressWarnings("unchecked")
		List<Name> data = (List<Name>) names.getWrappedData();
		data.add(name);
		name = new Name();
		return null;
	}

	public DataModel<Name> getNames() {
//		Connection conn = ds.getConnection();
//
//		try {
//			Statement stmt = conn.createStatement();
//			ResultSet result = stmt.executeQuery("SELECT * FROM names");
//			// return ResultSupport.toResult(result);
//			CachedRowSet crs = new com.sun.rowset.CachedRowSetImpl();
//			// or use an implementation from your database vendor
//			crs.populate(result);
//			return crs;
//		} finally {
//			conn.close();
//		}

		return names;
	}

	public Name getName() {
		return name;
	}

}
