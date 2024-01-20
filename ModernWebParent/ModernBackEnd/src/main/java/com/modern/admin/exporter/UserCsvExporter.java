package com.modern.admin.exporter;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.http.HttpServletResponse;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.modern.admin.user.AbstractExporter;
import com.modern.common.entity.User;

public class UserCsvExporter extends AbstractExporter  {

	public void export(List<User> listUsers, HttpServletResponse response) throws IOException {

		super.setResponseHeader(response, "text/csv", ".csv");
		
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), 
				CsvPreference.STANDARD_PREFERENCE);

		String[] csvHeader = {"ID", "Email", "Emri", "Mbiemri", "Rolet", "Aktivizimi"};
		String[] fieldMapping = {"id", "email", "firstName", "lastName", "roles", "enabled"};

		csvWriter.writeHeader(csvHeader);

		for (User user : listUsers) {
			csvWriter.write(user, fieldMapping);
		}

		csvWriter.close();
	}
}