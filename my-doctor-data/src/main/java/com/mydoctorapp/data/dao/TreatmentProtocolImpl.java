package com.mydoctorapp.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Component;

import com.mydoctorapp.data.bean.TreatmentProtocol;
import com.mydoctorapp.data.repository.TreatmentProtocolRepository;

@Component
public class TreatmentProtocolImpl  implements TreatmentProtocolRepository{
	
	@PersistenceContext
	private EntityManager manager;
	
	private String treatmentQuery="SELECT distinct dis.disease_name as diseaseName,sym.symptom_name as symptomName,"
			+ "med.medicine_name as medicineName,med.Treatment_description as medicineDescription," + 
			"med.duration_to_use as medicineDuration FROM SYMPTOM  sym JOIN  DISEASE dis on  sym.symptom_name=dis.symptom " + 
			"join medicine med on med.symptom_name=sym.symptom_name where sym.symptom_name=?";
	
	public List<Object[]> getTreatment(String symptomName){
		//List<Object[]> treatmentList=manager.
//				createNativeQuery(treatmentQuery,"TreatmentProtocolAndEntityMapping")
//				.setParameter("symptomName", symptomName).getResultList();
//		
//		 treatmentList.stream().forEach(x -> {
//			 Disease dis=(Disease) x[0];
//			 System.out.println("Disease : "+dis.getDiseaseName());
//		 });
//		 return treatmentList;
		return null;
	}
	
	
	static JdbcTemplate jdbcTemplateObj;
    static SimpleDriverDataSource dataSourceObj;
    

    static String DB_USERNAME = "sa";
    static String DB_PASSWORD = "";
    static String DB_URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;LOCK_TIMEOUT=2500;AUTOCOMMIT=OFF;DATABASE_TO_UPPER=true";
    static final String JDBC_DRIVER = "org.h2.Driver";
    
    public static JdbcDataSource getDatabaseConnection() throws ClassNotFoundException, SQLException, NamingException  {
        dataSourceObj = new SimpleDriverDataSource();
        Class.forName(JDBC_DRIVER); 
		//dataSourceObj.setDriver(new org.h2.Driver());
		dataSourceObj.setUrl(DB_URL);
		dataSourceObj.setUsername(DB_USERNAME);
		dataSourceObj.setPassword(DB_PASSWORD);
		JdbcDataSource ds = new JdbcDataSource();
		 ds.setURL(DB_URL);
		 ds.setUser(DB_USERNAME);
		 ds.setPassword(DB_PASSWORD);
		 Context ctx = new InitialContext();
		 ctx.bind("jdbc/dsName", ds);
        return ds;
    }
	
    
//    public List<TreatmentProtocol> getProtocol(String symptomName) throws ClassNotFoundException, SQLException, NamingException{
//    	jdbcTemplateObj = new JdbcTemplate(getDatabaseConnection());
//    	List<TreatmentProtocol> listContacts = jdbcTemplateObj.query(treatmentQuery,new Object[]{symptomName}, new RowMapper() {
//            public TreatmentProtocol mapRow(ResultSet result, int rowNum) throws SQLException {
//                TreatmentProtocol contactObj = new TreatmentProtocol();
//                contactObj.setDisease(result.getString("diseaseName"));
//                contactObj.setSymptom(result.getString("symptomName"));
//                contactObj.setMedicineName(result.getString("medicineName"));
//                contactObj.setTreatmentDescription(result.getString("medicineDescription"));
//                contactObj.setDurationToUse(result.getLong("medicineDuration"));
//                return contactObj;
//            }
//        });
//    	return listContacts;
//    }

    
    @Autowired
    private JdbcTemplate jtm;

	@Override
	public List<TreatmentProtocol> locateProtocol(String symptomName) {

		List<TreatmentProtocol> protocolList = jtm.query(treatmentQuery, 
				new Object[]{symptomName},
                new BeanPropertyRowMapper(TreatmentProtocol.class));
		
		return protocolList;
	}

}
